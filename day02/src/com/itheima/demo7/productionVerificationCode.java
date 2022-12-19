package com.itheima.demo7;

import java.util.Random;

public class productionVerificationCode {
    public static void main(String[] args) {
        // 生成一个长度为5的验证码
        // 其中4位是大写或者小写字母
        // 另一位是0-9的数字，数字可以出现在任何位置

        // 定义一个字符数组，存储a-z A-Z 52个字母
        char[] letters = new char[52];
        for (int i = 0; i < letters.length; i++) {
            if (i >= 26) {
                letters[i] = (char) (97 + i - 26);
            } else {
                letters[i] = (char) (65 + i);
            }
        }
        // 生成一个长度为5的字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            Random r = new Random();
            int num = r.nextInt(0, 52);
            sb.append(letters[num]);
        }
        String str = sb.toString();

        String result = scramble(str);
        System.out.println(result);
        // 整数变成字符
        char i = 1 + ' ';
        System.out.println(i);
    }

    // 生产一个随机的0-9之间的字符
    public static char numStr() {
        String str = "0123456789";
        char[] arr = str.toCharArray();
        Random r = new Random();
        int index = r.nextInt(0, str.length());
        return arr[index];
    }

    // 将0-9之间的字符随机插入
    public static String scramble(String str) {
        char[] arr = str.toCharArray();
        Random r = new Random();
        int index = r.nextInt(0, str.length());
        arr[index] = numStr();
        return new String(arr);
    }
}
