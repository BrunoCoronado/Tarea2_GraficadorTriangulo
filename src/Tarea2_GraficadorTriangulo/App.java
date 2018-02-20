/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea2_GraficadorTriangulo;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class App {
    /*Obtener el numero y analizarlo*/
    public void IngresoDatos()
    {
        Scanner scanner = new Scanner(System.in);          
        int NoLineas=0;
        
        System.out.println("Ingrese el numero de lineas:      NUMERO 0 PARA SALIR");
            
        //Try/Catch para controlar el ingreso de caracteres no permitidos
        try {
            
            //Obtener el numero
            NoLineas = scanner.nextInt();
            if(NoLineas<0){
                System.out.println("SOLO NUMEROS POSITIVOS");
                //Recursividad para volver a pedir el ingreso de datos
                IngresoDatos();
            }
            switch(NoLineas){
                case 0:
                    //salir del sistema, segun la opcion elegida por el usuario
                    System.exit(0);
                default:                        
                    Graficar(NoLineas);
            }                       
            //controlando caracteres no permitidos
        } catch (Exception e) {
            System.out.println("Ingrese solo numeros");
            //Recursividad para volver a pedir el ingreso de datos
            IngresoDatos();
        }
    }

    private void Graficar(int noLineas) {
       /*tipo de dato que tiene los metodos append, delete e insert para agregar, eliminar o insetar caracteres
       en ciertas posiciones dentro de la linea de caracteres*/
       StringBuffer lineas = new StringBuffer();
        
       lineas.append("/");

        boolean espacioInicial = true;
        
        //Ciclo para imprimir las lineas de caracteres
        for(int contador=0;contador<noLineas;contador++)
        {
            //ciclo para dejar espacio del borde
            while (espacioInicial) 
            {                
                for(int contadorEspacio=0;contadorEspacio<noLineas;contadorEspacio++){
                    lineas.insert(0," ");
                }                
                espacioInicial=false;
            }     
            //imprimir las lineas de caracteres
            System.out.println(lineas+"\\");  
            lineas.append("/\\");
            lineas.delete(0,1);            
        }
        //recursividad para volver a iniciar el programa
        IngresoDatos();
    }
}
