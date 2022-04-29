package practice;


import java.util.HashSet;
import java.util.Set;

public class N_3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int len = s.length();
        int maxSize = 0;
        int tail = 0;
        Set<Character> hs = new HashSet<Character>();
        for (int i = 0; i < len; ++i) {
            if(i != 0)
                hs.remove(s.charAt(i - 1));
            while (tail < len && !hs.contains(s.charAt(tail))){
                hs.add(s.charAt(tail));
                ++tail;
            }
            maxSize = Math.max(maxSize, tail - i);
        }
        return maxSize;
    }
}
