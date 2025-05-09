// Valid Anagram
 
// Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
// An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

import java.util.Arrays;
import java.util.HashMap;

public class IsAnagram {

    //Solution using sorting
    //O(nlogn+mlogm)

    public boolean isAnagramSort(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    //Solution using HashMap
    //O(n+m)

    public boolean isAnagramHashMap(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for (int i=0; i<s.length(); i++){
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0)+1);
            countT.put(t.charAt(i), 1+countT.getOrDefault(t.charAt(i), 0));
        }

        return countS.equals(countT);
    }

    //Solution using arrays
    //O(n+m)

    public boolean isAnagramArray(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
    
}
