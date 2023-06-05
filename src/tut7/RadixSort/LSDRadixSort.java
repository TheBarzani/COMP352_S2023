package tut7.RadixSort;

/**
 * This Radix Sort works for numbers with less than 10 digits.
 * The implementation here is based on the Least Significat 
 * Digit Radix Sort. Here we use the concept of buckets where
 * each bucket represents a digit. We put the elements in these
 * buckets based on the current digit value. In this case we go 
 * from LSD to RSD.
 */
 
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
 
public class LSDRadixSort {
 
    public static void radixSort(int[] arr)
    {
        @SuppressWarnings("unchecked") // Just suppressing a small warning
        /**
         * We have ten queue-based buckets here each representing
         * the digits from 0 to 9.
         */
        Queue < Integer > [] buckets = new Queue[10];
        
        /**
         * The backbone of each bucket is a linkedlist that stores
         * the elements containing that digit.
         */
        for (int i = 0; i < 10; i++)
            buckets[i] = new LinkedList < Integer >();
        
        
        boolean sorted = false;
        int expo = 1;
        
        while ( ! sorted) {
            sorted = true;
            
            // Sorting happens here
            for (int item : arr) {
                int bucket = (item / expo) % 10;
                if ((bucket > 0) || ((item/expo) > 0)) sorted = false;
                buckets[bucket].add(item);
            } // Added a fix here ahah
 
            expo *= 10;
            int index = 0;
            
            // We put the elements back into the array. 
            for (Queue < Integer > bucket : buckets)
                while ( ! bucket.isEmpty())
                    arr[index++] = bucket.remove();
        }
        
        // Checking if the array is sorted
        assert isSorted(arr);
       
    }

    /**
     * Auxiliary function to check if the array is sorted
     */
    private static boolean isSorted(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1] > arr[i])
                return false;

        return true;
    }
     
    public static void main(String[] args) {
        int []arr={36, 54, 83, 23, 67, 89, 54, 0};
         
        System.out.println("List of items from array before sorting: "+ Arrays.toString(arr));
      
        radixSort(arr);
        System.out.println("List of items from array after sorting: "+ Arrays.toString(arr));
 
    }
 
}

//Inspired by: https://www.careerdrill.com/fundamentals/algorithm/sorting/least-significant-digit-lsd-radix-sort/