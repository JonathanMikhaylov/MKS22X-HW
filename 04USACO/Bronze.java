import java.util.*;
import java.io.*; 

public class Bronze{
   
    
    public static void main(String[] args){
	//if (args.length == 1) {
	try{    
	
	    int R, C, E, N;
	    int[][] g;
	    
	    File f = new File("makelake.in");
	    Scanner in = new Scanner(f);
	    //String s = in.nextLine();
	    //	    System.out.println( setParams(s) );
	    
	    R = in.nextInt();
	    C = in.nextInt();
	    E = in.nextInt();
	    N = in.nextInt();
     	    //System.out.println( R +","+ C +","+ E +","+ N +"_\n");
	    
	    String s2 = in.nextLine();
	    System.out.println(s2);
	    g = new int[R][C];
	    
	    int n = 0;
	    	    
	    for (int i = 0; i<R; i++) {
		for (int j = 0; j<C; j++) {
		    int x = in.nextInt();
		    //System.out.println(x);
		    g[i][j] = x;
		    
		}
	    }	    

	    printA(g);

	    for (int i =0; i<N; i++) {
		int stompR = in.nextInt();
		int stompC = in.nextInt();
		int stompX = in.nextInt();

		g[stompR][stompC];
	    }
	  


	    System.out.println( addAll() + ",6,Mikhaylov,Jonathan" ); 
	    
	} catch (FileNotFoundException e) { 
	    System.out.println("File is not found!");
	}
    } 

    public void stomp() {
	
    }

    public static void printA(int[][] k) {
	for (int i =0; i < k.length; i++) {
	    for (int j = 0; j<k[0].length; j++) {
		System.out.print( k[i][j] + "\t");
	    }
	    System.out.println("\n");
	}
    }
    
    public int addAll(int[][] t) {
	int sum = 0;

	for (int i =0; i<t.length; i++) {
	    for (int j =0; j <t[0].length; j++) {
		sum += t[i][j]; 
	    }}
	return calcVolume(sum);
    }

    public int calcVolume(int x) {
	return x * 72 * 72;
    }
}
