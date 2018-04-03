package com.sigma.tactics;

import com.sigma.battleship.Barco;
import com.sigma.battleship.Coordenada;
import com.sigma.battleship.DatosRonda;
import com.sigma.battleship.Disparo;
import com.sigma.battleship.ResultadoDisparo;
import com.sigma.battleship.defaultplayers.ITactica;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MyTactic implements ITactica {

    private DatosRonda datosRonda;
    private tablero tablero;
    private Coordenada coordenadaADisparar;
    static int[][] tabcolbar;
    static ArrayList<Barco> barcos=new ArrayList<Barco>();
    @Override
    public void inicializarTactica(DatosRonda datosRonda) {
        this.datosRonda = datosRonda;
        tablero = new tablero(datosRonda.getTamanoX(), datosRonda.getTamanoY());
        tabcolbar = tablero.getTablero().clone();
    }

    @Override
    public List<Barco> generarBarcos() {
        
  
         for (int i = 0; i < tablero.sizeX; i++) {
            for (int e = 0; e < tablero.sizeY; e++) {
                tabcolbar[i][e]=0;
        
            }
         }       
        
        int numb2 = this.datosRonda.getBarcos2pos();
        int numb3 = this.datosRonda.getBarcos3pos();
        int numb4 = this.datosRonda.getBarcos4pos();
        int numb5 = this.datosRonda.getBarcos5pos();

   
        for (int i = 0; i < numb2; i++) {
            obtenercoorbar(2);
        }
        for (int i = 0; i < numb3; i++) {
            obtenercoorbar(3);
        }
        for (int i = 0; i < numb4; i++) {
              obtenercoorbar(4);
        }
        for (int i = 0; i < numb5; i++) {
              obtenercoorbar(5);
        }
        return barcos;
    }



    public void obtenercoorbar(int tb) {
     try{
      
       boolean bien=true;
        int x = tablero.sizeX;
        int y = tablero.sizeY;
        int posx = (int) (Math.random() * x-2);
        int posy = (int) (Math.random() * y-2);
        int direccion = (int) (Math.random() * 2);
        int posxfin = posx, posyfin = posy;

        //vertical
        if (direccion == 0) {
            if (tabcolbar[posx][posy] == 0) {
                for (int e = 0; e < tb; e++) {
                    if (tabcolbar[posx + e][posy] == 0) {
                        posxfin = posx + e;
                    } 
                    else{
                        bien=false;
                    }
                   
                }
            } else {
                bien=false;
            }
          
           
        } 
        //orizontal
        else if (direccion == 1) {
            if (tabcolbar[posx][posy] == 0) {
                for (int e = 0; e < tb; e++) {
                    if (tabcolbar[posx][posy + e] == 0) {
                        posyfin = posy + e;
                    }
                    else{
                        bien=false;
                    }

                }
            }
            else {
                bien=false;
            }
            
        }
        if(bien!=false){
            
            
            if(direccion == 1){ 
                for (int e = 0; e < tb; e++) {
                    tabcolbar[posx][posy + e] = 1;

                }
            }
            else{
                for (int e = 0; e < tb; e++) {
                tabcolbar[posx + e][posy] = 1;
                }
            }
            barcos.add(new Barco(new Coordenada(posx, posy), new Coordenada(posxfin, posyfin)));
        }
        else obtenercoorbar(tb);
         
        }catch(Exception ex){
        obtenercoorbar(tb);
        }
       
    }

    @Override
    public Disparo generarDisparo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void resultadoDisparo(ArrayList<ResultadoDisparo> disparos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<String> getNombreComponentesEquipo() {

        List<String> Nombres = Arrays.asList("Daniel Dominguez", "Daniel Ubeda", "Eloi Martinez");
        return Nombres;
    }
}