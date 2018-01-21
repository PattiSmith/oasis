package com.gaohanna.oasis.common.oom;

/**
 * Created by 高寒娜
 *
 * @User: gaohanna
 * @Date: 2018/1/21
 * @Time: 上午11:23
 * @Description:
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    /**
     * -XX:+PrintGCDetails
     * @param args
     */
    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;


        System.gc();
    }

}
