import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {


        int result = reverse(2000000000);


        System.out.println(reverse(1563847412) + "");
    }


    public static int reverse(int x) {
        boolean sign = x < 0;
        if (sign)
            x = x * -1;

        String xAsString = String.valueOf(x);

        if (xAsString.length() > 9) {
            int lastDigit = (xAsString.charAt(xAsString.length() - 1)) - '0';
            if (lastDigit > 2)
                return 0;
            else {
                StringBuilder sb = new StringBuilder(xAsString);
                xAsString = sb.reverse().toString();
                int reversedX = 0;

                try{
                    reversedX = Integer.parseInt(xAsString);
                }catch (Exception e){
                    return 0;
                }

                if (sign)
                    reversedX *= -1;


                return reversedX;
            }

        } else {
            StringBuilder sb = new StringBuilder(xAsString);
            xAsString = sb.reverse().toString();
            int reversedX = Integer.parseInt(xAsString);
            if (sign)
                reversedX *= -1;


            return reversedX;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;

                Character popedC = stack.pop();
                if (c == ')') {
                    if (popedC != '(')
                        return false;
                }
                if (c == '}') {
                    if (popedC != '{')
                        return false;
                }
                if (c == ']') {
                    if (popedC != '[')
                        return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        for (String s : strs) {
            if (s.length() == 0)
                return "";
        }

        String longestCommonPrefix = strs[0];

        int currentWordIndex = 1;
        char[] currentWord;

        while (longestCommonPrefix.length() > 0 && currentWordIndex < strs.length) {
            currentWord = strs[currentWordIndex].toCharArray();

            int index = 0;

            for (int i = 0; i < Math.min(currentWord.length, longestCommonPrefix.length()); i++) {
                if (currentWord[i] == longestCommonPrefix.charAt(i)) {
                    index++;
                } else {
                    longestCommonPrefix = longestCommonPrefix.substring(0, index);
                    break;
                }

                if (longestCommonPrefix.length() > Math.min(currentWord.length, longestCommonPrefix.length()))
                    longestCommonPrefix = longestCommonPrefix.substring(0, Math.min(currentWord.length, longestCommonPrefix.length()));


            }
            currentWordIndex++;
        }


        return longestCommonPrefix;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        String xToStr = String.valueOf(x);
        int i = 0, j = xToStr.length() - 1;

        while (i <= j) {
            if (xToStr.charAt(i) != xToStr.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }

    private static void sortInPlace() {
        ArrayList<String> list = setupList();

        int redCounter = 0;
        int blueCounter = 0;
        int greenCounter = 0;

        for (String element : list) {
            if (element.equals("red")) {
                redCounter++;
            } else if (element.equals("blue")) {
                blueCounter++;
            } else if (element.equals("green")) {
                greenCounter++;
            }
        }

        int redPointer = 0;
        int redStartingIndex = 0;

        int bluePointer = 0;
        int blueStartingIndex = redCounter;

        int greenPointer = 0;
        int greenStartingIndex = redCounter + blueCounter;


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("red") && (i > redStartingIndex + redCounter || i < redStartingIndex)) {
                int swapIndex = redPointer;
                swapElements(list, i, swapIndex);
                redPointer++;
            } else if (list.get(i).equals("blue") && (i > blueStartingIndex + blueCounter || i < blueStartingIndex)) {
                int swapIndex = bluePointer + blueCounter;
                swapElements(list, i, swapIndex);
                bluePointer++;
            } else if (list.get(i).equals("green") && (i > greenStartingIndex + greenPointer || i < greenStartingIndex)) {
                int swapIndex = greenPointer + redCounter + blueCounter;
                swapElements(list, i, swapIndex);
                greenPointer++;
            }
        }

        System.out.println(list);
    }

    private static ArrayList<String> setupList() {
        String red = "red";
        String blue = "blue";
        String green = "green";
        ArrayList<String> list = new ArrayList<>();

        list.add(blue);
        list.add(red);
        list.add(blue);
        list.add(green);
        list.add(red);
        list.add(green);
        list.add(green);
        list.add(red);
        list.add(blue);
        return list;
    }

    private static void swapElements(ArrayList<String> list, int first, int second) {
        String temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private static ArrayList<Integer> getUnionList(ArrayList<Integer> list1Unified, ArrayList<Integer> list2Unified) {
        ArrayList<Integer> result = new ArrayList<>();

        int firstListPointer = 0;
        int secondListPointer = 0;


        while (firstListPointer < list1Unified.size() && secondListPointer < list2Unified.size()) {
            if (list1Unified.get(firstListPointer) == list2Unified.get(secondListPointer)) {
                result.add(list1Unified.get(firstListPointer));
                firstListPointer++;
                secondListPointer++;
            } else if (list1Unified.get(firstListPointer) > list2Unified.get(secondListPointer)) {
                result.add(list2Unified.get(secondListPointer));
                secondListPointer++;
            } else if (list1Unified.get(firstListPointer) < list2Unified.get(secondListPointer)) {
                result.add(list1Unified.get(firstListPointer));
                firstListPointer++;
            }
        }

        for (int i = firstListPointer; i < list1Unified.size(); i++)
            result.add(list1Unified.get(i));


        for (int i = secondListPointer; i < list2Unified.size(); i++)
            result.add(list2Unified.get(i));


        return result;
    }

    private static ArrayList<Integer> getUnifiedList(ArrayList<Integer> list1) {
        ArrayList<Integer> result = new ArrayList<>();

        Integer current = list1.get(0);
        result.add(current);

        for (int i = 1; i < list1.size(); i++) {
            if (list1.get(i) != current) {
                current = list1.get(i);
                result.add(current);
            }
        }
        return result;
    }


    static void printLinkedList(ListNode node) {

        while (node != null) {
            System.out.print(node.val + "   ");
            node = node.next;
        }

    }

    static void printList(List<Integer> list) {
        for (Integer num : list) {
            System.out.print("  " + num.toString());
        }
    }

    private static boolean sumExist(ArrayList<Integer> list1, ArrayList<Integer> lis2) {

        return false;
    }

}



