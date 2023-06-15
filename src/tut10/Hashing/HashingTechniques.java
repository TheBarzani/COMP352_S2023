package tut10.Hashing;

public class HashingTechniques {
    private static int m=1000;                                // hash table size
    public static int FoldingShifting(String key){
        int hashVal = 0;
        int i = key.length() - 1;
        while(i > 0){
            hashVal +=  (int) key.charAt(i);
            i--;
        }
        return hashVal % (m-1);
    }
    public static int ShiftingCasting(String key){
        int hashVal = 0;
        int i = key.length() - 1;
        while(i > 0){
            hashVal = (hashVal << 10)  + (int) key.charAt(i);
            i--;
        }
        return hashVal % (m-1);
    }
    // hash function for keys - returns value between 0 and m-1 (assumes m is a power of 2)
    // (from Java 7 implementation, protects against poor quality hashCode() implementations)
    private static int hash(String key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
        return h & (m-1);
    }
    // hash function for keys - returns value between 0 and m-1
    private static int hashTextbook(String key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    //hashing function h(k) = (2k + 5) mod 11
    private static int mathematicalFunction(String key){
        return ((2 * Math.abs(key.hashCode()) + 5 ) % m);
    }
    public  static void main(String [] agrs){
        System.out.println("FoldingShifting [abcd]: " + FoldingShifting("abcd"));
        System.out.println("FoldingShifting [abcd]: " + FoldingShifting("dcba"));
        System.out.println("ShiftingCasting [abcd]: " + ShiftingCasting("abcd"));
        System.out.println("ShiftingCasting [dcba]: " + ShiftingCasting("dcba"));
        System.out.println("Hash [abcd]: " +hash("abcd"));
        System.out.println("Hash [dcba]: " +hash("dcba"));
        System.out.println("hashTextbook [abcd]: " + hashTextbook("abcd"));
        System.out.println("hashTextbook [dcba]: " + hashTextbook("dcba"));
        System.out.println("mathematicalFunction [abcd]: " + mathematicalFunction("abcd"));
        System.out.println("mathematicalFunction [dcba]: " + mathematicalFunction("dcba"));
    }


}

// Provided by: @MustafaDaraghmeh
