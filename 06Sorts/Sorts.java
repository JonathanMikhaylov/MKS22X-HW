public class Sorts{
    public static String name(){
	return "6,Mikhaylov,Jonathan";
    }

    public static void printArray(int[] ary){
	String retStr = "{";
	for(int i = 0;i < ary.length-1; i++){
	    retStr += ary[i] + ",";	       
	}
	System.out.println(retStr + ary[ary.length-1]+"}");
    }

    public static void insertionSort(int[] d){
	int temp;
	for(int i = 0;i < d.length; i++){
	    temp = d[i];
	    int replace;
	    for(replace = i; replace > 0 && temp < d[replace-1]; replace--){
		d[replace] = d[replace-1];
	    }
	    d[replace] = temp;
	}
    }

    public static int[] selectionSort(int[] d){
	int placeholder;
	int index;
	for(int i = 0;i < d.length; i++){
	    placeholder = d[i];
	    index = i;
	    for(int j = i;j < d.length; j++){
		if (placeholder > d[j]){
		    placeholder = d[j];
		    index = j;
		}
	    }
	    d[index] = d[i];
	    d[i] = placeholder;
	}
	return d;
    }
    
    public static int[] bubbleSort(int[] d){
	int hold;
	int n = 0;
	do{
	    for(int i = 0; i < d.length-n-1 ; i++){		
		if(d[i] > d[i+1]){
		    hold = d[i];
		    d[i] = d[i+1];
		    d[i+1] = hold;   
		}
	    }
	    n++;
	} while(n < d.length-1);
	return d;
    }

    public static int[] mergesort(int[] d){
	if(d.length == 1){
	    return d;
	}
	    int a = d.length/2;
	    int[] d1 = new int[a];
	    for(int i = 0;i < a; i++){
		d1[i]=d[i];
	    }
	    int[] d2;
	    if(d.length % 2 == 1){
		d2 = new int[a+1];
	    }else{
		d2 = new int[a];
	    }
	    for(int j = a; j < d.length; j++){
		d2[j-a] = d[j];
	    }
	    return merge(mergeSort(d1), mergeSort(d2));
    }

    public static int[] merge(int[] d1, int[] d2){
	int n1 = 0;
	int n2 = 0;
	int[] d = new int[d1.length + d2.length];
	while(n1 + n2 < d.length){
	    if(d1.length <= n1){
		d[n1+n2] = d2[n2];
		n2++;
	    }else if(d2.length <= n2){
		d[n1+n2] = d1[n1];
		n1++;
	    }else{
		if(d1[n1] > d2[n2]){
		    d[n1 + n2] = d2[n2];
		    n2++;
		}else{
		    d[n1 + n2] = d1[n1];
		    n1++;
		}
	    }
	}
	return d;
    }

    public static void main(String[]args){
	int[] a = {8,4,0,0,0,6,6,7,234,-1,3,4,8,123,1,2,444};
	int[] b = {8,-2,-1};
       	Sorts.printArray(b);
	int[] c = {3,5,6};
	int[] d = {1,2,7,8};
	Sorts.printArray(selectionSort(b));	
    }
}