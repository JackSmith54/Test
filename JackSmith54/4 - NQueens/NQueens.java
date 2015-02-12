public class NQueens {
	
	public static void main(String[] args) {
    
		int n = 5;
		int[][] board = new int[n][n];
    
		if (n < 4){
			System.out.println("No solution available for n < 4");
		} else if (n >= 4){
    	
			solve(0, board, n);

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(board[i][j] == 1){
						System.out.print(" Q ");
					}
					else System.out.print(" - ");
				}
				System.out.println();
			}
		}
	}

	static boolean solve(int row, int[][] board, int n) {
		if(row >= n){
			return true;
		}
		for(int pos = 0; pos < n; pos++) {
			if(isValid(board, row, pos, n)) {
				board[row][pos] = 1;
				if(!solve(row+1, board, n)) {
					board[row][pos] = 0;
				} else
					return true;
			}
		}	
		return false;
	}

	static boolean isValid(int[][] board, int row, int pos, int n) {
		int i, j;
		for(i = 0; i < row; i++){
			if(board[i][pos] == 1){
				return false;
			}
		}
		i = row;
		j = pos;
   
		while((i >= 0) && (j >= 0)){
			if(board[i--][j--] == 1){
				return false;
			}
		}
		i = row - 1;
		j = pos + 1;
    
		while((i >= 0) && (j < n)){
			if(board[i--][j++] == 1){
				return false;
			}
		}
		return true;
	}
}