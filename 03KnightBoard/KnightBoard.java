public class KnightBoard{
    private int[][] board;
    public int rc;    
    public KnightBoard(int size){
	board = new int[size][size];
	rc = 0;
    }

    public KnightBoard(int rows, int cols){
	board = new int[rows][cols];
        rc = 0;
    }
    
    public static void main(String[]args) {
	KnightBoard k;
	if(args.length > 1){
	    k = new KnightBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	}else{
	    k = new KnightBoard(Integer.parseInt(args[0]));
	}
	System.out.println(k.solve());
	System.out.println(k.rc + " recursive calls");
	k.printSolution();
    }

    public boolean solve(){
	return solveH(1,0,0);
    }

    public boolean solveH(int moveNum, int x, int y){
	rc++;
	if(x < 0 || x >= board.length || y < 0 || y >= board[0].length){
	    return false;
	}
	for(int i = 0; i < board.length; i++){
            for(int j = 0;j < board[0].length; j++){
                if(board[i][j] >= moveNum){
                    board[i][j]=0;
                }
            }
        }

	if(moveNum == board.length * board[0].length+1){
	    return true;
	} else if(board[x][y] > 0){
	    return false;
	} else{
	    board[x][y] = moveNum;
	    return (solveH(moveNum+1, x+2, y+1)||
		    solveH(moveNum+1, x+2, y-1)||
		    solveH(moveNum+1, x+1, y+2)||
		    solveH(moveNum+1, x+1, y-2)||
		    solveH(moveNum+1, x-1, y+2)||
		    solveH(moveNum+1, x-1, y-2)||
		    solveH(moveNum+1, x-2, y+1)||
		    solveH(moveNum+1, x-2, y-1));
	}
    }
    
    public void printSolution(){
	String ret  = "";
	for (int x = 0; x < board.length; x ++){
	    for (int y = 0; y < board[0].length; y ++){
		if (board[x][y] >= 1000){
		    ret = ret + " " + board[x][y] + " ";
		}else if (board[x][y] >= 100){
		    ret = ret + " " + board[x][y] + "  ";
		}else if (board[x][y] >= 10){
		    ret = ret + " " + board[x][y] + "   ";
		}else{
		    ret = ret + " " +  board[x][y] + "    ";
		}
	    }
	    ret += "\n";
	}
	System.out.println(ret);
    }

    public String printRow(int x){
	String ret = "";
	for(int i = 0; i < board[0].length; i++){
	    if(board[x][i]<10){
		ret += board[x][i] +"  ";
	    }else{
		ret += board[x][i] +" ";
	    }
	}
	return ret;
    }
}
