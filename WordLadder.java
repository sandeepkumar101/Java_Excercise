import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        String[] workArray = new String[] { "lest", "leet", "lose", "code", "lode", "robe", "lost" };

        List<String> workList = new ArrayList<>();
        for (String s : workArray) {
            workList.add(s);
        }

        System.out.println(list.contains("hot"));
        System.out.println(ladderLength("leet", "code", workList));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int numberOfWorkds = 0;
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            if (word.equals(beginWord)) {
                continue;
            }
            // for (char c : word.toCharArray()) {
            for (int i = 0; i < word.length(); i++) {
                // String newWord = word;
                // word.toCharArray()[i] = c;
                char[] newCharArray = word.toCharArray();
                newCharArray[i] = '*';
                String newWord = new String(newCharArray);
                if (!map.containsKey(newWord)) {
                    map.put(newWord, new ArrayList<>());
                }
                map.get(newWord).add(word);
            }
        }

        Map<String, Integer> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int level = visited.get(word);
            // for (char c : word.toCharArray()) {
            for (int i = 0; i < word.length(); i++) {
                char[] newCharArray = word.toCharArray();
                newCharArray[i] = '*';
                String newWord = new String(newCharArray);
                // String newWord = word.replace(c, '*');
                if (map.containsKey(newWord)) {
                    for (String s : map.get(newWord)) {
                        if (s.equals(endWord)) {
                            return level + 1;
                        }
                        if (!visited.containsKey(s)) {
                            visited.put(s, level + 1);
                            queue.add(s);
                        }
                    }
                }
            }
        }
        return numberOfWorkds;
    }

}
