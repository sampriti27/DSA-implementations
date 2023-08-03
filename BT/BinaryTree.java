import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    // method to create tree
    public static Node createTree() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data: ");
        int data = sc.nextInt();
        if (data == -1)
            return null;

        Node root = new Node(data);
        System.out.println("Enter data for the node present in the left of " + data);
        root.left = createTree();
        System.out.println("Enter data for the node present in the right of " + data);
        root.right = createTree();

        return root;
    }

    // method to perform inorder traversal recursively
    public static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // method to perform preorder traversal recursively
    public static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // method to perform postorder traversal recursively
    public static void postorder(Node root) {
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // method to perform level order traversal
    public static void levelorder(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.peek();
            q.poll();
            System.out.print(node.data + " ");

            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
    }

    public static void iterativePreorder(Node root) {
        if (root == null)
            return;
        // create a stack and add the root node
        Stack<Node> st = new Stack<>();
        st.add(root);

        while (!st.isEmpty()) {
            Node node = st.peek();
            System.out.print(node.data + " ");
            st.pop();
            if (node.right != null)
                st.add(node.right);
            if (node.left != null)
                st.add(node.left);
        }
    }

    public static void iterativeInorder(Node root) {
        if (root == null)
            return;
        Stack<Node> st = new Stack<>();
        Node node = root;
        // run an infinite loop
        while (true) {
            // if the node is not null then add it to stack and go to it's left
            if (node != null) {
                st.add(node);
                node = node.left;
            }
            // if the node is not null then if it is empty then brean the loop

            else {
                if (st.isEmpty())
                    break;
                // else add the top of the stack as answer and move to right
                node = st.pop();
                System.out.print(node.data + " ");
                node = node.right;
            }

        }

    }

    public static void iterativePostorder(Node root) {
        // using two stacks
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.add(root);
        // pop from st1 & add to st 2 then check if the left and right are not null then
        // add them to stack 1
        while (!st1.isEmpty()) {
            Node node = st1.peek();
            st1.pop();
            st2.add(node);
            if (node.left != null)
                st1.add(node.left);
            if (node.right != null)
                st1.add(node.right);

        }
        // while popping from st2 print the data to get the post order

        while (!st2.isEmpty()) {
            System.out.print(st2.peek().data + " ");
            st2.pop();
        }
    }

    public static void main(String[] args) {
        Node root = createTree();
        System.out.println();
        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        levelorder(root);
        System.out.println();
        iterativePreorder(root);
        System.out.println();
        iterativeInorder(root);
        System.out.println();
        iterativePostorder(root);
    }
}