package common;

public class FrequencyCacheNode {

    private int key, value, frequency;

    public FrequencyCacheNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getValue() {
        return value;
    }

    public int getKey() {
        return key;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
