class Skiplist {
    private static final int MAX_LEVEL =16;
    private Node head;
    private int level;
    private Random random;

    class Node{
        int val;
        Node next[];

        Node(int val,int level){
            this.val=val;
            this.next=new Node[level+1];
        }
    }

    public Skiplist() {
        this.head=new Node(-1, MAX_LEVEL);
        this.level=0;
        this.random=new Random();
    }
    
    public boolean search(int target) {
        Node cur=head;
        for(int i=level; i>=0; i--){
            while(cur.next[i] != null && cur.next[i].val <target){
                cur = cur.next[i];
            }
        }
        cur=cur.next[0];
        return cur!=null && cur.val ==target;
    }
    
    public void add(int num) {
        Node update[]=new Node[MAX_LEVEL + 1];
        Node cur=head;
         for(int i=level; i>=0; i--){
            while(cur.next[i] != null && cur.next[i].val <num){
                cur = cur.next[i];
            }
            update[i]=cur;
        }
        int newLevel= randomLevel();

        if(newLevel > level){
            for(int i=level+1;i <=newLevel;i++){
                update[i] = head;
            }
            level = newLevel;
        }

        Node newNode = new Node(num,newLevel);

        for(int i=0;i<=newLevel;i++){
            newNode.next[i] = update[i].next[i];
            update[i].next[i]=newNode;
        }

    }
    
    public boolean erase(int num) {
        Node update[]=new Node[MAX_LEVEL + 1];
        Node cur=head;

        for(int i=level; i>=0; i--){
            while(cur.next[i] != null && cur.next[i].val <num){
                cur = cur.next[i];
            }
            update[i]=cur;
        }
        cur=cur.next[0];
        if(cur == null || cur.val!= num){
            return false;
        }
        for(int i=0; i<=level; i++){
            if(update[i].next[i] != cur){
                break;
            }
            update[i].next[i] = cur.next[i];
        }
        while(level > 0 && head.next[level] == null){
            level--;
        }
        return true;
    }
    private int randomLevel(){
        int level=0;
        while(level < MAX_LEVEL && random.nextDouble()<0.5){
            level++;
        }
        return level;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */