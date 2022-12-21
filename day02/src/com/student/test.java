package com.student;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        // 登陆系统
        loginInterface();
        // 系统初始化
        // init();
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
        init();
    }

    // 删除功能
    // 键盘录入学生的id,要求如下:
    // 1.id存在,删除学生信息
    // 2.id不存在,需提示不存在,并返回开始菜单
    public static void delInfo(ArrayList<studentManagementSys> student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生id:");
        int id = sc.nextInt();
        boolean flag = isId(student, id);
        if (flag) {
            student.remove(id - 1);
            System.out.println("删除成功!");
            queryInfo(student);
            delInfo(student);
        }
        System.out.println("没有此学生的信息");
        init();
    }

    // 修改功能
    // 键盘录入要修改学生的id,要求如下:
    // 1.id存在,继续录入其他信息
    // 2.id不存在,需提示不存在,并返回开始菜单
    public static void modifyInfo(ArrayList<studentManagementSys> student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生id:");
        int id = sc.nextInt();
        boolean flag = isId(student, id);
        if (flag) {
            System.out.println("请修改学生姓名:");
            String name = sc.next();
            System.out.println("请修改学生年龄:");
            int age = sc.nextInt();
            System.out.println("请修改学生地址:");
            String address = sc.next();
            studentManagementSys s = new studentManagementSys(id, name, age, address);
            student.set(id - 1, s);
            System.out.println("修改成功!");
            queryInfo(student);
            modifyInfo(student);
        }
        System.out.println("没有此学生的信息");
        init();
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
            System.out.println("id" + "\t" + "name" + "\t" + "age" + "\t" + "address");
            for (int i = 0; i < student.size(); i++) {
                int id = student.get(i).getId();
                String name = student.get(i).getName();
                int age = student.get(i).getAge();
                String address = student.get(i).getAddress();
                System.out.println(id + "\t" + name + "\t" + age + "\t" + address);
            }
        }
    }

    // 初始化
    public static void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------欢迎来到黑马学院学生管理系统---------------");
        System.out.println("1：添加学生");
        System.out.println("2：删除学生");
        System.out.println("3：修改学生");
        System.out.println("4：查询学生");
        System.out.println("5：退出");
        System.out.println("请输入您的选择：");
        int num = sc.nextInt();
        ArrayList<studentManagementSys> student = initialInfo();
        switch (num) {
            case 1 -> addInfo(student);
            case 2 -> delInfo(student);
            case 3 -> modifyInfo(student);
            case 4 -> queryInfo(student);
            case 5 -> {
            }
            default -> {
                System.out.println("输入的字符无效,请重新输入");
                init();
            }
        }
    }


    // 登陆界面
    public static void loginInterface() {
        System.out.println("欢迎来到学生管理系统");
        System.out.println("请选择操作1登录 2注册 3忘记密码");
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        ArrayList<accountInformation> account = new ArrayList<>();
        accountInformation ac1 = new accountInformation("Admin", "744311", "360481196501260318", "15579486497");
        account.add(ac1);
        switch (num) {
            case "1" -> login(account);
            case "2" -> register(account);
            case "3" -> changePassword(account);
            default -> {
                System.out.println("输入的字符无效,请重新输入!!!");
                loginInterface();
            }
        }
    }

    // 登陆
    public static void login(ArrayList<accountInformation> account) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = sc.next();
        boolean flag = isUserName(account, userName);
        System.out.println("请输入密码：");
        String passWord = sc.next();
        // System.out.println(account.get(1).getUserName());

        if (flag) {
            int index = getIndex(account, userName);
            String passWord1 = account.get(index).getPassWord();
            if (passWord1.equals(passWord)) {
                init();
            } else {
                System.out.println("输入的用户名或密码不正确！！！");
                login(account);
            }
        } else {
            System.out.println("输入的用户名不正确！！！");
            login(account);
        }
    }

    // 注册
    public static void register(ArrayList<accountInformation> account) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = sc.next();
        boolean flag = verificationUserName(account, userName);
        if (flag) {
            System.out.println("请输入密码：");
            String passWord = sc.next();
            System.out.println("请再次输入密码：");
            String passWord1 = sc.next();
            if (confirmPassword(passWord, passWord1)) {
                System.out.println("请输入身份证号：");
                String id = sc.next();
                if (verificationId(id)) {
                    System.out.println("请输入手机号：");
                    String phoneNum = sc.next();
                    if (verificationPhoneNum(phoneNum)) {
                        accountInformation a = new accountInformation(userName, passWord, id, phoneNum);
                        account.add(a);
                        System.out.println("注册成功！！");
                        loginInterface();
                    } else {
                        System.out.println("输入的手机号格式不对！！！");
                        register(account);
                    }
                } else {
                    System.out.println("输入的不符合要求！！！");
                    register(account);
                }
            } else {
                System.out.println("两次输入的密码不一致！！！");
                register(account);
            }
        } else {
            System.out.println("输入的用户名已存在！！！");
            register(account);
        }
    }

    // 忘记密码,修改密码
    public static void changePassword(ArrayList<accountInformation> account) {
        System.out.println("修改密码");

    }

    // 预存入学生信息
    public static ArrayList<studentManagementSys> initialInfo() {
        ArrayList<studentManagementSys> student = new ArrayList<>();
        studentManagementSys s1 = new studentManagementSys(1, "张三", 18, "北京");
        studentManagementSys s2 = new studentManagementSys(2, "李四", 20, "南京");
        studentManagementSys s3 = new studentManagementSys(3, "王五", 24, "江西");
        student.add(s1);
        student.add(s2);
        student.add(s3);
        return student;
    }

    // 判断id是否存在
    public static boolean isId(ArrayList<studentManagementSys> student, int id) {
        for (int i = 0; i < student.size(); i++) {
            if (id == student.get(i).getId()) {
                return true;
            }
        }
        return false;
    }

    // 判断userName是否存在
    public static boolean isUserName(ArrayList<accountInformation> account, String userName) {
        for (int i = 0; i < account.size(); i++) {
            if (userName.equals(account.get(i).getUserName())) {
                return true;
            }
        }
        return false;
    }

    // 获取输入用户的索引
    public static int getIndex(ArrayList<accountInformation> account, String userName) {
        for (int i = 0; i < account.size(); i++) {
            if (userName.equals(account.get(i).getUserName())) {
                return i;
            }
        }
        return -1;
    }

    // 验证注册输入的用户名是否符合规则
    public static boolean verificationUserName(ArrayList<accountInformation> account, String userName) {
        // 1.验证用户名是否存在
        boolean flag = isUserName(account, userName);
        if (!flag) {
            if (userName.length() >= 3 && userName.length() <= 15) {
                char[] arr = userName.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    if ((arr[i] >= 'a' && arr[i] < 'z') || (arr[i] >= 'A' && arr[i] < 'Z') || (arr[i] >= '0' && arr[i] <= '9')) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    // 验证两次输入的密码是否一致
    public static boolean confirmPassword(String pw1, String pw2) {
        return pw1.equals(pw2);
    }

    // 验证身份证号是否符合需求
    public static boolean verificationId(String id) {
        char[] arr = id.toCharArray();
        if (id.length() == 18 && arr[0] != '0' && ((arr[arr.length - 1] > '0' && arr[arr.length - 1] < '9') || arr[arr.length - 1] == 'x' || arr[arr.length - 1] == 'X')) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] >= '0' && arr[i] <= '9') {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean verificationPhoneNum(String phoneNum) {
        char[] arr = phoneNum.toCharArray();
        if (phoneNum.length() == 11 && arr[0] == '1') {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] >= '0' && arr[i] <= '9') {
                    return true;
                }
            }
        }
        return false;
    }
}
