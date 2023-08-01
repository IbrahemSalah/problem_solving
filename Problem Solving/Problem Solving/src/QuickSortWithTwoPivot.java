import java.util.List;
import java.util.Random;

public class QuickSortWithTwoPivot {


    private void quickSort(List<Integer> list, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex)
            return;

        int leftPointer = partition(list, lowIndex, highIndex);

        quickSort(list, lowIndex, leftPointer - 1);
        quickSort(list, leftPointer + 1, highIndex);
    }

    void quickSort(List<Integer> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private int partition(List<Integer> list, int lowIndex, int highIndex) {

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;

        int pivot = list.get(pivotIndex);


        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (list.get(leftPointer) <= pivot && leftPointer < rightPointer) {
                if (list.get(leftPointer) == pivot && leftPointer != pivotIndex && list.get(pivotIndex + 1) < pivot) {
                    pivotIndex++;
                    swap(list, pivotIndex, leftPointer);
                }
                leftPointer++;
            }

            while (list.get(rightPointer) >= pivot && leftPointer < rightPointer) {
                if (list.get(rightPointer) == pivot && rightPointer != pivotIndex && list.get(pivotIndex + 1) > pivot) {
                    pivotIndex++;
                    swap(list, pivotIndex, rightPointer);
                }
                rightPointer--;
            }

            swap(list, leftPointer, rightPointer);
        }

        return pivotIndex;
    }

    public List<Integer> swap(List<Integer> list, int firstIndex, int secondIndex) {
        int temp = list.get(firstIndex);

        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);

        return list;
    }
}
