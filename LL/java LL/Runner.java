
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    // head and tail pointers
    Node head, tail;

    public LinkedList() {
        head = null;
    }

    // method to insert node in linkedlist
    public void insert(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = tail = node;
        }

        else {
            tail.next = node;
            tail = node;
        }
    }

    // method to insert at start
    public void insertAtStart(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;

        }
    }

    // method to insert at end
    public void insertAtEnd(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
        }
    }

    // insert at a particular position
    public void insertAtPos(int data, int pos) {
        Node node = new Node(data);
        Node temp = head;
        int length = countNodes();

        if (pos < 0 || pos > length) {
            System.out.println("Enter a valid position");
            return;
        }

        if (pos == 0) {
            insertAtStart(data);
        } else if (pos == length) {
            insertAtEnd(data);
        } else {
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }

            node.next = temp.next;
            temp.next = node;
            temp = node;

        }
    }

    // delete a node from start
    public void deleteFromStart() {
        if (head == null) {
            System.out.println("Empty List");
        } else if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
    }

    // delete a node from end
    public void deleteFromEnd() {
        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // delete a node from a particular pos
    public void deleteFromPos(int pos) {
        int length = countNodes();
        Node temp = head;
        System.out.println(length);
        if (pos < 0 || pos > length) {
            System.out.println("Enter a valid position");
            return;
        }

        if (pos == 0) {
            deleteFromStart();
        } else if (pos == length) {
            deleteFromEnd();
        } else {
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            Node deleted = temp.next;
            temp.next = temp.next.next;
            deleted.next = null;

        }
    }

    // method to count the number of nodes
    public int countNodes() {
        int len = 0;
        Node temp = head;

        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    // display the list
    public void display() {
        Node temp = head;

        while (temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println(temp.data);
    }

    // method to reverse a linkedlist
    public void reverse() {
        Node prev, curr, nextNode;
        curr = nextNode = head;
        prev = null;

        while (nextNode != null) {
            nextNode = nextNode.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;

        }
        head = prev;
    }
}

public class Runner {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insertAtStart(4);
        ll.insertAtEnd(5);
        ll.display();
        ll.insertAtPos(6, 0);
        ll.insertAtPos(6, 6);
        ll.display();
        ll.deleteFromStart();
        ll.display();
        // ll.deleteFromEnd();
        // ll.display();
        // ll.deleteFromPos(0);
        // ll.display();
        // ll.deleteFromPos(5);
        // ll.display();
        ll.reverse();
        ll.display();
        // int length = ll.countNodes();
        // System.out.println("The no. of nodes in LL are:" + " " + length);
    }
}
