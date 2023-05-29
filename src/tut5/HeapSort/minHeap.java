package tut5.HeapSort;

public class minHeap {
    private int[] Heap;
    private int size;
    private int maxsize;
 
    /**
     * Constructor to initialize an
     * empty min heap with given maximum
     * capacity.
     */

    public minHeap(int maxsize)
    {
        /* 'this' keyword refers to current instance itself */
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
    }
 
    // Method 1
    // Returning position of parent
    private int parent(int pos) { return (pos - 1) / 2; }
 
    // Method 2
    // Returning left children
    private int leftChild(int pos) { return (2 * pos) + 1; }
 
    // Method 3
    // Returning right children
    private int rightChild(int pos)
    {
        return (2 * pos) + 2;
    }
 
    // Method 4
    // Returning true if given node is leaf
    private boolean isLeaf(int pos)
    {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
 
    // Method 5
    // Swapping nodes
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
 
    //================================
    // THE SECONDARY CHANGE IS HERE
    //================================
    // Method 6
    // Recursive function to min heapify given subtree
    private void minHeapify(int pos)
    {
        if (isLeaf(pos))
            return;
 
        if (Heap[pos] > Heap[leftChild(pos)]
            || Heap[pos] > Heap[rightChild(pos)]) {
 
            if (Heap[leftChild(pos)]
                < Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                minHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                minHeapify(rightChild(pos));
            }
        }
    }
 
    // Method 7
    // Inserts a new element to min heap
    public void insert(int element)
    {
        Heap[size] = element;
        
        //================================
        // THE PRIMARY CHANGE IS HERE
        //================================
        // Traverse up and fix violated property
        int current = size;
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }
 
    // Method 8
    // To display heap
    public void print()
    {
 
        for (int i = 0; i < size / 2; i++) {
 
            System.out.print("Parent Node : " + Heap[i]);
 
            if (leftChild(i)
                < size) // if the child is out of the bound
                        // of the array
                System.out.print(" Left Child Node: "
                                 + Heap[leftChild(i)]);
 
            if (rightChild(i)
                < size) // the right child index must not
                        // be out of the index of the array
                System.out.print(" Right Child Node: "
                                 + Heap[rightChild(i)]);
 
            System.out.println(); // for new line
        }
    }
 
    // Method 9
    // Remove an element from min heap
    public int extractMin()
    {
        int popped = Heap[0];
        Heap[0] = Heap[--size];
        minHeapify(0);
        return popped;
    }
 
    // Method 10
    // main driver method
    public static void main(String[] arg)
    {
        int arr[] = {5, 3, 17, 10, 84, 19, 6, 22, 9};
        minHeap minH = new minHeap(9);
        

        // Inserting nodes
        // Custom inputs
        for (int i=0; i < arr.length; i++){
            minH.insert(arr[i]);
        }
    
        System.out.println();
        System.out.println("The Min Heap is ");
        // Calling minHeap() as defined above
        minH.print();
 
        // Print and display the minimum value in heap
        System.out.println("\nThe extracted min val is "
                           + minH.extractMin());
        System.out.println("\nThe Min Heap after extracting the min val is");

        minH.print();
        System.out.println();
    }
}