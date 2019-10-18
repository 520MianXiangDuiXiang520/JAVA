package junbao.tool;

import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> tLinkedList = new LinkedList<T>();
    public void push(T v){ tLinkedList.addFirst(v);}
    public T pop() {return tLinkedList.removeFirst();}
    public T peek(){ return tLinkedList.getFirst();}
    public boolean isEmpty(){return tLinkedList.isEmpty();}
    public String toString(){return tLinkedList.toString();}
}