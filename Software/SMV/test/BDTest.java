/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juanj
 */
public class BDTest {
    
    public BDTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of Conectar method, of class BD.
     */
    //@Test
    public void testConectar() throws Exception {
        System.out.println("Conectar");
        BD mBd = new BD();
        boolean esperado = true;
        boolean resultado = mBd.Conectar();
        assertEquals(esperado, resultado);
       
    }

    /**
     * Test of agregarVehiculo method, of class BD.
     */
    //@Test
    public void testAgregarVehiculo() throws Exception {
        vehiculo mVehiculo = new vehiculo();
        BD mBd = new BD();
        mVehiculo.setMarca("chevrolte");
        mVehiculo.setModelo("123");
        mVehiculo.setKm_actual(50);
        mVehiculo.setKm_recorr(0);
        mVehiculo.setComb_actual(0);
        mVehiculo.setComb_gastado(0);
        mVehiculo.setAnio(1992);
        mVehiculo.setDesc_Extra("nada");
        mBd.Conectar();
        boolean esperado = true;
        boolean resultado = mBd.agregarVehiculo(mVehiculo);
        assertEquals(esperado, resultado);
    }
    /**
     * Test of ConsultaGeneral method, of class BD.
     */
    @Test
    public void testConsultaGeneral() throws Exception {
        System.out.println("ConsultaGeneral");
        BD mBD = new BD();
        mBD.Conectar();
        int esperado = 8;
        List<vehiculo> result = mBD.ConsultaGeneral();
        assertEquals(esperado, result.size());
    }

    /**
     * Test of ConsultaPorMarca method, of class BD.
     */
    @Test
    public void testConsultaPorMarca() throws Exception {
        System.out.println("ConsultaPorMarca");
        vehiculo mVehiculo = new vehiculo();
        mVehiculo.setMarca("Ford");
        BD mBD = new BD();
        mBD.Conectar();
        int esperado = 3;
        List<vehiculo> result = mBD.ConsultaPorMarca(mVehiculo);
        assertEquals(esperado, result.size());
    }

    /**
     * Test of ConsultaPorModelo method, of class BD.
     */
    @Test
    public void testConsultaPorModelo() throws Exception {
        System.out.println("ConsultaPorModelo");
        vehiculo mVehiculo = new vehiculo();
        mVehiculo.setModelo("sepa");
        BD mBD = new BD();
        mBD.Conectar();
        int esperado = 1;
        List<vehiculo> result = mBD.ConsultaPorModelo(mVehiculo);
        assertEquals(esperado, result.size());
    }

    /**
     * Test of ConsultaPorAnio method, of class BD.
     */
    @Test
    public void testConsultaPorAnio() throws Exception {
        System.out.println("ConsultaPorAnio");
        vehiculo mVehiculo = new vehiculo();
        mVehiculo.setAnio(1987);
        BD mBD = new BD();
        mBD.Conectar();
        int esperado = 2;
        List<vehiculo> result = mBD.ConsultaPorAnio(mVehiculo);
        assertEquals(esperado, result.size());
    }

    /**
     * Test of ConsultaMixta method, of class BD.
     */
    @Test
    public void testConsultaMixta() throws Exception {
        System.out.println("ConsultaMixta");
        vehiculo mVehiculo = new vehiculo();
        mVehiculo.setMarca("Nissan");
        mVehiculo.setModelo("sepa");
        mVehiculo.setAnio(1986);
        BD mBD = new BD();
        mBD.Conectar();
        int esperado = 1;
        List<vehiculo> result = mBD.ConsultaMixta(mVehiculo);
        assertEquals(esperado, result.size());
    }

    /**
     * Test of ConsultaMarcaModelo method, of class BD.
     */
    @Test
    public void testConsultaMarcaModelo() throws Exception {
        System.out.println("ConsultaMarcaModelo");
        vehiculo mVehiculo = new vehiculo();
        mVehiculo.setMarca("Chevrolet");
        mVehiculo.setModelo("pick up");
        BD mBD = new BD();
        mBD.Conectar();
        int esperado = 1;
        List<vehiculo> result = mBD.ConsultaMarcaModelo(mVehiculo);
        assertEquals(esperado, result.size());
    }

    /**
     * Test of ConsultaMarcaAnio method, of class BD.
     */
    @Test
    public void testConsultaMarcaAnio() throws Exception {
        System.out.println("ConsultaMarcaAnio");
        vehiculo mVehiculo = new vehiculo();
        mVehiculo.setMarca("Ford");
        mVehiculo.setAnio(1987);
        BD mBD = new BD();
        mBD.Conectar();
        int esperado = 1;
        List<vehiculo> result = mBD.ConsultaMarcaAnio(mVehiculo);
        assertEquals(esperado, result.size());;
    }

    /**
     * Test of ConsultaModeloAnio method, of class BD.
     */
    @Test
    public void testConsultaModeloAnio() throws Exception {
        System.out.println("ConsultaModeloAnio");
        vehiculo mVehiculo = new vehiculo();
        mVehiculo.setModelo("pick up");
        mVehiculo.setAnio(2000);
        BD mBD = new BD();
        mBD.Conectar();
        int esperado = 1;
        List<vehiculo> result = mBD.ConsultaModeloAnio(mVehiculo);
        assertEquals(esperado, result.size());
    }
    
}
