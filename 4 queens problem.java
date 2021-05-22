public class Main {
    public static void main(String[] args) {
        fourQueens();
    }
    
    public static void fourQueens() {
        int[] board = {-1,-1,-1,-1};
        int n = 4;
        for(int i = 0; i < n; i++) {
            board[0] = i;
            for(int j = 0; j < n; j++) {
                board[1] = j;
                if(noKill(board, 1)) {
                    for(int k = 0; k < n; k++) {
                        board[2] = k;
                        if(noKill(board, 2)) {
                            for(int l = 0; l < n; l++) {
                                board[3] = l;
                                if(noKill(board,3))
                                    displayQueens(board);
                            }
                        }
                    }
                }
            }
        }
    }
    
    private static void displayQueens(int[] board) {
        System.out.println("---------------------------");
        int rows = 4;
        for(int row = 0; row < rows; row++) {
            for(int value : board) {
                if(value == row)
                    System.out.print("Q\t");
                else
                    System.out.print("*\t");
            }
            System.out.println();
        }
    }
    
    private static boolean noKill(int[] board, int currentColumnOfQueen) {
        for(int i = 0; i < currentColumnOfQueen; i++) {
            if(board[i] == board[currentColumnOfQueen])
                return false;
            if(currentColumnOfQueen - i == Math.abs(board[currentColumnOfQueen] - board[i]))
                return false;
        }
        return true;
    }
}
