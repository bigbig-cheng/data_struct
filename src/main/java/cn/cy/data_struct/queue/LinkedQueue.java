package cn.cy.data_struct.queue;

/**
 * Created by jiangyi on 2017/6/29.
 */
public class LinkedQueue<T> {

    public LinkedQueue(){
        this.head = new Node(null);
        this.end = new Node(null);
        this.init();
    }

    private Node head;// 头结点
    private Node end; // 尾节点
    private int size; // 队列长度

    public int size(){
        return this.size;
    }

    private void init(){
        this.size = 0;
        this.head.setNext(this.end);
        this.end.setPre(this.head);
    }

    public void empty(){
        this.init();
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public T add(T t){
        Node newNode = new Node(t);
        this.end.pre.setNext(newNode);
        newNode.setPre(this.end.pre);
        this.end.pre = newNode;
        newNode.setNext(this.end);
        this.size ++ ;
        return t;
    }

    public T poll(){
        if(this.isEmpty()){
            return null;
        }

        Node temp = this.head.getNext();
        this.head.next = temp.next;
        this.size--;
        return temp.getData();
    }

    public T peek(){
        if(this.isEmpty()){
            return null;
        }
        return this.head.next.getData();
    }

    public String toString(){
        StringBuffer sb = new StringBuffer("[");
        Node temp = this.head.next;
        while(temp != this.end){
            sb.append(temp.toString());
            temp = temp.next;
            if(temp != this.end){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    class Node{

        public Node(T t){
            this.data = t;
        }

        private T data;
        private Node pre;
        private Node next;

        public String toString(){
            return this.data==null ? "NULL":this.data.toString();
        }

        public T getData() {
            return data;
        }
        public void setData(T data) {
            this.data = data;
        }
        public Node getPre() {
            return pre;
        }
        public void setPre(Node pre) {
            this.pre = pre;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }
}
