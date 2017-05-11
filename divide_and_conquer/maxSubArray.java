import java.lang.Math;

class maxSubArray {

    //i inclusive, f inclusive
    public static int [] findMaxSubArray(int [] arr, int i, int f){
	//base case
	if (f-i <= 1){
	    //solve
	    System.out.println("Debug: f is: "+Integer.toString(f)+", i is: "+Integer.toString(i));

	    if (arr[i] < arr[f]){
		//greatest subseq
		int [] a = {i,f};
		return a;
	    } else {
		//f alone
		int [] a = {f,f};
		return a;
	    }
	}
	else {
	    //get greatest subseq of each half
	    int [] arr1 = findMaxSubArray(arr, i, ((i+f)/2)-1);
	    int [] arr2 = findMaxSubArray(arr, (i+f)/2, f);

	    //now calculate their values
	    int s1 = arr1[1]-arr1[0];
	    int s2 = arr2[1]-arr2[0];

	    //combined subseq value
	    int s3 = arr2[1]-arr1[0];

	    //max
	    int m = Math.max(s1,s2);
	    m = Math.max(m,s3);

	    if (m == s1) {
		int [] a = {i,((i+f)/2)-1};
		return a;
	    }
	    else if (m == s2) {
		int [] a = {(i+f)/2,f};
		return a;
	    }
	    else {
		int [] a = {i,f};
		return a;
	    }
	}
    }
	
    public static void main(String[] args){
	//test
	int [] a = {10,5,15,35,30,60,10,15};
	int [] sa = findMaxSubArray(a, 0, a.length-1);
	System.out.printf("\nBeginning ind:	   %d, Value: %d",sa[0],a[sa[0]]);
	System.out.printf("\nEnding ind:	   %d, Value: %d",sa[1],a[sa[1]]);
	System.out.printf("\nSubarray differntial: %d\n",a[sa[1]]-a[sa[0]]);	
    }
}
