import java.util.Arrays;
import java.util.Stack;
public class a23_next_smaller_on_right {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 6, 11, 9, 6};
        int[] result = nextSmallerElement(arr);
        System.out.println(Arrays.toString(result)); // Expected output: [3, 2, -1, 2, 4, 9, 6, -1]
    }

    public static int[] nextSmallerElement(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                ans[st.pop()] = arr[i];
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            ans[st.pop()] = -1;
        }

        return ans;
    }
}
