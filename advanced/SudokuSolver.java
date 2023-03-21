package advanced;

public class SudokuSolver {

    public void solveSudoku(char[][] A) {
        sudokuSolver(A, 0);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean sudokuSolver(char[][] mat, int x) {
        boolean isValid = false;
        if (x == 81) {
            return true;
        }
        int row = x / 9;
        int col = x % 9;

        if (mat[row][col] != '.') {
            sudokuSolver(mat, x + 1);

        } else {
            for (int i = 1; i <= 9; i++) {
                isValid = isValid(mat, row, col, (char) (i + '0'));
                if (isValid) {
                    mat[row][col] = (char) (i + '0');
                    isValid = sudokuSolver(mat, x + 1);

                    if (isValid){
                        return true;
                    }
                }
            }
        }
        mat[row][col] = isValid ? mat[row][col]: '.';// backtracking and reverting the decision
        return isValid;

    }

    private boolean isValid(char[][] mat, int row, int col, char d) {
        for (int i = 0; i < 9; i++) {
            if (mat[row][i] == d) {
                return false;
            } else if (mat[i][col] == d) {
                return false;
            }

        }

        int rowStart = row - row % 3;
        int colStart = col - col % 3;

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (mat[i][j] == d) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        char[][] A = {
                { '5', '3', '.', '7', '.', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        sudokuSolver.solveSudoku(A);
    }
}
