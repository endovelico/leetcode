package solutions.p895;

import java.util.*;

class FreqStack {

    // Node representing an element in the frequency list
    static class Node {
        int val;
        int freq;       // frequency of this value
        Node prev, next;
        Node(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    private Map<Integer, Node> valToNode;             // latest node for each value
    private Map<Integer, Node> freqToHeadTail;       // maps freq -> dummy head of DLL for that freq
    private Map<Integer, Node> freqToTail;           // maps freq -> tail node (most recent)
    private int maxFreq;

    public FreqStack() {
        valToNode = new HashMap<>();
        freqToHeadTail = new HashMap<>();
        freqToTail = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        int freq = valToNode.containsKey(x) ? valToNode.get(x).freq + 1 : 1;
        Node node = new Node(x, freq);
        valToNode.put(x, node);

        // Add node to the doubly linked list of its frequency
        Node head = freqToHeadTail.computeIfAbsent(freq, k -> new Node(-1, freq)); // dummy head
        Node tail = freqToTail.getOrDefault(freq, head);

        tail.next = node;
        node.prev = tail;
        freqToTail.put(freq, node);

        // Update max frequency
        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        if (maxFreq == 0) return -1;

        // Get the tail node of the max frequency DLL
        Node node = freqToTail.get(maxFreq);
        int val = node.val;

        // Remove node from DLL
        Node prev = node.prev;
        prev.next = null;

        // Update tail for this frequency
        if (prev.val == -1) { // dummy head
            freqToTail.remove(maxFreq); // DLL empty
            freqToHeadTail.remove(maxFreq);
        } else {
            freqToTail.put(maxFreq, prev);
        }

        // Update valToNode mapping
        if (node.freq == 1) {
            valToNode.remove(val);
        } else {
            valToNode.put(val, new Node(val, node.freq - 1));
        }

        // Update maxFreq if no nodes left at this freq
        if (!freqToTail.containsKey(maxFreq)) {
            maxFreq--;
        }

        return val;
    }
}
