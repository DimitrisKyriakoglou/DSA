package datastructures.queue;

import datastructures.stack.Stack;

public class Queue {
    private Node first;

    private Node last;

    private int length;

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value=value;
        }
    }

    public Queue(int value){
        Node newNode = new Node(value);
        first = newNode;
        last= newNode;
        length=1;
    }

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getFirst() {
        System.out.println("Head: " + first.value);
    }
    public void getLast() {
        System.out.println("Head: " + last.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }



}
