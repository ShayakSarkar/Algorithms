
//Given a string in lexicographical order, find all possible lexiographical subsets of the same String


import java.util.*;

public class PowerSetLexicographical{
	public static HashSet<String> findSetsInOrder(String s,int index){
		if(index==s.length()){
			HashSet<String> temp=new HashSet<String>();
			temp.add("");
			return temp;
		}
		HashSet<String> hs=new HashSet<String>();
		HashSet<String> retSet=findSetsInOrder(s,index+1);
		//System.out.println(retSet);
		for(String it : retSet){
			hs.add(it);
			String temp=s.charAt(index)+it;
			hs.add(temp);
		}
		//System.out.println(hs);
		return hs;
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		String s=in.next();
		System.out.println(s);
		System.out.println(findSetsInOrder(s,0));
	}
}

