package practice;

public class N_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        int strCount = strs.length;
        int j = 0;
        int min = strs[0].length();
        for(int i = 0; i < strCount - 1; ++i){
            j = 0;
            while (strs[i].charAt(j) == strs[i + 1].charAt(j))
                ++j;
            min = Math.min(min, j);
        }
        return strs[0].substring(0, min);
    }
}
