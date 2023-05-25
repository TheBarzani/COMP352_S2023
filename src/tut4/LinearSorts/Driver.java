package tut4.LinearSorts;

public class Driver {
    public static void main(String[] args) {
        int arrIns[] = { 12, 11, 13, 5, 6 };
        int arrSel[] = { 1, 14, 9, 5, 6 };
        int arrBub[] = { 8, 2, 9, 7, 6 };

        // Creating of sorting objects
        InsertionSort obI = new InsertionSort();
        SelectionSort obS = new SelectionSort();
        BubbleSort obB = new BubbleSort();

        // Sorting
        obI.sort(arrIns);
        obS.sort(arrSel);
        obB.sort(arrBub);
        
        System.out.println();
        System.out.print("Array sorted by Insertion Sort: ");
        InsertionSort.printArray(arrIns);
        System.out.println();
        System.out.print("Array sorted by Selection Sort: ");
        SelectionSort.printArray(arrSel);
        System.out.println();
        System.out.print("Array sorted by Bubble Sort: ");
        SelectionSort.printArray(arrBub);
        System.out.println();
        
    }

}
