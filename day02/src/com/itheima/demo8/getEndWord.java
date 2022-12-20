package com.itheima.demo8;

public class getEndWord {
    public static void main(String[] args) {
        String str = "   I have a  dream   oh!  year good lucky ";

        String str1 = removeFirstAndEndSpace(str);
        int temp = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == ' ') {
                temp = i;
            }
        }
        String result = str1.substring(temp + 1);
        System.out.println(result);
    }

    // 去掉首尾有空格的字符串
    public static String removeFirstAndEndSpace(String str) {
        int temp = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                temp = i;
                break;
            }
        }
        String strTemp = str.substring(temp);
        for (int length = strTemp.length() - 1; length > 0; length--) {
            if (strTemp.charAt(length) != ' ') {
                temp = length;
                break;
            }
        }
        return strTemp.substring(0, temp + 1);
    }
}
