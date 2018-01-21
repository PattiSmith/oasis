package com.gaohanna.oasis.common.oom;

/**
 * Created by 高寒娜
 *
 * @User: gaohanna
 * @Date: 2018/1/21
 * @Time: 上午10:38
 * @Description:
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

    }

}
