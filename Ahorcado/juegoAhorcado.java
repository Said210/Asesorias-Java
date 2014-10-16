import java.util.*;
class juegoAhorcado{
//Variables para poder acceder a ellas en toda la clase
	public static char[] cWord;
	public static char[] hiddenWord;
	public static int vidas=9;

	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		//Se pide una palabra
		String word=read.nextLine();
		//Se transforma la palabra a un arreglo de chars
		cWord=word.toCharArray();
		//Se crea un segundo arreglo con los caracteres ocultos, osea '_' 
		hiddenWord=new char[cWord.length];
		for (int i=0;i<hiddenWord.length;i++ ) {
			hiddenWord[i]='_';
		}
		//Se añaden las pistas al arreglo con los caracteres escondidos
		hiddenWord[0]=cWord[0];
		hiddenWord[cWord.length-1]=cWord[cWord.length-1];
		//Se imprime la palabra con los caracteres escondidos
		for (int i=0;i<hiddenWord.length ;i++ ) {
			System.out.print(hiddenWord[i]+" ");
		}
		//Variables y banderas
		char letter=' ';
		boolean finished=false;
		//Mientras queden vidas (vidas esta declarada en la linea 6 aprox) hacer lo siguiente
		while(vidas!=0){
			//Perdir letra
			System.out.print("\nLetra: ");
			//Se lee la letra, explicaré esto en la asesoria
			letter=read.nextLine().charAt(0);
			//Se manda a llamar a la función "checkGame" con 2 parametros, el arreglo con la palabra sin '_' y la letra que ingreso el usuario
			checkGame(cWord,letter);
			//Se imprime la palabra oculta (Osea la que tiene '_')
			System.out.println(toString(hiddenWord));
			//Se valida si la palabra fue descubierta y se asigna el valor de retorno a la variable "finished"
			finished=finishedGame(hiddenWord);
			//Si finished es cierta hacer
			if (finished) {
				System.out.println("******************");
				System.out.println("***Gana Jugador***");
				System.out.println("******************");
				break;
			}
		}
		//Si ya no hay vidas
		if (vidas==0) {
			System.out.println("******************");
			System.out.println("***Gana Maquina***");
			System.out.println("******************");
			//Revela la palabra 
			System.out.println("La palabra era "+toString(cWord));
		}

		System.out.print('\n');
	}


	//Se declara la funcion checkGame (que al ser void no tiene retorno) y recibe un arreglo de chars y un char
	public static void checkGame(char[] x, char letter){
		//bandera para tener control
		boolean flag=false;
		for (int i=0;i<x.length ;i++ ) {
			//Si x[i] es igual a la letra va a cambiar el valor de '_' en la palabra oculta por el de la letra y el flag a cierto
			if(x[i]==letter&&hiddenWord[i]=='_'){
				hiddenWord[i]=letter;
				flag=true;
			}
		}
		//Si el flag es falso, osea no coincidio una sola letra en todo el array
		if(!flag){
			--vidas;
		}

	}

	//Pfff pues es lo mismo que la de arriba pero en lugar de revisar si coincide alguna letra, revisa si aun hay letras ocultas
	public static boolean finishedGame(char[] x){
		boolean done=true;
		for (int i=0;i<x.length ;i++ ) {
			if(x[i]=='_'){
				done=false;
			}
		}
		return done;
	}
	//Solo hace de un arreglo un string
	public static String toString(char[] x){
		String str="";
		for (int i=0;i<x.length ;i++ ) {
			str+=x[i];
		}
		return str;
	}
}