import java.util.*;
public class CryptarithmeticPuzzle{
	public static void solvePuzzle(HashMap<Character,Integer> hm,String s1,String s2,String s3){
		int i=s1.length()-1;	//index for string 1
		int j=s2.length()-1;	//index for string 1
		int k=s3.length()-1;	//index for string 1
		
		HashSet<Character> hs=hm.keySet();
		for(int i=0;i<9;i++)
			


	public static void fillHashMap(HashMap<Character,Integer> hm,String s1,String s2,String s3){
		for(int i=0;i<s1.length();i++){
			char c=s1.charAt(i);
			if(hm.containsKey(c))
				continue;
			hm.put(c,-1);
		}
		for(int i=0;i<s2.length();i++){
			char c=s2.charAt(i);
			if(hm.containsKey(c))
				continue;
			hm.put(c,-1);
		}
		for(int i=0;i<s3.length();i++){
			char c=s3.charAt(i);
			if(hm.containsKey(c))
				continue;
			hm.put(c,-1);
		}
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		String s1=in.next();
		String s2=in.next();
		String s3=in.next();
		HashMap<Character,Integer>hm =new HashMap<Character,Integer>();
		solvePuzzle(hm,s1,s2,s3);
		fillHashMap(hm,s1,s2,s3);
	}
}

