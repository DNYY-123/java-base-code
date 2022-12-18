package com.itheima.demo2;

public class Test {
    public static void main(String[] args) {
        Role r2 = new Role("张敏",100,'女');
        Role r1 = new Role("张无忌",100,'男');
        int i = 0;
        while (i < 5) {
            r1.attack(r1.getName(), r2.getName());
            System.out.println();
            System.out.println(r1.getBlood());
            i++;
        }
    }

}

