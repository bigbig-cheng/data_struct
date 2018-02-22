package cn.cy.data_struct.link;

/**
 * 单链表
 * Created by jiangyi on 2017/6/26.
 */
public class LinkedList<T> {

    private int size;
    private Node first;

    public LinkedList(){
        init();
    }

    private void init(){
        first = new Node();
        this.first.data = null;
        this.first.next = null;
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public void empty(){
        init();
    }

    public boolean contains(T t){
        Node temp = first.next;
        while (temp!=null){
            if(temp.data.equals(t)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public Node getIndex(int index){

        rangeCheck(index);

        Node temp = first;
        for (int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp.next;
    }

    private void rangeCheck(int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    public Node remove(int index){

        rangeCheck(index);

        Node prev = first;
        for (int i=0; i<index; i++){
            prev = prev.next;
        }
        Node removeObj = prev.next;
        if(prev.next.next != null){
            prev.next = prev.next.next;
        }
        size--;
        return removeObj;
    }

    public Node addFirst(T data){
        Node temp = new Node();
        temp.data = data;
        temp.next = first.next;
        first.next = temp;
        size++;
        return temp;
    }

    public Node add(T data){

        Node temp = new Node();
        temp.data = data;
        Node prev = first;
        for (int i=0; i<size(); i++){
            prev = prev.next;
        }
        temp.next = prev.next;
        prev.next = temp;
        size++;
        return temp;
    }

    public String toString(){
        String str = "[";
        Node temp = first;
        while(temp.next != null){
            str += temp.next.toString();
            if(temp.next.next != null){
                str += ",";
            }
            temp = temp.next;
        }
        str += "]";

        return str;
    }

    public LinkedList<T> reverse(){
        LinkedList<T> newList = new LinkedList<>();
        for(int i=0;i<this.size; i++){
            newList.addFirst(this.getIndex(i).data);
            newList.size++;
        }
        return newList;
    }

    public void reverse2(){
        Node newHead = reverseNode(this.first);
        this.first.next = newHead;
    }

    private Node reverseNode(Node node){
        if(node==null || node.next==null){
            return node;
        }
        Node newHead = this.reverseNode(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    class Node {
        T data;
        Node next;

        public String toString(){
            return data==null ? "NULL" : data.toString();
        }
    }
}
