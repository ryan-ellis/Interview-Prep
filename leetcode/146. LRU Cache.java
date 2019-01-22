// The first time approaching this problem I thought to use a stack/queue in order to keep track of the lru. However, after
// sifting through some of the other answers it appears as though a combination of a double linked list and hashmap work best.
// It's important to use a double linked list instead of a single linked list because then we are able to remove nodes at ~ O(1)
// instead of ~ O(n).
// A HashMap is used to keep track of the key/node pairs so that we can get O(1) access time which is useful for the get method.
class LRUCache {
    private HashMap<Integer, Node> cache;
    private Node head, tail;
    private int capacity;
    
    // It's important to note that we are using a "dummy" head/tail here because it is
    // easier to update.
    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
        
        this.capacity = capacity;
    }
    
    // The get method is pretty simple, one bug that I got stuck on for a while was forgetting to remove
    // the node before adding it to the head. Here we also see the value in having a hashmap to record
    // the key/node pairs because we can access them directly even though they are in a list.
    public int get(int key) {
        if(cache.containsKey(key)){
            Node temp = cache.get(key);
            removeNode(temp);
            addToHead(temp);
            return temp.val;
        }
        
        return -1;
    }
    
    // Three different cases: 
    // 1. updating value
    // 2. inserting new value (capacity full)
    // 3. inserting new value (capacity not full)
    public void put(int key, int value) {
        if(cache.containsKey(key)){ // Case 1
            Node temp = cache.get(key);
            temp.val = value;
            removeNode(temp);
            addToHead(temp);
            cache.put(key, temp);
        } else if(cache.size() == capacity){ // Case 2
            int lru = popTail();
            cache.remove(lru);
            Node temp = new Node(key, value);
            addToHead(temp);
            cache.put(key, temp);
        } else{ // Case 3
            Node temp = new Node(key, value);
            addToHead(temp);
            cache.put(key, temp);
        }
    }

    // Adds a node to the front of a list, right after the dummy head
    public void addToHead(Node node){
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    // Removes a node from a list, this is why it is useful to use a dummy head/tail
    // because now we don't have to worry about the case when this is the tail. The tail
    // will automatically be updated using this method because the tail pointer doesn't actually
    // point to the last node directly. 
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // In order to implement the LRU feature we have to pop the tail and update the new tail.
    public int popTail(){
        Node oldTail = tail.prev;
        removeNode(oldTail);
        return oldTail.key;
    }
    
    // Simple double linked node class
    class Node {
        int val;
        int key;
        Node prev;
        Node next;
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */