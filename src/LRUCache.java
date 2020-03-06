import java.util.*;

public class LRUCache {
    /* a class for the data structure double linked list */
    private class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    /* always add the node after the head */
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /* remove the node from the list */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /* move the node in the list to the first */
    private void moveToFirst(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /* pop out the last node in the list and return it */
    private DLinkedNode popLast() {
        DLinkedNode last = tail.pre;

        this.removeNode(last);
        return last;
    }

    Map<Integer, DLinkedNode> map = new HashMap<>();
    int capacity;
    int size;
    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        this.head = new DLinkedNode();
        this.head.pre = null;

        this.tail = new DLinkedNode();
        this.tail.post = null;

        this.head.post = this.tail;
        this.tail.pre = this.head;
    }

    /* get the value of the key and move the node to the first of the list; if not find the key, return -1 */
    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkedNode node = this.map.get(key);
            this.moveToFirst(node);
            return node.value;

        } else {
            return -1;
        }
    }

    /* set the value to the key, if the key is in the cache, change the value; if not, add the node to the list and map,
     * then check for size, if size = capacity, then remove the last node in the list and map */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            node.value = value;
            moveToFirst(node);

        } else {
            DLinkedNode node = new DLinkedNode();
            node.key = key;
            node.value = value;
            addNode(node);
            this.map.put(key, node);

            size += 1;
            if (size > capacity) {
                DLinkedNode last = this.popLast();
                this.map.remove(last.key);
                size -= 1;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
