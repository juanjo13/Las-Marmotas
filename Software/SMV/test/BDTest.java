/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;
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
    @Test
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
    @Test
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
    
}
