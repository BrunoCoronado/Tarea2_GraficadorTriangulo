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
    public void IngresoDatos()
    {
        Scanner scanner = new Scanner(System.in);          
        Integer NoLineas=0;
        
        System.out.println("Ingrese el numero de lineas:      NUMERO 0 PARA SALIR");
        
        do
        {        
            try {
                NoLineas = scanner.nextInt();
                if(NoLineas<0){
                    System.out.println("SOLO NUMEROS POSITIVOS");
                    IngresoDatos();
                }
                switch(NoLineas){
                    case 0:
                        System.exit(0);
                    default:                        
                        Graficar(NoLineas);
                }                       
            } catch (Exception e) {
                System.out.println("Ingrese solo numeros");
                IngresoDatos();
            }
        }while(NoLineas!=0);
    }

    private void Graficar(int noLineas) {
        
        StringBuffer lineas = new StringBuffer();
        StringBuffer ultimaLinea = new StringBuffer();
        
        lineas.append("/");
        ultimaLinea.append(" /\\");

        boolean espacioInicial = true;        
        int contador;
        int contadorEspacio=0;

        for(contador=0;contador<(noLineas-1);contador++)
        {
            while (espacioInicial) 
            {                
                for(contadorEspacio=0;contadorEspacio<noLineas;contadorEspacio++){
                    lineas.insert(0," ");
                    espacioInicial=false;
                }
            }     

            System.out.println(lineas+"\\");  
            lineas.append("  ");
            lineas.delete(0,1);            
        }

        if(noLineas!=1)
        {           
            for(int i=0;i<=(contadorEspacio-2);i++)
            {
                ultimaLinea.insert(2,"_");
                ultimaLinea.insert(2,"_");
            }
            System.out.println(ultimaLinea);         
        }
        else
        {
            System.out.println("/_\\");
        }     
           IngresoDatos();
    }
}
