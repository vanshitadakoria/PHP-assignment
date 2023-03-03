import java.util.*; 
public class palindromeSolution {
static int lo, maxLen;

static String longestPalindrome(String s) {
	int len = s.length();
	if (len < 2)
		return s;
	
    for (int i = 0; i < len-1; i++) {
     	extendPalindrome(s, i, i);  //assume odd length
     	extendPalindrome(s, i, i+1); //assume even length.
    }
    return s.substring(lo, lo + maxLen);
}

static void extendPalindrome(String s, int j, int k) {
	while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
		j--;
		k++;
	}
	if (maxLen < k - j - 1) {
		lo = j + 1;
		maxLen = k - j - 1;
	}
}
public static void main(String[] args){
	Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
	System.out.print("Enter a string: ");  
	String s= sc.nextLine(); 
	//String s = "babad";
	System.out.print("Longest palindromic subsequence is : ");
	System.out.println(longestPalindrome(s));
 }


}