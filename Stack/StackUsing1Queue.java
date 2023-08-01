import java.util.*;
import java.util.LinkedList;

class StackUsing1Q {
    Queue<Integer> q = new LinkedList<>();

    public void push(int data) {
        q.add(data);
        for (int i = 1; i < q.size(); i++) {
            q.add(q.remove());
        }
    }

    public void pop() {
        q.remove();
    }

    public void peek() {
        System.out.println(q.peek());
    }
}

public class StackUsing1Queue {
    public static void main(String[] args) {
        StackUsing1Q st = new StackUsing1Q();
        st.push(1);
        st.push(2);
        st.push(3);
        st.peek();
        st.pop();
        st.peek();

    }
}
