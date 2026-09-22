package leetcode;

/** 392. Is Subsequence **/
public class Is_Subsequence_392 {
    public static void main(String[] args) {
        // System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
    public static boolean isSubsequence(String s, String t) {
        int sl = 0, tl = 0;

        while(sl<s.length() && tl<t.length()) {
            if(s.charAt(sl) == t.charAt(tl)) sl++;
            tl++;
        }

        return sl == s.length();
    }
}
