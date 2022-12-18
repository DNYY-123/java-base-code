package com.itheima.demo2;


import java.util.Random;

public class Role {
    //定义人物数据
    //姓名 name  血量 blood 性别 gender 相貌 face
    private String name;
    private int blood;
    private char gender;
    private String face;
    String[] boyFace = {"英俊潇洒", "仪表不凡", "五官端正","相貌平平"};
    String[] girlFace = {"美若天仙", "亭亭玉立", "气质不凡","相貌平平"};

    String[] attack_des = {
            "%s轻轻的打了%s一下",
            "%s重重的打了%s一下",
            "%s拿皮带打了%s一下",
            "%s拿扫把打了%s一下",
            "%s鞭子打了%s一下",
    };
    //构造方法没有返回值 没有返回值类型 void都不能有
    //会在创建对象是由虚拟机调用，不能自己调用
    public  Role() {}

    public Role(String name, int blood, char gender) {
        this.name = name;
        this.blood = blood;
        this.gender = gender;
        setFace(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        Random r = new Random();
        this.blood = this.blood - r.nextInt(15);
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFace() {

        return face;
    }

    public void setFace(char gender) {
        Random r = new Random();

        //需根据性别来判断相貌
        if(gender == '男') {
            int index = r.nextInt(boyFace.length);
            this.face = boyFace[index];
        } else if (gender == '女') {
            int index = r.nextInt(girlFace.length);
            this.face = girlFace[index];
        } else {
            this.face = "相貌平平";
        }
    }

    // 展示信息
    public void  showInfo() {
        setBlood(blood);
        System.out.println("姓名：" + this.name);
        System.out.println("姓名：" + this.name);
        System.out.println("血量：" + this.blood);
        System.out.println("性别：" + this.gender);
        System.out.println("相貌：" + this.face);
    }

    // 攻击
    int[] damageValue = {2,5,10,15,20};
    public void attack(String name1, String name2) {
        Random r = new Random();
        int index = r.nextInt(attack_des.length);
        switch (index) {
            case 1 -> {
                System.out.printf(attack_des[index] + "造成了" + damageValue[1] +"伤害", name1, name2);
                this.blood = this.blood - damageValue[1];
            }
            case 2 -> {
                System.out.printf(attack_des[index] + "造成了" + damageValue[2] +"伤害", name1, name2);
                this.blood = this.blood - damageValue[2];
            }
            case 3 -> {
                System.out.printf(attack_des[index] + "造成了" + damageValue[3] +"伤害", name1, name2);
                this.blood = this.blood - damageValue[3];
            }
            case 4 -> {
                System.out.printf(attack_des[index] + "造成了" + damageValue[4] +"伤害", name1, name2);
                this.blood = this.blood - damageValue[4];
            }
            case 5 -> {
                System.out.printf(attack_des[index] + "造成了" + damageValue[5] +"伤害", name1, name2);
                this.blood = this.blood - damageValue[5];
            }

        }
    }


}
