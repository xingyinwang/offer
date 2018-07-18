package com.wxy.sort;

import java.util.Arrays;

/**
 * Created by Cser_W on 2018/3/4.
 */
public class Sort {
    /**
     * 插入排序
     * */
    public static void insertSort(int[] array) {
        int temp;
        int len = array.length;
        for (int i = 1; i < len; i++) {
             temp = array[i];
            int cur = i - 1;
            while (cur >= 0 && array[cur] > temp) {
                array[cur + 1] = array[cur];
                cur--;
            }
            array[cur + 1] = temp;
        }
    }

    /**
     * 冒泡排序
     * */
    public static void bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i ++) {
            for (int j = i + 1 ; j < array.length;j ++) {
                if (array[i] > array[j]) {
                    temp =  array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 快排
     * */
    public static void qucikSort(int[] array) {
        qSort(array, 0, array.length - 1);

    }
    public static void qSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            qSort(array, low, pivot - 1);
            qSort(array, pivot + 1, high);
        }
    }
    public static int partition(int[] array, int low, int high) {

        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivot) {
                --high;
            }
            array[low] = array[high];
            while(low < high && array[low] <= pivot) {
                ++low;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }

    /**
     * 选择排序
     * */
    public static void selectSort(int[] array) {
       int start = 0;
       int end = array.length - 1;
        while (start < end) {
            int temp = Integer.MAX_VALUE; // 记录最小值
            int pos = 0; //记录最小下标
            for (int i = start; i < array.length; i++) {
                if (temp > array[i]) {
                    pos = i;
                    temp = array[i];
                }
            }
            int tp = array[start];
            array[start] = array[pos];
            array[pos] = tp;
            start ++;
        }
    }

    /**
     * 希尔排序
     * */
    public static void shellSort(int[] array) {
       int len = array.length;
        for (int h = len / 2; h > 0; h = h / 2) {
            for (int j = h; j < len; j+= h) {
                int cur = j - h;
                int temp = array[j];
                while (cur >= 0 && array[cur] > temp) {
                    array[cur + h] = array[cur];
                    cur = cur - h;
                }
                array[cur + h] = temp;
            }
        }
    }

    /**
     * 归并排序
     * */
    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }
    public static void mergeSort(int[] array, int start, int end) {
        int mid = (end + start) / 2;
        if (start < end) {
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }
    public static void merge(int[] array, int start, int mid,int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int count = 0;
        while (i <= mid && j <= end) {
            if (array[i] < array[j]) {
                temp[count ++] = array[i ++];
            } else {
                temp[count++] = array[j ++];
            }
        }
        while (i <= mid) {
            temp[count ++] = array[i++];
        }
        while (j <= end) {
            temp[count++] = array[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            array[k + start] = temp[k ];
        }
    }

    /**
     * 堆排序*/
    public static void heapSort(int[] array) {
        buildMaxHeap(array);
        for (int i = array.length - 1; i >= 1 ; i--) {
            swap(array, 0,i);
            maxHeap(array, i, 0);
        }
    }

    private static void buildMaxHeap(int[] array) {
        for (int i = array.length / 2; i >= 0 ; i--) {
            maxHeap(array, array.length, i);
        }
    }

    public static void  maxHeap(int[] array, int heapsize, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < heapsize && array[left] > array[index]) {
            largest = left;
        }
        if (right < heapsize && array[right] > array[index]) {
            largest = right;
        }
        if (largest != index) {
            swap(array, index, largest);
            maxHeap(array, heapsize, largest);
            maxHeap(array,heapsize, index);
        }

    }
    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    public static void main(String[] args){
        int[] array = new int[]{49,38,65,97,76,13,27};
        //bubbleSort(array);
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}