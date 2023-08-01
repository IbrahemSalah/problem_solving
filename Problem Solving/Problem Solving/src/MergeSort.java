import java.util.List;

public class MergeSort {

    public static void mMergeSortImpl(List<Integer> arr, int mLeft, int mRight) {
        if (mLeft < mRight) {

            int mMid = (mLeft + mRight) / 2;

            mMergeSortImpl(arr, mLeft, mMid);
            mMergeSortImpl(arr, mMid + 1, mRight);

            mMergeImpl(arr, mLeft, mMid, mRight);
        }

    }

    public static void mMergeImpl(List<Integer> arr, int mLeft, int mMid, int mRight) {


        int firstArraySize = mMid - mLeft + 1;
        int secondArraySize = mRight - mMid;


        List<Integer> firstArray = arr.subList(0, mLeft);
        List<Integer> secondArray = arr.subList(mMid + 1, mRight);


        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int mergedArrayIndex = 0;

        // merge arrays
        while (firstArrayIndex < firstArraySize && secondArrayIndex < secondArraySize) {
            if (firstArray.get(firstArrayIndex) > secondArray.get(secondArrayIndex)) {
                arr.set(mergedArrayIndex, secondArray.get(secondArrayIndex));
                secondArrayIndex++;
            } else {
                arr.set(mergedArrayIndex, firstArray.get(firstArrayIndex));
                firstArrayIndex++;
            }

            mergedArrayIndex++;
        }


        // handle remaining
        if (firstArrayIndex < firstArraySize) {
            while (firstArrayIndex < firstArraySize) {
                arr.set(mergedArrayIndex, firstArray.get(firstArrayIndex));
                firstArrayIndex++;
                mergedArrayIndex++;
            }
        }

        if (secondArrayIndex < secondArraySize) {
            while (secondArrayIndex < secondArraySize) {
                arr.set(mergedArrayIndex, secondArray.get(secondArrayIndex));
                secondArrayIndex++;
                mergedArrayIndex++;
            }
        }

    }

}
