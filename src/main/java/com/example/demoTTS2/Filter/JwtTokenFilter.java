package com.example.demoTTS2.Filter;

import com.example.demoTTS2.Component.JwtTokenUtil;
import com.example.demoTTS2.Model.RoleEntity;
import com.example.demoTTS2.Model.UserEntity;
import com.example.demoTTS2.Repository.RoleRepo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    private final UserDetailsService userDetailsService;
    private final RoleRepo roleRepo;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        final List<Pair<String, String>> bypassToken = Arrays.asList(
                Pair.of("/registerUser", "POST"),
                Pair.of("/loginAdmin", "POST"),
                Pair.of("/registerUser2", "POST")
        );

        // Kiểm tra nếu request cần bypass
        for (Pair<String, String> bypasstoken : bypassToken) {
            if (request.getServletPath().contains(bypasstoken.getFirst()) &&
                    request.getMethod().equals(bypasstoken.getSecond())) {
                filterChain.doFilter(request, response);
                return;  // Kết thúc filter ngay lập tức sau khi bypass
            }
        }

        // Xử lý JWT cho các request không bypass
        try {
            final String authHeader = request.getHeader("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new ServletException("No valid token provided");
            }
            final String token = authHeader.substring(7);
            final String username = jwtTokenUtil.extractUsername(token);
            if (username == null) {
                throw new ServletException("Invalid token");
            }
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (jwtTokenUtil.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities()
                    );
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    String requestURI = request.getRequestURI();
                    if (authenticationToken.getPrincipal() instanceof UserEntity){
                        if (((UserEntity) authenticationToken.getPrincipal()).getRole()==1) {
                            filterChain.doFilter(request, response);
                            return;  // Kết thúc filter ngay lập tức sau khi bypass
                        }
                    }
                    if (!checkUserRole(username, requestURI)) {
                        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Không có quyền truy cập");
                        return;
                    }
                } else {
                    throw new ServletException("Token validation failed");
                }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("An error occurred during authentication");
            logger.error("Cannot set user authentication: {}", e);
        }
    }

    private boolean checkUserRole(String username, String requestURI) {
        RoleEntity role = roleRepo.findByUsername(username);
        if (role == null) return false;

        Permission requiredPermission = URIPermissionMapper.getPermission(requestURI);
        if (requiredPermission == null) return false;

        return hasPermission(role, requiredPermission);
    }

    private boolean hasPermission(RoleEntity role, Permission permission) {
        switch (permission) {
            case QUERY_CUSTOMER:
                return role.getQueryCustomerRole() != null && role.getQueryCustomerRole() == 1;
            case ADD_USER:
                return role.getAddRole() != null && role.getAddRole() == 1;
            case DELETE_USER:
                return role.getDeleteRole() != null && role.getDeleteRole() == 1;
            case EDIT_USER:
                return role.getEditRole() != null && role.getEditRole() == 1;
            case READ_SALARY:
                return role.getReadSalaryRole() != null && role.getReadSalaryRole() == 1;
            default:
                return false;
        }
    }
}