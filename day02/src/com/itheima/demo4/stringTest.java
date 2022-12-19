package com.itheima.demo4;

import java.util.Scanner;

public class stringTest {
    public static void main(String[] args) {
        // 1.输入需要转换的金额
        Scanner sc = new Scanner(System.in);
        int money;
        System.out.println("请录入一个金额:");
        while (true) {
            money = sc.nextInt();
            if (money >= 0 && money < 9999999) {
                break;
            } else {
                System.out.println("录入金额无效,请重新录入:");
            }
        }
        // 定义一个StringBuilder对象 存储大写金额
        StringBuilder moneyCase = new StringBuilder();
        // 2.定义大写金额数组
        String[] moneyStrings = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        // 遍历出金额的每一个数字,将其转换为大写
        while (true) {
            int ge = money % 10;
            if (ge == 0) {
                break;
            }
            money = money / 10;
            moneyCase.append(moneyStrings[ge]);
        }
        // 金额长度不足7位 在前面补零
        int moneyCaseLength = moneyCase.length();
        // String.repeat(i) 复制字符串i次 返回复制之后的结果
        moneyCase.append("零".repeat(7 - moneyCaseLength));
        // 调用字符串反转方法
        String moneyCase2 = invertString(moneyCase.toString());

        // 定义一个储存单位的数组
        String[] Company = {"佰", "拾", "万", "仟", "佰", "拾", "元"};
        // 输出最后结果
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Company.length; i++) {
            result.append(moneyCase2.charAt(i)).append(Company[i]);
        }
        System.out.println(result);
    }

    // 将字符串反转
    public static String invertString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
