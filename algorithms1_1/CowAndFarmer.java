package algorithms1_1;


import java.io.IOException;
import java.util.Scanner;

class State{

	int X;
	int Y;
	char head = 'N'; //默认朝上
	State(){}
	State(int X,int Y,char head){
		this.X = X;
		this.Y = Y;
		this.head = head;
	}
}

class Mover {
	char name;
	State state;

	Mover(char name){
		this.name = name;
		this.state = new State();
	}
	
	void goAhead(char[][] map) {
		int newX = 0;
		int newY = 0;
		switch (this.state.head) {
		case 'N':newX = this.state.X - 1;newY = this.state.Y;break;	
		case 'E':newX = this.state.X;newY = this.state.Y + 1;break;	
		case 'S':newX = this.state.X + 1;newY = this.state.Y;break;	
		case 'W':newX = this.state.X;newY = this.state.Y - 1;break;	
		}
	
		map[newX][newY] = this.name;
		if(map[this.state.X][this.state.Y] == this.name && map[this.state.X][this.state.Y] != '*') {
			map[this.state.X][this.state.Y] = '.';
		}
		this.state.X = newX;
		this.state.Y = newY;
	}
	void turnhead() {
		 switch(this.state.head) {
		 case 'N':this.state.head = 'E';break;
		 case 'E':this.state.head = 'S';break;
		 case 'S':this.state.head = 'W';break;
		 case 'W':this.state.head = 'N';break;
		 }
	}
	
	char getAhead(char[][] map) {
		if(this.state.head == 'N') {
			if(this.state.X == 0) {return '*';}
			else {return map[this.state.X - 1][this.state.Y];}
		}
		if(this.state.head == 'S') {
			if(this.state.X == 9) {return '*';}
			else return map[this.state.X + 1][this.state.Y];
		}
		if(this.state.head == 'W') {
			if(this.state.Y == 0) return '*';
			else return map[this.state.X][this.state.Y - 1];
		}
		if(this.state.head == 'E') {
			if(this.state.Y == 9) return '*';
			else return map[this.state.X][this.state.Y + 1];
		}
		return '.';
	}
}



public class CowAndFarmer {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		char[][] map = new char[10][10];
		String line;
		//读入地图
		for(int i = 0; i<10; i++) {
			line = sc.nextLine();
			for(int j = 0; j<10; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		sc.close();
		Mover C = new Mover('C');
		Mover F = new Mover('F');
		// 找初始位置
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(map[i][j] =='F') {
					F.state.X = i;
					F.state.Y = j;
				}
				if(map[i][j] =='C') {
					C.state.X = i;
					C.state.Y = j;
				}
			}
		}
		

		boolean Catch = false;
		int minues = 0;
		//模拟抓捕
		while(!Catch) {
			if(C.state.head == 'F') {
				action(F,map);
				action(C,map);
			} else {
				action(C,map);
				action(F,map);
			}

			minues++;
			if(C.state.X == F.state.X && C.state.Y == F.state.Y) {
				Catch = true;
			}
			if(minues > 4*10*10*4*10*10) {
				break;
			}
		}
		//输出结果
		if(Catch) {
			System.out.print(minues);
		}else {
			System.out.print(0);
		}
		
	}
	
	static void action(Mover mover,char[][] map) {
			if(mover.getAhead(map) == '*') {
			mover.turnhead();
		} else {
			mover.goAhead(map);
		}
	}

}
