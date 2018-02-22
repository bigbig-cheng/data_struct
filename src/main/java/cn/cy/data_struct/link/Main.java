package cn.cy.data_struct.link;

/**
 * Created by jiangyi on 2017/6/26.
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("LinkedList size after init:"+list.size());
        System.out.println("LinkedList print after init:"+list);
        list.addFirst(5);
        System.out.println("LinkedList size after addFirst:"+list.size());
        System.out.println("LinkedList print after addFirst:"+list);
        System.out.println("LinkedList contains:"+list.contains(5));
        System.out.println("LinkedList 指定下标元素为:"+list.getIndex(4));
        list.remove(1);
        System.out.println("LinkedList size after delete:"+list.size());
        System.out.println("LinkedList print after delete:"+list);

        LinkedList newList = list.reverse();
        System.out.println(list);
        System.out.println(newList);
        list.reverse2();
        System.out.println("reverse2:"+list);

        list.empty();
        System.out.println("LinkedList print after empty:"+list.size());
        System.out.println("LinkedList print after empty:"+list);


    }

}
