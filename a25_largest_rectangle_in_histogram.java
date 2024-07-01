import java.util.Stack;

public class a25_largest_rectangle_in_histogram {
     public static void main(String[] args) {
        int[] arr={2,1,5,6,2,3};
        int max=largestRectangleArea(arr);
        System.out.println(max);
     }
     public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> pt = new Stack<>();

        int[] nextsmallest_right = new int[heights.length];
        int[] nextsmallest_left = new int[heights.length];

        // Next smaller on right
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                nextsmallest_right[st.pop()] = i;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            nextsmallest_right[st.pop()] = heights.length;
        }

        // Next smallest on left
        for (int i = 0; i < heights.length; i++) {
            while (!pt.isEmpty() && heights[pt.peek()] >= heights[i]) {
                pt.pop();
            }
            if (pt.isEmpty()) {
                nextsmallest_left[i] = -1;
            } else {
                nextsmallest_left[i] = pt.peek();
            }
            pt.push(i);
        }

        // Calculate maximum area
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = nextsmallest_right[i] - nextsmallest_left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
