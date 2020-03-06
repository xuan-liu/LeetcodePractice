import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ladderLength {
    public static int mySolution(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>(); // use as the queue for the begin case
        Set<String> endSet = new HashSet<>(); // use as the queue for the end case
        int len = 1; // the result ladderLength
        Set<String> visited = new HashSet<>(); // conclude all the visited word for both begin and end case

        beginSet.add(beginWord);
        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // if beginSet.size > endSet, swap them
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }

            Set<String> temp = new HashSet<>();

            // for each word in beginSet, find the next level word
            for (String word: beginSet) {
                char[] chs = word.toCharArray();

                // change the word to another word by changing one letter and add it to temp and visited
                for (int i = 0; i < chs.length; i++) {
                    // convert the ith char in word to another char
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;

                        String target = String.valueOf(chs);

                        // if endSet contains the string, return to len+1
                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        // otherwise, check it is not been visited
                        if (wordList.contains(target) && !visited.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;

                    }
                }
            }

            // go to the next level word
            beginSet = temp;
            len += 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println(mySolution(beginWord, endWord, Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}
