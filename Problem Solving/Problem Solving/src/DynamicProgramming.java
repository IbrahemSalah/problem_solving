import java.util.ArrayList;
import java.util.HashMap;

public class DynamicProgramming {


    public int isValidAVL(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = isValidAVL(root.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = isValidAVL(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        else
            return Math.max(leftHeight, rightHeight) + 1;
    }

    public long fibCalculator(long value, HashMap<Long, Long> memory) {
        if (value == 0)
            return 0;

        if (value == 1)
            return 1;

        if (memory.get(value) != null)
            return memory.get(value);

        long fib = fibCalculator(value - 1, memory) + fibCalculator(value - 2, memory);
        memory.put(value, fib);

        return fib;
    }

    public long fibCalculatorWithoutMemory(long value) {
        if (value == 0)
            return 0;

        if (value == 1)
            return 1;

        return fibCalculatorWithoutMemory(value - 1) + fibCalculatorWithoutMemory(value - 2);
    }
}
