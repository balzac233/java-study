package practice.easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @problem 819. 最常见的单词
 * @idea 字符串的基础操作：StringBuilder Character HashSet HashMap
 */
public class N_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<>();
        for (String str : banned) {
            bannedSet.add(str.toLowerCase());
        }
        HashMap<String, Integer> frequency = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int len = paragraph.length();
        int maxFrequency = 0;

        //for(i <= len)而不是for(i < len)的目的是：当最后一个单词以字母结尾时，将单词读入到StringBuilder，否则最后一个单词会丢失
        for (int i = 0; i <= len; i++) {
            if(i < len && Character.isLetter(paragraph.charAt(i)))
                sb.append(paragraph.charAt(i));
            else if(sb.length() != 0){
                String word = sb.toString().toLowerCase();
                if(bannedSet.size() == 0 || !bannedSet.contains(word)){
                    int count = frequency.getOrDefault(word, 0) + 1;
                    frequency.put(word, count);
                    maxFrequency = Math.max(maxFrequency, count);
                }
                sb.setLength(0);
            }
        }
        for (String s : frequency.keySet()) {
            if(frequency.get(s).equals(maxFrequency))
                return s;
        }
        return null;
    }
}
