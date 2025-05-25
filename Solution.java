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