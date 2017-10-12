
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public boolean Conectar() throws Exception {
        String host = "localhost";
        String BD = "smv";
        String User = "root";
        String Password = "";
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
    public List<vehiculo> ConsultaGeneral()throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            vehiculo mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_actual(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por Marca
    public List<vehiculo> ConsultaPorMarca(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where marca='" + mVehiculo.getMarca() + "';";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_actual(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por Modelo
    public List<vehiculo> ConsultaPorModelo(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where modelo='" + mVehiculo.getModelo() + "';";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_actual(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    
    //Buscar por Año
    public List<vehiculo> ConsultaPorAnio(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where anio='" + mVehiculo.getAnio() + "';";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_actual(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por Marca, Modelo y Año
    public List<vehiculo> ConsultaMixta(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where anio='" + mVehiculo.getAnio() + "' and marca='" + mVehiculo.getMarca()+
                "' and modelo='" + mVehiculo.getModelo() +"';";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_actual(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    
    public List<vehiculo> ConsultaMarcaModelo(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where marca='" + mVehiculo.getMarca() + "' and modelo='" + mVehiculo.getModelo()+"';";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_actual(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    public List<vehiculo> ConsultaMarcaAnio(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where marca='" + mVehiculo.getMarca() + "' and anio='" + mVehiculo.getAnio()+"';";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_actual(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    public List<vehiculo> ConsultaModeloAnio(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where modelo='" + mVehiculo.getModelo() + "' and anio='" + mVehiculo.getAnio()+"';";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_actual(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    public ResultSet ConsultarMarcas() throws SQLException{
        String sql = "select distinct marca from automovil";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    public ResultSet ConsultarModelos() throws SQLException{
        String sql = "select distinct modelo from automovil";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    public ResultSet ConsultarAnios() throws SQLException{
        String sql = "select distinct anio from automovil";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }

    public boolean agregarCombustibleGastado(vehiculo mVehiculo) throws SQLException{
        try{
            //update automovil set combustibe_actual=combustibe_actual-10, combustible_gastado=combustible_gastado+10 
            //where idAutomovil=16
        String SQL = "update automovil set combustible_actual=combustible_actual- '"+mVehiculo.getComb_gastado() + "',combustible_gastado=combustible_gastado+'"+ mVehiculo.getComb_gastado() +
                "'where idAutomovil='" + mVehiculo.getIdentificador() +"';";
        ejecutarActualizacion(SQL);
        return true;
        }catch(Exception e){
            return false;
        }
    }
        public boolean cargarCombustible(vehiculo mVehiculo) throws SQLException{
        try{
            //update automovil set combustibe_actual=combustibe_actual-10, combustible_gastado=combustible_gastado+10 
            //where idAutomovil=16
        String SQL = "update  automovil set combustible_actual=combustible_actual+ '"+mVehiculo.getComb_gastado() +
                "'where idAutomovil='" + mVehiculo.getIdentificador() +"';";
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
