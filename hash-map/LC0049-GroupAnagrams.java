/**
 * LeetCode #49 - Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 *
 * 🧠 Core Idea
 * Two strings are anagrams if they contain the same characters with the same frequencies.
 * All anagrams will share the same sorted key.
 *
 * We store them in a HashMap:
 * key = sorted string
 * value = list of original strings
 *
 * ⏱️ Time Complexity: O(n * k log k)
 * 💾 Space Complexity: O(n * k)
 * n = number of strings
 * k = average length of each string
 */
import java.util.*;

public class LC0049GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
