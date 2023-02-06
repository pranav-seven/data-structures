import java.util.Scanner;
import static java.lang.System.*;

class List
{
    int val;
    static int count;
    List next;
    List()
    {}
    List(int i)
    {
        val = i;
    }
}

class LinkedListTest {
	Scanner sc;
	List head;
	ListOperations listOp;
	LinkedListTest()
	{
		sc = new Scanner(System.in);
        head = new List();
        listOp = new ListOperations(head);
	}
    public static void main(String[] args) {
        new LinkedListTest().doListOperations();
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
		                    if(deletePos>0 && deletePos<=List.count+1)
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
            	
	            case 6:	out.println(List.count);
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
	List head;    //node to store reference of first node
	List temp = null;		//temporary node for traversal
	ListOperations(List head)
	{
		this.head = head;
	}
    void insertAtEnd(int val)
    {
    	temp = head;
        while(temp.next!=null)
        	temp=temp.next;
        temp.next = new List(val);
        List.count++;
    }
    void insertAtPos(int pos, int val)
    {
    	temp = head;
        List node = new List(val);
        for(int i=1; i<pos; i++)
        	temp = temp.next;
        node.next = temp.next;
        temp.next = node;
        List.count++;
    }
    void deleteAtEnd()
    {
    	temp = head;
        for(int i=1; i<List.count; i++)
        	temp=temp.next;
        temp.next = null;
        List.count--;
    }
    void deleteAtPos(int pos)
    {
    	temp = head;
        for(int i=1; i<pos; i++)
        	temp = temp.next;
        temp.next = temp.next.next;
        List.count--;
    }
    void print()
    {
    	temp = head;
        while(temp.next!=null)
        {
            System.out.print(temp.next.val+" ");
            temp = temp.next;
        }
        out.println();
    }
}