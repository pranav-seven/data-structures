import static java.lang.System.in;
import static java.lang.System.out;
import java.util.*;

class ArrayListTest {
	ArrayList list;
	static Scanner scanner;
    public static void main(String arraylist[])
    {
        ArrayListTest test = new ArrayListTest();
        test.useArrayList();
    }
    void useArrayList()
    {
    	list = new ArrayList();
        scanner = new Scanner(in);
        int choice=0;
        do{
            out.println("Enter 1 to insert, 2 to delete, 0 to exit:");
            choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    out.print("No.of elemets:");
                    int count = scanner.nextInt();
                    out.println("Enter elements:");
                    list.insert(count);
                    print();
                    break;
                case 2:
                    if(list.last>=0)
                    {
            			out.print("Number of elements to be deleted: ");
            			list.delete(scanner.nextInt());
            			print();
                    }
                    else
                    {
                    	out.println("Nothing to delete...");
 //                       out.println(list.size+" "+list.array.length+" "+list.last);
                    }
            }
            System.out.println("-----------");
        }while(choice==1 || choice==2);
    }
    void print()
    {
        if(list.last>=0)
        {
        	out.print("Array: ");
            for(int i=0; i<=list.last; i++)
                out.print(list.array[i]+" ");
            out.println();
        }
        else
            out.println("Nothing to show...");
    }
}

class ArrayList {
    int array[], size;
    int last;
    ArrayList()
    {
        array = new int[5];
        size = 5;
        last = -1;				//index of last element
        						//gets incremented when an element is added
    }
    void insert(int count)
    {
        for(int start = 0; start<count; start++)
        {
            last++;
            if(last==size)
            {
            	//create new array with 5 more spaces
                int[] temp = new int[size+=5];
                for(int i=0; i<last; i++)
                	temp[i] = array[i];
                array = temp.clone();
            }
            array[last] = ArrayListTest.scanner.nextInt();
        }
    }
    void delete(int count)
    {
		int newSize = last-last%5;
        last = last - count;
        //if all elements are deleted, create an empty array
        if(last<=-1)
		{
            last = -1;
		    array = new int[5];
		}
        //if last element is in previous block,
        //create new array with size of next 5 multiple of last index
		else if(last<newSize)
		{
			int[] temp = new int[size=last-last%5+5];
		    for(int i=0; i<=last; i++)
		    	temp[i] = array[i];
		    array = temp.clone();
		}
    }
}
