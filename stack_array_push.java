class stack_array_push {
    int peek;
    int[] arr;
    int capacity;

    stack_array_push(int size) {
        capacity = size;
        arr = new int[capacity];
        peek = -1;
    }

  
    void push(int x) {
        if (peek == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++peek] = x;
        System.out.println(x + " pushed into stack");
    }

    public static void main(String[] args) {
        stack_array_push s = new stack_array_push(5);
        s.push(10);
        s.push(20);
        s.push(30);
    }
}
