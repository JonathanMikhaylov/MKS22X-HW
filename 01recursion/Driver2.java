public class Driver2 {

    public static void main(String[] args) {
	Recursion a = new Recursion();
	int i = 10000;
	if (args.length> 0) { 
	    i = Integer.parseInt(args[0]);
	}
	double ans= a.sqrt(i);
	System.out.println(ans);

    }

}