package com.sigma.tactics;

import com.sigma.battleship.Barco;
import com.sigma.battleship.Coordenada;
import com.sigma.battleship.DatosRonda;
import com.sigma.battleship.Disparo;
import com.sigma.battleship.ResultadoDisparo;
import com.sigma.battleship.defaultplayers.ITactica;
import com.sigma.tactics.tablero;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MyTactic implements ITactica {

    private DatosRonda datosRonda;
    private tablero tablero;
    private Coordenada coordenadaADisparar;

    @Override
    public void inicializarTactica(DatosRonda datosRonda) {
        this.datosRonda = datosRonda;
        tablero = new tablero(datosRonda.getTamanoX(), datosRonda.getTamanoY());
    }

    @Override
    public List<Barco> generarBarcos() {
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}