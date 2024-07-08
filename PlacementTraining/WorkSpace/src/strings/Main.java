package strings;

import java.util.Arrays;

public class Main {
	
	//Leetcode:1108
    public static String defangIPaddr(String address) {
        
    	//Here we create an empty stringBuilder(Str obj)
    	//later we check each character at address if it matchec '.' we replace it with "[.]" else we append the same character
    	StringBuilder str = new StringBuilder();
        
        for(int i = 0 ; i < address.length() ;i++) {
        	char c = address.charAt(i);
        	
        	if(c ==  '.') {
        		str.append("[.]");
        	}else {
        		str.append(c);
        	}
        }
//        System.out.print("String " + str.toString());
        return str.toString();
    }

    //Leetcode: 1528 
    public static String restoreString(String s, int[] indices) {
        
    	char[] cArr = s.toCharArray();
    	System.out.println(Arrays.toString(cArr));
    	
    	//now apply cyclic sort for int array
    	int i = 0 ; 
    	
    	while(i < indices.length) {
    		
    		int crt = indices[i];
    		if(indices[i] != indices[crt]) {
    			swap(indices, i , crt);
    			swapChar(cArr, i, crt);
    		}else {
    			i++;
    		}
    	}
    	System.out.println(Arrays.toString(indices));
//    	System.out.println(Arrays.toString(indices));
    	
    	//now create a string builder and add the char array as string
    	StringBuilder str = new StringBuilder();
    	for(i = 0 ; i < cArr.length ; i++) {
    		str.append(cArr[i]);
    	}
    	
    	
    	return str.toString();
    } 
    
    public static void swapChar(char[] arr, int i, int j) {
		// TODO Auto-generated method stub
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void swap(int[] arr, int i, int j) {
    	
    	int temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }
    
	//leetcode 1869
    public static String sortSentence(String s) {
        
    	String[] arr = s.split(" ");
    	
    	System.out.println(Arrays.toString(arr));
    	
    	//apply cyclic sort to last index of each word
    	
    	for(int i = 0 ; i < arr.length ; i++) {
    		int index = arr[i].charAt(arr[i].length() - 1) - '0' - 1;
            while (index != i) {
                String temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                index = arr[i].charAt(arr[i].length() - 1) - '0' - 1;
            }
    	}
    	System.out.println(Arrays.toString(arr));

    	StringBuilder str = new StringBuilder();
    	for(int i = 0 ; i < arr.length ; i++) {
    		
    		str.append(arr[i].substring(0, arr[i].length() - 1));
    		str.append(" ");
    	}
    	
    	
    	return str.toString().trim();
    }
    
    //leetcode 1662
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for(String s: word1){
            str1.append(s);
        }

        for(String s: word2){
            str2.append(s);
        }    
        System.out.println(str1 + " " + str2);
        
        
        return str1.toString().equals(str2.toString());    
    }
    
    //Leetcode
    public String toLowerCase(String s) {
        
        int n = s.length(); 
        StringBuilder str = new StringBuilder();
        
        for(int i = 0 ; i  < n ; i++) {
        	char c = s.charAt(i);
        	
        	if(c >= 'A' && c <= 'Z') {
        		c += 32;
        	}
        	
        	str.append(c);
        }
        
        return str.toString();
    }
    
    //leetcode 1704
    public boolean halvesAreAlike(String s) {
        
    	int n = s.length();
    	
    	int mid = n/2;
    	int a = 0;
    	for(int i = 0 ; i < mid ; i++) {
    		if(isVowel(s.charAt(i)))
    			a++;
    	}

    	int b = 0;
    	for(int i = mid ; i < n ; i++) {
    		if(isVowel(s.charAt(i)))
    			b++;
    	}

    	return a == b;
    }
    
    public boolean isVowel(char c) {
    	
    	if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
    		return true;
    	
    	if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
    		return true;    	
    	return false;
    }
    
    //leetcode 1309
    public String freqAlphabets(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder();
        int i = n - 1;
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                int num = (s.charAt(i - 1) - '0') + (s.charAt(i - 2) - '0') * 10;
                char ch = (char)(num + 'A' - 1);
                str.append(ch);
                i -= 3;
            } else {
                int num = (s.charAt(i)) - '0';
                char ch = (char) (num + 'A' - 1) ;
                str.append(ch);
                i--;
            }
        }
        return str.reverse().toString();
    }
    
    //Leetcode 1967
    public int numOfStrings(String[] patterns, String word) {
        
        int count = 0;
        for(String s: patterns){
            int n = s.length();
            
            int i = 0;
//            System.out.println(n+s);
            while(i < word.length() - n + 1) {
//            	System.out.println(i);
                String w = word.substring(i,i+n);
                
                if(w.equals(s)) {
//                	System.out.println(s+" "+w);
                	count++;
                	break;
                	}
                
                i++;
            }

        }

        return count;
    }
    
    //Leetcode 125. Valid Palindrome
    public boolean isPalindrome(String s) {
        
    	StringBuilder str = new StringBuilder();
    	int n = s.length();
    	s = s.toLowerCase();
		System.out.println("org: " +s);

    	for(int i = 0 ; i < n ; i++) {
    		
    		char c = s.charAt(i);
    		
    		if(Character.isDigit(c) || Character.isAlphabetic(c)) {
    			str.append(c);
    		}
    		
    	}
    	
    	String rev = reverse(str.toString());
    	
		System.out.println("org: " +str.toString());
    	return str.toString().equals(rev);
    }
    
	public String reverse(String s) {
		
		StringBuilder rev = new StringBuilder();
		int i = s.length() - 1;
		
		while(i >= 0) {
			rev.append(s.charAt(i));
			i--;
		}
		System.out.println("reverse: " +rev);
		return rev.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
//		String s1 = "255.100.50.0";
//		System.out.println(defangIPaddr(s));
		
//		String s = "codeleet";
//		int[] indices = {4,5,6,7,0,2,1,3};
//		System.out.println(restoreString(s, indices));
		
//		String s = "is2 sentence4 This1 a3";
//		System.out.println(sortSentence(s));
//		//arrayStringsAreEqual
//		String[] s1 = {"ab", "c"} , s2 = {"a", "bc"};
//		System.out.println(arrayStringsAreEqual(s1,s2));
//		String s = "textbook";
//		System.out.println(main.halvesAreAlike(s));
//		String s = "10#11#12"; 
//		System.out.println(main.freqAlphabets(s));
//		
//		String w = "aaaaabbbbb";String[] arr = {"a","b","c"};
//		System.out.println(main.numOfStrings(arr,w));
		String s = "A man, a plan, a canal: Panama";
		System.out.print(main.isPalindrome(s));
	}

}
