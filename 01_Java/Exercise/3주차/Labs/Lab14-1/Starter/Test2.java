import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class HashTable<K, V> implements Iterable<V> { // <Key, Value>
    private static final int INITIAL_CAPACITY = 16;
    private Entry<K, V>[] table;
    private int size;

    // TODO: Inner Class 라고 하나?
    public static class Entry<K, V> {
        final K key;
        V value; // key는 고유한 값이기 때문에 변경되지 않지만, value는 변경될 수 있음

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        this.table = new Entry[INITIAL_CAPACITY];
    }

    /**
     * index를 만드는 함수
     * @param key
     * @return index 반환
     */
    public int hashFunction(K key) {
        return Math.abs(key.hashCode()) % INITIAL_CAPACITY;
    }

    public void put(K key, V value) {
        int index = this.hashFunction(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (table[index] == null) {
            table[index] = newEntry;
            this.size++;
        } else {
            table[index].value = value;
        }
    }

    public V get(K key) throws NullPointerException {
        int index = this.hashFunction(key);
        return table[index].value;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<V> iterator() {
        List<Entry<K, V>> list = Arrays.asList(this.table);
        List<V> tempList = new ArrayList<>();

        for (Entry<K, V> entry : list) {
            if (entry != null) {
                tempList.add(entry.value);
            }
        }
        return tempList.iterator();
    }
}

public class Test2 {
    public static void main(String[] args) {
        HashTable<Integer, String> hashTable = new HashTable<>();

        hashTable.put(1, "a");
        hashTable.put(1, "b");
        hashTable.put(2, "c");

        try {
            System.out.println(hashTable.get(1));
            System.out.println(hashTable.hashFunction(1));
            System.out.println(hashTable.size());
        } catch (NullPointerException e) {
            System.out.println("Data Not Found");
        }

        for (String s : hashTable) {
            System.out.println(s);
        }
    }
}