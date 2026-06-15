package com.wyr.ecommercesys.console;

// 控制台输出当中，有一些基础的工具，做成工具类方便调用
// ANSI 转义Code 通过AI工具查询，代码为手工编写

// 我发现通过控制台直接输出非常不美观，因此通过查阅相关解决方案，借助AI工具查询ANSI代码，完成了这个工具类的编写。
public class ConsoleTools {
    protected ConsoleTools() {} //工具类，私有化构造方法

    // 该表格为通过AI工具进行查询
    protected static final String RESET = "\033[0m";       // 重置颜色
    protected static final String BOLD = "\033[1m";        // 加粗
    protected static final String RED = "\033[31m";        // 红色 (用于报错)
    protected static final String GREEN = "\033[32m";      // 绿色 (用于成功)
    protected static final String YELLOW = "\033[33m";     // 黄色 (用于警告/高亮)
    protected static final String CYAN = "\033[36m";       // 青色 (用于标题/装饰)

    public static void clearScreen(){
        // 打印 ANSI 清屏码（通过查询），并刷新输出流
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
        //实际上，在IDEA中，这个也没有用，因为它采用的是日志追加模式
        //因此直接暴力改成打印100个换行
        printN(100,"\n");
    }
//    public static void clearCurrentLine() {
//        //清除当前行
//        System.out.print("\r\033[2K");
//        System.out.flush();
//    }
//    public static void clearPreviousLine() {
//        // \033[1A 光标上移一行，然后清除该行
//        System.out.print("\033[1A\033[2K");
//        System.out.flush();
//    }
    //打印分割线
    public static void printDivider(int length) {
        StringBuilder sb = new StringBuilder("+");
        for (int i = 0; i < length; i++) {
            sb.append("-");
        }
        sb.append("+");
        System.out.println(CYAN + sb.toString() + RESET);
    }
    public static void printDivider() {
        printDivider(52);
    }


    // 为什么会有这个？因为实际开发中，我发现中文无法准确通过%s进行格式化控制，比如说，如果使用%s，可能会出现下面的问题
//            +--------------------------------------------------+
//            | 电子商务管理系统 V1.0 by 王煜冉                             |
//            +--------------------------------------------------+
    //因此，需要直接计算出来视觉宽度（中文2，英文1），然后根据视觉宽度补全
    public static int getDisplayWidth(String str) {
        if (str == null) return 0;
        int width = 0;
        for (char c : str.toCharArray()) {
            // 简单判断：如果字符的 ASCII 码大于 255，说明是宽字符（如汉字）
            if (c > 255) {
                width += 2;
            } else {
                width += 1;
            }
        }
        return width;
    }

    protected static void printN(int n,String str){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        System.out.print(sb.toString());
    }

    public static String padToTarget(String str, int targetWidth,int type) {
        int currentWidth = getDisplayWidth(str);
        int spacesNeeded = targetWidth - currentWidth;
        StringBuffer sb = new StringBuffer();
        if(type ==1){
            for(int i=0;i<spacesNeeded;i++){
                sb.append(" ");
            }
            sb.append(str);
        }else if(type == 2){
            sb.append(str);
            for(int i=0;i<spacesNeeded;i++){
                sb.append(" ");
            }
        }else if(type == 3){
            int spacesNeededRight = spacesNeeded - (spacesNeeded/2);
            for(int i=0;i<spacesNeeded/2;i++){
                sb.append(" ");
            }
            sb.append(str);
            for(int i=0;i<spacesNeededRight;i++){
                sb.append(" ");
            }
        }else{
            throw new RuntimeException("wyr-不合法的控制台工具对齐类型");
        }
        return sb.toString();
    }

    public static void printFunction(String func,String desc,int level){
        if(level==1){
            System.out.println(BOLD + YELLOW + func + RESET + " " + desc + RESET);
        }
    }

    public static void printFunction(String func,String desc){
        printFunction(func,desc,1);
    }
}
