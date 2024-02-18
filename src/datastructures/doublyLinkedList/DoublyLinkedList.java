package datastructures.doublyLinkedList;

import datastructures.linkedList.LinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    class Node {
        int value;
        Node next;
        Node previous;
        Node(int value) {
            this.value = value;
        }

    }

    public void printList() {
        DoublyLinkedList.Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }


    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            // If the list is not empty, set the next node of the
            // current tail to the new node
            // and update the tail to be the new node
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        // Increment the length of the list
        length++;
    }


    public Node removeLast() {
        // if the length of the linked list is 0, return null
        if (length == 0) return null;
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
            temp.previous = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value) {
        // create a new node with the specified value
        Node newNode = new Node(value);
        // if the linked list is currently empty
        if (length == 0) {
            // set the new node as both the head and tail of the linked list
            head = newNode;
            tail = newNode;
        } else {
            // set the new node's next reference to the current head node
            newNode.next = head;
            head.previous = newNode;
            // set the new node as the new head node of the linked list
            head = newNode;
        }
        // increment the length of the linked list
        length++;
    }

    public Node removeFirst() {
        // if the length of the linked list is 0, return null
        if (length == 0) return null;
        // save a reference to the current head node
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index) {
        // if the index is less than 0 or greater than or equal to the length of the linked list, return null
        if (index < 0 || index >= length) return null;
        Node temp = head;
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.previous;
            }
        }
        // return the pointer to the node at the desired index
        return temp;
    }

    public boolean set(int index, int value) {
        // retrieve the node at the specified index
        Node temp = get(index);
        // if the index is out of bounds, return false
        if (temp != null) {
            // if the node is found, set the value of the node
            temp.value = value;
            // return true to indicate that the value was set successfully
            return true;
        }
        // return false if the index is out of bounds
        return false;
    }

    public boolean insert(int index, int value) {
        // Check if the index is valid
        if (index < 0 || index > length) return false;
        // If the index is 0, insert at the beginning of the list
        if (index == 0) {
            prepend(value);
            return true;
        }
        // If the index is at the end, insert at the end of the list
        if (index == length) {
            append(value);
            return true;
        }
        // If the index is in the middle, insert the node
        // Create the new node
        Node newNode = new Node(value);
        // Get a pointer to the node at the previous index
        Node before = get(index - 1);
        Node after = before.previous;
        // Insert the new node by updating the next and previous pointers
        newNode.previous=before;
        newNode.next = after;
        before.next=newNode;
        after.previous=newNode;
        // Update the length of the list
        length++;
        // Return true to indicate successful insertion
        return true;
    }

    public Node remove(int index) {
        // Check if the index is out of bounds
        if (index < 0 || index >= length) return null;
        // If the index is 0, remove the first node in the list
        if (index == 0) return removeFirst();
        // If the index is the last one in the list, remove the last node
        if (index == length - 1) return removeLast();

        //WITH MULTIPLE VARIABLES
        // Get the previous node of the one to be removed
        Node before = get(index - 1);
        // Get the node to be removed
        Node temp = before.next;
        Node after = temp.next;
        before.next = after;
        after.previous=before;
        // Detach the removed node from the list
        temp.next = null;
        temp.previous= null;

        /////////////////////////////////////////////////////////////
        //WITH ONE VARIABLE
        Node tempOneVariable= get(index);
        tempOneVariable.next.previous=tempOneVariable.previous;
        tempOneVariable.previous.next=tempOneVariable.next;
        tempOneVariable.next=null;
        tempOneVariable.previous=null;
        //return tempOneVariable
        ////////////////////////////////////////////////////////////

        // Decrease the length of the list
        length--;
        // Return the removed node
        return temp;
    }

    public void swapFirstLast() {
        // If there are less than two nodes in the list, there's nothing to swap
        if (length < 2) return;

        // Swap the values of the head and tail nodes
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }
    public void reverse() {
        // 'current' starts at the head of the list. This is the starting point
        // for the reversal process.
        Node current = head;

        // 'temp' is a temporary variable used for swapping nodes. It is initially
        // set to null since we haven't started the swapping process yet.
        Node temp = null;

        // We enter a loop that will continue as long as 'current' is not null.
        // This loop goes through each node in the list.
        while (current != null) {
            // Store the previous node of 'current' in 'temp'.
            // This is needed because we will be overwriting 'current.prev' next,
            // and we don't want to lose this reference.
            temp = current.previous;

            // The next two lines are where we swap the 'next' and 'prev' references
            // of the 'current' node. This effectively reverses the direction of the
            // links for 'current'.
            current.previous = current.next; // 'prev' now points to what used to be 'next'
            current.next = temp;         // 'next' now points to what used to be 'prev'

            // Move to the next node in the original list. After the swap, the original
            // 'next' node is now in 'current.prev', so we update 'current' to this node.
            current = current.previous;
        }

        // After the while loop, the list is reversed, but our 'head' and 'tail' pointers
        // are still pointing to the original head and tail. So we need to swap them.
        temp = head;   // Store the original head in 'temp'
        head = tail;   // Update head to be the original tail
        tail = temp;   // Update tail to be what was originally the head
    }



    public boolean isPalindrome() {
        // if the list has only 1 or 0 nodes, it's automatically a palindrome
        if (length <= 1) return true;

        // set up two pointers starting from opposite ends of the list
        Node forwardNode = head;
        Node backwardNode = tail;

        // iterate through the list until the two pointers meet in the middle
        for (int i = 0; i < length / 2; i++) {
            // if the values at the two pointers don't match, the list is not a palindrome
            if (forwardNode.value != backwardNode.value) return false;

            // move the pointers toward the center of the list
            forwardNode = forwardNode.next;
            backwardNode = backwardNode.previous;
        }

        // if the loop completes without returning false, the list is a palindrome
        return true;
    }

    public void swapNodePairs() {
        // Create a placeholder (dummyNode) node to simplify swapping.
        Node dummyNode = new Node(0);

        // Link the dummyNode node to the start of our list.
        dummyNode.next = head;

        // Initialize 'previousNode' to 'dummyNode' to remember the node
        // before each pair we're swapping.
        Node previousNode = dummyNode;

        // Continue as long as there's a pair of nodes to swap.
        while (head != null && head.next != null) {

            // Identify the first node of the pair to swap.
            Node firstNode = head;

            // Identify the second node of the pair to swap.
            Node secondNode = head.next;

            // Connect the previousNode's 'next' pointer to secondNode,
            // essentially skipping over firstNode.
            previousNode.next = secondNode;

            // Connect firstNode to the node after secondNode.
            // This ensures we don't lose the rest of the list.
            firstNode.next = secondNode.next;

            // Connect secondNode back to firstNode,
            // completing the swap.
            secondNode.next = firstNode;

            // Adjust 'prev' pointers for our doubly linked list.
            // Set secondNode's 'prev' to the node before current pair.
            secondNode.previous = previousNode;

            // Set firstNode's 'prev' to secondNode as they've been swapped.
            firstNode.previous = secondNode;

            // If there's a node after our current pair, set its 'prev' to firstNode.
            if (firstNode.next != null) {
                firstNode.next.previous = firstNode;
            }

            // Move the head pointer to the node after the current pair.
            head = firstNode.next;

            // Update 'previousNode' for the next pair of nodes.
            previousNode = firstNode;
        }

        // After swapping all pairs, update our list's head to
        // start at the node after dummyNode.
        head = dummyNode.next;

        // Ensure the new head's 'prev' is null, indicating the start of list.
        if (head != null) head.previous = null;
    }


}



