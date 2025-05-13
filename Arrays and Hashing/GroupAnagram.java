import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

// An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

public class GroupAnagram {

    //n*mlogm where n is num of strings and m is length of longest string
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();
        for (String s : strs) {
            char[] sToCharArr = s.toCharArray();
            Arrays.sort(sToCharArr);
            String sortedS = new String(sToCharArr);
            result.putIfAbsent(sortedS, new ArrayList<>());
            result.get(sortedS).add(s);
        }

        return new ArrayList<>(result.values());
    }
}
