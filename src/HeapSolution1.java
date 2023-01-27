import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HeapSolution1 extends HeapAbstr {

    public HeapSolution1(String fName) {
        super(fName);
    }

    @Override
    public void contact(FileWriter fw) {
        int index1 = (int) (Math.random() * sizeWithoutZeros + (heap.length - sizeWithoutZeros));
        int index2 = (int) (Math.random() * sizeWithoutZeros + (heap.length - sizeWithoutZeros));

        while (index1 == index2) {
            index2 = (int) (Math.random() * sizeWithoutZeros + (heap.length - sizeWithoutZeros));
        }

        //System.out.println("rozmawiaja:   " + heap[index1] + "   " + heap[index2]);

        try {
            if (heap[index1].id < heap[index2].id) {
                fw.write(heap[index1].id + "," + heap[index2].id + " ");
            } else {
                fw.write(heap[index2].id + "," + heap[index1].id + " ");
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


        heap[index1].tokens--;
        heap[index2].tokens--;
        money++;

        if (heap[index1].tokens == 0) {
            sizeWithoutZeros--;
        }
        if (heap[index2].tokens == 0) {
            sizeWithoutZeros--;
        }

        sort();

        if (sizeWithoutZeros < 2) {
            isDone = false;
        }
    }

    @Override
    public void talk() {
        try {
            File file = new File("dataout/dataout_" + heap.length + "_1.txt");

            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);

            while (isDone) {
                contact(fw);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
