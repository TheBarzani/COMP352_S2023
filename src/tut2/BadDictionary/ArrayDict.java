package tut2.BadDictionary;

import java.util.ArrayList;

public class ArrayDict<K, V> {

    ArrayList<K>[] key;
    ArrayList<V>[] val;
    int size;
    int curr;

    ArrayDict(int s){
        size = s;
        key = new ArrayList[size];
        val = new ArrayList[size];
        curr = 0;
    }

    public Integer find(K k){
        Integer i;
        for (i=0; i < curr; i++){
            if(key[i] == k) return i;
        }
        return curr;
    }

    public V get(K k){
        Integer index = find(k);
        if (index == null) return null;
        else return val[index];
    }

    public boolean set(K k, V v){
        Integer index = find(k);
        if (index == null) return false;
        else{
            val[index] = v;
            return true;
        }
    }

    public boolean add(K k, V v){
        Integer index = find(k);
        if (index != null || curr == size) return false;
        else{
            key[curr] = k;
            val[curr] = v;
            curr++;
            return true;
        }
    }

    public static void main(String[] args) {
        ArrayDict<Character, String> myDict = new ArrayDict(4);
        myDict.add('a', "alpha");
        myDict.add('o', "omega");
        myDict.add('g',"gamma");

        System.out.println(myDict.get(a));

    }
    
}
