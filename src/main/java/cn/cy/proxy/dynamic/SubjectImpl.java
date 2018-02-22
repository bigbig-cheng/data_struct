package cn.cy.proxy.dynamic;

/**
 * Created by jiangyi on 2017/7/19.
 */
public class SubjectImpl implements Subject {

    @Override
    public boolean doSomething() {
        System.out.println("做一些该做的事...");
        return true;
    }
}
