import java.util.*;
import java.io.*; 

public class Bronze{
   
    public static int R, C, E, N, x;
    public static int[][] g;
    Scanner in;

    public static void main(String[] args){
	//if (args.length == 1) {
	try{    
	    File f = new File("makelake.in");
	    Scanner in = new Scanner(f);
	    String s = in.nextLine();
	    System.out.println( setParams(s) );

	    String s2 = in.nextLine();
	    System.out.println(	    makeG(s2));

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

	
	System.out.println(",6,Mikhaylov,Jonathan"); 

	} catch (FileNotFoundException e) { 
	    System.out.println("File is not found!");
	}
    } 

    public static String setParams(String s) {
	Scanner in = new Scanner(s);
	R = in.nextInt();
	C = in.nextInt();
	E = in.nextInt();
	N = in.nextInt();


	       	return R +","+ C +","+ E +","+ N +"_\n";
	//	return ""+g;
}


    public static String makeG(String s) {
       	g = new int[R][C];

	int n = 0;
	Scanner in = new Scanner(s);	

	for (int i = 0; i<1; i++) {
	    for (int j = 0; j<C; j++) {
		g[i][j] = in.nextInt();
	    }
	}
	return(""+ g);

    }


    public int addAll(int[][] t) {
	int sum = 0;

	for (int i =0; i<R; i++) {
	    for (int j =0; j <C; j++) {
		sum += t[i][j]; 
	    }
	}
	return calcVolume(sum);
    }

    public int calcVolume(int x) {
	return x * 72 * 72;
    }

}
