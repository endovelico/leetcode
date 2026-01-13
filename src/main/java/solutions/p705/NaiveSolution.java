package solutions.p705;

import java.util.ArrayList;
import java.util.List;

class NaiveSolution {
    private List<Integer> list = new ArrayList<>();

    public void add(int key) {
        if (!list.contains(key)) list.add(key);
    }

    public void remove(int key) {
        list.remove((Integer) key);
    }

    public boolean contains(int key) {
        return list.contains(key);
    }
}