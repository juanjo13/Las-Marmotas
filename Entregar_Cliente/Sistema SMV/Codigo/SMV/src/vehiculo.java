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
    private String estado;
    private int identificador;
    private int anio;    
    private float Km_inicial;
    private float Km_recorr;
    private float Comb_actual;
    private float Comb_gastado;
    private String Desc_Extra;
    private float Km_carroceria;
    private float Km_neumaticos;
    private float Km_frenos;
    private float Km_afinacion;
    
    
    public vehiculo(){
        Marca = "";
        Modelo = "";
        anio = 0 ;
        Km_inicial = 0;
        Km_recorr = 0;
        Comb_actual = 0;
        Comb_gastado = 0;
        Desc_Extra = "";
        Km_carroceria=0;
        Km_frenos=0;
        Km_afinacion=0;
        Km_neumaticos=0;
        estado = "";
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public float getKm_inicial() {
        return Km_inicial;
    }

    public void setKm_inicial(float Km_actual) {
        this.Km_inicial = Km_actual;
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
    public float getKm_carroceria() {
        return Km_carroceria;
    }

    public void setKm_carroceria(float Km_carroceria) {
        this.Km_carroceria=Km_carroceria;
    }
    public float getKm_frenos() {
        return Km_frenos;
    }

    public void setKm_frenos(float Km_frenos) {
        this.Km_frenos=Km_frenos;
    }
    public float getKm_neumaticos() {
        return Km_neumaticos;
    }

    public void setKm_neumaticos(float Km_neumaticos) {
        this.Km_neumaticos=Km_neumaticos;
    }
    public float getKm_afinacion() {
        return Km_afinacion;
    }

    public void setKm_afinacion(float Km_afinacion) {
        this.Km_afinacion=Km_afinacion;
    }

}
