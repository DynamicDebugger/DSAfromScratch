package basics;

public class Parctice {

	public static boolean isPalindrome(String s) {
		
//		StringBuilder builder = new StringBuilder(s);
//		StringBuilder rev = new StringBuilder(s).reverse();
//		System.out.println("S: "+ s
//				+"\nBuilder: "+builder
//				+"\nRev: "+rev);
//		if(builder.compareTo(rev) == 0) {
//		
//
//			System.out.println(builder);
//			return true;
//		}
		if(s == null || s.length() <= 0) return false;
		int i = 0 , j = s.length() - 1;
		
		while(i <= j) {
			
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isPalindrome("a"));
	}

}
