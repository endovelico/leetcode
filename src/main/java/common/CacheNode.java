package common;

public class CacheNode {

    private CacheNode previous;
    private CacheNode next;
    private int key, value;

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public CacheNode getNext() {
        return next;
    }

    public CacheNode getPrevious() {
        return previous;
    }

    public void setNext(CacheNode next) {
        this.next = next;
    }

    public void setPrevious(CacheNode previous) {
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
