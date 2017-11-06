package lrucache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by APandey on 12-04-2017.
 */
public class LRUCache {

    private int capacity;
    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        Integer val = map.get(key);;
        if(val != null) {
            map.put(key, val);
        } else
            return -1;
        return val;
    }

    public void set(int key, int val) {
        if(map.containsKey(key)) {
            map.remove(key);
        } else if(map.size() == capacity) {
            Iterator<Integer> it = map.keySet().iterator();
            it.next();
            it.remove();
        }
        map.put(key, val);
    }

    public void print() {
        for(Map.Entry<Integer, Integer> map : map.entrySet()) {
            System.out.println(map.getKey() + " - " + map.getValue());
        }
    }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(5);
        c.set(5, 1);
        c.set(3, 2);
        c.set(1, 5);
        c.print();
        System.out.println("------------");
        c.set(6, 8);
        c.set(9, 10);
        c.print();
        System.out.println("------------");
        c.set(11, 4);
        c.set(1,5);
        c.print();
        System.out.println("------------");
    }
}
