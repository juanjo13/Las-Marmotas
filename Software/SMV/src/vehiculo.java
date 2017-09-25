/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanj
 */
public class vehiculo {
    private String Marca;
    private String Modelo;
    private int anio;
    private String Desc_Extra;
    
    public vehiculo(){
        Marca = "";
        Modelo = "";
        anio = 0 ;
        Desc_Extra = "";
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDesc_Extra() {
        return Desc_Extra;
    }

    public void setDesc_Extra(String Desc_Extra) {
        this.Desc_Extra = Desc_Extra;
    }
    
}
