class LinkedList
{
	node head ;
	class node 
	{
		int data;
		node next;
		node() { data=0;next=null; }
		node(int i) { data=i;next=null; }
	}
	public int getData(node a){return a.data;}
	// Push Data in front of LinkedList
	public void push(int a){
		node new_node=new node(a);
		if(head!=null){
			new_node.next=head;
			head=new_node;
		}
		else {head=new_node;}
	}
	//insert a node after the given value of interger
	public void insertAfterValue(int i,int j){
		node p_node=new node();
		p_node=head;
		node new_node=new node(j);
		if(head!=null){
			//node p_node=new node();
			while(getData(p_node)!=i && p_node.next!=null){
				p_node=p_node.next;
			}
			if(p_node.next!=null){
				//node new_node=new node(j);
				new_node.next=p_node.next;
				p_node.next=new_node;
			}
		}
		if (p_node.next==null){System.out.println("There is no such element");}
	}
	// Insert a node in the end of the list 
	public void insertEnd(int i){
		node new_node=new node(i);
		node p_node=new node();
		p_node=head;
		while(p_node.next!=null){
			p_node=p_node.next;
		}
		p_node.next=new_node;
	}
	// Delete node of an Instance for a given value
	public void deleteNode(int i){
		node new_node=new node();
		node prev_node=new node();
		new_node=head;
		while(getData(new_node)!=i && new_node.next!=null){
			prev_node=new_node;
			new_node=new_node.next;
		}
		if(getData(new_node)==i && new_node.next==null){prev_node.next=null;}
		else if (getData(new_node)==i && new_node.next!=null) {prev_node.next=new_node.next;}
		
		//if(new_node.next!= null){
		//	prev_node.next=new_node.next;
		//}
	}
	public void deleteNodePosition(int i){
		node new_node=new node();
		node prev_node=new node();
		new_node=head;
		int j=1;
		if(i==1){
			//node new_node=new node();
			//prev_node=head;
			new_node=head.next;
			head=new_node;
		}
		else if(i>1){
			//int j=0;
			while(new_node.next!=null && j<i ){
				prev_node=new_node;
				new_node=new_node.next;
				j++;
			}
			if (new_node.next==null) {prev_node.next=null;}
			if (new_node.next!=null) {prev_node.next=new_node.next;}
		}
	}
	// Print node of a given instance from head to toe
	public void printNode(){
		if(head!=null){
			node p_node=new node();
			System.out.println("Head:"+getData(head));
			p_node=head;
			while(p_node!=null){
				System.out.println(getData(p_node));
				p_node=p_node.next;
			}
		}
	}
	// Insert Node After a given node
	// Insert node in the end of the list 
	public static void main(String args[])
	{
		a1 list=new a1();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		list.push(6);
		list.printNode();
		list.insertAfterValue(7,22);
		list.printNode();
		list.insertEnd(10);
		list.printNode();
		list.insertEnd(31);
		list.printNode();
		list.deleteNode(31);
		list.printNode();
		list.deleteNodePosition(1);
		list.printNode();
	}
}
