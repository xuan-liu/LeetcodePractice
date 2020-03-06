public class isMatchWildcard {
    public static boolean mySolution(String s, String p) {
        // use two pointer to iterate s and p, if p=? or s=p, then both move one step; if p=*, then record s as s_pos, p as p_pos
        // and move p one step; if p_pos != -1 (means we encountered * before), p = p_pos+1, s_pos += 1, s = s_pos. (this can be
        // used if we found a match after * but cannot continue matching, then we can change that match due to this case); otherwise,
        // return false. At last, check for remaining p is all *

        int ss = 0;
        int pp = 0;
        int p_pos = -1;
        int s_pos = 0;

        while (ss < s.length()) {
            // case1: if p=? or s=p, then both move one step
            if (pp < p.length() && (p.charAt(pp) == '?' || s.charAt(ss) == p.charAt(pp))) {
                ss += 1;
                pp += 1;
            }
            // case2: if p=*, then record s as s_pos, p as p_pos and move p one step
            else if (pp < p.length() && p.charAt(pp) == '*') {
                p_pos = pp;
                pp += 1;
                s_pos = ss;
            }
            // case3: if p_pos != -1 (means we encountered * before), p = p_pos+1, s_pos += 1, s = s_pos.
            else if (p_pos != -1) {
                pp = p_pos+1;
                s_pos += 1;
                ss = s_pos;
            }
            // case4: otherwise, return false
            else {
                return false;
            }
        }

        // check for remaining p is all *
        while (pp < p.length() && p.charAt(pp) == '*') {
            pp += 1;
        }
        return pp == p.length();
    }

    public static void main(String[] args) {
        System.out.println(mySolution("acdcb", "a*c?b"));
    }
}
