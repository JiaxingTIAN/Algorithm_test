package nqueen;
/* Backtrack Algorithm --- Recursion is the Key
 * Pick a starting point.
 	while(Problem is not solved)
	For each path from the starting point.
		check if selected path is safe, if yes select it
                and make recursive call to rest of the problem
		If recursive calls returns true, then return true.
		else undo the current move and return false.
	End For
	If none of the move works out, return false, NO SOLUTON.
 * 
 */
public class NQueen {
	//NxN board to store the solution
	public int[][] solution;
	int n;
	//Initialize the board with all zero
	public NQueen(int N){
		solution = new int[N][N];
		n = N;
	}
	
	public void solve(){
		if(placeQueens(0)){
			//Print the result
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++)
					System.out.print(" " + solution[i][j]);
				System.out.println();
				
			}
		}
		else
			System.out.println("No solution");
	}
	
	public boolean placeQueens(int col){
		//Place the queen once a time, column wise
		//One column and one row for a queen if solution exists
		if(col == n) return true;	//last column can be placed, return true
		for(int row = 0; row < n; row++){
			//check if the queen can be placed at current row, col
			//If it can be placed 
			if(canPlace(solution, row, col)){
				solution[row][col] = 1;	//Set to 1 if can
				//Solve for the next col
				//Return true if the rest of problem return true
				if(placeQueens(col+1))
					return true;	//Return true if next col is solved
				//Above placement didnt work out
				//Backtrack undo the current move and return false
				solution[row][col] = 0;	//reset to 0
			}
		}
		//No solution exists return false
		return false;
			
	}
	
	//Check if the current row and col can be placed 
	public boolean canPlace(int[][] matrix, int row, int col){
		//Check if a queen can be placed in the current row
		//Col wise, each col once, we need to check the cell on the left of current row
		for(int i=0;i<col;i++)
			if(matrix[row][i]==1) return false;
		//column wise, we need to check the upper left of diagonal
		for(int i=row,j=col;i>=0&&j>=0;i--,j--)
			if(matrix[i][j]==1) return false;
		//Check the lower left diagonal
		for(int i=row,j=col;i<n&&j>=0;i++,j--)
			if(matrix[i][j]==1) return false;
		//Column wise no need to check for the upper column
		return true;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueen q = new NQueen(4);
		q.solve();
		int board[][] = {{1,1,1},{1,-1,1},{1,-1,1}};
		NoOfPath no = new NoOfPath();
		System.out.println("No of path:" + no.countDP(board));
	}

}
