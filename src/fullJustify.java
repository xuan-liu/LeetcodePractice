import java.util.ArrayList;
import java.util.List;

public class fullJustify {
    public static List<String> mySolution(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int left = 0;

        while (left < words.length) {
            int right = findRight(words, left, maxWidth);
            String line = justify(left, right, words, maxWidth);
            result.add(line);
            left = right;
        }

        return result;
    }

    /* given left, find right that can full the line as much as possible, not include words[right] */
    private static int findRight(String[] words, int left, int maxWidth) {
        int right = left;
        int sum = words[right].length();
        right += 1;

        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth) {
            sum += 1 + words[right].length();
            right += 1;
        }

        return right;
    }

    /* given a word list, justify it in a line */
    private static String justify(int left, int right, String[] words, int maxWidth) {
        String ans = "";
        int n = right - left;

        if (n == 1) {
            // if there are only one word, then left justify the word.
            ans += words[left];
            int nSpace = maxWidth - words[left].length();
            ans += blank(nSpace);

        } else if (right == words.length) {
            // if this is the last line, then left justify of all the words
            int nSpace = maxWidth - countWordLen(left, right, words);
            for (int i = left; i < right; i++) {
                if (i == right - 1) {
                    ans += words[i] + blank(nSpace);
                } else {
                    ans += words[i] + " ";
                }
            }
        } else {
            // if the normal, then justify of all the words
            int nSpace = maxWidth - countWordLen(left, right, words);
            int nBetween = right - left - 1;
            int quotient = nSpace / nBetween;
            int remainder = nSpace % nBetween;

            int count = 0;
            for (int i = left; i < right; i++) {
                if (i == right - 1) {
                    ans += words[i];
                } else {
                    ans += words[i];
                    ans += count < remainder? blank(quotient + 2): blank(quotient + 1);
                }
                count += 1;
            }
        }

        return ans;
    }

    /* count the all the words length including the necessary space */
    private static int countWordLen(int left, int right, String[] words) {
        int ans = 0;
        for (int i = left; i < right; i++) {
            ans += words[i].length();
        }
        ans += (right - left - 1);
        return ans;
    }

    /* generate a string consist of len of space */
    private static String blank(int len) {
        return new String(new char[len]).replace('\0', ' ');
    }

    public static void main(String[] args) {
        String[] s = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(mySolution(s, 16));
    }
}
