import java.util.*;
import java.io.*;
public class MyDeque<T>{
    
    private T[] d;
    public int start;
    public int fin;
    private int size;
    
    @SuppressWarnings("unchecked") public MyDeque() {
	d = (T[]) new Object[10];
    }

    @SuppressWarnings("unchecked") private void grow() {
	T[] newD = (T[]) new Object[d.length * 2];
	
	for(int i = start; i < d.length; i++) {
	    newD[i] = d[i];
	}
	for(int j = 0; j < start; j++){
	    newD[d.length + j] = d[j];
	}
	fin = start + size-1;
	d = newD;
    }

    public void addFirst(T val) {
	if(fin + 1 == start || (start == 0 && fin == d.length-1)) {
	    grow();
	    addFirst(val);
        } else {
	    if(size == 0) {
		d[start] = val;
	    } else if(start == 0) {
		d[d.length-1] = val;
		start = d.length-1;
	    } else {
		d[start-1] = val;
		start--;
	    }
	    size++;
	}
    }

    public void addLast(T val) {
	if(fin + 1 == start || (start == 0 && fin == d.length-1)) {
	    grow();
	    addLast(val);
        } else {
	    if(size == 0) {
		d[fin] = val;
	    } else if(fin == d.length-1) {
		d[0] = val;
		fin = 0;
	    } else {
		d[fin+1] = val;
		fin++;
	    }
	    size++;
	}
    }

    public T removeFirst(){
	if(start == fin && d[start] == null){
	    throw(new NoSuchElementException());
	} else {
	    T ans = d[start];
	    d[start]=null;
	    if(start == d.length-1) {
		start = 0;
	    } else { 
		start++;
	    }
	    size--;
	    return ans;
	}
    }

    public T removeLast(){
	if(start == fin && d[start] == null) {
	    throw(new NoSuchElementException());
	} else {
	    T ans = d[fin];
	    d[fin] = null;
	    if(fin == 0) {
		fin = d.length-1;
	    } else {
		fin--;
	    }
	    size--;
	    return ans;
	}
    }

    public T getFirst(){
	if(start == fin && d[start] == null) {
            throw(new NoSuchElementException());
	} else {
	    return d[start];
	}
    }

    public T getLast(){
	if(start == fin && d[start] == null) {
            throw(new NoSuchElementException());
	} else {
	    return d[fin];
	}
    } 

    public String toString(){
	String ans = "[";
	for(int i = 0; i < d.length; i++) {
	    ans += d[i] + ", ";
	}
	return ans.substring(0, ans.length()-2) +"]";
    }

    public int size() {
	return size;
    }

    public static void main(String[]args){
        MyDeque<Integer> deque = new MyDeque<Integer>();
        ArrayDeque<Integer> aryDeque = new ArrayDeque<Integer>();
 
	int lim = 0;
 
        if (args.length > 0) {
            lim = Integer.parseInt(args[0]);
        }
 
        for (int i = 0; i < lim; i++) {
            Integer r1 = (int)(Math.random() * 10);
	      
	    if (Math.random()*2 < 1) {
		deque.addFirst(r1);
		aryDeque.addFirst(r1);
	    } else {
		deque.addLast(r1);
		aryDeque.addLast(r1);
	    }
        }
   
        for (int i = 0; i < lim/2; i++) {
	       
            if (!deque.getFirst().equals(aryDeque.getFirst())) {
                System.out.println(deque.getFirst() + " " + aryDeque.getFirst());
		System.out.println("Test #0 (addFirst) failed at: " + i + "!");
                System.exit(0);
            }
 
            if (!deque.getLast().equals(aryDeque.getLast())) {
                System.out.println("Test #1 (addLast) failed at: " + i + "!");
                System.exit(0);
            }
       
            if (!deque.removeFirst().equals(aryDeque.removeFirst())) {
                System.out.println("Test #2 (removeFirst) failed at: " + i + "!");
                System.exit(0);
            }
 
            if (!deque.removeLast().equals(aryDeque.removeLast())) {
                System.out.println("Test #3 (removeLast) failed at: " + i + "!");
                System.exit(0);
            }
        }
 
        if (deque.size() != aryDeque.size()) {
            System.out.println("Not equal sizes. Error!");
            System.exit(0);
        }
 
        System.out.println("Success!");
    }
}