import java.util.*;

public class GraphColoring{
	public static class Node{
		Integer color;
		String name;
		public Node(String name,Integer color){
			this.name=name;
			this.color=color;
		}

	};
	public static class Graph{
		HashMap<Node,HashSet<Node>> hm;
	}
	public static void printGraph(HashMap<Node,HashSet<Node>> hm){
		for(Node it1 : hm.keySet()){
			System.out.print(it1.name+" ==> ");
			HashSet<Node> hs=hm.get(it1);
			for(Node it2 : hs)
				System.out.print(it2.name+" ");
			System.out.println();
		}
	}
	public static HashMap<Node,HashSet<Node>> createGraph(){			// The graph shall be a hash map
		Scanner in=new Scanner(System.in);
		HashMap<Node,HashSet<Node>> hm=new HashMap<Node,HashSet<Node>>();
		while(true){
			System.out.println("Enter the name of the node: ");
			String newNodeName=in.next();
			if(newNodeName.equals("-1"))
				break;
			Node newNode=new Node(newNodeName,null);
			while(true){
				System.out.println("Enter the neighbour: ");
				String neighbourName=in.next();
				if(neighbourName.equals("-1"))
					break;
				Node neighbour=new Node(neighbourName,null);
				if(!hm.containsKey(newNode))
					hm.put(newNode,new HashSet<Node>());
				hm.get(newNode).add(neighbour);
			}
		}
		return hm;
		
	}
	public static boolean colorIsValid(HashMap<Node,HashSet<Node>> hm,Node key,int color){
		for(Node neighbour : hm.get(key)){
			if(neighbour.color==color)
				return false;
		}
		return true;
	}
		

	public static boolean findIfPossible(HashMap<Node,HashSet<Node>> hm,Node key,int m){	// m = max number of permissible colors, used = no of colors used
		if(key.color!=null)
			return false;
		for(int i=0;i<m;i++){
			if(!colorIsValid(hm,key,i))
				continue;
			key.color=i;
			for(Node neighbour : hm.get(key)){
				if(findIfPossible(hm,neighbour,m))
					return true;
			}
			key.color=null;
		}
		key.color=null;
		return false;
	}


	public static void main(String args[]){
		HashMap<Node,HashSet<Node>> hm=createGraph();
		printGraph(hm);
		findIfPossible(hm,)
	}
}
		
