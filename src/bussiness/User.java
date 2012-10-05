/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bussiness;

/**
 *
 * @author Luc3
 */
public class User {

   String id_Usuario;
    String nombre;
    String usuario;
    String contrasena;
    String tipo_Perfil;


    public User(String id_Usuario, String usuario,String contrasena, String nombre, String tipo_Perfil) {

        this.id_Usuario = id_Usuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipo_Perfil = tipo_Perfil;
    }

      public User(String usuario,  String contrasena, String nombre, String tipo_Perfil) {

        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipo_Perfil = tipo_Perfil;
    }


    public String getIdUser(){
        return this.id_Usuario;
    }

    public String getName(){
        return this.nombre;
    }

    public String getUser(){
        return this.usuario;
    }

    public String getpassword(){
        return this.contrasena;
    }

    public String getProfileType(){
        return this.tipo_Perfil;
    }




}
