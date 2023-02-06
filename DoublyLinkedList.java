import java.util.Scanner;
import static java.lang.System.*;

class List
{
    int val;
    static int count;
    List prev, next;
    List()
    {}
    List(int i)
    {
        val = i;
    }
}

class DoublyLinkedListTest {
	Scanner sc;
	List head, tail;
	ListOperations listOp;
	DoublyLinkedListTest()
	{
		sc = new Scanner(System.in);
        head = new List();
        tail = new List();
        listOp = new ListOperations(head, tail);
	}
    public static void main(String[] args) {
        new DoublyLinkedListTest().doListOperations();
    }
    void doListOperations()
    {
    	byte choice = 0;
    	do {
            out.print("Enter\n1: insert at end;");
            out.println("\t2: insert at position;");
            out.print("3: delete at end;");
            out.println("\t4: delete at position;");
            out.print("5: print list;");
            out.println("\t6: get count of node(s);");
            out.println("0: exit");
    		choice = sc.nextByte();
    		switch(choice)
            {
	            case 1:	out.println("Enter value: ");
		                listOp.insertAtEnd(sc.nextInt());
		                listOp.print();
		                break;
                
	            case 2:	out.println("Enter position and value: ");
		                int pos = sc.nextInt();
		                int val = sc.nextInt();
		                if(pos>0 && pos<=List.count+1)
		                {
			                listOp.insertAtPos(pos, val);
			                listOp.print();
		                }
		                else
		                	out.println("Position doesn't exist.");
		                break;
                
	            case 3:	if(List.count>0)
			            {
			    				listOp.deleteAtEnd();
			    				listOp.print();
			            }
		            	else
		            		out.println("Nothing to delete...");
		            	break;
            	
	            case 4:	if(List.count>0)
		            	{
		                    out.println("Enter position: ");
		                    int deletePos = sc.nextInt();
		                    if(deletePos>0 && deletePos<=List.count)
		                    {
		                    	listOp.deleteAtPos(deletePos);
		                    	listOp.print();
		                    }
		                    else
		                    	out.println("Position doesn't exist.");
		            	}
		            	else
		            		out.println("Nothing to delete...");
		            	break;
            	
	            case 5:	listOp.print();
	            		break;
            	
	            case 6:	out.println("Count: "+List.count);
            			break;
	            	
	            case 0:	break;

            	default: out.println("Choice doesn't exist.");
            }
    		out.println("---------------");
    	}while(choice!=0);
    }
}

class ListOperations
{
	List head, tail;  		//node to store reference of first and last nodes
	List temp = null;		//temporary node for traversal
	ListOperations(List head, List tail)
	{
		this.head = head;
		this.tail = tail;
		head.next = tail;
		tail.prev = head;
	}
    void insertAtEnd(int val)
    {
    	List node = new List(val);
    	node.prev = tail.prev;
    	node.next = tail;
    	tail.prev.next = node;
    	tail.prev = node;
        List.count++;
    }
    void insertAtPos(int pos, int val)
    {
    	//if position is in left half, traverse from head
    	//else traverse from tail
        List node = new List(val);
    	if(pos<(List.count>>1))
    	{
	    	temp = head;
	        for(int i=1; i<pos; i++)
	            temp = temp.next;
	        node.next = temp.next;
	        node.prev = temp;
	        temp.next.prev = node;
	        temp.next = node;
	        ArrayList;
    	}
    	else
    	{
	    	temp = tail;
	        for(int i=List.count; i>=pos; i--)
	        	temp = temp.prev;
	        node.next = temp;
	        node.prev = temp.prev;
	        temp.prev.next = node;
	        temp.prev = node;
    	}
        List.count++;
    }
    void deleteAtEnd()
    {
    	tail.prev = tail.prev.prev;
    	tail.prev.next = tail;
        List.count--;
    }
    void deleteAtPos(int pos)
    {
    	//if position is in left half, traverse from head
    	//else traverse from tail
    	if(pos<(List.count>>1))
    	{
    		temp = head;
	        for(int i=1; i<pos; i++)
	        	temp = temp.next;
	        temp.next = temp.next.next;
	        temp.next.prev = temp;
    	}
    	else
    	{
    		temp = tail;
	        for(int i=List.count; i>pos; i--)
	        	temp = temp.prev;
	        temp.prev = temp.prev.prev;
	        temp.prev.next = temp;
    	}
        List.count--;
    }
    void print()
    {
    	temp = head;
    	out.print("List: ");
        while(temp.next!=tail)
        {
            System.out.print(temp.next.val+" ");
            temp = temp.next;
        }
        out.println();
    }
}