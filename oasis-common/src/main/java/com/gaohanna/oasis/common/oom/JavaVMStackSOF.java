package com.gaohanna.oasis.common.oom;

/**
 * Created by 高寒娜
 *
 * @User: gaohanna
 * @Date: 2018/1/20
 * @Time: 下午9:15
 * @Description:
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    /**
     * -Xss160k
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }

}
