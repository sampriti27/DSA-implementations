
class StackArray {
    int[] stack = new int[10];
    int top = -1;

    // inserting an element in a stack
    public void push(int data) {
        if (top == 9) {
            System.out.println("Overflow");
        } else {
            top++;
            stack[top] = data;
        }
    }

    // taking element out of the stack
    public void pop() {
        if (top == -1) {
            System.out.println("Underflow");

        } else {
            int deletedItem = stack[top];
            top--;
        }
    }

    // peek item in stack
    public void peek() {
        if (top == -1) {
            System.out.println("Empty Stack!");
        } else {
            System.out.println(stack[top]);
        }
    }

    // display the items in stack
    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        StackArray st = new StackArray();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println("The peek of the stack is:");
        st.peek();
        st.display();
        st.pop();
        System.out.print("New Peek is: ");
        st.peek();

        st.display();

    }

}