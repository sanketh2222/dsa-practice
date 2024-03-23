package easy;

public class FirstOccurrenceIndexFinder {
    public int strStr(String haystack, String needle) {
        int n = haystack.length() - needle.length();
        for (int i = 0; i <= n; i++) {
            if (haystack.substring(i , i + needle.length()).equals(needle)) {
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        FirstOccurrenceIndexFinder finder = new FirstOccurrenceIndexFinder();
        int index = finder.strStr("hello", "ll");
        System.out.println(index);
    }
}
