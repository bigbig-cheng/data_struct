package cn.cy.data_struct.stack;

/**
 * Created by jiangyi on 2017/6/29.
 */
public class Main {

    public static void main(String[] args) {

        LinkedStack<Integer> stack = new LinkedStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);
        Integer i = stack.pop();
        stack.pop();

        System.out.println(stack);
        stack.push(i);
        System.out.println(stack);

    }


}
