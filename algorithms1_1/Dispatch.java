package algorithms1_1;

import java.util.ArrayList;
import java.util.Scanner;

class Work {
	int workpice;
	int machine;
	int waste;
//	@Override
//	public String toString() {
//		return "Work [workpice=" + workpice + ", machine=" + machine + ", waste=" + waste + "]";
//	}
}
class Machine{
	int num;
	int state; //  0:waiting     other number :working, matching workPice 
	
	public Machine(int num, int state) {
		this.num = num;
		this.state = state;
	}
	

//	@Override
//	public String toString() {
//		return "Machine [num=" + num + ", state=" + state + "]";
//	}


	private static boolean workpiceAtMachines(Work work, ArrayList<Machine> machines){
		Boolean judge = false;
		for(int i = 0; i < machines.size(); i++) {
			judge |= Math.abs(machines.get(i).state) == work.workpice;
		}
		return judge;
	}

	
	void process(ArrayList<Machine> machines, ArrayList<Work> works, int index) {
		if(this.state <= 0) {
			if(this.state < 0) this.state = 0;
			while(index < works.size() && (workpiceAtMachines(works.get(index),machines) || works.get(index).machine != this.num || works.get(index).waste == 0)) index++;
			if(index < works.size()) {
				for(int i = 0;i < index; i++ ) {				//检查是否前面的工序已完成
					if(works.get(i).workpice == works.get(index).workpice && works.get(i).waste > 0) {System.out.print("\t"); return;}
				}
				if(works.get(index).waste > 1) {
					this.state = works.get(index).workpice;
					works.get(index).waste--;
					System.out.print(works.get(index).workpice+"\t");
				}else if(works.get(index).waste == 1){
					works.get(index).waste--;
					System.out.print(works.get(index).workpice+"\t");
				}else {
					System.out.print("\t");
				}
			}else {
				System.out.print("\t");
			}
		}else {
			while (works.get(index).workpice != this.state || works.get(index).machine != this.num) index++;
			works.get(index).waste--;
			System.out.print(works.get(index).workpice+"\t");
			if(works.get(index).waste == 0) {
				this.state = -this.state;
			}
		}
	}
}

public class Dispatch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		ArrayList<Work> works = new ArrayList<Work>();
		Work work;
		for(int i = 0; i < m*n; i++) {
			work = new Work();
			work.workpice= sc.nextInt();
			works.add(work);
		}
		
		int index;
		for(int i = 0; i < n; i++) {
			index = -1;
			for (int j = 0; j < m; j++) {
				while(works.get(++index).workpice != i+1) {}
				works.get(index).machine = sc.nextInt();
			}
		}
		for(int i = 0; i < n; i++) {
			index = -1;
			for (int j = 0; j < m; j++) {
				while(works.get(++index).workpice != i+1) {}
				works.get(index).waste = sc.nextInt();
			}
		}
		//System.out.println(works);
		sc.close();
		ArrayList<Machine> machines = new ArrayList<Machine>();
		Machine machine;
		for (int j = 0; j < m; j++) {
			machine = new Machine(j+1,0);
			machines.add(machine);
		}
		//System.out.println(machines);
		
		int timeCounter = 0;
		int firstUnfinished = 0;
		for (int j = 0; j < m; j++) {
			System.out.print("mac["+j+"]\t");
		}
		System.out.print("\n");
		while(firstUnfinished < works.size()) {
			for (int j = 0; j < m; j++) {
				machines.get(j).process(machines,works,firstUnfinished);
			}
			System.out.print("\n");
			firstUnfinished = upDatefirstUnfinished(works,firstUnfinished);
			timeCounter++;
		}
		
		System.out.println(timeCounter);
	}

	private static int upDatefirstUnfinished(ArrayList<Work> works, int firstUnfinished) {
		while(firstUnfinished < works.size() && works.get(firstUnfinished).waste == 0) firstUnfinished++;
		return firstUnfinished;
	}

}
