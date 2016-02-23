import java.util.*;
import java.io.*; 

public class Bronze() {
   
    public int R, C, E, N, x;
    public int[][] g;
    Scanner in;

    public static void main(String[] args){
	//if (args.length == 1) {
	try{    
	    File f = new File("makelake.in");
	    Scanner in = new Scanner(f);
	    String s = in.nextLine();
	    /*}	
	      else if (args.length > 1) {
	      R = args[0];
	      C = args[1];
	      E = args[2];
	      N = args[3];
	      g = new int[R][C];
	      
	      for (int i = 0; i <= R; i++) {
	      for(int j = 0; i <= C; i++) {
	      
	      }
	      } 
	      }*/
	}catch
	System.out.print( calcVolume() );
	System.out.println( +",6,Mikhaylov,Jonathan"); 
    } 

    public setParams(String s) {
	Scanner in = new Scanner(s);
	R = in.nextInt();
	C = ;
	E = ;
	N = ;
	g = new int[][];
    }

    public calcVolume(int x) {
	return x * 72 * 72;
    }

}
