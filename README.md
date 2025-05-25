# may25_2025
The problem that i solved today in leetcode

1.You are given an array of strings words. Each element of words consists of two lowercase English letters.

Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.

Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.

A palindrome is a string that reads the same forward and backward.

Code:
class Solution {
    public int longestPalindrome(String[] words) {
        int len=0;
        Map<String,Integer> s=new HashMap<>();
        for(String x:words)
        {
            String rev=new StringBuilder(x).reverse().toString();
            if(s.containsKey(rev))
            {
                len+=4;
                if(s.get(rev)==1)
                    s.remove(rev);
                else 
                    s.put(rev,s.get(rev)-1);
            }
            else
                s.put(x,s.getOrDefault(x,0)+1);
        }
        for(Map.Entry<String,Integer> x:s.entrySet())
        {
            String z=x.getKey();
            if(z.charAt(0)==z.charAt(1))
            {
                len+=2;
                break;
            }
        }
        return len;
    }
}
