/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.mycompany.trabajointegrador;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author marti
 */
public class LectorArchivo {
    
    private String rutaResultados;
    private String rutaPronostico;
    private List<Partido> partidosJugados;
    private List<Pronostico> pronosticoPartidos;
    
    public void compararArchivos(String resultados, String pronostico) {
        this.rutaResultados = resultados;
        this.rutaPronostico = pronostico;
    }
    
    public void parsearArchivo() {
        
        List<Partido> listaDePartidos = null;
        List<Pronostico> listaDePronosticos = null;
        
        try {
            listaDePartidos = new CsvToBeanBuilder(new FileReader(this.rutaResultados))
                    .withSkipLines(1)
                    .withSeparator(';')
                    .withType(Partido.class)
                    .build()
                    .parse();
            listaDePronosticos = new CsvToBeanBuilder(new FileReader(this.rutaPronostico))
                    .withSkipLines(1)
                    .withSeparator(';')
                    .withType(Pronostico.class)
                    .build()
                    .parse();

        } catch (IOException e) {
        e.printStackTrace();
        }
        
        //System.out.println(listaDePartidos.size());
        //System.out.println(listaDePronosticos.size());
        
        this.partidosJugados = listaDePartidos;
        this.pronosticoPartidos = listaDePronosticos;
        
        /*asocia el partido en la posición i de la List partidosJugados al atributos 'partido' del
        objeto en la posición i de la List pronosticoPartidos*/
        for (int i = 0; i < this.partidosJugados.size(); i++) {
            
            this.pronosticoPartidos.get(i).setPartido(this.partidosJugados.get(i));
            System.out.println(this.pronosticoPartidos.get(i).getResultadoPartido());
            this.pronosticoPartidos.get(i).sacarResultado();
            
        }
        
        
//        for (Partido partidillo : this.partidosJugados) {
//            System.out.println(partidillo.getEquipo1() + partidillo.getEquipo2());
//            System.out.println(partidillo.resultado());
//        }
//        for (Pronostico pronostiquillo : this.pronosticoPartidos) {
//            System.out.println(pronostiquillo);
//        }
        
    }
    
    
    public int consultarResultado() {
        
        int puntaje = 0;
        
        for (int i= 0; i<this.pronosticoPartidos.size(); i++) {
            //System.out.println(this.pronosticoPartidos.get(i).getResultado());
            puntaje += this.pronosticoPartidos.get(i).puntos();
        }
        
        return puntaje;
        
    }
    
    /*getters y setters varios*/

    public String getRutaResultados() {
        return rutaResultados;
    }

    public void setRutaResultados(String rutaResultados) {
        this.rutaResultados = rutaResultados;
    }

    public String getRutaPronostico() {
        return rutaPronostico;
    }

    public void setRutaPronostico(String rutaPronostico) {
        this.rutaPronostico = rutaPronostico;
    }

    public List<Partido> getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(List<Partido> partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public List<Pronostico> getPronosticoPartidos() {
        return pronosticoPartidos;
    }

    public void setPronosticoPartidos(List<Pronostico> pronosticoPartidos) {
        this.pronosticoPartidos = pronosticoPartidos;
    }
    
    
    
}
