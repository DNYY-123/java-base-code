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
            System.out.println("是否继续删除信息？ 1 是 2 否");
            String str = sc.next();
            if (str.equals("1")) {
                delInfo(student);
            }
        } else {
            System.out.println("没有此学生的信息");
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
        ArrayList<studentManagementSys> student = initialInfo();
        loop:
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("---------------欢迎来到黑马学院学生管理系统---------------");
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("5：退出");
            System.out.println("请输入您的选择：");
            String num = sc.next();
            switch (num) {
                case "1" -> addInfo(student);
                case "2" -> delInfo(student);
                case "3" -> modifyInfo(student);
                case "4" -> queryInfo(student);
                case "5" -> {
                    break loop;
                }
                default -> System.out.println("输入的字符无效,请重新输入");
            }
        }
    }


    // 登陆界面
    public static void loginInterface() {
        accountInformation ac1 = new accountInformation("Admin", "744311", "360481196501260318", "15579486497");
        ArrayList<accountInformation> account = new ArrayList<>();
        account.add(ac1);
        loop:
        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作1登录 2注册 3忘记密码");
            Scanner sc = new Scanner(System.in);
            String num = sc.next();
            switch (num) {
                case "1" -> {
                    login(account);
                    break loop;
                }
                case "2" -> register(account);
                case "3" -> changePassword(account);
                default -> {
                    System.out.println("输入的字符无效,请重新输入!!!");
                    break loop;
                }
            }
        }
    }

    // 登陆
    public static void login(ArrayList<accountInformation> account) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名：");
            String userName = sc.next();
            boolean flag = isUserName(account, userName);
            System.out.println("请输入密码：");
            String passWord = sc.next();
            String passWord1 = " ";
            // 输入的用户名不对时，会返回-1
            int index = getIndex(account, userName);
            if (index != -1) {
                passWord1 = account.get(index).getPassWord();
            }
            // 验证用户名和密码
            if (passWord1.equals(passWord) && flag) {
                init();
                break;
            } else System.out.println("输入的用户名或密码不正确！！！");
        }
    }

    // 注册
    public static void register(ArrayList<accountInformation> account) {
        Scanner sc = new Scanner(System.in);
        // 判断用户名
        String userName;
        while (true) {
            System.out.println("请输入用户名：");
            userName = sc.next();
            boolean flag = verificationUserName(account, userName);
            if (flag) {
                break;
            } else System.out.println("输入的用户名已存在或者不符合要求！！！");
        }
        // 判断密码
        String passWord;
        while (true) {
            System.out.println("请输入密码：");
            passWord = sc.next();
            System.out.println("请再次输入密码：");
            String passWord1 = sc.next();
            if (confirmPassword(passWord, passWord1)) {
                break;
            } else System.out.println("两次输入的密码不一致！！！");
        }
        // 判断身份证号
        String id;
        while (true) {
            System.out.println("请输入身份证号：");
            id = sc.next();
            if (verificationId(id)) {
                break;
            } else System.out.println("输入的不符合要求！！！");
        }
        // 判断手机号
        String phoneNum;
        while (true) {
            System.out.println("请输入手机号：");
            phoneNum = sc.next();
            if (verificationPhoneNum(phoneNum)) {
                break;
            } else System.out.println("输入的手机号格式不对！！！");
        }
        accountInformation a = new accountInformation(userName, passWord, id, phoneNum);
        account.add(a);
        System.out.println("注册成功！！");
    }

    // 忘记密码,修改密码
    public static void changePassword(ArrayList<accountInformation> account) {
        Scanner sc = new Scanner(System.in);
        String userName;
        // 判断需要修改密码的用户名是否存在
        while (true) {
            System.out.println("请输入需要修改密码的用户名");
            userName = sc.next();
            boolean flag = isUserName(account, userName);
            if (flag) {
                break;
            } else System.out.println("输入的用户名不存在!!!");
        }
        // 判断两次输入的密码是否一致,若一致 则修改 若不一致 则重新输入
        while (true) {
            int index = getIndex(account, userName);
            System.out.println("请输入新密码：");
            String passWord = sc.next();
            System.out.println("请再次输入新密码：");
            String passWord1 = sc.next();
            if (confirmPassword(passWord, passWord1)) {
                account.get(index).setPassWord(passWord);
                System.out.println("修改密码成功！！！");
                break;
            } else System.out.println("两次输入的密码不一致！！！");
        }
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
        int flag = getIndex(account, userName);
        return flag != -1;
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
        // 验证用户名的的长度
        if (userName.length() < 3 || userName.length() > 15) {
            return false;
        }
        // 验证用户名是否只是由字母和数字组成
        for (int i = 0; i < userName.length(); i++) {
            char c = userName.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {
                return false;
            }
        }
        // 验证用户名是否全由数字组成
        for (int i = 0; i < userName.length(); i++) {
            char c = userName.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                // 如果有多个验证条件，那么验证唯一性的语句放在最后
                // 验证用户名是否存在
                boolean flag = isUserName(account, userName);
                if (!flag) {
                    return true;
                }
            }
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
        // 长度是18，第一位不是0，最后以为可以是数字和x或者X
        if (!(id.length() == 18 && arr[0] != '0' && ((arr[arr.length - 1] > '0' && arr[arr.length - 1] < '9') || arr[arr.length - 1] == 'x' || arr[arr.length - 1] == 'X'))) {
            return false;
        }
        // 前十七位必须是数字
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < '0' || arr[i] > '9') {
                return false;
            }
        }
        return true;
    }

    // 验证手机号格式是否正确
    public static boolean verificationPhoneNum(String phoneNum) {
        char[] arr = phoneNum.toCharArray();
        // 长度是11，第一位是12
        if (phoneNum.length() != 11 || arr[0] != '1') {
            return false;
        }
        // 全部是数字
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < '0' || arr[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
