
//Given list of integers, the last one froms the RHS of an equation and the numbers to its left constitute the LHS. Insert Symbols in between the numbers on the LHS so as to arrive at the RHS. Give all possible solutions to the same.

import java.util.*;

public class Equation{
	public static LinkedList<LinkedList<Integer>> finalList=new LinkedList<LinkedList<Integer>>();
	public static boolean isValid(LinkedList<Integer> ll,LinkedList<Integer> symbols){
		int lhs=0;
		lhs+=ll.get(0);
		for(int i=1;i<ll.size()-1;i++){
			if(symbols.get(i-1)==1)
				lhs+=ll.get(i);
			else
				lhs-=ll.get(i);
		}
		if(lhs == ll.get(ll.size()-1))
			return true;
		return false;
	}
		
	public static void findEquations(LinkedList<Integer> ll,LinkedList<Integer> symbols,int index){
		if(index==symbols.size() && isValid(ll,symbols)){
			System.out.println("valid: "+symbols);
			return;
		}
		else if(index==symbols.size())
			return;
		symbols.set(index,1);
		findEquations(ll,symbols,index+1);
		symbols.set(index,0);
		findEquations(ll,symbols,index+1);
	}

	public static void initSymbols(LinkedList<Integer> symbols,int size){
		for(int i=0;i<size;i++)
			symbols.add(0);
	}

	public static void main(String agrs[]){
		Scanner in=new Scanner(System.in);
		LinkedList<Integer> ll=new LinkedList<Integer>();
		while(true){
			System.out.println("Enter the number(Enter -1 to end): ");
			int no=in.nextInt();
			if(no == -1)
				break;
			ll.add(no);
		}
		LinkedList<Integer> symbols=new LinkedList<Integer>();		// 1 for + and 0 for -
		initSymbols(symbols,ll.size()-2);
		findEquations(ll,symbols,0);
	}

}

