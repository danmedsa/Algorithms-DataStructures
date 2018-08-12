package com.danielmedina;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.lang.System.out;

public class SortingPractice {
    final private int dataLength = 10;

    public int[] data = new int[dataLength];

    public SortingPractice() {
        out.println("--- Sorting Practice ---");
        for (int i = 0; i < dataLength; i ++) {
            data[i] = (new Random()).nextInt() % 10;
        }
        out.println("Array Generated: " + Arrays.toString(data));
    }
}

class MergeSort {
    public MergeSort(int[] arr) {
        out.println("--- Merge Sort ---");
        out.println("Before: " + Arrays.toString(arr));
        mergeSort(arr);
        out.println("After: " + Arrays.toString(arr));
    }

    private void mergeSort(int[] arr) {
        int[] helper = new int[arr.length];
        mergeSort(arr, helper, 0, arr.length - 1);

    }

    private void mergeSort(int[] arr, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(arr, helper, low, middle); // sort left half
            mergeSort(arr, helper, middle+1, high); //sort right half
            merge(arr, helper, low, middle, high);  //Merge halfs
        }
    }

    private void merge(int[] arr, int[] helper, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while(helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                arr[current] = helper[helperLeft];
                helperLeft++;
            } else {
                arr[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for (int i=0; i <= remaining; i++) {
            arr[current + i] = helper[helperLeft + 1];
        }
    }
}

class QuickSort {
    public QuickSort(int[] arr){
        out.println("--- Quick Sort ---");
        out.println("Before: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        out.println("After: "+ Arrays.toString(arr));
    }


    private void quickSort(int[] arr, int left, int right){
        int index = partition(arr,left,right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr,index,right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];  //pick pivot
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}