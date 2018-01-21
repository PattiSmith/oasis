package com.gaohanna.oasis.common.oom;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * Created by 高寒娜
 *
 * @User: gaohanna
 * @Date: 2018/1/21
 * @Time: 上午10:52
 * @Description:
 */
public class JavaMethodAreaOOM {

    /**
     * -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
     * @param args
     */
    public static void main(final String[] args) {

        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
                    throws Throwable {
                    return methodProxy.invokeSuper(o, args);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject{}

}
