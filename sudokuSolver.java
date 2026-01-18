public class sudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {

                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {

            // check column
            if (board[i][col] == c) return false;

            // check row
            if (board[row][i] == c) return false;

            // check 3x3 sub-box
            if (board[3 * (row / 3) + i / 3]
                     [3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
    sudokuSolver solver = new sudokuSolver();

    char[][] board = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '6', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    solver.solveSudoku(board);

    // 🔁 NORMAL for loops (row & column traversal)
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            System.out.print(board[i][j] + " ");
        }
        System.out.println();
    }
}
}