package com.gaohanna.oasis.common.oom;

/**
 * Created by 高寒娜
 *
 * @User: gaohanna
 * @Date: 2018/1/20
 * @Time: 下午9:38
 * @Description:
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true){}
    }

    public void trackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    /**
     * -Xss4M
     * @param args
     */
    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.trackLeakByThread();
    }

}
