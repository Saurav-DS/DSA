package src.main.java.com.saurav.dsa.leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import HashMap;

/*
LeetCode 127 - Word Ladder
Difficulty: Hard
Link: https://leetcode.com/problems/word-ladder/

Approach:
- Treat each word as a node in a graph.
- Two nodes are connected if their words differ by exactly one letter.
- Use BFS to find the shortest transformation path from beginWord to endWord.
- To efficiently find neighbors, use a pattern map:
  For each word, replace one letter with '*' to form patterns like "h*t" or "*ot".
  All words sharing the same pattern are directly connected.

Complexity:
- Time Complexity: O(N * L^2)
  (N = number of words, L = word length)
- Space Complexity: O(N * L)
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Map<String, List<String>> patternMap = new HashMap<>();
        int L = beginWord.length();

        for (String word : wordSet) {
            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }
        
        // BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Map<String, Integer> dist = new HashMap<>();
        dist.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int level = dist.get(word);

            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> neighbors = patternMap.getOrDefault(pattern, new ArrayList<>());

                for (String next : neighbors) {
                    if (next.equals(endWord)) {
                        return level + 1;
                    }

                    if (!dist.containsKey(next)) {
                        dist.put(next, level + 1);
                        queue.add(next);
                    }
                }
            }
        }

        return 0;
    }
}

