import java.util.*;
import java.io.*; 

public class Bronze{
       
    public static void main(String[] args){
	try{    
	    int R, C, E, N;
	    int[][] g;
	    
	    File f = new File("makelake.in");
	    Scanner in = new Scanner(f);
	    	    	    
	    R = in.nextInt();
	    C = in.nextInt();
	    E = in.nextInt();
	    N = in.nextInt();
	    g = new int[R][C];
	    //System.out.println( R +","+ C +","+ E +","+ N +"_\n");                 //uncomment for debugging
	    
	    for (int i = 0; i<R; i++) {
		for (int j = 0; j<C; j++) {
		    int x = in.nextInt();
		    //System.out.println(x);                                         //uncomment for debugging
		    g[i][j] = x;    
		}
	    }	    

	    //printA(g);                                                             //uncomment for debugging

	    for (int i =0; i<N; i++) {
		int stompR = in.nextInt();
		int stompC = in.nextInt();
		int stompX = in.nextInt();

		stomp(g, stompR, stompC, stompX);
		//System.out.println("\n\n");                                        //uncomment for debugging
		//printA(g);                                                         //uncomment for debugging
	    }
	  
	    int[][] g2 = new int[R][C];
	    for (int i =0; i<R; i++) {
		for (int j=0; j<C; j++) {
		    if (g[i][j] < E) g2[i][j] = E - g[i][j];
		    else g2[i][j] = 0;
		}
	    }
	    
	    //System.out.println("\n\n");                                            //uncomment for debugging
	    //printA(g2);                                                            //uncomment for debugging
	    System.out.println( addAll(g2) + ",6,Mikhaylov,Jonathan" ); 
	    
	} catch (FileNotFoundException e) { 
	    System.out.println("File is not found! Please make sure there is a file named 'makelake.in' in the directory");
	}
    } 

    

    public static void stomp(int[][] g, int stompR, int stompC, int stompX) {
	int max = g[stompR][stompC];

	for (int i =stompR-1; i<stompR+2; i++) {
	    for (int j = stompC-1; j<stompC+2; j++) {
		if (g[i][j] > max) max = g[i][j];
	    }
	}

	int m = max - stompX;
	for (int i =stompR-1; i<stompR+2; i++) {
	    for (int j = stompC-1; j<stompC+2; j++) {
		if ( g[i][j] > m ) g[i][j] = m; 
	    }
	}

    }

    public static void printA(int[][] k) {
	for (int i =0; i < k.length; i++) {
	    for (int j = 0; j<k[0].length; j++) {
		System.out.print( k[i][j] + "\t");
	    }
	    System.out.println("\n");
	}
    }
    
    public static int addAll(int[][] t) {
	int sum = 0;

	for (int i =0; i<t.length; i++) {
	    for (int j =0; j <t[0].length; j++) {
		sum += t[i][j]; 
	    }}
	return sum*72*72;
    }
}
