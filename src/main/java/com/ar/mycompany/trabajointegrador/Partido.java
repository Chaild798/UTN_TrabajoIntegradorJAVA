/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.mycompany.trabajointegrador;

import com.opencsv.bean.CsvBindByPosition;

/**
 *
 * @author marti
 */
public class Partido {
    
    @CsvBindByPosition(position = 0)
    private String equipo1;
    @CsvBindByPosition(position = 3)
    private String equipo2;
    
    @CsvBindByPosition(position = 1)
    private int golesEquipo1;
    @CsvBindByPosition(position = 2)
    private int golesEquipo2;
    
    public ResultadoEnum resultado() {
        if (this.golesEquipo1 > this.golesEquipo2) {
            return ResultadoEnum.ganador;
        }
        else if (golesEquipo1 == golesEquipo2) {
            return ResultadoEnum.empate;
        }
        else {
            return ResultadoEnum.perdedor;
        }
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }
    
    
}
