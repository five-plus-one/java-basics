package com.fiveplusone.test1;

public class GameTest {
    public static void main(String[] args) {
        Role r1 = new Role("test1",100,'男');
        Role r2 = new Role("test2",100,'女');

        r1.showRoleInfo();
        r2.showRoleInfo();
        while(true){
            r1.attack(r2);
            if(r2.getBlood() == 0){
                System.out.println(r2.getName()+"被"+r1.getName()+"击杀了");
                break;
            }
            r2.attack(r1);
            if(r1.getBlood() == 0){
                System.out.println(r1.getName()+"被"+r2.getName()+"击杀了");
                break;
            }
        }
    }
}
