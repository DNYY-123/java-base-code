package com.itheima.demo2;

import java.util.Scanner;

public class strToRoman {
    // 键盘录入一个字符串
    // 要求1：长度小于等于9
    // 要求2：只能是数字
    // 将内容变成罗马数字
    // 对应关系
    // Ⅰ - 1、 Ⅱ - 2、 Ⅲ - 3、 Ⅳ - 4、 Ⅴ - 5、 Ⅵ - 6、 Ⅶ - 7、 Ⅷ - 8、 Ⅸ - 9
    // 罗马数字里没有0
    // 如果键盘录入的数字包含0，可以变成” “
    public static void main(String[] args) {
        // 键盘录入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String nums;
        while (true) {
            nums = sc.next();
            // 判断输入的字符串是否小于9位
            if (nums.length() <= 9 && isNum(nums)) {
                break;
            } else {
                System.out.println("输入的字符串不符合要求！！");
                System.out.println("请重新输入一个字符串：");
            }
        }
        String result = toRoma(nums);
        System.out.println(result);

    }

    public static String toRoma(String str) {
        //  定义一个数组存入罗马数字
        StringBuilder sb = new StringBuilder();
        String result = "";
        char[] romaNum = {'1', 'Ⅰ', 'Ⅱ', 'Ⅲ', 'Ⅳ', 'Ⅴ', 'Ⅵ', 'Ⅶ', 'Ⅷ', 'Ⅸ'};
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            int num = s - 48;
            sb.append(romaNum[num]);
            result = sb.toString();
        }
        return result;
    }

    // 判断输入的字符串是否是数字
    public static boolean isNum(String str) {
        for (int i = 0; i < str.length(); ) {
            char s = str.charAt(i);
            if (s >= '0' && s <= '9') {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}






