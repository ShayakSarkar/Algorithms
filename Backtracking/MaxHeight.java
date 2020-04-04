// Given a list of 3d boxes, stack them up in a way such that the stack has the max height 
// possible. A box can be placed on the stack only if the l and w of the topmost box is
// strictly less than the box. We can use multiple copies of a particular box

import java.util.*;

public class MaxHeight{
	public static Scanner in=new Scanner(System.in);
	static class Box{
		int l,w,h;
		public Box(){
			l=w=h=0;
		}

		public Box(int l,int w,int h){
			this.l=l;
			this.w=w;
			this.h=h;
		}
		public void print(){
			System.out.print("("+l+" "+w+" "+h+")");
		}
	}

	public static Box rotate(Box b){
		Box ans=new Box();
		ans.l=b.h;
		ans.w=b.l;
		ans.h=b.w;
		return ans;
	}
	public static int heightOf(ArrayList<Box> stack){
		int height=0;
		for(int i=0;i<stack.size();i++)
			height+=stack.get(i).h;
		return height;
	}
	public static boolean isPlaceable(Box b,ArrayList<Box> stack){
		if(stack.size()==0)
			return true;
		Box last=stack.get(stack.size()-1);
		if(last.l<=b.l || last.w<=b.w)
			return false;
		return true;
	}

	public static Box getMinHeightBox(Box[] arr){
		Box min=arr[0];
		for(int i=0;i<arr.length;i++)
			if(arr[i].h<min.h)
				min=arr[i];
		return min;
	}
	public static ArrayList<Box> findMaxHeight(Box[] arr,ArrayList<Box> curStack){
		int maxHeight=0;
		ArrayList<Box> maxStack=new ArrayList<Box>();
		boolean isTerminal=false;

		for(int i=0;i<arr.length;i++){
			Box temp=arr[i];
			if(isPlaceable(temp,curStack)){
				isTerminal=true;
				curStack.add(temp);
				ArrayList<Box> retStack=findMaxHeight(arr,curStack);
				int retHeight=heightOf(retStack);
				if(retHeight>maxHeight){
					maxHeight=retHeight;
					maxStack=retStack;
				}
				curStack.remove(curStack.size()-1);
			}
			if(isPlaceable(rotate(temp),curStack)){
				isTerminal=true;
				curStack.add(rotate(temp));
				ArrayList<Box> retStack=findMaxHeight(arr,curStack);
				int retHeight=heightOf(retStack);
				if(retHeight>maxHeight){
					maxHeight=retHeight;
					maxStack=new ArrayList<Box>(retStack);
				}
				curStack.remove(curStack.size()-1);
			}
			if(isPlaceable(rotate(rotate(temp)),curStack)){
				isTerminal=true;
				curStack.add(rotate(rotate(temp)));
				ArrayList<Box> retStack=findMaxHeight(arr,curStack);
				int retHeight=heightOf(retStack);
				if(retHeight>maxHeight){
					maxHeight=retHeight;
					maxStack=retStack;
				}
				curStack.remove(curStack.size()-1);
			}
		}
		if(!isTerminal)
			maxStack=new ArrayList<Box>(curStack);
		return maxStack;
	}
	public static void main(String args[]){
		//int no=in.nextInt();
		int no=4;
		Box arr[]=new Box[no];
		//for(int i=0;i<no;i++)
		//	arr[i]=new Box(in.nextInt(),in.nextInt(),in.nextInt());
		
		arr[0]=new Box(4,2,5);
		arr[1]=new Box(3,1,6);
		arr[2]=new Box(3,2,1);
		arr[3]=new Box(6,3,8);
		//for(int i=0;i<no;i++)
		//	arr[i].print();	
		ArrayList<Box> ans=findMaxHeight(arr,new ArrayList<Box>());
		for(Box it : ans)
			it.print();
		System.out.println();
	}
}

