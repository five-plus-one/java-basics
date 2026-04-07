package com.fiveplusone.homework05.task04;

public class RecycleLine {
    public void processWaste(Ewaste item){
        System.out.println("开始处理...");
        item.crush();
        if (item instanceof Phone) {
            Phone phone = (Phone) item;
            phone.extractLithium();
        } else if (item instanceof Motherboard) {
            Motherboard board = (Motherboard) item;
            board.extractGold();
        } else {
            System.out.println("该电子垃圾无特殊提炼价值。");
        }
        System.out.println("处理完成！");
    }
}
