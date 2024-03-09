package solutions.p460;

public class Tester {

    public static void main(String[] args) {

        LFUCache cache = new LFUCache(10);

        LFUCacheNode primeiro = new LFUCacheNode(1);

        LFUCacheNode segundo = new LFUCacheNode(2);

        LFUCacheNode terceiro = new LFUCacheNode(3);

        LFUCacheNode quarto = new LFUCacheNode(4);

        LFUCacheNode quinto = new LFUCacheNode(4);

        cache.get(1, primeiro);


    }
}
