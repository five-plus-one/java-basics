package com.fiveplusone.homework03.task02;

public class SecurityUtils {
    // 无参构造私有化，防止通过new创建对象
    private SecurityUtils() {
    }

    // 静态方法，用于生成随机验证码
    public static String generateCode() {
        StringBuilder sb = new StringBuilder(); // 用于构建随机安全码的字符串
        // 生成4位随机数字,重复4次
        for (int i = 0; i < 4; i++) {
            sb.append((int) (Math.random() * 10)); // 生成0-9之间的随机整数，并添加到字符串中
        }
        return sb.toString(); // 返回随机安全码
    }

    // 静态方法，用于验证密码是否符合要求
    // 密码长度必须大于等于8位
    public static boolean isValidPassword(String password) {
        // 空值安全检查：防止传入null导致空指针异常
        if (password == null) {
            return false;
        }
        // 密码长度必须大于等于8位
        return password.length() >= 8;
    }
}
