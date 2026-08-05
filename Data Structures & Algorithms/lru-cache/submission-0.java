// Approach : DLL + Hashmap
class LRUCache {
    class Node{
        int key , value;
        Node next , prev;

        //constructor (parameterized)
        Node(int k,int v){
            key = k;
            value = v;
        }
    }
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);

        int capacity;

    //stores key-node
    HashMap<Integer,Node>hm = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity; 
        head.next = tail;
        tail.prev = head; 
    }
        //function to add node at start (just after head)
    void insertAfterHead(Node t){
        Node front = head.next;
        head.next = t;
        t.next = front;
        t.prev = head;
        front.prev = t;
    }
        //delete node from end of dll
    void deleteNode(Node t){
        Node prevnode = t.prev;
        Node frontnode = t.next;
        prevnode.next = frontnode;
        frontnode.prev = prevnode;
    }


    public int get(int key) {
        if(hm.containsKey(key)){
            Node temp = hm.get(key);
            deleteNode(temp);
            insertAfterHead(temp);
            return temp.value;
        }
        return -1; // key is not in the map
    }
    
    public void put(int key, int value) {
        
        //if key already exists , update its value 
        if(hm.containsKey(key)){
            Node temp = hm.get(key);
            hm.remove(key);
            deleteNode(temp);
        }
        //if capacity is full
        if(hm.size() == capacity){
            hm.remove(tail.prev.key); //last element which is lru
            deleteNode(tail.prev);
        }
        insertAfterHead(new Node(key,value));
        hm.put(key,head.next);
    }
}
