package com.gaohanna.oasis.common.oom;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * Created by 高寒娜
 *
 * @User: gaohanna
 * @Date: 2018/1/21
 * @Time: 上午11:04
 * @Description:
 */
public class DirectMemory {

    private static final int _1MB = 1024 * 1024;

    /**
     * -Xmx20M -XX:MaxDirectMemorySize=10M
     * @param args
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }

}
