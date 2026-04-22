package com.fiveplusone.test01;

public class replaceUpperCase {
    public static String replaceUpperCase(String s) {
        // 处理边界情况
        if (s == null || s.length() == 0) {
            return s;
        }

        // 预分配容量，避免底层数组频繁扩容，提高性能
        StringBuilder sb = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 判断是否为大写字母 (ASCII 码范围判定)
            if (c >= 'A' && c <= 'Z') {
                sb.append('_');
            } else {
                // 小写字母和数字保持不变
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
