package HashMap;

/* Imp methods :- 
 1. put() 2. get() 3. containsKey() 4. remove() 5. size() 6.keySet() --> runs in O(1)
 
 Keys are always unique, values can be duplicate
 Hashmap is internally implemented using array of LinkedList. i.e each index of an array will store a LL.
 All the index of an array are called as Bucket.
 No. of bucket = size of Array (N);
 no. of nodes = n;
 We decide that which node will go in which bucketlist with the help of hashing.
 hashing -> changing the form of data 
 Famous hashing algorithms -> sha1 sha-256
 lambda = no. of nodes (n) / no. of buckets (N)
 lambda <= K (threshold value) 
 put() function t.c -> O(lambda)
 when lambda > K , we have to perform a function rehashing  => increase the size of array / bucket. 
 if the size of the array changes i.e the hashmap changes then the bucket index also changes
 */
import java.util.LinkedList;
import java.util.ArrayList;

public class Runner {
    static class HashMap<K, V> {
        // 1. Creating structure of Node in which form we will store our data in LL
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        // 2. Variable declaration and initializing bucket array
        private int n; // no. of nodes
        private int N; // Array size
        private LinkedList<Node> buckets[]; // N = buckets.length

        @SuppressWarnings("unchecked")
        // 3. define constructor to declare array
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int bi = key.hashCode(); // can return any positive or negative int value
            return Math.abs(bi) % N; // since we need only numbers in the range 0 to N-1 for our index and only
                                     // positive numbers
        }

        // this function returns the index of the data if existed in LL else returns -1
        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];

            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i; // di
                }
            }

            return -1;
        }

        // rehashing function
        private void rehash() {
            this.N = N * 2;
            this.n = 0;
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N];

            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        // Put function
        public void put(K key, V value) {
            // we check the bucket index for k using a method called hashFunction
            int bi = hashFunction(key);

            // funtion which tells the key exists in bucket ind or not
            int di = searchInLL(key, bi); // data index

            if (di == -1) { // Key doesn't exist
                buckets[bi].add(new Node(key, value)); // creating a new node
                n++; // no. of nodes increased
            } else {// key exists
                Node data = buckets[bi].get(di);
                data.value = value; // update the value of the node with current data
            }

            double lambda = (double) n / N;
            System.out.println("lambda value: " + lambda + " Size of Array: " + N);
            if (lambda > 0.75) {
                // rehashing
                System.out.println("Lambda exceeded");
                rehash();
            }

        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1)
                return false;
            else
                return true;
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1)
                return null;
            else {
                Node data = buckets[bi].remove(di);
                return data.value;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                return null;
            } else {
                Node data = buckets[bi].get(di);
                return data.value;
            }
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public ArrayList<K> KeySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }

            return keys;
        }

    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 1);
    }
}
