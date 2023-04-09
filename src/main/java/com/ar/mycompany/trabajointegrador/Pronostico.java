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
public class Pronostico {
    
    private Partido partido;
    private Equipo equipo;
    @CsvBindByPosition(position = 1)
    private String gana1;
    @CsvBindByPosition(position = 2)
    private String empate;
    @CsvBindByPosition(position = 3)
    private String gana2;
    private ResultadoEnum resultado;
    
    
    public int puntos() {
        if (this.resultado==this.partido.resultado()) {
            return 1;
        }
        else {
            return 0;
        }
   }
    
    public void sacarResultado() {
        if (this.gana1.equals("x")) {
            this.resultado = ResultadoEnum.ganador;
        } else if (this.empate.equals("x")) {
            this.resultado = ResultadoEnum.empate;
        } else {
            this.resultado = ResultadoEnum.perdedor;
        }
    }
    
    
    /*getters y setters varios*/
    
    public Partido getPartido() {
        return partido;
    }
    
    public ResultadoEnum getResultadoPartido() {
        return this.partido.resultado();
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }
    
    
    
}
