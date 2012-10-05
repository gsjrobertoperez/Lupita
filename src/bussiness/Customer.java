package bussiness;

public class Customer  {

    String id_C;
    String name = "";
    String l_name = "";
    String address = "";
    String phone = "";
    String type = "";
    Integer l_payment;

    public Customer() {
        name = "";
        l_name = "";
        address = "";
        phone = "";
    }

    
    public Customer(String name, String l_name, String address, String phone){
       
        this.name = name; 
        this.l_name = l_name;
        this.address = address; 
        this.phone = phone; 
        
    }
    
    
    
    public Customer(String id_C, String name, String l_name, String address, String phone, String type, Integer l_payment) {

        this.id_C = id_C;
        this.name = name;
        this.l_name = l_name;
        this.address = address;
        this.phone = phone;
        this.type = type;
        this.l_payment = l_payment;
    }

    public String getid_C() {

        return id_C;
    }

    public String getName() {

        return name;
    }

    public String getl_Name() {

        return l_name;
    }

    public String getAddress() {

        return address;
    }

    public String getPhone() {

        return phone;
    }
    
    public Integer getLastPayment(){
        return l_payment;
    }

    public String getType(){
        return type;
    }
}
