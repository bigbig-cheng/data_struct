package cn.cy.data_struct.queue;

/**
 * Created by jiangyi on 2017/6/29.
 */
public class Main {

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        queue.add(3);
        queue.add(2);
        queue.add(5);
        queue.add(4);
        queue.add(1);

        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
    }

}
