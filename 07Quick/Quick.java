import java.util.*;
import java.io.*;

public class Quick{

  
    public static int quickselect(int[] d, int n){
	return quickselect(d, n, 0, d.length-1);
    }

    public static int quickselect(int[] d, int n, int l, int r){
	if(l == r){
	    return d[n];
	}
	int place = partitionOld(d, l, r);
	if(place == n){
	    return d[n];
	}
	if(n < place){
	    return quickselect(d, n, l, place-1);
	}else{
	    return quickselect(d, n, place+1, r);
	}
    }

    public static void quicksortOld(int[] d){
	quicksortOld(d, 0, d.length-1);
    }

    public static void quicksortOld(int[] d,int l,int r){
	if(l != r && l < r){
	    int place = partitionOld(d, l, r);
	    if (place < d.length-1){
		quicksortOld(d, l, place-1);
		quicksortOld(d, place+1, r);
	    }
	}
    }
    
  public static int partitionOld(int[] d, int l, int r){
	int ind = l + (int)(Math.random() * (r-l));
	swap(d, ind, r);
	int beg = l;
	int fin = r - 1;
	while(beg < fin) {
	    if (d[beg] >= d[r]) {
		swap(d, beg, fin);
		fin--;
	    } else {
		beg++;
	    }
	}
	if(d[r] < d[beg]) {
	    swap(d, beg, r);
	    return beg;
	} else {
	    swap(d, beg + 1, r);
	    return beg + 1;
	}
    }
  
  public static int[] partition(int[] d, int l, int r) {
	int ind = l + (int)(Math.random() * (r - l));
	int[] newA = new int[d.length];
	for(int i = 0; i < l; i++) {
	    newA[i] = d[i];
	}
	for(int j = d.length-1; j > r; j--) {
	    newA[j] = d[j];
	}
        int beg = l;
        int fin = r;
	for(int x = l; x <= r; x++) {
	    if(d[x] > d[ind]) {
		newA[fin] = d[x];
		fin--;
	    } else if(d[x] < d[ind]) {
		newA[beg] = d[x];
		beg++;
	    }
	}
	if(beg == fin){
	    newA[beg] = d[ind];
	} else {
	    for(int y = beg; y <= fin; y++) {
		newA[y] = d[ind];
	    }
	}
	for(int m = 0; m < d.length; m++){
	    d[m] = newA[m];
	}
	int[] retA = new int[2];
	
	retA[0] = beg;
	retA[1] = fin;
	return retA;
    }
    
    public static void quicksort(int[] d){
	quicksort(d, 0, d.length-1);
    }

    public static void quicksort(int[]d, int l, int r){
	if(l != r && l < r){
            int[] places = partition(d, l, r);
            if (places[0] < d.length-1 && places[1] < d.length-1){
                quicksort(d, l, places[0]-1);
                quicksort(d, places[1]+1, r);
            }
        }
    }
    
    public static void swap(int[] d, int n1, int n2){
	int hold = d[n1];
	d[n1] = d[n2];
	d[n2] = hold;
    }

    public static String name(){
	return "6,Mikhaylov,Jonathan";
    }

    public static void main(String[] args){
	int[] x1 = new int[4000000];
	int[] x2 = new int[4000000];
	for(int i = 0; i < x1.length; i++){
	    x1[i] = (int)Math.random()*4;
	}
	for(int j = 0; j< x2.length; j++){
	    x2[j] = Integer.MIN_VALUE + 2 * (int)Math.random() * Integer.MAX_VALUE; 
	}
    }
   
}
