import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> sortedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        Integer searched = 20;
        boolean exist = binarySearch(sortedList, searched);

        int index = getIndexUsingBinarySearch(sortedList, searched, 0, sortedList.size());
        System.out.println(exist);
        System.out.println(index);
    }


    public static boolean binarySearch(List<Integer> sortedList, Integer searched) {


        if (sortedList.size() > 1) {
            int midIndex = sortedList.size() / 2;

            if (Objects.equals(sortedList.get(midIndex), searched)) return true;

            if (sortedList.get(midIndex) > searched) {
                return binarySearch(sortedList.subList(0, midIndex), searched);
            } else {
                return binarySearch(sortedList.subList(midIndex, sortedList.size()), searched);
            }
        } else if (sortedList.size() == 1) {
            return Objects.equals(sortedList.get(0), searched);
        }

        return false;
    }

    public static int getIndexUsingBinarySearch(List<Integer> sortedList, Integer searched, int start, int end) {

        if (start <= end) {
            int midIndex = (start + end) / 2;
            if (Objects.equals(searched, sortedList.get(midIndex)))
                return midIndex;

            if (sortedList.get(midIndex) > searched) {
                return getIndexUsingBinarySearch(sortedList, searched, start, midIndex - 1);
            } else {
                return getIndexUsingBinarySearch(sortedList, searched, midIndex + 1, end);
            }
        }

        return -1;
    }
}
