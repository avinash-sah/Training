package practice.july28;

public class Q20_BinaryHeap {
    int capacity;
    int size;
    int[] ds;

    public Q20_BinaryHeap(int pCapacity) {
        capacity = pCapacity;
        ds = new int[pCapacity];
        size = 0;
    }

    public static void main(String[] args) {
        Q20_BinaryHeap heap = new Q20_BinaryHeap(11);
        heap.insertKey(3);
        heap.printArray();
        heap.insertKey(2);
        heap.printArray();
        heap.deleteKey(1);
        heap.printArray();
        heap.insertKey(15);
        heap.printArray();
        heap.insertKey(5);
        heap.printArray();
        heap.insertKey(4);
        heap.printArray();
        heap.insertKey(45);
        heap.printArray();
        System.out.println(" +++++++++++" + heap.extractMin());
        heap.printArray();
        System.out.println(" +++++++++++" + heap.getMin());
        heap.printArray();
        heap.updateKey(2, 1);
        heap.printArray();
        System.out.println(" +++++++++++" + heap.getMin());
        heap.printArray();
    }

    void printArray() {
        for (int i : ds) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public void insertKey(int key) {
        if (size == capacity) {
            System.out.println("Max limit reached");
            return;
        }
        size++;
        int i = size - 1;
        ds[i] = key;
        while (i != 0 && ds[i] < ds[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void swap(int pI, int pJ) {
        int temp = ds[pI];
        ds[pI] = ds[pJ];
        ds[pJ] = temp;
    }

    public void updateKey(int i, int key) {
        ds[i] = key;
        while (i != 0 && ds[i] < ds[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int deleteKey(int i) {
        int key = ds[i];
        updateKey(i, Integer.MIN_VALUE);
        extractMin();
        return key;
    }

    public int getMin() {
        return ds[0];
    }

    public int extractMin() {
        if (size <= 0) {
            return Integer.MAX_VALUE;
        }
        if (size == 1) {
            size--;
            return ds[0];
        }
        int key = ds[0];
        ds[0] = ds[size - 1];
        size--;
        heapify(0);
        return key;

    }

    void heapify(int i) {
        int min = i;
        int l = left(i);
        int r = right(i);
        if (l < size && ds[l] < ds[min]) {
            min = l;
        }
        if (r < size && ds[r] < ds[min]) {
            min = r;
        }
        if (min != i) {
            swap(i, min);
            heapify(min);
        }
    }
}
