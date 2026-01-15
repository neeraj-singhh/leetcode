class stack_LL_push{
    private class Node{
        int data;
        Node next;
    }
    private Node top;
    
    stack_LL_push(){
        top=null;
    }

    void push(int x){
        Node newNode = new Node();
        newNode.data=x;
        newNode.next=top;
        top=newNode;
        System.out.println(x);
   }
    void display() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return;
        }
        System.out.print(" elements: ");
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        stack_LL_push s = new stack_LL_push();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.display();
    }
}