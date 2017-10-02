
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aide
 */
public class BD {
    
    private Connection conexion;
    private Statement comando;


    @SuppressWarnings("empty-statement")
    public boolean Conectar(String host, String BD, String User, String Password) throws Exception {
        boolean con;
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            this.conexion = DriverManager.getConnection("jdbc:mysql://" + host+"/"+BD ,  User , Password);
            this.comando = conexion.createStatement();

            con = true;
        } catch (SQLException exc) {
            System.out.println("Error "+exc.toString());
            con = false;
        };

        return con;
    }
    
    public boolean agregarVehiculo(vehiculo mVehiculo) throws SQLException{
        try{
        String SQL = "insert into automovil values (null, '"+mVehiculo.getMarca() + "','"+ mVehiculo.getModelo() +
                "','" + mVehiculo.getAnio() + "','" + mVehiculo.getDesc_Extra() + "','" + mVehiculo.getKm_actual()+
                "','" + mVehiculo.getKm_recorr()+"','"+mVehiculo.getComb_actual()+"','"+ mVehiculo.getComb_gastado()+"');";
        ejecutarActualizacion(SQL);
        return true;
        }catch(Exception e){
            return false;
        }
    }

    public ResultSet ejecutarConsulta(String instruccionQL) throws SQLException {
        ResultSet resultado = this.comando.executeQuery(instruccionQL);
        return resultado;
    }

    
    public int ejecutarActualizacion(String instruccionDML) throws SQLException {
        int i;
        i = this.comando.executeUpdate(instruccionDML);
        System.out.println(instruccionDML + " Ejecutada");
        return i;
    }
    
}
