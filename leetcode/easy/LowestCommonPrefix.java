package easy;

public class LowestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int lcp = Math.min(strs[0].length(), strs[1].length());
        for (int i = 0; i < strs.length - 1; i++) {
            lcp = Math.min(lcp, getLcp(strs[i], strs[i + 1], lcp));
            if (lcp == 0) {
                return "";
            }
        }

        return strs[0].substring(0, lcp);
    }

    private int getLcp(String str1, String str2, int maxLen) {
        int lcp = 0, idx = 0;
        maxLen = Math.min(maxLen, Math.min(str1.length(), str2.length()));
        while (maxLen > 0 && str1.charAt(idx) == str2.charAt(idx)) {
            lcp += 1;
            maxLen -= 1;
            idx += 1;
        }

        return lcp;
    }

    public static void main(String[] args) {
        LowestCommonPrefix lcp = new LowestCommonPrefix();
        String[] strs = {"baab", "bacb", "b", "cbc"};
        System.out.println(lcp.longestCommonPrefix(strs));
    }
}
