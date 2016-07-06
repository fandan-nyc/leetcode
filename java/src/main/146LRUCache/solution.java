
public class LRUCache {
    
    private final int  cap ;
    private int count;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    
    private class Node{
        private int key;
        private int value; 
        private Node prev; 
        private Node next;
        
        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private void removeNode(Node a){
        a.prev.next = a.next;
        a.next.prev = a.prev;
    }
    
    private void addNodeToHead(Node a){
        a.next = this.head.next;
        a.prev = this.head;
        this.head.next.prev = a;
        this.head.next =a;
    }
    
    public LRUCache(int capacity) {
        cap = capacity;
        count = 0; 
        head= new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            removeNode(map.get(key));
            addNodeToHead(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            removeNode(map.get(key));
            addNodeToHead(map.get(key));
            map.get(key).value = value;
        }else{
            Node newNode = new Node(key,value);
            if(count == cap){
                map.remove(tail.prev.key);
                removeNode(tail.prev);
                count--;
            }
            addNodeToHead(newNode);
            map.put(key, newNode);
            count++;
        }
    }
}
