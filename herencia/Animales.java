class Animales{
	public int extremidades;
	public String alimentacion, nombre;
	public Animales ()
	{
		extremidades=4;
		alimentacion="";
		nombre="";
	}
	public void comer()
	{
		System.out.println("Yo soy:"+ alimentacion);
	}
	public void morir()
	{
		System.out.println("Yo muero");
	}
	
	public String get_alimentacion(){
		return this.alimentacion;
	}
	public String get_nombre(){
		return this.nombre;
	}
	public void set_nombre(String x){
		this.nombre=x;
	}
	public void set_alimentacion(String x){
		this.alimentacion=x;
	}
}	