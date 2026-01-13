package common;

public class DoubleLinkListNode<T> {

    public T val;
    public DoubleLinkListNode<T> next;
    public DoubleLinkListNode<T> previous;

    public DoubleLinkListNode() {
    }

    public DoubleLinkListNode(T val) {
        this.val = val;
    }

    public DoubleLinkListNode(T val, DoubleLinkListNode next) {
        this.val = val;
        this.next = next;
    }


    public void setNext(DoubleLinkListNode next) {
        this.next = next;
    }

    public void setPrevious(DoubleLinkListNode previous) {
        this.previous = previous;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public DoubleLinkListNode<T> getNext() {
        return next;
    }

    public DoubleLinkListNode<T> getPrevious() {
        return previous;
    }
}
