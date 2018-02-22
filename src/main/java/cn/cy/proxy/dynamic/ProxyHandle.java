package cn.cy.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by jiangyi on 2017/7/19.
 */
public class ProxyHandle<T> implements InvocationHandler {

    public ProxyHandle(T obj){
        this.obj = obj;
    }

    T obj;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("方法执行前...");

        Object o =  method.invoke(obj, args);

        System.out.println("方法执行后...");

        return o;
    }
}
