public class BSTree<T extends comparable<T>> {

    private class Node {
	T d;
	Node l;
	Node r;

	public T getData() {
	    return d;
	}

	public Node getLeft() {
	    return l;
	}

	public Node getRight() {
	    return r;
	}

	public void setData(T val) {
	    d = val;
	}

	public void setLeft(Node newN) {
	    l = newN;
	}

	public void setRight(Node newN) {
	    r = newN;
	}

	public int height() {
	    int lH = 1;
	    int rH = 1;
	    if(l != null) {
		lH += l.height();
	    }
	    if(r != null) {
		rH += r.height();
	    }
	    if(rH > lH) {
		return rH;
	    } else {
		return lH;
	    }
	}

	public void add(T val) {
	    if(val < d){
		if(l == null) {
		    l = new Node(val);
		} else {
		    l.add(val);
		}
	    } else {
		if(r == null) {
		    r = new Node(val);
		} else {
		    r.add(val);
		}
	    }
	}

	public String toString() {
	    String ans = "";
	    ans += d;
	    if(l != null) {
		ans += l.toString();
	    }
	    if(r != null) {
		ans += r.toString();
	    }
	    return ans;
	}

	public boolean contains(T val) {
	    if(d.compareTo(val)) {
		return true;
	    } else {
	    }
	}
	private Node root;
    }
}