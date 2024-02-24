package datastructures.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;


    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) {
                return false;
            }
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                } else {
                    temp = temp.right;
                }
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }


    ////////  Recursive   //////////////
    public boolean recursiveContains(Node currentNode, int value) {
        if (currentNode == null) return false;
        if (value == currentNode.value) return true;
        if (value < currentNode.value) {
            return recursiveContains(currentNode.left, value);
        } else {  //if(value > currentNode.value){
            return recursiveContains(currentNode.right, value);
        }
    }

    //Overloaded Method public
    public boolean recursiveContains(int value) {

        return recursiveContains(root, value);
    }

    private Node recursiveInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = recursiveInsert(currentNode.left, value);
        } else { //if(value > currentNode.value){
            currentNode.right = recursiveInsert(currentNode.right, value);
        }


        return currentNode;
    }

    //Overloaded Method public
    public void recursiveInsert(int value) {
        if (root == null) root = new Node(value);
        recursiveInsert(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;

        /// Traverse through the tree
        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
            ///// until here we have checked if the value is in the tree, if not return null
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////// from here and on we found the value and we will take actions to delete it
        } else {
            //left leaf
            if (currentNode.left == null && currentNode.right == null) {
                currentNode = null;
                /// Open on the left and has node on the right
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
                /// Open on the right and has node on the left
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
                //// Has nodes  both left and right
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);

            }
        }
        return currentNode;
    }

    //Overloaded Method public
    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    //////////  Helper Minimum Value //////////////

    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }
/////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////
    //Breath First Search
//////////////////////////////////////////////////////////////////

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return results;
    }



}