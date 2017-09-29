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
    private float Km_actual;
    private float Km_recorr;
    private float Comb_actual;
    private float Comb_gastado;
    private String Desc_Extra;
    
    public vehiculo(){
        Marca = "";
        Modelo = "";
        anio = 0 ;
        Km_actual = 0;
        Km_recorr = 0;
        Comb_actual = 0;
        Comb_gastado = 0;
        Desc_Extra = "";
    }

    public float getKm_actual() {
        return Km_actual;
    }

    public void setKm_actual(float Km_actual) {
        this.Km_actual = Km_actual;
    }

    public float getKm_recorr() {
        return Km_recorr;
    }

    public void setKm_recorr(float Km_recorr) {
        this.Km_recorr = Km_recorr;
    }

    public float getComb_actual() {
        return Comb_actual;
    }

    public void setComb_actual(float Comb_actual) {
        this.Comb_actual = Comb_actual;
    }

    public float getComb_gastado() {
        return Comb_gastado;
    }

    public void setComb_gastado(float Comb_gastado) {
        this.Comb_gastado = Comb_gastado;
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
