package com.tahiri.SERVICES;

public class SecurityContext {
    private static String username = "";
    private static String password = "";
    private static String[] roles = {};

    public static void authenticateUser(String u, String p, String[] rs) {
        if ((u.equals("tahiri")) && (p.equals("tahiri"))) {
            username = u;
            password = p;
            roles = rs;
        } else throw new RuntimeException("Access Denied...");
    }

    public static boolean hasRole(String role) {
        for (String r : roles) {
            if (r.equals(role)) return true;
        }
        return false;
    }
}
