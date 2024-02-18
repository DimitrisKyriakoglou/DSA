package datastructures.linkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    // Declare private instance variables
    private Node head;
    private Node tail;
    private int length;

    // Declare a Node inner class
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    // Constructor for initializing the linked list with a value
    public LinkedList(int value) {
        // Create a new node called newNode with the given value,
        // and point both the head and tail at it
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1; // The length of the list is 1
    }

    public void printList() {
        Node temp = head;
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
        // Create a new node with the given value
        Node newNode = new Node(value);
        // If the list is empty, have both head and tail
        // point at the new node.
        // The LL could be come empty if the original node was removed.
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            // If the list is not empty, set the next node of the
            // current tail to the new node
            // and update the tail to be the new node
            tail.next = newNode;
            tail = newNode;
        }
        // Increment the length of the list
        length++;
    }

    public Node removeLast() {
        // if the length of the linked list is 0, return null
        if (length == 0) return null;

        // start at the head node
        Node temp = head;
        Node pre = head;
        // iterate through the linked list until the last node is reached
        while (temp.next != null) {
            pre = temp;  // keep track of the second-to-last node
            temp = temp.next;
        }
        // set the new tail node to be the second-to-last node
        tail = pre;
        // remove the reference to the former tail node
        tail.next = null;
        // decrement the length of the linked list
        length--;
        // if the linked list is now empty, set head and tail to null
        if (length == 0) {
            head = null;
            tail = null;
        }
        // return the removed node
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
        // set the new head node to be the next node in the linked list
        head = head.next;
        // remove the reference to the former head node
        temp.next = null;
        // decrement the length of the linked list
        length--;
        // if the linked list is now empty, set tail to null
        if (length == 0) {
            head = null;
            tail = null;
        }
        // return the removed node
        return temp;
    }

    public Node get(int index) {
        // if the index is less than 0 or greater than or equal to the length of the linked list, return null
        if (index < 0 || index >= length) return null;
        // start at the head of the linked list
        Node temp = head;
        // traverse the linked list until the desired node is reached
        for (int i = 0; i < index; i++) {
            temp = temp.next;
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
        Node temp = get(index - 1);

        // Insert the new node by updating the next pointers
        newNode.next = temp.next;
        temp.next = newNode;

        // Update the length of the list
        length++;

        // Return true to indicate successful insertion
        return true;
    }

    // Remove the node at the specified index in the list
    public Node remove(int index) {
        // Check if the index is out of bounds
        if (index < 0 || index >= length) return null;
        // If the index is 0, remove the first node in the list
        if (index == 0) return removeFirst();
        // If the index is the last one in the list, remove the last node
        if (index == length - 1) return removeLast();

        // Get the previous node of the one to be removed
        Node prev = get(index - 1);
        // Get the node to be removed
        Node temp = prev.next;

        // Update the previous node's pointer to skip over the removed node
        prev.next = temp.next;
        // Detach the removed node from the list
        temp.next = null;
        // Decrease the length of the list
        length--;
        // Return the removed node
        return temp;
    }

    public void reverse() {
        // Set temp to the current head of the linked list
        Node temp = head;
        // Set the new head to be the current tail
        head = tail;
        // Set the new tail to be the previous head (stored in temp)
        tail = temp;

        // Set after to be the next node after the current head
        Node after = temp.next;
        // Initialize before to null, as the first node in the reversed list will not have a previous node
        Node before = null;

        // Loop through the linked list, reversing the order of the nodes
        for (int i = 0; i < length; i++) {
            // Set after to be the next node after the current node
            after = temp.next;
            // Set the current node's next pointer to the previous node
            temp.next = before;
            // Set before to be the current node, as it will be the previous node in the next iteration of the loop
            before = temp;
            // Set temp to be the next node in the linked list
            temp = after;
        }
    }

    public Node findMiddleNode() {
        //Floyd's Tortoise and Hare algorithm
        // Initialize slow pointer to the head of the linked list
        Node slow = head;

        // Initialize fast pointer to the head of the linked list
        Node fast = head;

        // Traverse the linked list with two pointers: slow and fast
        // slow moves one node at a time, while fast moves two nodes at a time
        while (fast != null && fast.next != null) {
            // Move slow pointer to the next node
            slow = slow.next;

            // Move fast pointer to the next two nodes
            fast = fast.next.next;
        }

        // Return the Node object representing the middle node of the linked list
        return slow;
    }
    public boolean hasLoop() {
        // Initialize slow pointer to the head of the linked list
        Node slow = head;

        // Initialize fast pointer to the head of the linked list
        Node fast = head;

        // Traverse the linked list with two pointers: slow and fast
        // slow moves one node at a time, while fast moves two nodes at a time
        while (fast != null && fast.next != null) {
            // Move slow pointer to the next node
            slow = slow.next;

            // Move fast pointer to the next two nodes
            fast = fast.next.next;

            // If slow pointer meets fast pointer, then there is a loop in the linked list
            if (slow == fast) {
                return true;
            }
        }

        // If the loop has not been detected after the traversal, then there is no loop in the linked list
        return false;
    }

    public Node findKthFromEnd(int k) {
        Node slow = head; // Initialize slow pointer at head
        Node fast = head; // Initialize fast pointer at head

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) { // If k is out of bounds, return null
                return null;
            }
            fast = fast.next; // Move the fast pointer to the next node
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next; // Move the slow pointer to the next node
            fast = fast.next; // Move the fast pointer to the next node
        }

        return slow; // Return the kth node from the end (slow pointer)
    }
    public void partitionList(int x) {
        // Step 1: Check for an empty list.
        // If the list is empty, there is nothing
        // to partition, so we exit the method.
        if (head == null) return;

        // Step 2: Create two dummy nodes.
        // These dummy nodes act as placeholders
        // to simplify list manipulation.
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        // Step 3: Initialize pointers for new lists.
        // 'prev1' and 'prev2' will track the end nodes of
        // the two lists that are being created.
        Node prev1 = dummy1;
        Node prev2 = dummy2;

        // Step 4: Start with the head of the original list.
        Node current = head;

        // Step 5: Iterate through the original list.
        while (current != null) {

            // Step 6: Compare current node value with 'x'.
            // Nodes are partitioned based on their value
            // being less than or greater than/equal to 'x'.

            // Step 6.1: If value is less than 'x',
            // add node to the first list.
            if (current.value < x) {
                prev1.next = current;  // Link node to the end of the first list.
                prev1 = current;       // Update the end pointer of the first list.
            } else {
                // Step 6.2: If value is greater or equal,
                // add node to the second list.
                prev2.next = current;  // Link node to the end of the second list.
                prev2 = current;       // Update the end pointer of the second list.
            }

            // Move to the next node in the original list.
            current = current.next;
        }

        // Step 7: Terminate the second list.
        // This prevents cycles in the list.
        prev2.next = null;

        // Step 8: Connect the two lists.
        // The first list is followed by the second list.
        prev1.next = dummy2.next;

        // Step 9: Update the head of the original list.
        // The head now points to the start of the first list.
        head = dummy1.next;
    }

    public void removeDuplicates() {
        // Step 1: Create a Set to store unique node values.
        // We initialize a HashSet, which allows for fast look-up
        // to check for duplicates later on.
        Set<Integer> values = new HashSet<>();

        // Step 2: Initialize a Node variable 'previous' to null.
        // 'previous' will help us unlink a node if it's a duplicate.
        Node previous = null;

        // Step 3: Initialize 'current' to point to the head node.
        // 'current' will be used to iterate through the linked list.
        Node current = head;

        // Step 4: Begin iteration through the linked list.
        // We will keep iterating until 'current' becomes null,
        // indicating we have reached the end of the list.
        while (current != null) {

            // Step 5: Check for duplicates.
            // We check if the current node's value is already in the set.
            if (values.contains(current.value)) {

                // Step 6: Remove the duplicate node.
                // By setting 'previous.next' to 'current.next',
                // we remove the link to 'current', effectively
                // deleting it from the list.
                previous.next = current.next;

                // Step 7: Update the length of the list.
                // Since we removed a node, we decrement the length by 1.
                length -= 1;

            } else {

                // Step 8: Add unique value to set.
                // If the current value is not a duplicate,
                // we add it to the set for future reference.
                values.add(current.value);

                // Step 9: Update 'previous' node.
                // We set 'previous' to the 'current' node, as we
                // move forward in the list.
                previous = current;
            }

            // Step 10: Move to the next node.
            // We update 'current' to point to the next node in the list,
            // continuing our iteration.
            current = current.next;
        }
    }

    public void removeDuplicatesNoSet() {
        // Step 1: Start at the beginning of the list.
        // Initialize `current` to point to the head node.
        // `current` will be used to navigate through the list,
        // one node at a time, starting from the head node.
        Node current = head;

        // Step 2: Check if we've reached the end of the list.
        // We loop until `current` becomes null, which means
        // we've checked all nodes for duplicates.
        while (current != null) {

            // Step 3: Set up a runner node.
            // Initialize `runner` to the `current` node.
            // We'll use `runner` to scan ahead and find duplicates
            // of the `current` node.
            Node runner = current;

            // Step 4: Loop through the remaining nodes.
            // `runner.next` will be null at the end of the list.
            while (runner.next != null) {

                // Step 5: Compare nodes.
                // Check if `runner.next` (the next node) has the
                // same value as `current`.
                if (runner.next.value == current.value) {

                    // Step 6: Remove duplicate.
                    // If we find a duplicate, we skip it by
                    // setting `runner.next` to `runner.next.next`.
                    runner.next = runner.next.next;

                    // Step 7: Update list length.
                    // We removed a node, so decrease the list length
                    // by 1 to keep it accurate.
                    length -= 1;

                } else {
                    // Step 8: Move to the next node.
                    // If the next node is not a duplicate,
                    // move `runner` to the next node to continue.
                    runner = runner.next;
                }
            }
            // Step 9: Move to the next unique node.
            // After checking all nodes for duplicates of the
            // current value, move `current` to the next node.
            current = current.next;
        }
    }
    // Define the binaryToDecimal method for the LinkedList class
    public int binaryToDecimal() {
        // Initialize an integer variable 'num' to 0.
        // This variable will hold the decimal value of the binary number.
        int num = 0;

        // Initialize a Node variable 'current' to point to the head of the LinkedList.
        // We will use 'current' to traverse through the LinkedList.
        Node current = head;

        // Begin a while loop that continues as long as 'current' is not null.
        // A null 'current' would mean we've reached the end of the LinkedList.
        while (current != null) {

            // For each node, shift the existing 'num' value one binary place to the left
            // by multiplying it by 2. Then, add the value of the current node to it.
            // This will build our binary number into its decimal equivalent,
            // one bit at a time.
            num = num * 2 + current.value;

            // Move to the next node in the LinkedList.
            // 'current.next' will either point to the next node, or to null
            // if we've reached the end of the list.
            current = current.next;
        }

        // After the loop, return the decimal value stored in 'num'.
        return num;
    }

    public void reverseBetween(int startIndex, int endIndex) {
        // Check: If linked list is empty, nothing to reverse.
        // Exit the method.
        if (head == null) return;

        // Create a 'dummyNode' that precedes the head.
        // Simplifies handling edge cases.
        Node dummyNode = new Node(0);
        dummyNode.next = head;

        // 'previousNode' is used to navigate to the node
        // right before our sublist begins.
        Node previousNode = dummyNode;

        // Move 'previousNode' to node just before sublist.
        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        // 'currentNode' marks the first node of sublist.
        Node currentNode = previousNode.next;

        // Loop reverses the section from startIndex to endIndex.
        for (int i = 0; i < endIndex - startIndex; i++) {

            // 'nodeToMove' is the node we'll move to sublist start.
            Node nodeToMove = currentNode.next;

            // Detach 'nodeToMove' from its current position.
            currentNode.next = nodeToMove.next;

            // Attach 'nodeToMove' at the beginning of the sublist.
            nodeToMove.next = previousNode.next;

            // Move 'nodeToMove' to the start of our sublist.
            previousNode.next = nodeToMove;
        }

        // Adjust 'head' if the first node was part of sublist.
        head = dummyNode.next;
    }



}

