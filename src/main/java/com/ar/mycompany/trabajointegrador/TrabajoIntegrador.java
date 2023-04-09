/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ar.mycompany.trabajointegrador;

/**
 *
 * @author marti
 */
public class TrabajoIntegrador {

    public static void main(String[] args) {
        
        LectorArchivo lectorArchivos = new LectorArchivo();
        String miRutaDeResultados = "C:\\Users\\marti\\OneDrive\\Escritorio\\resultados.csv";
        String miRutaDePronostico = "C:\\Users\\marti\\OneDrive\\Escritorio\\pronostico.csv";
        
        lectorArchivos.compararArchivos(miRutaDeResultados, miRutaDePronostico);
        lectorArchivos.parsearArchivo();
     
        System.out.println(lectorArchivos.consultarResultado());
        
    }

}
