import java.util.*;
public class Jugador{
	char[][] miMapa;
	char[][] suMapa;
	int cantidad;
	Scanner read;
	public Jugador(){
		miMapa=new char[5][5];
		suMapa=new char[5][5];
		cantidad=3;
		read=new Scanner(System.in);

		llenar();
	}
	
	public void llenar(){
		for (int i=0;i<5 ;i++ ) {
			for (int j=0;j<5 ;j++ ) {
				miMapa[i][j]='+';
				suMapa[i][j]='+';
			}
		}
	}
	public void tirar(){
		System.out.print("ingrese X:");
			int x=read.nextInt();
		System.out.print("ingrese Y:");
			int y=read.nextInt();
		if(suMapa[y][x]=='@'){ //si le dio a un
			if(miMapa[y][x]!='@') miMapa[y][x]='X'; //Si en tu mapa la coordenada no es la misma que la de uno de tus barcos la cambiaras por X
			suMapa[y][x]='#';
		}else{
			if(miMapa[y][x]!='@') miMapa[y][x]='%'; //Si en tu mapa la coordenada no es la misma que la de tu barco la cambiaras por %
			suMapa[y][x]='%';
		}
	}

	//Pide los barcos para  el mapa de este jugador
	public void aniadir_barcos(){
		int y=0;
		int x=0;
		//lo hace tantas veces como el valor de cantidad 
		for (int i=0;i<cantidad ;i++ ) {
			System.out.print("ingrese X:");
			x=read.nextInt();
			System.out.print("ingrese Y:");
			y=read.nextInt();

			//Añade un barco en el lugar y,x, se usa el %5 para traer el número en un rango de 0 a 4
			miMapa[y%5][x%5]='@';
		}
	}
//Si ya termino
	public boolean analizar_mapa(){
		//Damos por hecho que ya termino
		boolean terminado=true;
		for (int i=0;i<5 ;i++ ) {
			for (int j=0;j<5 ;j++ ) {
				if(suMapa[i][j]=='@'){ //Si en el mapa del otro jugador hay un barco en i,j 
					terminado=false; //Entonces no termina aun el juego
					break;
				}
			}
		}
		//Regresa el valor
		return terminado;
	}
//Pues solo imprime el mapa
	public void mostrar_mi_mapa(){
		for (int i=-1;i<5 ;i++ ) {
			System.out.print(i+" ");//Cordenada en Y
			for (int j=0;j<5 ;j++ ) {
//Imprime las coordenadas y el mapa ||Aquí las coordenads||  Aquí el mapa en el lugar i,j con unos "[]"
				if (i==-1) System.out.print(" "+j+" "); else System.out.print("["+miMapa[i][j]+"]");
			}
			//Salto de linea doble
			System.out.println("\n");
		}
	}
	//Imprime el mapa del otro jugador
	public void mostrar_su_mapa(){
		for (int i=0;i<5 ;i++ ) {
			for (int j=0;j<5 ;j++ ) {
				System.out.print(suMapa[i][j]);
			}
			System.out.println("");
		}
	}
}