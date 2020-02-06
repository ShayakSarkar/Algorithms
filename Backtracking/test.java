import java.util.*;
public class test{
	public static void main(String args[]){
		LinkedList<LinkedList<Integer>> ll=new LinkedList<LinkedList<Integer>>();
		LinkedList<Integer> temp=new LinkedList<Integer>();
		temp.add(1);
		temp.add(2);
		ll.add(temp);
		System.out.println(ll);
		LinkedList<Integer> temp2=new LinkedList<Integer>(temp);

	}
}
