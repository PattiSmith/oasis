package com.gaohanna.oasis.common.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 高寒娜
 *
 * @User: gaohanna
 * @Date: 2018/1/20
 * @Time: 下午8:01
 * @Description:
 */
public class HeapOOM {

    static class OOMObject{}

    /**
     * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }

}
