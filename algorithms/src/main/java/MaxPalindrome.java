//给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
//输出需要删除的字符个数。


import java.lang.*;
import java.io.*;
import java.util.*;

public class MaxPalindrome {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            String s = sc.next();
            System.out.println(s.length()-compute(s));
        }
    }

    private static int compute(String s)
    {
        int n = s.length();
        if(n <= 1) return n;
        int[][] dp = new int[n][n];
        for(int k = 0; k < n; k++)
            for(int i = 0; i < n-k; i++)
            {
                int j = i+k;
                if(k == 0) dp[i][i] = 1;
                else if(k == 1) dp[i][j] = (s.charAt(i)==s.charAt(j))?2:1;
                else {

                    int res = dp[i+1][j-1];
                    for(int t = i; t < j; t++)
                        if(s.charAt(t)==(s.charAt(j))) {
                            res = Math.max(res, ((j - t) >= 2 ? dp[t + 1][j - 1] : 0) + 2);
                            break;
                        }
                    for(int t = j; t > i; t--)
                        if(s.charAt(t)==(s.charAt(i))) {
                            res = Math.max(res, ((t - i) >= 2 ? dp[i + 1][t - 1] : 0) + 2);
                            break;
                        }
                    dp[i][j]=res;
                }
            }

        return dp[0][n-1];
    }



}
