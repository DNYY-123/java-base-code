package com.itheima.demo6;

import java.util.Random;
import java.util.Scanner;

public class scrambleStrings {
    // 键盘录入一个字符串
    // 打乱里面的内容
    // 修改字符串里面的两种形式
    // 1.subString
    // 2.变成字符数组
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数组：");
        String str = sc.next();
        String result = scramble(str);
        System.out.print(result);
    }


    public static String scramble(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            Random r = new Random();
            int index = r.nextInt(0, arr.length);
            // 将数组中第一个元素和一个随机的元素进行交换
            char temp = arr[0];
            arr[0] = arr[index];
            arr[index] = temp;
        }
        return new String(arr);
    }
}
