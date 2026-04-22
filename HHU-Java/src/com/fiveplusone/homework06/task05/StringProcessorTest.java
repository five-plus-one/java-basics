package com.fiveplusone.homework06.task05;


class StringProcessor {
    public StringBuilder processStrings(String[] inputs) {
        // 1. 【防御性检查】处理数组本身为 null 的情况
        if (inputs == null) {
            System.out.println("[系统警告]：输入数组为 null，返回空结果。");
            return new StringBuilder();
        }
        // 2. 【性能优化】预估初始容量。默认 16 字节，频繁扩容会损耗性能
        // 假设平均每个单词 10 个字符
        int initialCapacity = (inputs.length > 0) ? inputs.length * 10 : 16;
        StringBuilder sb = new StringBuilder(initialCapacity);

        // 3. 【防御性循环】
        for (int i = 0; i < inputs.length; i++) {
            String str = inputs[i];

            // 4. 【防御性检查】处理数组元素为 null 的情况
            if (str != null) {
                sb.append(str.toUpperCase());
            } else {
                System.out.println("[日志记录]：索引为 " + i + " 的元素为空，已跳过。");
            }
        }
        return sb;
    }
}


public class StringProcessorTest {

    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();

        System.out.println(">>> 场景 1：正常数据测试");
        String[] normalData = {"hello", "world", "java"};
        StringBuilder result1 = processor.processStrings(normalData);
        System.out.println("运行结果：" + result1.toString()); // 预期：HELLOWORLDJAVA
        System.out.println();

        System.out.println(">>> 场景 2：数组本身为 null 测试");
        String[] nullArray = null;
        StringBuilder result2 = processor.processStrings(nullArray);
        System.out.println("运行结果：" + (result2.length() == 0 ? "(空字符)" : result2));
        System.out.println();

        System.out.println(">>> 场景 3：包含 null 元素的数组测试");
        String[] dirtyData = {"hhu", null, "student"};
        StringBuilder result3 = processor.processStrings(dirtyData);
        System.out.println("运行结果：" + result3.toString()); // 预期：HHUSTUDENT
        System.out.println();

        System.out.println(">>> 场景 4：数组中包含空字符串 \"\" ");
        String[] emptyStrings = {"", " ", "cs"};
        StringBuilder result4 = processor.processStrings(emptyStrings);
        System.out.println("运行结果：" + result4.toString()); // 预期： CS

        System.out.println("\n==============================");
        System.out.println("测试全部完成，程序未发生崩溃。");
    }
}