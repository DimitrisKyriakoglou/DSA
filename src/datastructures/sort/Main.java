package datastructures.sort;


import datastructures.sort.oOFnsquared.BubbleSort;
import datastructures.sort.oOFnsquared.InsertionSort;
import datastructures.sort.oOFnsquared.Review;
import datastructures.sort.oOFnsquared.SelectionSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        int[] array={9,1,2,8,7,3,6,4,5};

        BubbleSort bSort = new BubbleSort();
        bSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));

        InsertionSort iSort= new InsertionSort();
        iSort.insertionSort(array);
        System.out.println(Arrays.toString(array));

        SelectionSort sSort= new SelectionSort();
        sSort.selectionSort(array);
        System.out.println(Arrays.toString(array));



        Review sSort2= new Review();
        sSort2.selectionSortReview(array);
        System.out.println(Arrays.toString(array));

    }
}
