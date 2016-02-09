public class Recursion{

    public static void main(String[] args) {
	System.out.println(sqrt(100.0));
    }
    public String name() {
	return "Mikhaylov,Jonathan";
    }
    
    public static double sqrt(double n) throws IllegalArgumentException {
	if (n<0) throw new IllegalArgumentException();
	
    }
    
    public static double helper(double n, double guess) {
	if (guess*guess < n+1 && guess*guess > n-1) {
            return guess;
        } else {
            System.out.println("guess =" + helper(n,1 ));
        }
    }
	guess = ( (n/guess)+guess ) /2;
    }
}