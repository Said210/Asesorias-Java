import java.util.*;

class gato{
	public static boolean winner=false;
	public static int pWinner=-1;
	public static int[][] tablero = new int[3][3];
	public static  int i,j;

	public static void main(String[] args) {
		
		int x,y;
		int tirada=0;
		Scanner read = new Scanner(System.in);

	 	for (i = 0; i < 3; i++) {
	       	for (j = 0; j < 3; j++) {
				tablero[i][j]=-1;
			}
		}
		printT();
		while(!winner){
			System.out.print("X: ");
			x=read.nextInt();
			System.out.print("Y: ");
			y=read.nextInt();
			if(tirada==9){pWinner=2;break; }
			if(tirada%2==0){
				pturn(x,y,0);
			}else{
				pturn(x,y,1);
			}
			++tirada;
			printT();
			defWinner();
		}
	}
	
	public static void pturn(int x,int y, int f){
		if(tablero[y][x]==-1){
			tablero[y][x]=f;
		}
	}

	public static void printT(){
		for (i = 0; i < 3; i++) {
	       	for (j = 0; j < 3; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.print("\n");
		} 
	}

	public static void defWinner(){
		for (int i=0;i<3 ;i++ ) {
			if(tablero[i][0]==0&&tablero[i][1]==0&&tablero[i][2]==0){
				winner=true;
				pWinner=0;
				printWinner(1);
			}
			if(tablero[i][0]==1&&tablero[i][1]==1&&tablero[i][2]==1){
				winner=true;
				pWinner=1;
				printWinner(2);
			}
		}
		for (int i=0;i<3 ;i++ ) {
			if(tablero[0][i]==0&&tablero[1][i]==0&&tablero[2][i]==0){
				winner=true;
				pWinner=0;
				printWinner(1);
			}
			if(tablero[0][i]==1&&tablero[1][i]==1&&tablero[2][i]==1){
				winner=true;
				pWinner=1;
				printWinner(2);
			}
		}
	}

	public static void printWinner(int w){
		System.out.println("*-------------------*");
		System.out.println("|   GANA JUGADOR "+w+"  |");
		System.out.println("*-------------------*");
	}

}