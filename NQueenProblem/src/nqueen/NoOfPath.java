package nqueen;

public class NoOfPath {
	public int countDP(int [][] board){
		int result[][] = board;
		
		for(int i=1;i<result.length;i++){
			for(int j=1;j<result.length;j++){
				if(result[i][j]!=-1){
					result[i][j] = 0;
					if(result[i-1][j]>0)
						result[i][j] += result[i-1][j];
					if(result[i][j-1]>0)
						result[i][j] += result[i][j-1];		
				}
			}
		}
		return result[result.length-1][result.length-1];
	}

}
