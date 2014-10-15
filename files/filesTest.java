import java.io.*;//no olviden importar esta librería al inicio de su programa
//esto es solo un método, no una clase, el método deberá ser incluido en una clase java para su uso
class filesTest{
	public static void escribir(animal e){
		try{
			 FileOutputStream fileOut = new FileOutputStream("data.dat");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(e);
	         out.close();
	         fileOut.close();
	         System.out.println("Serialized data is saved in data.dat");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	public static animal leer(){
		animal e=null;
		try{
         FileInputStream fileIn = new FileInputStream("data.dat");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (animal) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i){
         i.printStackTrace();
      }catch(ClassNotFoundException c){
         System.out.println("animal class not found");
         c.printStackTrace();
      }

      return e;
	}


	public static void main(String[] args) {
		animal panda=leer();
		System.out.println(panda.nombre);
	}
}
