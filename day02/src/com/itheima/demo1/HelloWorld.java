package com.itheima.demo1;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
       // System.out.println("请输入一个三位数：");
       // Scanner sc = new Scanner(System.in);
       // int num = sc.nextInt();
       // System.out.println(num);
       //  强制转换 有可能会导致数据错误
       // double a =12.2;
       // int b = (int) a;
       //
       // byte c = 12;
       // byte d = 13;
       // System.out.println(b);
       // byte e = (byte)(c + d );
       // System.out.println(e);
       //
       // 短路逻辑运算符
       // 左边的表达式?可以确定结果，就不会判断右边
       // 短路与&&
       // System.out.println(false && true);
       // 短路或||
       // System.out.println(true || false);

        /*
        * 键盘录入两个整数
        * 如果其中一个为6，最终结果输出为true
        * 如果他们的和为6的倍数，最终结果输出为true
        * 其他情况为false
        * */
        // Scanner sc = new Scanner(System.in);
        // System.out.println("请输入第一位数：");
        // int num1 = sc.nextInt();
        // int numLenth = ("" + num1).length();
        // System.out.println(numLenth);
        // int ge = num1 % (10^(numLenth - 1));
        char[] arr = {'1', '2', '3'};
        System.out.println(arr.toString());
    }
}
