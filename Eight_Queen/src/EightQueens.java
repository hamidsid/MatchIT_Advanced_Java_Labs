public class EightQueens {
    public static void main(String args[]) {
        int N = 4;
        int[][] board = new int[N][N];
        solve(0, board, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
    }

    static boolean solve(int row, int[][] board, int N) {
        if (row >= N) {  //we have reached the final row; all queens are placed
            return true;
        }

        //Recursive case
        //Try to place the queen on the current row, the remaining queens will be solved by calling recursion
        for (int position = 0; position < N; position++) {

            //check if its safe to place the queen or not
            if (isValid(board, row, position, N)) {

                //if its safe then place the queen; Assumption; row,col is the right position
                board[row][position] = 1;

                //now its time to check the placement of the next queen

                //if we can place the next queen as well then return true
                if (solve(row + 1, board, N)) {
                    return true;
                }

                //but if we can not place the next queen, meaning row, col was not the right position
                // showing that our assumption was wrong, so we should remove the queen from its place
                else {
                    board[row][position] = 0;
                }
            }
        }


        //we have tried all positions for current row but could not place it.
        return false;
    }

    static boolean isValid(int[][] board, int x, int y, int N) {

        //check for the column; row will change but column will stay the same
        int i, j;
        for (i = 0; i < x; i++) {
            if (board[i][y] == 1) {
                return false;
            }
        }

        //check for the left diagonal
        i = x - 1;
        j = y - 1;
        while ((i >= 0) && (j >= 0)) {
            if (board[i--][j--] == 1) {
                return false;
            }
        }

        //check for the right diagonal
        i = x - 1;
        j = y + 1;
        while ((i >= 0) && (j < N)) {
            if (board[i--][j++] == 1) {
                return false;
            }

        }

        return true;
    }
}