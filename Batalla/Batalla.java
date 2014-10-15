import java.util.*;

class Batalla{
	public static void main(String[] args) {
		Scanner read=new Scanner(System.in);
		Jugador jugador1=new Jugador();
		Jugador jugador2=new Jugador();
		
		Jugador[] jugador=new Jugador[5];
		jugador[0]=new Jugador();
		jugador[1]=new Jugador();
		boolean terminado=false;
		int turno=0;
		//Añade los barcos al mapa del jugador 1
		jugador[0].aniadir_barcos();
		//Muestra el mapa del jugador 1
		jugador[0].mostrar_mi_mapa();
		//Deja muchos espacios porque no queria limpiarla
		clearConsole();
		//Añade los barcos al mapa del jugador 2
		jugador[1].aniadir_barcos();
		//Muestra el mapa del jugador 2
		jugador[1].mostrar_mi_mapa();
		clearConsole();
		//Se dan sus mapas
		jugador[0].suMapa=jugador[1].miMapa;
		jugador[1].suMapa=jugador[0].miMapa;

		System.out.println("Empieza el juego");
		
		//Mientras terminado sea falso se sigue el juego
		while(!terminado){
			
			if(turno%2==0){
				System.out.println("|***Jugador 1***|");
				jugador[0].tirar();
				System.out.println("|***Mapa del jugador 1***|");
				//Se actualiza el mapa2 del jugador 1
				jugador[0].suMapa=jugador[1].miMapa;
				jugador[0].mostrar_mi_mapa();
				
				terminado=jugador[0].analizar_mapa();
			}else{
				System.out.println("|***Jugador 2***|");
				jugador[1].tirar();
				//Se actualiza el mapa2 del jugador 2
				jugador[0].suMapa=jugador[1].miMapa;
				System.out.println("|***Mapa del jugador 2***|");
				jugador[1].mostrar_mi_mapa();
				
				terminado=jugador[1].analizar_mapa();
			}
			++turno;
		}
		System.out.println("|****************|");
		System.out.println("| Gana jugador "+((turno%2)+1)+" |");
		System.out.println("|****************|");
	}

	public static void clearConsole(){
	    for (int i=0;i<10;i++ ) {
	    	System.out.println("");
	    }
	}
}