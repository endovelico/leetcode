package solutions.p460;

import common.CacheNode;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    private LFUCacheNode first_node;
    private LFUCacheNode last_node;

    private Map<Integer, LFUCacheNode> cache = new HashMap<>();

    private int capacity = 0;

    public LFUCache() {
        first_node = new LFUCacheNode();
        last_node = new LFUCacheNode();
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        LFUCacheNode cacheNode = cache.get(key);
        if(cacheNode == null) return -1; //No caso de nao existir...

        // adicionar 1 ao seu contador
        cacheNode.cacheHit();
        cacheNode.reorderOnHit();

        // atualizar a ordem dos nos baseado no numero de utilizacoes
        return cacheNode.getValue();
    }

    public void put(int key, int value) throws Exception {

        LFUCacheNode lfuCacheNode = cache.get(key);

        // Se existir lancar excepcao
        if(lfuCacheNode != null) throw new Exception("Element was already put into map!");

        // se nao existir, adicionar ao mapa com contagem 1
        if (lfuCacheNode == null){
            cache.put(key, new LFUCacheNode(value, 1));
        }

        // colocar no fim em ordem
            // O anterior deste no, passa a ser o ultimo no
            lfuCacheNode.setPrevious(last_node);

            // o seguinte deste no, passa a ser null
            lfuCacheNode.setNext(null);

            // O anterior do ultimo antigo e o mesmo
            //O proximo do ultimo antigo
            last_node.setNext(lfuCacheNode);

            // este no passa a ser o ultimo
            last_node = lfuCacheNode;
    }
}