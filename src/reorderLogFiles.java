import java.lang.*;
import java.util.Arrays;
import java.util.Comparator;

public class reorderLogFiles {
    public static String[] mySolution(String[] logs) {

        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split(" ", 2);
                String[] split2 = o2.split(" ", 2);

                boolean b1 = Character.isDigit(split1[1].charAt(0));
                boolean b2 = Character.isDigit(split2[1].charAt(0));

                if (!b1 && !b2) {
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0) {
                        return cmp;
                    } else {
                        return split1[0].compareTo(split2[0]);
                    }
                }

                return b1? (b2? 0: 1): -1;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;

    }

    public static void main(String[] args) {
        String[] logs = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] result = mySolution(logs);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        boolean b1 = Character.isDigit('c');
        boolean b2 =  Character.isDigit('6');
        System.out.println(b1? (b2? 0: 1): -1);

    }

}
