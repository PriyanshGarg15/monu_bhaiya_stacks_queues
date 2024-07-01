import java.util.Scanner;
import java.util.*;

public class a11_minimum_add_to_make_parenthesis_valid_leetcode_921 
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int ans=minAddToMakeValid(str);
        System.out.println(ans);
    }
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    count++;
                }
            }
        }
        return count+stack.size();
    }
    
}
