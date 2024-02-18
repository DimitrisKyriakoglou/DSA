package datastructures.hashtable;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    public HashTable(){
        dataMap=new Node[size];
    }
    class Node{
        int value;
        String key;
        Node next;

        Node(String key, int value){
            this.key=key;
            this.value=value;
        }
    }
    private int hash(String key)
    {
        int hash=0;
        char[] keychars= key.toCharArray();
        for(int i=0; i<keychars.length; i++){
            int asciiValue = keychars[i];
            hash = (hash +asciiValue*23)%dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value){
        int index = hash(key);
        Node newNode= new Node(key,value);
        if (dataMap[index]==null){
            dataMap[index]=newNode;
        }else{
            Node temp = dataMap[index];
            while(temp.next !=null){
                temp = temp.next;
            }
            temp.next=newNode;
        }
    }

    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];
        while(temp.next !=null){
            if (temp.key == key ){return temp.value;}
            temp = temp.next;
        }
        return 0;
    }





}
