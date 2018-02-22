package cn.cy.data_struct.stack;

/**
 * Created by jiangyi on 2017/6/29.
 */
public class LinkedStack<T> {

    Node top;

    public LinkedStack(){
        this.init();
    }

    private void init(){
        this.top = new Node(null);
        this.top.next = null;
    };

    public void empty(){
        this.init();
    }

    public boolean isEmpty(){
        return this.top.next == null;
    }

    public T push(T t){
        Node next = top.next;
        Node newNode = new Node(t);
        newNode.next = next;
        top.next = newNode;
        return t;
    }

    public T pop(){
        Node currNode = top.next;
        top.next = currNode.next;
        return currNode.data;
    }

    public String toString(){

        Node temp = top.next;
        StringBuffer sb = new StringBuffer("[");
        while(temp != null){
            sb.append(temp);
            temp = temp.next;
            if(temp != null){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    class Node{
        T data;
        Node next;

        public Node(T t){
            this.data = t;
        }

        public String toString(){
            return this.data==null?"NULL":this.data.toString();
        }
    }

}
