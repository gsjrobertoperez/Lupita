package bussiness;

public class Purchase {


	String fecha;
	int cantidad_Art; 
	double precio_C;
	String id_A;
        String descripcion;

	public Purchase(String descripcion, String id_A, int cantidad_Art, double precio_C, String fecha ){

         this.descripcion = descripcion;
	 this.fecha = fecha;
	 this.cantidad_Art = cantidad_Art; 
	 this.id_A = id_A; 
	 this.precio_C = precio_C;

	}

        public String getDesc(){
            return this.descripcion;
        }
	public String getDate(){

		return fecha;
	}
	public int getcantidad_Art(){

		return cantidad_Art;
	}
	public String getid_A(){

		return id_A;
	}
	public double getprecio_C(){

		return precio_C;
	}
	
	
}
