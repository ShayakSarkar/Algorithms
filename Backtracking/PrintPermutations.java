// Given a String, print all possible permutations

import java.util.*;

public class PrintPermutations{
	public static HashSet<String> generatedPerms=new HashSet<String>();
	public static int ctr=0;
	public static void printArray(char[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	public static void printPermutationsUtil(String s,char[] positions,int startIndex){
		if(startIndex==s.length()){
			String temp="";
			for(int i=0;i<positions.length;i++)
				temp+=positions[i];
			if(generatedPerms.contains(temp))
				return;
			System.out.print((++ctr)+" ");
			printArray(positions);
			generatedPerms.add(temp);
			return;
		}
		for(int i=0;i<positions.length;i++){
			if(positions[i]!='\0')
				continue;
			positions[i]=s.charAt(startIndex);
			printPermutationsUtil(s,positions,startIndex+1);
			positions[i]='\0';
		}
	}


	public static void printPermutations(String s){
		char[] positions=new char[s.length()];
		for(int i=0;i<s.length();i++)
			positions[i]='\0';

		printPermutationsUtil(s,positions,0);
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		String s;
		s=in.next();
		printPermutations(s);
	}
}
