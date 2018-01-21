package com.gaohanna.oasis.common.oom;

/**
 * Created by 高寒娜
 *
 * @User: gaohanna
 * @Date: 2018/1/21
 * @Time: 下午6:24
 * @Description:
 */
public class MemoryAllocation {

    private static final int int_1MB = 1024 * 1024;

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+UseSerialGC -XX:SurvivorRatio=8
     */
    public static void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * int_1MB];
        allocation2 = new byte[2 * int_1MB];
        allocation3 = new byte[2 * int_1MB];
        allocation4 = new byte[4 * int_1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }

}
