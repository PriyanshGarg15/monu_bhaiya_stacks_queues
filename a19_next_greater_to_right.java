import java.util.Stack;
public class a19_next_greater_to_right {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 2, 4, 6, 11, 9, 6 };
		NGE(arr);
	}
	public static void NGE(int[] arr) 
    {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) 
        {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                ans[st.pop()] = arr[i]; 
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            ans[st.pop()] = -1;
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.println(arr[i] + " -> " + ans[i]);
        }
    }
}