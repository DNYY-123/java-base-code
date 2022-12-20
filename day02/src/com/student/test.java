package com.student;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        ArrayList<studentManagementSys> student = new ArrayList<>();
        studentManagementSys s1 = new studentManagementSys(1, "张三", 18, "北京");
        studentManagementSys s2 = new studentManagementSys(2, "李四", 20, "南京");
        studentManagementSys s3 = new studentManagementSys(3, "王五", 24, "江西");
        student.add(s1);
        student.add(s2);
        student.add(s3);
        init(student);
    }

    // 添加功能
    // 键盘录入每一个学生的信息并添加,要求id唯一
    public static void addInfo(ArrayList<studentManagementSys> student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请添加学生信息:");
        System.out.println("请添加学生姓名:");
        String name = sc.next();
        System.out.println("请添加学生年龄:");
        int age = sc.nextInt();
        System.out.println("请添加学生地址:");
        String address = sc.next();
        studentManagementSys s = new studentManagementSys(student.size() + 1, name, age, address);
        student.add(s);
        queryInfo(student);
        init(student);
    }

    // 删除功能
    // 键盘录入学生的id,要求如下:
    // 1.id存在,删除学生信息
    // 2.id不存在,需提示不存在,并返回开始菜单
    public static void delInfo(ArrayList<studentManagementSys> student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生id:");
        int id = sc.nextInt();
        for (int i = 0; i < student.size(); i++) {
            if (id == student.get(i).getId()) {
                student.remove(i);
                System.out.println("删除成功!");
                queryInfo(student);
                delInfo(student);
                break;
            } else {
                System.out.println("没有此学生的信息");
                init(student);
            }
        }
    }

    // 修改功能
    // 键盘录入要修改学生的id,要求如下:
    // 1.id存在,继续录入其他信息
    // 2.id不存在,需提示不存在,并返回开始菜单
    public static void modifyInfo(ArrayList<studentManagementSys> student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生id:");
        int id = sc.nextInt();
        for (int i = 0; i < student.size(); i++) {
            if (id == student.get(i).getId()) {
                System.out.println("请修改学生姓名:");
                String name = sc.next();
                System.out.println("请修改学生年龄:");
                int age = sc.nextInt();
                System.out.println("请修改学生地址:");
                String address = sc.next();
                studentManagementSys s = new studentManagementSys(id, name, age, address);
                student.set(i, s);
                System.out.println("修改成功!");
                queryInfo(student);
                modifyInfo(student);
                break;
            } else {
                System.out.println("没有此学生的信息");
                init(student);
            }
        }
    }

    // 查询功能
    // 打印每一个学生的信息,要求如下:
    // 1.若没有学生信息,提示当前无学生信息,请添加后查询
    // 2.若有学生信息,则按照格式输入信息
    // id  name  age  address
    // 1   张三   18   北京
    public static void queryInfo(ArrayList<studentManagementSys> student) {
        if (student.size() == 0) {
            System.out.println("当前无学生信息,请添加后查询!");
        } else {
            System.out.println("id   " + "name   " + "age   " + "address");
            for (int i = 0; i < student.size(); i++) {
                int id = student.get(i).getId();
                String name = student.get(i).getName();
                int age = student.get(i).getAge();
                String address = student.get(i).getAddress();
                System.out.println(id + "    " + name + "    " + age + "    " + address);
            }

        }
    }

    // 初始化
    public static void init(ArrayList<studentManagementSys> student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------欢迎来到黑马学院学生管理系统---------------");
        System.out.println("1：添加学生");
        System.out.println("2：删除学生");
        System.out.println("3：修改学生");
        System.out.println("4：查询学生");
        System.out.println("5：退出");
        System.out.println("请输入您的选择：");
        int num = sc.nextInt();
        switch (num) {
            case 1 -> addInfo(student);
            case 2 -> delInfo(student);
            case 3 -> modifyInfo(student);
            case 4 -> queryInfo(student);
            case 5 -> {
                break;
            }
            default -> {
                System.out.println("输入的字符无效,请重新输入");
                init(student);
            }
        }

    }
}
