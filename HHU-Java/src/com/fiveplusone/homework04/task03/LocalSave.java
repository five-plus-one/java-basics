package com.fiveplusone.homework04.task03;

public class LocalSave extends GameSave{
    @Override
    void loadSave() {
        System.out.println("Loading save from local storage...");
    }
}
