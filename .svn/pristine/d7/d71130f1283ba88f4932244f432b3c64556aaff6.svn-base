package com.uestc.ganbu.util;

import java.util.LinkedList;

public class Stack<E> {
    private LinkedList<E> linkedList;

    public Stack() {
        linkedList = new LinkedList<>();
    }

    public E push(E e){
        linkedList.addFirst(e);
        return e;
    }

    public E pop(){
        return linkedList.removeFirst();
    }

    public E getTop() {
        return linkedList.getFirst();
    }

    public boolean empty(){
        return linkedList.size() == 0;
    }

    public int size() {
        return linkedList.size();
    }
}
