import java.util.*;
import java.util.LinkedList;

class StackQ {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // insert a data in the stack
    public void push(int data) {
        q2.add(data);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        while (!q2.isEmpty()) {
            q1.add(q2.remove());
            // q2.poll();
        }
    }

    // find the top element
    public void peek() {
        System.out.println(q1.peek());
    }

    // pop element from stack
    public void pop() {
        if (q1.isEmpty()) {
            System.out.println("Empty List");
        } else {
            q1.remove();
        }
    }
}

class StackUsingQueue {
    public static void main(String[] args) {
        StackQ st = new StackQ();
        st.push(1);
        // st.peek();
        st.push(2);
        st.push(3);
        st.push(4);
        st.peek();
        st.pop();
        st.peek();
    }
}