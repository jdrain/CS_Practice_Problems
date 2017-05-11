import java.util.Scanner;

class lexMin{

    public static String rotateAtInd(int ind, String s){
	//rotate a string
	//get the substring
	String endSubstr = s.substring(ind);
	String initSubstr = s.substring(0,ind);
	String rotatedStr = endSubstr + initSubstr;
	return rotatedStr;
    }

    public static int getBestSubstring(String s){
	//get the index where the lexicographically minimal substring is
	
	int i = 1;
	int shortest = 0;
	int len = s.length();
	
	//iterate through the whole word
	while (i < len){
	    if ((int)s.charAt(i) < (int)s.charAt(shortest)){
		shortest = i;
	    }
	    //compare the succeeding characters after initial until a difference is found
	    else if ((int)s.charAt(i) == (int)s.charAt(shortest)){
		int j = 0;
		int k = i;
		int l = shortest;
		while (j < len-1 && (int)s.charAt(k) == (int)s.charAt(l)){
		    j++;
		    if (i + j >= len && shortest + j >= len){
			k = i + j - len;
			l = shortest + j - len;
		    }
		    else if (shortest  + j >= len){
			l = shortest + j - len;
			k++;
		    }
		    else if (i + j >= len){
			k = i + j - len;
			l++;
		    }
		    else{
			k++;
			l++;
		    }
		}
		if ((int)s.charAt(k) == s.charAt(l)){
		    //cycled through the whole word
		    return shortest;
		}
		else if ((int)s.charAt(k) < (int)s.charAt(l)){
		    //found a new shortest substring
		    shortest = i;
		}
	    }
	    i++;
	}
	return shortest;
    }

    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	String s = new String();
	String r = new String();
	int x = 0;
	do {
	    System.out.println("Please enter a String. q to quit");
	    s = scan.nextLine();
	    x = getBestSubstring(s);
	    r = rotateAtInd(x,s);
	    if (!s.equals("q")){
		System.out.printf("String: %s, Best substring start ind: %d, Lexicographically minimal rotation: %s\n",s,x,r);
	    }
	} while(!s.equals("q"));
    }
}

