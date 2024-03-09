package solutions.p460;

public class LFUCacheNode {

    private LFUCacheNode next;
    private LFUCacheNode previous;

    private int value;

    private int usage_counter = 0;

    public  LFUCacheNode(int value) {
        this.value = value;
    }

    public LFUCacheNode(int value, int usage_counter) {

        this.value = value;
        this.usage_counter = usage_counter;
    }

    public  LFUCacheNode() {
    }


    public LFUCacheNode getNext() {
        return next;
    }

    public void setNext(LFUCacheNode next) {
        this.next = next;
    }

    public LFUCacheNode getPrevious() {
        return previous;
    }

    public void setPrevious(LFUCacheNode previous) {
        this.previous = previous;
    }

    public int getUsage_counter() {
        return usage_counter;
    }

    public void setUsage_counter(int usage_counter) {
        this.usage_counter = usage_counter;
    }

    public void cacheHit(){
        usage_counter = usage_counter + 1;
    }

    public void reorderOnHit(){

        while(previous != null && previous.getUsage_counter() <= usage_counter ) {

            LFUCacheNode oldNext = this.next;
            // O proximo do currente fica o anterior
            this.next = previous;

            // O anteior do currente, fica o anterior do anterior
            this.previous = previous.getPrevious();

            //O anterior do mais pequeno fica o currente
            previous.setPrevious(this);

            // O proximo do currente fica o proximo antigo do currente
            previous.setNext(oldNext);
        }
    }

    public int getValue(){
        return value;
    }
}
