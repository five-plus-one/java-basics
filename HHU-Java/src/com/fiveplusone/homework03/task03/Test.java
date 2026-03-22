package com.fiveplusone.homework03.task03;

public class Test {
    public static void main(String[] args) {
        Pet p1 = new Pet();
        p1.setName("布丁");
        System.out.println(p1.getName() + "的初始体重为：" + p1.getWeight() + "kg" );
        Pet p2 = p1; //模拟室友代养宠物
        p2.feed();
        p2.feed();
        System.out.println("此时" + p1.getName() + "的体重变成了" + p1.getWeight() + "kg");
    }
    /* 为什么明明只对p2进行操作，最终p1的体重发生了变化？
     *  因为从根本上来看，p1,p2是同一只宠物。
     *  当执行 Pet p1 = new Pet() 时，在堆内存创建了一个Pet对象，p1变量存储的是这个对象的地址，不是对象本身
     *  当执行 Pet p2 = p1 时，只是把p1中的地址复制给了p2，此时p1和p2指向的是堆内存中的同一个对象
     *  所以通过p2修改了对象的weight，用p1访问时自然能看到变化
     *  "别名现象"的本质： 多个引用指向同一个对象
     *          原因： = 在引用类型中，赋值的是"地址"，不是"复制对象"
     */
}
