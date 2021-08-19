package diskScheduling;
import java.util.*;

public class DiskScheduling {
	int n,m,e,h;
	ArrayList<Integer> s = new ArrayList<Integer>();     //ARRAYLIST TO STORE SEQUENCE

	
	void accept() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter maximum the number of cylinders: ");
		n=sc.nextInt();
		System.out.println("Enter total number of cylinders to be accessed: ");
		m=sc.nextInt();
		
		System.out.println("Enter the sequence cylinders to be accessed: ");
		for(int i=0;i<m;i++) {
			e=sc.nextInt();
			s.add(e);
		}
		System.out.println("Enter starting location of head: ");    
		h=sc.nextInt();
		s.add(0, h);    //INSERING HEAD AT THE FIRST POSITION
		
	
	}
	
	void display() {
		System.out.println();
		System.out.println("The sequence is: ");
		System.out.println(s);
		System.out.println("The starting location of head: " +h);
		System.out.println("The maximum number of cylinders: " +n);
	}
	
	void fcfs() {
		int time=0,seek_time=0;         //seek_time= TOTAL HEAD MOVEMENT
	
		System.out.println("\nDISTANCE CALCULATIONS: ");
		for (int i=0;i<s.size()-1;i++) {
			if(s.get(i+1)>s.get(i)) {          //IF-ELSE LOOP TO GET TIME AS A POSITIVE INTEGER 
				time=s.get(i+1)-s.get(i);
				seek_time+=time;
				System.out.println(s.get(i+1)+" - "+ s.get(i)+" = "+time);
			}
			else {
				time=s.get(i)-s.get(i+1);
				seek_time+=time;
				System.out.println(s.get(i)+" - "+ s.get(i+1)+" = "+time);

			}
			
		
		
		}
		System.out.println("Total distance travelled by head: "+seek_time);
	}
	
	void sstf() {
		int time=0,seek_time=0;
		int min=99999;
		int head;
		int new_min=0;
		System.out.println("\nDISTANCE CALCULATIONS: ");
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		//NEW ARRAYLIST TO STORE ELEMENTS THAT ARE USED AS HEAD ALREADY
		
		head=s.get(0);
		list.add(s.get(0));
		s.remove(0);

		while(!s.isEmpty()) {
			
			for(int k=0;k<s.size();k++) {
				
				if(Math.abs(head-s.get(k))<min) {        //TO GET MINIMUM DISTANCE
					min=Math.abs(head-s.get(k));         
					new_min=k;
					
				}
			}
			System.out.println("\nMinimum distance is "+min+" for disk number "+s.get(new_min));
			System.out.println("|"+s.get(new_min)+" - "+ head+"| = "+min);

			seek_time+=min;                //UPDATING VALUES
			list.add(s.get(new_min));
			head=s.get(new_min);
			s.remove(new_min);
			min=9999;
	
		}

		System.out.println("\n\nTotal distance travelled by head: "+seek_time);
	
	}
	

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
        int no;
        DiskScheduling d= new DiskScheduling();
        
        d.accept();
		d.display();
		
		do {
		System.out.println("\n********MENU**********");
		System.out.println("\n1. FIRST COME FIRST SERVE(FCFS)\n2. SHORTEST SEEK TIME FIRST(SSTF)\n3. EXIT");
		System.out.println("\n*************************");
		System.out.println("\nEnter your choice: ");
		no=sc.nextInt();
		switch(no)
		{
		case 1:
			d.fcfs();
		break;
		
		case 2:
			d.sstf();
		break;
		
		case 3:
			
		break;
			
		default: System.out.println("INVALID CHOICE!");
		break;

		}
		
		}while(no!=3);

		
	}

}


/*
 OUTPUT
 
 Enter maximum the number of cylinders: 
200
Enter total number of cylinders to be accessed: 
5
Enter the sequence cylinders to be accessed: 
23
89
132
42
187
Enter starting location of head: 
100

The sequence is: 
[100, 23, 89, 132, 42, 187]
The starting location of head: 100
The maximum number of cylinders: 200

********MENU**********

1. FIRST COME FIRST SERVE(FCFS)
2. SHORTEST SEEK TIME FIRST(SSTF)
3. EXIT

*************************

Enter your choice: 
1

DISTANCE CALCULATIONS: 
100 - 23 = 77
89 - 23 = 66
132 - 89 = 43
132 - 42 = 90
187 - 42 = 145
Total distance travelled by head: 421

********MENU**********

1. FIRST COME FIRST SERVE(FCFS)
2. SHORTEST SEEK TIME FIRST(SSTF)
3. EXIT

*************************

Enter your choice: 
2

DISTANCE CALCULATIONS: 

Minimum distance is 11 for disk number 89
|89 - 100| = 11

Minimum distance is 43 for disk number 132
|132 - 89| = 43

Minimum distance is 55 for disk number 187
|187 - 132| = 55

Minimum distance is 145 for disk number 42
|42 - 187| = 145

Minimum distance is 19 for disk number 23
|23 - 42| = 19


Total distance travelled by head: 273

********MENU**********

1. FIRST COME FIRST SERVE(FCFS)
2. SHORTEST SEEK TIME FIRST(SSTF)
3. EXIT

*************************

Enter your choice: 
3
*/
