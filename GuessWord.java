import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/discuss/interview-question/1146079/Wayfair-Onsite
public class GuessWord {
    private static class WordCount {
        public String word;
        public int count;

        public WordCount(String word, int count) {
            this.count = count;
            this.word = word;
        }
    }

    private static class CharWeight {
        public char c;
        public int count;

        public CharWeight(char c, int count) {
            this.count = count;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        List<WordCount> list = new ArrayList<>();
        list.add(new WordCount("MOXTE", 3));
        list.add(new WordCount("MOQRT", 2));
        list.add(new WordCount("FOUSE", 4));
        list.add(new WordCount("POWER", 1));
        System.out.println(guessWord(list, 5));
    }

    public static String guessWord(List<WordCount> list, int wordLength) {
        Map<Integer, CharWeight> wordWeightMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordLength; i++) {
            for (WordCount wc : list) {
                char c = wc.word.charAt(i);
                checkAndUpdateMap(wordWeightMap, i, c, wc.count);
            }
            char finalChar = wordWeightMap.get(i).c;
            sb.append(finalChar);
        }
        return sb.toString();
    }

    public static void checkAndUpdateMap(Map<Integer, CharWeight> wordWeightMap, int i, char c, int w) {
        CharWeight characterWeight = null;
        if (wordWeightMap.containsKey(i)) {
            characterWeight = wordWeightMap.get(i);
            int preWeight = characterWeight.count;
            if (characterWeight.c == c) {
                characterWeight.count = preWeight + w;
            } else {
                if (preWeight < w) {
                    characterWeight.c = c;
                    characterWeight.count = w;
                }
            }

        } else {
            characterWeight = new CharWeight(c, w);
            wordWeightMap.put(i, characterWeight);
        }

    }
}
