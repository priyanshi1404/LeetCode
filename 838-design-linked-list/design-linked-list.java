// //Approach 01- using singly linked list
// class Node{
//     int val;  //for the data(Instance variable)
//     Node next; //for the next node reference
//     Node(int val){  //local variable
//         this.val=val;  //when instance var and local var name is same in that case use this
//     }
// }

// //when data type of the data is not sure
// // class Node<T>{
// //     T data;   //T is generic here
// //     Node<T> next;  //T is generic
// // }
// // Node <String> node= new Node<>("Panchi");

// class MyLinkedList {
//     int size; // total number of nodes
//     Node head; //head contains refernce of first node
//     public MyLinkedList() {
//         size=0;
        
//     }
    
//     public int get(int index) {
//         if(index<0 || index>=size){
//             return -1; //invalid index
//         }
//         else{
//             Node temp=head;
//             for(int i=0;i<index;i++){
//                 temp=temp.next;
//             }
//             return temp.val;
//         }
//     }
    
//     public void addAtHead(int val) {
//         //Create a new NOde
//         Node node= new Node(val);
//         size++;
//         //no ll
//         if(head == null){
//             head = node;
//         }
//         else{
//             node.next=head;
//             head=node;
//         }
//     }
    
//     public void addAtTail(int val) {
//         //create  a node
//         Node node= new Node(val);
//         size++;
//         //no ll exist
//         if(head == null){
//             head=node;
//         }
//         else{
//             Node temp=head;
//             while(temp.next!=null){
//                 temp=temp.next;
//             }
//             temp.next = node;
//         }
//     }
    
//     public void addAtIndex(int index, int val) {
//         if(index<0 || index>size){
//             return; //invalid index
//         }
//         if(index == 0){
//             addAtHead(val);
//         }
//         else if(index == size){
//             addAtTail(val);
//         }
//         else{
//             Node node=new Node(val);
//             Node temp= head;
//             //add at middle
//             for(int i=0;i<index-1;i++){
//                 temp=temp.next;
//             }
//             node.next = temp.next;
//             temp.next=node;
//             size++;
//         }
//     }
    
//     public void deleteAtIndex(int index) {
//         if(index<0 || index>=size){
//             return;
//         }
//         if(head == null){
//             return;
//         }
//         if(index==0){
//             head=head.next;
//             size--;
//         }
//         else{
//             Node temp = head;
//             for(int i=0;i<index-1;i++){
//                 temp=temp.next;
//             }
//             temp.next=temp.next.next;
//         }
//         size--;
//     }
// }

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    int size;
    Node head;

    public MyLinkedList() {
        size = 0;
        head = null;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;

        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node node = new Node(val);
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) {
            head = head.next;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */