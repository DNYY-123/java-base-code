package com.itheima.demo5;

public class rotateString {
    // 给定两个字符串 A 和 B
    // A的旋转操作就是A最左边的字符移动到最右边
    // 在若干次之后，A能变回B，那么返回True
    // 若不能，则返回false
    public static void main(String[] args) {
        String strA = "ABCDE";
        String strB = "DEABC";

        Boolean result = check(strA, strB);
        System.out.println(result);
    }

    // 旋转A
    // 方法1  将第一个字符和其他字符分开，再将第一个字符加到其他字符的后面
    public static String rotateA(String str) {
        char s1 = str.charAt(0);
        String s2 = str.substring(1);
        return s2 + s1;
    }

    // 方法2
    /*String str = "abc";
    等效于：
    char data[] = {'a', 'b', 'c'};
    String str = new String(data);*/
    public static String rotateB(String str) {
        // 将字符串通过toCharArray转换为数组
        char[] arr = str.toCharArray();
        char temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
        // 通过 new String(arr)转换字符串
        return new String(arr);
    }

    // 比较两个字符串是否一样
    public static boolean check(String str1, String str2) {
        for (int i = 0; i < str1.length() - 1; ) {
            str1 = rotateB(str1);
            if (str2.equals(str1)) {
                return true;
            } else {
                i++;
            }
        }
        return false;
    }
}
