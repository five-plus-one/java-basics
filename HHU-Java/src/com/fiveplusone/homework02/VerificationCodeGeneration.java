package com.fiveplusone.homework02;

public class VerificationCodeGeneration {
    public static void main(String[] args) {
        // 生成随机6位数字验证码
        String verificationCode = generateVerificationCode();
        System.out.println("生成的6位数字验证码是: " + verificationCode);
    }
    
    /**
     * 生成6位随机数字验证码
     * @return 6位数字验证码字符串
     */
    public static String generateVerificationCode() {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            // 生成0-9之间的随机数字
            int digit = (int) (Math.random() * 10);
            code.append(digit);
        }
        return code.toString();
    }
}