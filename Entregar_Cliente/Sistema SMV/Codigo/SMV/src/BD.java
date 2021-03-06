
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
            //+"');";
        String SQL = "insert into automovil values (null, '"+mVehiculo.getMarca() + "','"+ mVehiculo.getModelo() +
                "','" + mVehiculo.getAnio() + "','" + mVehiculo.getDesc_Extra() + "','" + mVehiculo.getKm_inicial()+
                "','" + mVehiculo.getKm_recorr()+"','"+mVehiculo.getComb_actual()+"','"+ mVehiculo.getComb_gastado()+"','"+
                mVehiculo.getKm_carroceria()+"','"+mVehiculo.getKm_neumaticos()+"','"+mVehiculo.getKm_frenos()+
                "','"+mVehiculo.getKm_afinacion()+"','" + mVehiculo.getEstado() +"');";
        ejecutarActualizacion(SQL);
        return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean Vehiculo_inactivo(vehiculo mVehiculo) throws SQLException{
        try{
        String SQL = "update automovil set estado='inactivo' where idAutomovil = "+mVehiculo.getIdentificador()+";";
        ejecutarActualizacion(SQL);
        return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean EliminarVehiculo(vehiculo mVehiculo) throws SQLException{
        try{
        String SQL = "delete from automovil where idAutomovil = "+mVehiculo.getIdentificador()+";";
        ejecutarActualizacion(SQL);
        return true;
        }catch(Exception e){
            return false;
        }
    }
    public List<vehiculo> ConsultaGeneral()throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            vehiculo mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setKm_carroceria(consulta.getFloat("km_carroceria"));
            mVehiculo.setKm_neumaticos(consulta.getFloat("km_neumaticos"));
            mVehiculo.setKm_frenos(consulta.getFloat("km_frenos"));
            mVehiculo.setKm_afinacion(consulta.getFloat("km_afinacion"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //consulta de vehiculo por id
    public List<vehiculo> ConsultaAutomovil(int id)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where idAutomovil ="+id+";";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            vehiculo mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setKm_carroceria(consulta.getFloat("km_carroceria"));
            mVehiculo.setKm_neumaticos(consulta.getFloat("km_neumaticos"));
            mVehiculo.setKm_frenos(consulta.getFloat("km_frenos"));
            mVehiculo.setKm_afinacion(consulta.getFloat("km_afinacion"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    public List<vehiculo> ConsultaInactivos()throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where estado='inactivo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            vehiculo mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setKm_carroceria(consulta.getFloat("km_carroceria"));
            mVehiculo.setKm_neumaticos(consulta.getFloat("km_neumaticos"));
            mVehiculo.setKm_frenos(consulta.getFloat("km_frenos"));
            mVehiculo.setKm_afinacion(consulta.getFloat("km_afinacion"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    public List<vehiculo> ConsultaActivos()throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where estado='activo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            vehiculo mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setKm_carroceria(consulta.getFloat("km_carroceria"));
            mVehiculo.setKm_neumaticos(consulta.getFloat("km_neumaticos"));
            mVehiculo.setKm_frenos(consulta.getFloat("km_frenos"));
            mVehiculo.setKm_afinacion(consulta.getFloat("km_afinacion"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    
    
    
    //Buscar por Marca
    public List<vehiculo> ConsultaPorMarca(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where marca='" + mVehiculo.getMarca() + "' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    
    //Buscar por Marca en vehiculos activos
    public List<vehiculo> ConsultaPorMarca_Activos(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where marca='" + mVehiculo.getMarca() + "' and estado = 'activo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    
    //Buscar por marca en vehiculos inactivos
    public List<vehiculo> ConsultaPorMarca_Inactivos(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where marca='" + mVehiculo.getMarca() + "' and estado = 'inactivo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por Modelo
    public List<vehiculo> ConsultaPorModelo(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where modelo='" + mVehiculo.getModelo() + "' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    
    //Buscar por Modelo en vehiculos activos
    public List<vehiculo> ConsultaPorModelo_Activos(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where modelo='" + mVehiculo.getModelo() + "' and estado = 'activo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por Modelo en vehiculos inactivos
    public List<vehiculo> ConsultaPorModelo_Inactivos(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where modelo='" + mVehiculo.getModelo() + "' and estado='inactivo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    
    //Buscar por Año
    public List<vehiculo> ConsultaPorAnio(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where anio='" + mVehiculo.getAnio() + "' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por Año en vehiculos activos
    public List<vehiculo> ConsultaPorAnio_Activos(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where anio='" + mVehiculo.getAnio() + "' and estado='activo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por Año en vehiculos inactivos
    public List<vehiculo> ConsultaPorAnio_Inactivos(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where anio='" + mVehiculo.getAnio() + "' and estado = 'inactivo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    
    //Buscar por Marca, Modelo y Año
    public List<vehiculo> ConsultaMixta(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where anio='" + mVehiculo.getAnio() + "' and marca='" + mVehiculo.getMarca()+
                "' and modelo='" + mVehiculo.getModelo() +"' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por Marca, Modelo y Año en vehiculos activos
    public List<vehiculo> ConsultaMixta_Activos(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where anio='" + mVehiculo.getAnio() + "' and marca='" + mVehiculo.getMarca()+
                "' and modelo='" + mVehiculo.getModelo() +"' and estado = 'activo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por Marca, Modelo y Año en vehiculos en inactivos
    public List<vehiculo> ConsultaMixta_Inactivos(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where anio='" + mVehiculo.getAnio() + "' and marca='" + mVehiculo.getMarca()+
                "' and modelo='" + mVehiculo.getModelo() +"' and estado = 'inactivo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por marca modelo 
    public List<vehiculo> ConsultaMarcaModelo(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where marca='" + mVehiculo.getMarca() + "' and modelo='" + mVehiculo.getModelo()+"' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por marca modelo en vehiculos activos 
    public List<vehiculo> ConsultaMarcaModelo_Activos(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where marca='" + mVehiculo.getMarca() + "' and modelo='" + mVehiculo.getModelo()+"' and estado = 'activo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por marca modelo en vehiculos inactivos
    public List<vehiculo> ConsultaMarcaModelo_Inactivos(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where marca='" + mVehiculo.getMarca() + "' and modelo='" + mVehiculo.getModelo()+"' and estado = 'inactivo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    
    //Buscar por marca año
    public List<vehiculo> ConsultaMarcaAnio(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where marca='" + mVehiculo.getMarca() + "' and anio='" + mVehiculo.getAnio()+"' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por marca año en vehiculos activos
    public List<vehiculo> ConsultaMarcaAnio_Activos(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where marca='" + mVehiculo.getMarca() + "' and anio='" + mVehiculo.getAnio()+"' and estado = 'activo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por marca año en vehiculos inactivos
    public List<vehiculo> ConsultaMarcaAnio_Inactivos(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where marca='" + mVehiculo.getMarca() + "' and anio='" + mVehiculo.getAnio()+"' and estado = 'inactivo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    
    //Buscar por modelo año
    public List<vehiculo> ConsultaModeloAnio(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where modelo='" + mVehiculo.getModelo() + "' and anio='" + mVehiculo.getAnio()+"' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por modelo año en vehiculos activos
    public List<vehiculo> ConsultaModeloAnio_Activos(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where modelo='" + mVehiculo.getModelo() + "' and anio='" + mVehiculo.getAnio()+"' and estado = 'activo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    //Buscar por modelo año en vehiculos inactivos
    public List<vehiculo> ConsultaModeloAnio_Inactivos(vehiculo mVehiculo)throws SQLException{
        List<vehiculo> ListaVehiculos = new ArrayList();
        String SQL = "select * from automovil where modelo='" + mVehiculo.getModelo() + "' and anio='" + mVehiculo.getAnio()+"' and estado = 'inactivo' order by marca, modelo, anio desc;";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
            ListaVehiculos.add(mVehiculo);
        }
        return ListaVehiculos;
    }
    
    
    public vehiculo ConsultaReporte(int id)throws SQLException{
        vehiculo mVehiculo = new vehiculo();
        String SQL = "select * from automovil where idAutomovil=" + id + ";";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setIdentificador(consulta.getInt("idAutomovil"));
            mVehiculo.setMarca(consulta.getString("Marca"));
            mVehiculo.setModelo(consulta.getString("Modelo"));
            mVehiculo.setAnio(consulta.getInt("Anio"));
            mVehiculo.setDesc_Extra(consulta.getString("Desc_Extra"));
            mVehiculo.setKm_inicial(consulta.getFloat("Kilometraje_Actual"));
            mVehiculo.setKm_recorr(consulta.getFloat("Kilometraje_Recorrido"));
            mVehiculo.setComb_actual(consulta.getFloat("Combustible_Actual"));
            mVehiculo.setComb_gastado(consulta.getFloat("Combustible_Gastado"));
            mVehiculo.setEstado(consulta.getString("estado"));
        }
        
        return mVehiculo;
    }
    
    //Consulta de mantenimientos realizados
    public List<Mantenimiento> ConsultaMantimiento(int id)throws SQLException{
        List<Mantenimiento> ListaMantenimientos = new ArrayList();
        Mantenimiento mMantenimiento = new Mantenimiento();
        String SQL = "select Tipo, Fecha from mantenimiento where automovil_idAutomovil=" + id + ";";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mMantenimiento = new Mantenimiento();
            mMantenimiento.setTipo(consulta.getString("Tipo"));
            mMantenimiento.setFecha_consulta(consulta.getString("Fecha"));
            ListaMantenimientos.add(mMantenimiento);
        }
        
        return ListaMantenimientos;
    }
    //consultar ultimo rendimiento calculado
    public float ConsultaRendimiento(int id)throws SQLException{
        Rendimiento mRendi = new Rendimiento();
        String SQL = "select Rendimiento from rendimiento where automovil_idAutomovil=" + id + ";";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mRendi = new Rendimiento();
            mRendi.setRendimiento(consulta.getFloat("Rendimiento"));
        }
        
        return mRendi.getRendimiento();
    }
    
    //Consulta del estado del vehiculo
    public String ConsultaEstado(int id)throws SQLException{
        vehiculo mVehiculo = new vehiculo();
        String SQL = "select estado from automovil where idAutomovil=" + id + ";";
        ResultSet consulta = ejecutarConsulta(SQL);
        while(consulta.next()){
            mVehiculo = new vehiculo();
            mVehiculo.setEstado(consulta.getString("estado"));
        }
        
        return mVehiculo.getEstado();
    }
    public ResultSet ConsultarMarcas() throws SQLException{
        String sql = "select distinct marca from automovil order by marca";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    public ResultSet ConsultarModelos() throws SQLException{
        String sql = "select distinct modelo from automovil order by modelo";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    public ResultSet ConsultarAnios() throws SQLException{
        String sql = "select distinct anio from automovil order by anio desc;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    public ResultSet ConsultarMarcas_Activos() throws SQLException{
        String sql = "select distinct marca from automovil where estado='activo' order by marca;" ;
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    
    public ResultSet ConsultarMarcas_Activosa(String anyo) throws SQLException{
        String sql = "select distinct marca from automovil where anio = '" + anyo + "' and estado='activo' order by marca;" ;
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    
    public ResultSet ConsultarMarcas_ActivosM(String modelo) throws SQLException{
        String sql = "select distinct marca from automovil where modelo = '" + modelo + "' and estado='activo' order by marca;" ;
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    
    public ResultSet ConsultarModelos_Activos() throws SQLException{

        String sql = "select distinct modelo from automovil where estado='activo' order by modelo;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    
    public ResultSet ConsultarModelos_ActivosM(String marca) throws SQLException{
        
        String sql = "select distinct modelo from automovil where marca = '"+ marca +"' and estado='activo' order by modelo;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    //consultar modelos de vehiculos inactivos coincidentes con la marca
    public ResultSet ConsultarModelos_InactivosM(String marca) throws SQLException{
        
        String sql = "select distinct modelo from automovil where marca = '"+ marca +"' and estado='inactivo' order by modelo;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    //consultar modelos de vehiculos  coincidentes con la marca
    public ResultSet ConsultarModelos_M(String marca) throws SQLException{
        
        String sql = "select distinct modelo from automovil where marca = '"+ marca +"' order by modelo;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    //Consultar modelos que coinciden con la marca y año de automoviles activos
    public ResultSet ConsultarModelos_ActivosMA(String marca, String anyo) throws SQLException{
        
        String sql = "select distinct modelo from automovil where marca = '"+ marca +"' and anio = '"+ anyo +"'  and estado='activo' order by modelo;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    public ResultSet ConsultarModelos_ActivosMo(String anyo) throws SQLException{
        
        String sql = "select distinct modelo from automovil where anio = '"+ anyo +"' and estado='activo' order by modelo;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    
    public ResultSet ConsultarAnios_Activos() throws SQLException{
        String sql = "select distinct anio from automovil where estado='activo' order by anio desc;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    
    public ResultSet ConsultarAnios_ActivosM(String modelo) throws SQLException{
        String sql = "select distinct anio from automovil where modelo = '"+ modelo +"' and estado='activo' order by anio desc;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    //consultar años que coinciden con la marca y modelo de automoviles activos
    public ResultSet ConsultarAnios_ActivosMM(String modelo, String marca) throws SQLException{
        String sql = "select distinct anio from automovil where modelo = '"+ modelo +"' and marca = '"+ marca +"' and estado='activo' order by anio desc;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    //consultar años que coinciden con la marca y modelo de automoviles inactivos
    public ResultSet ConsultarAnios_InactivosMM(String modelo, String marca) throws SQLException{
        String sql = "select distinct anio from automovil where modelo = '"+ modelo +"' and marca = '"+ marca +"' and estado='inactivo' order by anio desc;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    //consultar años que coinciden con la marca y modelo de automoviles 
    public ResultSet ConsultarAnios_MM(String modelo, String marca) throws SQLException{
        String sql = "select distinct anio from automovil where modelo = '"+ modelo +"' and marca = '"+ marca +"' order by anio desc;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    
    public ResultSet ConsultarAnios_ActivosA(String marca) throws SQLException{
        String sql = "select distinct anio from automovil where marca = '"+ marca +"' and estado='activo' order by anio desc;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    //Consultar años de vehiculos inactivos que coinciden con la marca
    public ResultSet ConsultarAnios_InactivosA(String marca) throws SQLException{
        String sql = "select distinct anio from automovil where marca = '"+ marca +"' and estado='inactivo' order by anio desc;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    //Consultar años de vehiculos  que coinciden con la marca
    public ResultSet ConsultarAnios_A(String marca) throws SQLException{
        String sql = "select distinct anio from automovil where marca = '"+ marca +"' order by anio desc;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    
    public ResultSet ConsultarMarcas_Inactivos() throws SQLException{
        String sql = "select distinct marca from automovil where estado='inactivo' order by marca;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    public ResultSet ConsultarModelos_Inactivos() throws SQLException{
        String sql = "select distinct modelo from automovil where estado='inactivo' order by modelo;";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
    public ResultSet ConsultarAnios_Inactivos() throws SQLException{
        String sql = "select distinct anio from automovil where estado='inactivo' order by anio desc;";
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
    public boolean agregarKilometraje(vehiculo mVehiculo) throws SQLException{
        try{
        String SQL = "update automovil set  Kilometraje_Recorrido= Kilometraje_Recorrido+" + mVehiculo.getKm_recorr() +
                ", km_carroceria=km_carroceria+"+mVehiculo.getKm_recorr()+
                ", km_neumaticos=km_neumaticos+"+mVehiculo.getKm_recorr()+
                ", km_frenos=km_frenos+"+mVehiculo.getKm_recorr()+
                ", km_afinacion=km_afinacion+"+mVehiculo.getKm_recorr()+
                "where idAutomovil=" + mVehiculo.getIdentificador() + ";";
        ejecutarActualizacion(SQL);
        return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean actualizarVehiculo(vehiculo mVehiculo) throws SQLException{
        try{
        String SQL = "update automovil set Marca= '" + mVehiculo.getMarca() 
                + "', Modelo= '" + mVehiculo.getModelo() + "', Anio= '" 
                + mVehiculo.getAnio() + "', Desc_Extra= '" + mVehiculo.getDesc_Extra() +
                "', estado= '" + mVehiculo.getEstado() + "' where idAutomovil='" 
                + mVehiculo.getIdentificador() +"';";
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
    public float combustibleGastado(vehiculo mVehiculo) throws SQLException {
      //  float combustible=0;
        
        try{
        String SQL = "select combustible_gastado from automovil where idAutomovil'"  + mVehiculo.getIdentificador() +"';";
       ResultSet combustible= this.ejecutarConsulta(SQL);
       float com=0;
       com = combustible.getFloat(1);
       return com;
        }catch(Exception e){
            return 0;
        }
    }
         public boolean regRendimiento(Rendimiento mRendimiento) throws SQLException{
        try{
        
            String SQL = "select idRendimiento from rendimiento where Automovil_idAutomovil='"  + mRendimiento.getId_vehiculo() +"';";
        ResultSet consulta = ejecutarConsulta(SQL);
         int com=0;
        if(consulta.next()){
         com = consulta.getInt(1);
        }
            
          if(com!=0){
              SQL = "update  rendimiento set Rendimiento = "+mRendimiento.getRendimiento() +
                "where idRendimiento=" + com +";";
              ejecutarActualizacion(SQL);
              return true;
          }else{ 
        SQL = "insert into rendimiento values (null, '"+mRendimiento.getId_vehiculo() + "','"+ mRendimiento.getRendimiento()+"');";
        ejecutarActualizacion(SQL);
        return true;
        
        }
        }catch(Exception e){
            return false;
    } 
    }
      
       public ResultSet ConskmCarroceria(vehiculo mVehiculo) throws SQLException{
        String sql = "select km_carroceria from automovil where idAutomovil="  + mVehiculo.getIdentificador() +";";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
       public ResultSet ConskmNeumaticos(vehiculo mVehiculo) throws SQLException{
        String sql = "select km_neumaticos from automovil where idAutomovil="  + mVehiculo.getIdentificador() +";";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
       public ResultSet ConskmFrenos(vehiculo mVehiculo) throws SQLException{
        String sql = "select km_frenos from automovil where idAutomovil="  + mVehiculo.getIdentificador() +";";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
       public ResultSet ConskmAfinacion(vehiculo mVehiculo) throws SQLException{
        String sql = "select km_afinacion from automovil where idAutomovil="  + mVehiculo.getIdentificador() +";";
        ResultSet resultado = ejecutarConsulta(sql);
        return resultado;
    }
     
    

    public int ejecutarActualizacion(String instruccionDML) throws SQLException {
        int i;
        i = this.comando.executeUpdate(instruccionDML);
        System.out.println(instruccionDML + " Ejecutada");
        return i;
    }
    public boolean RegisMantenimientos(Mantenimiento mMantenimiento,vehiculo mVehiculo,int a,int s,int n,int c,float ka,float ks, float kc, float kn) throws SQLException{
        try{
         if(a==1){  
        String SQL = "insert into mantenimiento values (null,"+ mMantenimiento.getId_Vehiculo()+
                ",'a','"+mMantenimiento.getFecha()+"',1,"+ mMantenimiento.getKm_recorrido()+
                ","+ka+");";
                
        ejecutarActualizacion(SQL);
        SQL="update automovil set km_afinacion=0 where idAutomovil="+mVehiculo.getIdentificador()+";";
        ejecutarActualizacion(SQL);
     
         }  
         if (s==1){
            String   SQL = "insert into mantenimiento values (null,"+ mMantenimiento.getId_Vehiculo()+
                ",'s','"+mMantenimiento.getFecha()+"',1,"+ mMantenimiento.getKm_recorrido()+
                ","+ks+");";
                
        ejecutarActualizacion(SQL);
        SQL="update automovil set km_frenos=0 where idAutomovil="+mVehiculo.getIdentificador()+";";
        ejecutarActualizacion(SQL); 
         }
          if(n==1){
                  String  SQL = "insert into mantenimiento values (null,"+ mMantenimiento.getId_Vehiculo()+
                ",'n','"+mMantenimiento.getFecha()+"',1,"+ mMantenimiento.getKm_recorrido()+
                ","+kn+");";
                
        ejecutarActualizacion(SQL);
        SQL="update automovil set km_neumaticos=0 where idAutomovil="+mVehiculo.getIdentificador()+";";
        ejecutarActualizacion(SQL);
          }
         if(c==1){
                  String  SQL = "insert into mantenimiento values (null,"+ mMantenimiento.getId_Vehiculo()+
                ",'c','"+mMantenimiento.getFecha()+"',1,"+ mMantenimiento.getKm_recorrido()+
                ","+kc+");";
                
        ejecutarActualizacion(SQL);
        SQL="update automovil set km_carroceria=0 where idAutomovil="+mVehiculo.getIdentificador()+";";
        ejecutarActualizacion(SQL);
             
         }
         return true;
        }catch(Exception e){
            return false;
        
    }
    }
}
        
        
  
