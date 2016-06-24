import java.util.*;
import java.io.*;

public class FrontierQueue<T> extends MyQueue<T> implements Frontier<T>{

    public void add(T element) {
	enqueue(element);
    }

    public T next() {
	if(isEmpty()) {
	    throw(new NoSuchElementException());
	} else {
	    return dequeue();
	}
    }

    public boolean hasNext() {
	return isEmpty();
    }

    public static void main(String[]args){
	FrontierQueue<Integer> f = new FrontierQueue<Integer>();
	f.add(10);
	f.add(371);
	System.out.println(f.next() + " " + f.next());
    }
}