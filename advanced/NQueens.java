

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    ArrayList<ArrayList<String>> solutions = new ArrayList<>();
    private char QUEEN = 'Q';

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        ArrayList<String> chessBoard = initializeBoard(A);
        solveNQueens(chessBoard, 0, A);
        return solutions;
    }

    // n * n board
    private ArrayList<String> initializeBoard(int n) {
        ArrayList<String> board = new ArrayList<>();
        StringBuffer boardRow = new StringBuffer();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boardRow.append(".");
            }
            board.add(boardRow.toString());
            boardRow.setLength(0);
        }

        return board;
    }

    private boolean canPlaceQueen(List<String> board, int row, int col) {
        int totalCols = board.get(0).length();
        for (int i = 0; i <= row; i++) {
            if (board.get(i).charAt(col) == QUEEN) {
                return false;
            }

        }

        int currRow = row - 1;
        int currCol = col - 1;
        // left diagonal
        while (currCol >= 0 && currRow >= 0) {
            if (board.get(currRow).charAt(currCol) == QUEEN) {
                return false;
            }
            currRow--;
            currCol--;
        }

        currRow = row - 1;
        currCol = col + 1;

        // right diagonal
        while (currCol < totalCols && currRow >= 0) {
            if (board.get(currRow).charAt(currCol) == QUEEN) {
                return false;
            }
            currCol++;
            currRow--;
        }

        return true;
    }

    private String getBoardRowData(int n) {
        StringBuffer rowData = new StringBuffer();
        for (int i = 0; i < n; i++) {
            rowData.append(".");
        }
        return rowData.toString();
    }

    private void solveNQueens(ArrayList<String> board, int currentRow, int totalRows) {
        if (currentRow == totalRows) {
            solutions.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < totalRows; col++) {

            if (canPlaceQueen(board, currentRow, col)) {
                StringBuffer currentBoardRowData = new StringBuffer(getBoardRowData(totalRows));

                currentBoardRowData.setCharAt(col, QUEEN);
                board.set(currentRow, currentBoardRowData.toString());

                solveNQueens(board, currentRow + 1, totalRows);
                board.set(currentRow, getBoardRowData(totalRows));//backtrack
            }
        }
        //revert the decision/backtrack here if you want a single solution

    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        ArrayList<ArrayList<String>> soln = nQueens.solveNQueens(4);
        System.out.println("done");

        for (int i = 0; i < soln.size(); i++) {
            System.out.println("==========Solution " + (int) (i + 1) + "===================");
            for (int j = 0; j < soln.get(i).size(); j++) {
                System.out.print(soln.get(i).get(j) + " ");
                System.out.println();
            }
            System.out.println();
        }
    }
}
