/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aide
 */
public class Rendimiento {
    private int Id_vehiculo;
    private int Id_rendimiento;
    private float Rendimiento;
    
    public Rendimiento(){
        Id_vehiculo=0;
        Id_rendimiento=0;
        Rendimiento=0;
    }
    public int getId_vehiculo() {
        return Id_vehiculo;
    }

    public void setId_vehiculo(int Id_vehiculo) {
        this.Id_vehiculo = Id_vehiculo;
    }
     public int getId_rendimiento() {
        return Id_rendimiento;
    }

    public void setId_rendimiento(int Id_rendimiento) {
        this.Id_rendimiento = Id_rendimiento;
    }
    public float getRendimiento() {
        return Rendimiento;
    }

    public void setRendimiento(float Rendimiento) {
        this.Rendimiento = Rendimiento;
    }

    
}
