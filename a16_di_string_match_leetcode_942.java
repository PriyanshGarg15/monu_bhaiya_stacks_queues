import java.util.*;
public class a16_di_string_match_leetcode_942
{
    public static void main(String[] args){ 
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); //"IIIDIDDD"
        int[] ans = diStringMatch(str);
        for(int i=0;i<ans.length;i++)
        System.out.print(ans[i]+"");
        
    }
    public static int[] diStringMatch(String s) 
    {
        int n = s.length();
        int[] perm = new int[n + 1];
        int left = 0, right = n;

        for (int i = 0; i < n; i++) 
        {
            if (s.charAt(i) == 'I') 
            {
                perm[i] = left++;
            } else {
                perm[i] = right--;
            }
        }
        
        // The last position
        perm[n] = left; 

        return perm;
    }
}