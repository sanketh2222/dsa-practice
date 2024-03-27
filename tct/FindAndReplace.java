package tct;

public class FindAndReplace {
    public String findAndReplace(String A, String B, String C) {
        int index = 0;
        StringBuilder result = new StringBuilder();
        while (index < A.length()) {
            int start = A.indexOf('[') + 1, end = A.indexOf(']') + 1;

            if (start == 0 || end == 0) {
                result.append(A.substring(index));
                break;
            }

            result.append(A.substring(index, start));

            for (int i = start; i < end; i++) {
                if (A.substring(i, B.length()).equals(B)) {
                    result.append(C);
                    i += B.length() - 1;
                } else {
                    result.append(A.charAt(i));
                }
            }
            result.append(']');
            index += 1;

        }
        return result.toString();
    }

    public static void main(String[] args) {
        String A = "a[ab]ba[bab]cz";
        String B = "a";
        String c = "b";
        FindAndReplace findAndReplace = new FindAndReplace();
        System.out.println(findAndReplace.findAndReplace(A, B, c));
    }
}
