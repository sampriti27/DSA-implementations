class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

}

class StackLL {
    Node top = null;

    // method to insert a node in stack
    public void push(int data) {
        Node node = new Node(data);
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }

    }

    public void pop() {
        if (top == null) {
            System.out.println("Empty List!");
        } else {
            Node item = top;
            top = top.next;
        }
    }

    public void display() {
        Node temp = top;
        if (top == null) {
            System.out.println("Empty List!");
        }
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public void peek() {
        if (top == null) {
            System.out.println("Empty List!");
        } else {
            System.out.println(top.data);
        }
    }
}

public class StackUsingLL {
    public static void main(String[] args) {
        StackLL st = new StackLL();
        st.push(1);
        st.push(2);
        st.push(3);
        st.display();
        // st.pop();
        // System.out.println("New List");
        // st.display();
        // st.peek();
    }
}
