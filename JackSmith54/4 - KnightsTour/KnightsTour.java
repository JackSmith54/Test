
public class KnightsTour {

	public static void main(String[] args){
		int[][] board = new int[8][8];
		
		for (int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				board[i][j] = 0;
			}
		}
		
	    solve(board,4,3);
	//    boardSolution(board);

	    
	}
	
	static boolean isSafe(int row, int col, int board[][]){
	    if ( row >= 0 && row < 8 && col >= 0 && col < 8 && board[row][col] == 0){
	        return true;
	    }else{
	    	return false;
	    }
	}
	
	public static void solve(int[][] board, int row, int col){

		int rowMove[] = {2, 2, -2, -2, 1, 1, -1, -1};
		int colMove[] = {1, -1, 1, -1, 2, -2, 2, -2};

		board[row][col] = 1;
		solveCheck(row, col,rowMove, colMove, board, 2);
		boardSolution(board);
	}
	
	static boolean solveCheck(int row, int col, int[] rowMove,int[] colMove, int[][] board, int moveNum){
		int nextRow;
		int nextCol;
		
		if (moveNum == 65){
			return true;
		}
		for (int i = 0; i < 8; i++)
		   {
		       nextRow = row + rowMove[i];
		       nextCol = col + colMove[i];
		       if (isSafe(nextRow, nextCol, board)){
		         board[nextRow][nextCol] = moveNum;
		         if (solveCheck(nextRow, nextCol, rowMove, colMove, board, moveNum+1) == true)
		             return true;
		         else
		             board[nextRow][nextCol] = 0;
		       }
		   }
		 
		   return false;
		}
	
	static void boardSolution(int board[][]){
	    for (int i = 0; i < 8; i++){
	        for (int j = 0; j < 8; j++){
	            System.out.print((board[i][j] + "       "));
	        }
	        System.out.println();
	    }
	}
}
