package bussiness;

public class SalesArt {


	String id_Venta;
	String id_A;
	int cantidad_Art; 
	
	
	public SalesArt(String id_Venta, String id_A, int cantidad_Art){

		this.id_A = id_Venta; 
		this.id_Venta = id_Venta; 
		this.cantidad_Art = cantidad_Art; 
	}


	public String getid_Venta(){

		return id_Venta;
	}
	public String getid_A(){

		return id_A;
	}
	public int getcantidad_Art(){

		return cantidad_Art;
	}
	
}
