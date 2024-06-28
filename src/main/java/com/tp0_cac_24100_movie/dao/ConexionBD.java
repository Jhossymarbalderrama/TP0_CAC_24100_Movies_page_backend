package com.tp0_cac_24100_movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    /**
     *  Metodo para establecer una conexion a la base de datos 'tp_cac_24100_movies'
     * @return connection (conexion)
     */
    public static Connection connect(){
        // ! Params
        //#region
        String nameBD = "tp_cac_24100_movies";
        String urlConexion = "jdbc:mysql://127.0.0.1:3306/" + nameBD + "?serverTimeZone=UTC&userSSL=false";
        String user = "root";
        String pass = "root";        
        String driver = "com.mysql.cj.jdbc.Driver";
        //#endregion

        Connection connection = null;
        
        try {           
            Class.forName(driver); // ? instancia una conexion            
            connection = DriverManager.getConnection(urlConexion, user, pass); //  ! Establesco la conexion
        } catch (Exception e) {
           System.out.println("No se ha podido conectar a la db: " + e.toString());
        }

        return connection;
    }


    /**
     * Metodo para desconectar una conexion a una base de datos de tipo Connection
     * @param connection
     */
    public static void disconnect(Connection connection){
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
