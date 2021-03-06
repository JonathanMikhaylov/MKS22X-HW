public class QueenBoard{
    private int[][]board;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *postcondition: 
     *-return false, and board is still filled
     *with 0's for a board that cannot be solved.
     *-return true, and board is filled with the 
     *final configuration of the board after adding 
     *all n queens.
     */
    public boolean solve() {
	if(board.length <= 1) return false;
	else if(board.length > 1) {
	    for (int i = 0; i<board.length; i++) {
		solveH(i);
		return true;
	    }
	}
	   
	//this.addQueen(0, 0);
	//	solveH(0);
	return false;
    }

    public boolean solveH(int col) {
	if (col >= board.length) {
	    return true;
	}
	else{
	    for (int i = 0; i<=board.length; i++) {
		if (board[i][col] == 0) {
		    addQueen(i,col);
		    if ( solveH(col+1) ) return true;
		    else removeQueen(i, col);
		}
	    }
	}
	return false;
    }

    public void printSolution(){
	/**Print the board like toString, except
	   all negative numbers, and 0's are replaced with '_'
	   and all 1's are replaced with 'Q'
	 */
	this.solve();
	String ret = "";
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[0].length; j++) {
		if (board[i][j] == 0) ret+= "-\t";		
		if (board[i][j] < 0) ret+= "+\t";		
		else if (board[i][j] == 1) ret+= "Q\t";
	    }
	    if (i != board.length - 1) ret += "\n";
	}
	System.out.println(ret);
    }

    public boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    //	    col++;
	    offset++;
	}
	return true;
    }

    public boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    //	    col++;
	    offset++;
	}
	return true;
    }

    public String toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ans+= board[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }


    public static void main(String[]args){
	QueenBoard b = new QueenBoard(5);
        //System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
        //System.out.println(b);
	b.removeQueen(3,0);
	b.removeQueen(0,1);
	//        System.out.println(b);

	//	b.addQueen(0,0);
	b.printSolution();
    }
    
}
