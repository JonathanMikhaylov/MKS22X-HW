import java.util.*;

@SuppressWarnings("unchecked") public class MyHeap<T extends Comparable<T>> {

    private int size;
    private T[] d;
    boolean isMax;

    public MyHeap() {
	size = 0;
	T[] d = (T[])(new Comparable[3]);
    }

    public MyHeap(T[] ary){
	d = (T[])(new Comparable[ary.length+1]);
	size = ary.length;
	for(int i = 1; i < d.length; i++) {
	    d[i] = ary[i-1];
	}
	heapify();
    }

    private boolean checkIndex(int index) {
	return (index < d.length && index > 1);
    }

    private void pushDown(int n) {
	if(isMax) {
	    while(checkIndex(2*n+1)) {
		if(d[2*n].compareTo(d[n]) > 0 || d[2*n+1].compareTo(d[n]) > 0) {
		    if (d[2*n].compareTo( d[2*n+1]) > 0) {
			T temp = d[2*n];
			d[2*n] = d[n];
			d[2*n] = temp;
			n *= 2;
		    } else {
			T temp = d[2*n+1];
			d[2*n+1] = d[n];
			d[2*n+1] = temp;
			n = n*2 + 1;
		    }
		}
	    }
	} else {
	    while(checkIndex(2*n+1)) {
		if(d[2*n].compareTo(d[n]) > 0 || d[2*n+1].compareTo(d[n]) < 0) {
		    if(d[2*n].compareTo(d[2*n+1]) < 0) {
			T temp = d[2*n];
                        d[2*n] = d[n];
			d[2*n] = temp;
			n *= 2;
		    } else {
                        T temp = d[2*n+1];
                        d[2*n+1] = d[n];
                        d[2*n+1] = temp;
                        n = n*2 + 1;
		    }
		}
	    }
	}
    }

    private void pushUp(int n) {
	if(isMax) {
	    while(checkIndex(n/2)) {
		if(d[n].compareTo(d[n/2]) > 0) {
		    T temp = d[n];
		    d[n] = d[n/2];
		    d[n/2] = temp;
		    n /= 2;
		}
	    }
	} else { 
	    while(checkIndex(n/2)) {
		if(d[n].compareTo(d[n/2]) < 0) {
		    T temp = d[n];
		    d[n] = d[n/2];
		    d[n/2] =temp;
		    n /= 2;
		}
	    }
	}
    }
    
    private void heapify() {
	for(int i = size/2; i > 0; i--) {
	    pushDown(i);
	}
    }

    public void doubleSize() {
	T[] newArray = (T[])(new Comparable[size*2]);
	for(int i = 0; i < d.length; i++) {
	    newArray[i] = d[i];
	}
	d = newArray;
    }

    public T delete() {
	T temp = d[1];
	d[1] = d[size];
	d[size] = null;
	size--;
	pushDown(1);
	return temp;
    }

    public void add(T x) {
	if(size+1 >= d.length){
	    doubleSize();
	    add(x);
	} else {
	    d[size+1] = x;
	    pushUp(size+1);
	    size++;
	}
    }

    public String toString(){
	String ans = "[";
	for(int index = 1; index < d.length; index++) {
	    ans += d[index] + ", ";
	}
	return ans.substring(0, d.length-2) + "]";
    }
    
    public MyHeap(boolean isMax) {
	d = (T[])(new Comparable[3]);
	this.isMax = isMax;
	size = 0;
    }

    public MyHeap(T[] ary, boolean isMax){
	d = (T[])(new Comparable[ary.length+1]);
	this.isMax = isMax;
	size = ary.length;
	for(int n = 1; n < d.length; n++) {
	    d[n] = ary[size-1];
	}
	heapify();
    }
}