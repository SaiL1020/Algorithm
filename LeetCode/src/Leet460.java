import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Created by sail on 12/14/16.
 * LFUCache
 */
public class Leet460 {
    final int cap;
    Node head;
    Map<Integer, Integer> valueMap;
    Map<Integer, Node> nodeMap;

    class Node {
        int count;
        Node prev, next;
        LinkedHashSet<Integer> keys = new LinkedHashSet<>();
        Node (Node pv, Node nt, int cnt, int key) {
            prev = pv;
            next = nt;
            count = cnt;
            keys.add(key);
        }
    }
    public Leet460(int capacity) {
        cap = capacity;
        head = null;
        valueMap = new HashMap<>();
        nodeMap = new HashMap<>();
    }

    public int get(int key) {
        if (!valueMap.containsKey(key)) return -1;
        increase(key);
        return valueMap.get(key);
    }

    public void set(int key, int value) {
        if (cap == 0) return;
        if (valueMap.put(key, value) != null) {
            increase(key);
        } else {
            if (nodeMap.size() == cap) removeOldest();
            add(key);
        }
    }

    private void increase(int key) {
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        if (node.next == null) node.next = new Node(node, null, node.count + 1, key);
        else if (node.next.count == node.count + 1) node.next.keys.add(key);
        else node.next = node.next.prev = new Node(node, node.next, node.count + 1, key);
        nodeMap.put(key, node.next);
        if (node.keys.isEmpty()) remove(node);
    }

    private void remove(Node node) {
        if (head == node) head = head.next;
        else node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
    }

    private void removeOldest() {
        if (head == null) return;
        int oldest = head.keys.iterator().next();
        head.keys.remove(oldest);
        if (head.keys.isEmpty()) remove(head);
        valueMap.remove(oldest);
        nodeMap.remove(oldest);
    }

    private void add(int key) {
        if (head == null) head = new Node(null, null, 1, key);
        else if (head.count == 1) head.keys.add(key);
        else head = head.prev = new Node(null, head, 1, key);
        nodeMap.put(key, head);
    }
}

/*
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.set(key,value);
 */
