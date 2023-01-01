import java.util.HashSet;


public class ValidSudoku {

    public static int isValidSudoku(final String[] A) {

        // check unique elements row-wise
        for (int i = 0; i < A.length; i++) {
            Object[] row = A[i].chars().mapToObj(ch -> (char) ch).toArray();
            HashSet<Integer> rowSet = new HashSet<Integer>();
            for (int j = 0; j < row.length; j++) {
                if ((char) row[j] == '.')
                    continue;
                else if (rowSet.contains((char) row[j] - '0')) {
                    return 0;
                } else {
                    int value = (char) row[j] - '0';
                    rowSet.add(value);
                }
            }
        }

        // check unique elements col-wise
        for (int i = 0; i < A.length; i++) {
            HashSet<Integer> colSet = new HashSet<Integer>();
            for (int j = 0; j < 9; j++) {
                Object[] col = A[j].chars().mapToObj(ch -> (char) ch).toArray();
                if ((char) col[i] == '.')
                    continue;
                if (colSet.contains((char) col[i] - '0')) {
                    return 0;
                } else {
                    int value = (char) col[i] - '0';
                    colSet.add(value);
                }
            }
        }

        // check unique elements in each 3*3 box
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {

                HashSet<Integer> boxSet = new HashSet<Integer>();

                for (int x = i; x < i + 3; x++) {
                    Object[] row = A[x].chars().mapToObj(ch -> (char) ch).toArray();
                    for (int y = j; y < j + 3; y++) {
                        if ((char) row[y] == '.') {
                            continue;
                        } else if (boxSet.contains((char) row[y] - '0')) {
                            return 0;
                        } else {
                            int value = (char) row[y] - '0';
                            boxSet.add(value);
                        }
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String[] sudokuMatrix = { "..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.",
                "...54....", "3.....42.", "...27.6.." };
        int ans = isValidSudoku(sudokuMatrix);
        System.out.println(ans);

    }
}
