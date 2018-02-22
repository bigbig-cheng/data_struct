package cn.cy.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * Created by jiangyi on 2017/7/19.
 */
public class Main {

    public static void main(String[] args) {
        Subject realSubject = new SubjectImpl();

        Subject proxyObj =
                (Subject) Proxy.newProxyInstance(
                        Subject.class.getClassLoader(),
                        new Class[]{Subject.class},
                        new ProxyHandle<Subject>(realSubject)
                );
        Boolean result = proxyObj.doSomething();
        System.out.println(result);
    }

}
