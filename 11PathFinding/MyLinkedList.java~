import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{

    private class LNode{
	private T val;
	private LNode next;

	public LNode(T v){
	    val = v;
	}

	public T getValue(){
	    return val;
	}

	public LNode getNext(){
	    return next;
	}

	public T setValue(T v){
	    T old = val;
	    val = v;
	    return old;
	}

	public void setNext(LNode n){
	    next = n;
	}

	public String toString(){
	    return val.toString();
	}
    }

    LNode head;
    LNode tail;
    int size;
    
    public Iterator<T> iterator() {
       	return new Iterator<T>() {
		private LNode curr = head;

		public boolean hasNext() {
		    return curr != null;
		}

		public T next() {
		    if(!hasNext()) {
			throw new NoSuchElementException();
		    }
		    T value = curr.getValue();
		    curr = curr.getNext();
		    return value;
		}
		public void remove(){
		    throw new UnsupportedOperationException();
		}
	};
    } 

    public String toString() {
	String ans = "[";
	LNode p = head;

	while(p != null) {
	    ans += p.getValue();
	    if(p.getNext() != null) {
		ans += ", ";
	    }
	    p = p.getNext();
	}
	return ans+"]";
    }

    public String toString(boolean b) {
	return toString()+" head: "+head +", tail: "+tail;
    }

    private LNode getNth(int index) {
	LNode temp = head;
	while(index > 0){
	    temp = temp.getNext();
	    index--;
	}
	return temp;
    }

    public boolean add(T val){
	if(head == null) {
	    head = new LNode(val);
	    tail = head;
	} else {
	    tail.setNext(new LNode(val));
	    tail = tail.getNext();
	}
	size++;
	return true;
    }

    public T remove(int index){
	if(index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size());
	}
	LNode temp;
	if(index == 0) {
	    temp = head;
	    head = head.getNext();
	    size--;
	    if(head == null) {
		tail = null;
	    }
	    return temp.getValue();
	} else {
	    LNode p = getNth(index-1);
	    temp = p.getNext();
	    if(tail == temp){
		tail = p;
	    }
	    p.setNext(p.getNext().getNext());
	    size --;
	    return temp.getValue();
	}
    }

    public boolean add(int index, T val) {
	if(index < 0 || index > size()) {
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	LNode temp = new LNode(val); 
	if(index == 0) {
	    temp.setNext(head);
	    head = temp;
	    if(size==0) {
		tail = head;
	    }
	} else { 
	    LNode p = getNth(index-1);
	    temp.setNext(p.getNext());
	    p.setNext(temp);
	    if(tail.getNext() != null) {
		tail = tail.getNext();
	    }
	}
	size++;
	return true;
    }
    
    public int size(){
	return size;
    }
    
    public T get(int index){
	if(index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).getValue();
    }

    public T set(int index, T newVal) {
	if(index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).setValue(newVal);
    }

    public int indexOf(T target) {
	LNode temp = head;
	int index = 0;
	while(temp != null) {
	    if(temp.getValue().equals(target)) {
		return index;
	    }
	    index++;
	    temp = temp.getNext();
	}
	return -1;
    }
}