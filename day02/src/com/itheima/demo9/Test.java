package com.itheima.demo9;

public class Test {
    // 现有如下文本：
    // "Java语言是面向对象的，Java语言是健壮的，Java语言是安全的，Java是高性能的，Java语言是跨平台的。"
    // 请编写程序，统计该文本中"Java"一词出现的次数。

    public static void main(String[] args) {
        String str1 = "Java语言是面向对象的，Java语言是健壮的，Java语言是安全的，Java是高性能的，Java语言是跨平台的。";
        String str2 = "Java";
        int count = 0;
        while (true) {
            int index = str1.indexOf(str2);
            str1 = str1.substring(index + str2.length());
            if (index == -1) {
                break;
            } else {
                count++;
            }
        }
        System.out.println(str2 + "出现的次数是：" + count);
    }
}
