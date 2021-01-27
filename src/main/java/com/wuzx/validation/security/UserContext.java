package com.wuzx.validation.security;

public class UserContext {
    private UserContext(){}

    private static final ThreadLocal<Long> USER = new ThreadLocal<>();

    public static void add(Long id) {
        USER.set(id);
    }

    public static void remove() {
        USER.remove();
    }

    /**
     * @return 当前登录用户的id
     */
    public static Long getCurrentUserId() {
        return USER.get();
    }
}
