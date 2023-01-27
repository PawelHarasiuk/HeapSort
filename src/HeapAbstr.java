import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public abstract class HeapAbstr {
    protected Senior[] heap;
    protected boolean isDone;
    protected int sizeWithoutZeros;
    //dane do liczenia zarobku
    protected int money;

    public HeapAbstr(String fName) {
        isDone = true;
        read(fName);
        sort();
    }

    private void read(String fName) {
        File file = new File(fName);
        String line = "";
        try {
            Scanner scanner = new Scanner(file);
            line = scanner.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] data = line.split(" ");
        heap = new Senior[Integer.parseInt(data[0])];

        int countZeros = 0;
        int index = -1;
        for (String e : data) {
            if (index == heap.length) {
                return;
            }

            if (index != -1) {
                heap[index] = new Senior(index + 1, Integer.parseInt(e));
            }

            if (Integer.parseInt(e) == 0) {
                countZeros++;
            }
            index++;
        }
        sizeWithoutZeros = heap.length - countZeros;
    }

    protected void sort() {
        for (int i = heap.length / 2 - 1; i >= 0; i--) {
            heapify(heap.length, i);
        }

        for (int i = heap.length - 1; i >= 0; i--) {
            Senior tmp = heap[0];
            heap[0] = heap[i];
            heap[i] = tmp;

            heapify(i, 0);
        }
    }


    private void heapify(int n, int rootIndex) {
        int maxIndex = rootIndex;
        int leftIndex = 2 * rootIndex + 1;
        int rightIndex = 2 * rootIndex + 2;

        if (leftIndex < n && heap[leftIndex].tokens > heap[maxIndex].tokens) {
            maxIndex = leftIndex;
        }

        if (rightIndex < n && heap[leftIndex].tokens == heap[maxIndex].tokens) {
            if (heap[leftIndex].id < heap[maxIndex].id) {
                maxIndex = leftIndex;
            }
        }

        if (rightIndex < n && heap[rightIndex].tokens > heap[maxIndex].tokens) {
            maxIndex = rightIndex;
        }

        if (rightIndex < n && heap[rightIndex].tokens == heap[maxIndex].tokens) {
            if (heap[rightIndex].id < heap[maxIndex].id) {
                maxIndex = rightIndex;
            }
        }

        if (maxIndex != rootIndex) {
            Senior tmp = heap[rootIndex];
            heap[rootIndex] = heap[maxIndex];
            heap[maxIndex] = tmp;

            heapify(n, maxIndex);
        }
    }


    public void displayWithZeros() {
        for (int i = heap.length - 1; i >= 0; i--) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public void displayLeftTokens() {
        int i = heap.length - 1;
        while (i >= 0 && heap[i].tokens != 0) {
            System.out.print(heap[i].tokens + " ");
            i--;
        }

        if (i == heap.length - 1) {
            System.out.print(0);
        }
        System.out.println();
    }

    public abstract void contact(FileWriter fileWriter);
    public abstract void talk();
}
