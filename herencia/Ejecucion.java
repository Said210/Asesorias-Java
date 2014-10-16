class Ejecucion{
	public static void main(String[] args) {
		Oso oso=new Oso();
		Leon leon = new Leon();

		System.out.println(oso.get_alimentacion());
		System.out.println(oso.get_nombre());
		oso.set_nombre("perezoso");
		System.out.println(oso.get_nombre());
		oso.set_alimentacion("Carnivoro");
		System.out.println(oso.get_alimentacion());


		System.out.println(leon.get_alimentacion());
		System.out.println(leon.get_nombre());
		leon.set_nombre("rey");
		System.out.println(leon.get_nombre());
		leon.set_alimentacion("Carnivoro");
		System.out.println(leon.get_alimentacion());
		}
	
}