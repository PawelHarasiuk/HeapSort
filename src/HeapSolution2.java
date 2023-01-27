import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HeapSolution2 extends HeapAbstr {

    public HeapSolution2(String fName) {
        super(fName);
    }

    @Override
    public void contact(FileWriter fw) {
        if ((heap[heap.length - 1].tokens > 0) &&
                ((heap[heap.length - 2].tokens > 0) ||
                        ((heap[heap.length - 3].tokens > 0)
                        ))) {
            heap[heap.length - 1].tokens--;
            heap[heap.length - 2].tokens--;

            //System.out.println("rozmawiaja:   " + heap[heap.length - 1] + "   " + heap[heap.length - 2]);
            try {
                if (heap[heap.length - 1].id < heap[heap.length - 2].id) {
                    fw.write(heap[heap.length - 1].id + "," + heap[heap.length - 2].id + " ");
                } else {
                    fw.write(heap[heap.length - 2].id + "," + heap[heap.length - 1].id + " ");
                }
                fw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            sort();
            money++;
        } else {
            isDone = false;
        }
    }

    @Override
    public void talk() {
        try {
            File file = new File("dataout/dataout_" + heap.length + "_2.txt");
            FileWriter fw = new FileWriter(file);

            if (!file.exists()) {
                file.createNewFile();
            }
            while (isDone) {
                contact(fw);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
