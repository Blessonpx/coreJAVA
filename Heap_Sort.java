// Create data structure around it 
// like linked list 
// For Printing the Details around Binary Tree a Data Structure is required 
//
// Properties , each node it is a structure with int value and left and right node
// Is either left or right node is not connected , then left and right node becoome null
// int value of node can be replaced  with Another so can the details be also
// there will be separate Operations for Swapping Values,allocating left and Right nodes 
// BUILD FROM SCRATCH ----no third site references 
// There should be a root for the tree
import  java.lang.Object;
import  java.io.OutputStream;
import  java.io.FilterOutputStream;
import  java.io.PrintStream;
public class Heap_Sort
{
	public static void main(String args[])
	{
		//int[] array={1,2,3,4,7,56,78,99,134,230,512,1001,2005,5007,12000,20011,5012345,11123145};
		int[] array={1,5,2,3,4,6,66,99,798,487,21,34,99,100,1000,2001};
		System.out.println("");
                System.out.println("Print Heap");
                Heap_Sort s=new Heap_Sort();
		for (int i=0;i<array.length ; i++)
		{
			System.out.print(array[i]+":");
		}
		System.out.println("");
		tree alpha = new tree();
		int[] arr_return= new int[array.length];
		System.out.println("Print Output Array");
		arr_return= alpha.sortTree(array);
		System.out.println("");
                System.out.println("");
		for (int i=0;i<arr_return.length ; i++)
                {
                        System.out.print(arr_return[i]+":");
                }
		System.out.println("");
	}
}
class treeNode
{
	private int value;
	private static int nextIndex=1;
	private int index;
	private treeNode left;
	private treeNode right;
	public treeNode(int i)
	{
		value=i;
	}
	// Basic Getters and Setters 
	public int getValue()
	{
		if(this!=null)
		{return this.value;}
		else 
		{return -1;}
	}
	public void setValue(int i )
	{
		this.value=i;
	}
	public treeNode leftNode()  {return left; }
	public treeNode rightNode() {return right;}
	// Allocating left and right nodes for each treeNode 
	public void left_alloc(treeNode a)
	{
		this.left=a;
	}
	public void right_alloc(treeNode b)
	{
		this.right=b;
	}
	// Setting index for the node
	public void setIndex()
	{
		index=nextIndex;
		nextIndex++;
	}
	public int getIndex()
	{
		return index;
	}
	public void swapValue(treeNode a)
	{
		int i=a.getValue();
		a.setValue(this.getValue());
		this.setValue(i);
	}
	public void printNode(PrintStream os)
	{
		StringBuilder sb = new StringBuilder();
		travelNode(sb,"","",this);
		os.print(sb.toString());
	}
	// Transversing the node from the Root to the tips based on the left and right nodes
	public void travelNode(StringBuilder sb, String padding, String pointer,treeNode node)
	{
		if (node != null) 
		{
        	sb.append(padding);
        	sb.append(pointer);
        	sb.append(node.getValue());
        	sb.append("\n");
        	StringBuilder paddingBuilder = new StringBuilder(padding);
        	paddingBuilder.append("│  ");
        	String paddingForBoth = paddingBuilder.toString();
        	String pointerForRight = "└──";
        	String pointerForLeft = (node.rightNode() != null) ? "├──" : "└──";
        	travelNode(sb, paddingForBoth, pointerForLeft, node.leftNode());
        	travelNode(sb, paddingForBoth, pointerForRight, node.rightNode());
		}
	}
}
class tree 
{
	public treeNode[] createTree(int[] arr)
	{
		treeNode[] vTree=new treeNode[arr.length];
		for(int i=0;i<arr.length;i++)
                {
                        vTree[i]=new treeNode(arr[i]);
                        vTree[i].setIndex();
                }
		return vTree;
	}
	public int[] sortTree(int[] arr)
	{
		treeNode[] vTree=createTree(arr);
		// Create New splitRule
		splitRule x=new splitRule();
		// Allocating Left and Rigth Nodes
		// with left and right rules defined in splitRule
		for (int j=0;j<vTree.length;j++)
		{
			int left_index=x.left(vTree[j].getIndex()) ;
			int right_index=x.right(vTree[j].getIndex()) ;
			// Allocate left index and right index 
			// why index was used particularly 
			// for the left and right values from index as treeNode index is subject to change maybe 
			// but for allocation need relation between index and internal_index 
			// Maybe a search funtion that returns a node with the required index 
			// search iterates through all index for the search and in the process increasing computation 
			// but will be helpful in future applications if left_alloc and right_alloc become more complex
			// Search Index should be part of the tree or treeNode 
			if(searchTreeindex(left_index,vTree)<vTree.length  && searchTreeindex(left_index,vTree)>-1 )
			{
				vTree[j].left_alloc(vTree[searchTreeindex(left_index,vTree)]);
			}
                        if(searchTreeindex(right_index,vTree)<vTree.length  && searchTreeindex(right_index,vTree)>-1 )
                        {
                                vTree[j].right_alloc(vTree[searchTreeindex(right_index,vTree)]);
                        }
		}
		int[] arr_return=new int[arr.length];
		print z = new print();
		z.printTree(vTree);
		System.out.println("Sorted Array");
		sortHeap SORT =new sortHeap();
		SORT.build_max_heap(vTree);
		for(int i=0;i<vTree.length;i++)
                {
                        arr_return[i]=vTree[i].getValue();
                }
		z.printTree(vTree);
		System.out.println("---Print Nodes---");
		z.printTree(vTree);
		System.out.println("---Print StringBuilder String---");
		StringBuilder sb =new StringBuilder();
		z.print( vTree[0]);
		System.out.println("---Internal Print Option ---");
		vTree[0].printNode(System.out);
		return arr_return;
	}
	// Method that returns the index of array for a given internal Index value
	public int searchTreeindex(int j,treeNode[] xTree)
	{
		if(j<xTree.length )
		{
			for (int i=0;i<xTree.length;i++)
			{
				if(xTree[i].getIndex()==j)
				{return i;  }
			}
		}
		return -1;
	}
}
// Method to decide the split rule for left and right node
// Kept as a separate function to facilat option of different split rules for different instances
class splitRule
{
        public int left(int a){return a*2;}
        public int right(int a) {return a*2+1;}
        public int parent(int a) {return a/2;}
}
class print
{
	splitRule s=new splitRule();
	public void printTree(treeNode[] vTree )
	{
		for(int i=0;i<vTree.length;i++ )
		{
			int a,b;
			if(vTree[i].leftNode()!=null){a=vTree[i].leftNode().getValue();} else {a=-1;}
			if(vTree[i].rightNode()!=null){b=vTree[i].rightNode().getValue();} else {b=-1;}
			System.out.println( "Node:: "+vTree[i].getValue() +" :: Left Node:: "+a+" :: Right Node :: "+b+" :: Index Value:: "+vTree[i].getIndex());
		}
	}
	public  void printRootedTree(StringBuilder sb,treeNode vNode)
	{
		// method for finding the details on route
		// pass the node then print rest of the elements 
		// node1  
		int i;
		if(vNode!=null)
		{
			i=vNode.getValue();
			sb.append(i);
			sb.append("\n");
			sb.append("\t");
			printRootedTree(sb,vNode.leftNode());
			printRootedTree(sb,vNode.rightNode());
		}
	}
	public void print(treeNode vNode ) 
	{
		StringBuilder sb = new StringBuilder();
		printRootedTree(sb, vNode );
		System.out.print(sb.toString());
		System.out.println("\n");
	}
}
class sortHeap
{
	public void maxHeapify(treeNode[] vTree,int i )
	{
		splitRule s =new splitRule();
		tree all =new tree();
		System.out.println("");
		System.out.println("---- Inter branch -----");
		for (int zeta=0;zeta<vTree.length;zeta++)
			{System.out.print( ":: "+vTree[zeta].getValue()) ;}
		System.out.println("");
		int jx,jz;
		int l,r,largest;
		l=s.left(vTree[i].getIndex()) ;
		r=s.right(vTree[i].getIndex()) ;
		jx=all.searchTreeindex(l,vTree);
		jz=all.searchTreeindex(r,vTree);
		if ( jx >-1 && vTree[jx].getValue()>vTree[i].getValue())
		{largest=jx;}
		else {largest=i;}
		if ( jz >-1 && vTree[jz].getValue()>vTree[i].getValue())
		{largest=jz;}
		if (largest!=i)
		{
			vTree[i].swapValue(vTree[largest]);
			maxHeapify(vTree,largest );
		}
	}
	public void build_max_heap(treeNode[] vTree)
	{
		int i=(vTree.length)/2;
		for (int j=i;j>0;j--)
		{
			maxHeapify(vTree,j);
		}
	}
}
