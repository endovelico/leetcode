package solutions.p1047;

public class SolutionPointers {

    public String removeDuplicates(String s) {
        char[] arr = s.toCharArray();
        int i = 0; // stack pointer
        for (int j = 0; j < arr.length; j++) {
            arr[i] = arr[j];
            if (i > 0 && arr[i] == arr[i - 1]) i -= 2; // remove duplicate
            i++;
        }
        return new String(arr, 0, i);
    }

}
