package com.itheima.demo10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 正则表达式
// 校验qq号
// 长度在6~20之间
// 不能以0开头
// 必须全是数字
public class RegexDemo1 {
    public static void main(String[] args) {
        String qq = "[GCDZTSPKXLY1-9]\\d{1,4}";

        System.out.println(qq.matches("1[2-9]\\d{9}"));

        String str = "Java11 112313 Java";
        Pattern p = Pattern.compile("Java\\d{0,2}");
        Matcher m = p.matcher(str);
        boolean b = m.find();
        System.out.println(b);

    }
}
