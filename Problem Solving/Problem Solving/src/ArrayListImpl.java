import java.util.Arrays;

public class ArrayListImpl {
    int size;
    int[] dataSet;


    ArrayListImpl(int maxSize) {
        dataSet = new int[maxSize];
    }


    void insert(int value) {
        dataSet[size] = value;
        size++;
    }

    void insert(int value, int position) {

        for (int i = size; i > position; i--) {
            dataSet[i] = dataSet[i - 1];
        }

        dataSet[position] = value;
        size++;
    }

    void replace(int value, int position){
        dataSet[position] = value;
    }

    void delete(int position) {

        for (int i = position; i < size - 1; i++) {
            dataSet[i] = dataSet[i + 1];
        }

        size--;
    }

    int size(){
        return size;
    }

    void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println(dataSet[i]);
        }
    }
}
