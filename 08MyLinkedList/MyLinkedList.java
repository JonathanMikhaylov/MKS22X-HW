import java.util.*;
import java.io.*;

public class MyLinkedList<T> {


    private class LNode{
	private T value;
	private LNode next;

	public LNode(T val){
	    value = val;
	}

	public void setValue(T Value){
	    value = Value;
	}

	public void setNext(LNode Next){
	    next = Next;
	}

	public T getValue(){
	    return value;
	}

	public LNode getNext(){
	    return next;
	}
    } 


    public LNode head;
    public LNode tail;
    public int size;

    public boolean add(T value) {
	if(head==null) {
	    head = new LNode(value);
	    tail = head;
	} else {
	    LNode next = new LNode(value);
	    tail.setNext(next);
	    tail = next;
	}
	size++;
	return true;
    }

    public T get(int index) {
	if(index < 0 || index >= size) {
	    throw(new IndexOutOfBoundsException());
	} else {
	    LNode p = head;
	    int x = index;
	    while(x > 0){
		p = p.getNext();
		x--;
	    }
	    return p.getValue();
	}
    }

    public T set(int index, T newValue) {
	if(index < 0 || index >= size) {
	    throw(new IndexOutOfBoundsException());
	} else {
	    LNode p = head;
	    int x = index;
	    while(x > 0) {
		p = p.getNext();
		x--;
	    }
	    T ans = p.getValue();
	    p.setValue(newValue);
	    return ans;
	}
    }

    public boolean add(int index, T value){
	if(index < 0 || index > size) {
	    throw(new IndexOutOfBoundsException());
	} else if(index == size) {
	    add(value);
	    return true;
	} else if(index == 0) {
	    LNode newH = new LNode(value);
	    newH.setNext(head);
	    head = newH;
	    size++;
	    return true;
	} else {
	    LNode p = head;
	    int x = index;
	    while (x > 1) {
		p = p.getNext();
		x--;
	    }
	    LNode restL = p.getNext();
	    LNode newInd = new LNode(value);
	    newInd.setNext(restL);
	    p.setNext(newInd);
	    size++;
	    return true;
	}
    }

    public T remove(int index){
	if(index < 0 || index >= size){
	    throw(new IndexOutOfBoundsException());
	} else if(index == 0) {
	    T ans = head.getValue();
	    head = head.getNext();
	    size--;
	    return ans;    
	} else {
	    LNode p = head;
	    int x = index;
	    while(x > 1) {
		p = p.getNext();
		x--;
	    }
	    T ans = p.getNext().getValue();
	    if(index == size - 1) {
		p.setNext(null);
		size--;
		tail = p;
	    } else {
		p.setNext(p.getNext().getNext());
		size--;
	    }
	    return ans;
	}
    }

    public String toString(){
	String ans = "[";
	LNode p = head;
	while(p != null){
	    ans += p.getValue();
	    if(p.getNext() != null){
		ans += ", ";
	    }
	    p = p.getNext();
	}
	return ans + "]";
    }

    public int size(){
	return size;
    }

    public static void main(String[] args){
	MyLinkedList<String> m = new MyLinkedList<String>();
	for(int i = 0; i < 10; i++){
	    m.add(i + "");
	}
	m.add(54);
	m.add(-10);
	m.add(47);
	System.out.println(m);
    }
}