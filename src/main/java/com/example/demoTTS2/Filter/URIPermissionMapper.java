package com.example.demoTTS2.Filter;
import java.util.HashMap;
import java.util.Map;

public class URIPermissionMapper {

    private static final Map<String, Permission> uriPermissionMap = new HashMap<>();

    static {
        uriPermissionMap.put("/api/customers", Permission.QUERY_CUSTOMER);
        uriPermissionMap.put("/api/add-user", Permission.ADD_USER);
        uriPermissionMap.put("/api/delete-user", Permission.DELETE_USER);
        uriPermissionMap.put("/api/edit-user", Permission.EDIT_USER);
        uriPermissionMap.put("/api/salary", Permission.READ_SALARY);
    }

    public static Permission getPermission(String uri) {
        return uriPermissionMap.entrySet().stream()
                .filter(entry -> uri.startsWith(entry.getKey()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }
}
