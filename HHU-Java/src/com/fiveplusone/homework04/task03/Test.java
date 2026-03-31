package com.fiveplusone.homework04.task03;

public class Test {
    public static void main(String[] args) {
        GameSave localSave = new LocalSave();
        GameSave cloudSave = new CloudSave();
        localSave.loadSave();
        cloudSave.loadSave();
    }
}
