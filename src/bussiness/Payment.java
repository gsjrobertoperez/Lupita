

package bussiness;

import java.sql.Timestamp;

public class Payment {
  
	
	String id_C;
	String id_Sale;
	double payment; 
	Timestamp date;
	

	public Payment(String id_Sale, String id_C, int payment, Timestamp date){

	
		this.id_C = id_C;
		this.id_Sale = id_Sale; 
		this.payment = payment; 
	    this.date = date;  
	}

	
	public double getPayment(){
		
	return payment;
	}
	
	public Timestamp getDate(){
		
	return date; 	
	
	}
	
	public String getid_C(){
		
		return id_C; 	
		}
	
	public String getid_Sale(){
		
		return id_Sale; 	
		}
	
	

}//fn
