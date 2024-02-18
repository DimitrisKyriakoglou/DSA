package datastructures.linkedList;

public class Main {

    public static void main(String[] args){

        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);

        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();
        myLinkedList.printList();
        myLinkedList.insert(1,5);


        myLinkedList.removeLast();

        myLinkedList.printList();

    }
}
