class Node{
    int key;
    int value;
    Node next;
    Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}

class MyHashMap {
    private int size;
    private Node buckets[];

    public MyHashMap() {
        size=1000;
        buckets=new Node[size];
    }
    int hash(int key){
        return key%size;
    }
    
    public void put(int key, int value) {
        int index=hash(key);
        if(buckets[index] == null){
            buckets[index] = new Node(key,value);
            return;
        }
        Node cur=buckets[index];
        while(cur != null){
            if(cur .key == key){
                cur.value=value;
                return;
            }
            if(cur.next  == null){ //reached last
              cur.next=new Node(key,value);

            }
            cur=cur.next;
        }
    }
    
    public int get(int key) {
        int index=hash(key);
        Node cur=buckets[index];
        while(cur!= null){
            if(cur.key == key){
                return cur.value;
            }
            cur = cur.next;
        }
         return -1;
    }
    
    public void remove(int key) {
        int index=hash(key);
        Node cur=buckets[index];
        if(cur == null){
            return;
        }
        if(cur.key==key){
            buckets[index]=cur.next;
            return;
        }
        while(cur.next != null){
            if(cur.next.key == key){
                cur.next= cur.next.next;
                return;
            }
            cur=cur.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */