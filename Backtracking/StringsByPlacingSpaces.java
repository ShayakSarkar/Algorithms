// Given a string print all possible strings by placing spaces 
// in the string

import java.util.*;
public class StringsByPlacingSpaces{
	
	// function to print all possible strings by placing spaces in between them.
	//
	// The logic is to get all possible strings excluding the first character
	// of the string, and then add the first character with and without a space
	// to all the strings obtained.
	
	public static HashSet<String> findStrings(String s){
		
		// when length of string is 1, the string itself is the possible string 
		// that can be obtained, since there are no places to insert spaces.
		// Therefore, a set containing the string itself is returned
		// This is the base case

		if(s.length()==1){
			HashSet<String> hs=new HashSet<String>();	
			hs.add(s);	
			return hs;	
		}
		
		// retSet --> Set of all possible strings obtained by excluding the first character 
		// 	      from the string
		// ans --> The set of strings to be returned
	
		HashSet<String> retSet=findStrings(s.substring(1));
		HashSet<String> ans=new HashSet<String>();

		// for every string in retSet, add the the first character in s
		// with and without a space
		for(String it : retSet){
			ans.add(s.charAt(0)+" "+it);	// add first character with space
			ans.add(s.charAt(0)+it);	// add first character without space
		}
		return ans;
			
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		String s=in.next();
		HashSet<String> set=findStrings(s);
		System.out.println(set);
	}
}

// This code has been contributed by Shayak Sarkar
