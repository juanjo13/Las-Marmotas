
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aide
 */
public class Mantenimiento {
   
    private int Id_Mantenimiento;
    private int Id_Vehiculo;
    private String Tipo;
    private LocalDate Fecha;
    private int Estado;
    private float Km_recorrido;
    private float Km_realizado;
    
    
    public Mantenimiento(){
     Id_Mantenimiento=0;
     Id_Vehiculo=0;
     Tipo="";
     Estado=0;
     Km_recorrido=0;
     Km_realizado=0;
    }
    public int getId_Mantenimiento() {
        return Id_Mantenimiento;
    }

    public void setId_Mantenimiento(int Id_Mantenimiento) {
        this.Id_Mantenimiento = Id_Mantenimiento;
    }
    public int getId_Vehiculo() {
        return Id_Vehiculo;
    }

    public void setId_Vehiculo(int Id_Vehiculo) {
        this.Id_Vehiculo = Id_Vehiculo;
    }
    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    public LocalDate getFecha() {
        ZoneId zona = ZoneId.systemDefault();
        LocalDate date = LocalDate.now();
        return date;
    }

   
    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado =Estado;
    }
    public float getKm_recorrido() {
        return Km_recorrido;
    }

    public void setKm_recorrido(float Km_recorrido) {
        this.Km_recorrido = Km_recorrido;
    }
     public float getKm_realizado() {
        return Km_realizado;
    }

    public void setKm_realizado(float Km_realizado) {
        this.Km_realizado = Km_realizado;
    }
    
    
    
    
    

}
