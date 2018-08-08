package practice.mustdo;

public class QArray11_KthSmallest {

    public static void main(String[] args) {
        int arr[] = {12, 3, 5, 7, 19};
        int k = 3;
        Heap heap = new Heap(arr, k);
        int kth = heap.findKthSmallest(arr, arr.length, k);
        System.out.println(kth);
    }

    static class Heap {
        int size;
        int capacity;
        int[] heap_array;

        Heap(int[] pArr, int k) {
            capacity = k;
            heap_array = new int[k];
            size = 0;
            for (int i = 0; i < k; i++) {
                heap_array[i] = pArr[i];
            }
            for (int i = parent(size); i >= 0; i--) {
                heapify(i);
            }
        }

        int findKthSmallest(int[] pArr, int pN, int pK) {
            for (int i = pK; i < pN; i++) {
                if (pArr[i] < getMax()) {
                    replaceMax(pArr[i]);
                }
            }
            return getMax();
        }

        int left(int pI) {
            return pI * 2 + 1;
        }

        int right(int pI) {
            return pI * 2 + 2;
        }

        int parent(int pI) {
            return (pI - 1) / 2;
        }

        int getMax() {
            return heap_array[0];
        }

        int extractMax() {
            if (size <= 0) {
                return Integer.MIN_VALUE;
            }
            int key = heap_array[0];
            if (size > 1) {
                heap_array[0] = heap_array[size - 1];
                heapify(0);
            }
            size--;
            return key;
        }

        void heapify(int pI) {
            int left = left(pI);
            int right = right(pI);
            int largest = pI;

            if (left < size && heap_array[left] > heap_array[largest]) {
                largest = left;
            }
            if (right < size && heap_array[right] > heap_array[largest]) {
                largest = right;
            }
            if (largest != pI) {
                int temp = heap_array[largest];
                heap_array[largest] = heap_array[pI];
                heap_array[pI] = temp;
                heapify(largest);
            }
        }

        void replaceMax(int pI) {
            heap_array[0] = pI;
            heapify(0);
        }
    }
}
