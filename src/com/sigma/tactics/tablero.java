/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.tactics;

import com.sigma.battleship.Barco;
import java.util.List;

/**
 *
 * @author eloi.martinez
 */
public class tablero {

    public final int CELL_NULL = 0;
    public final int CELL_WATER = 1;
    public final int CELL_HIT = 2;
    private final int[][] tablero;
    private final int sizeX;
    private final int sizeY;

    public tablero(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        tablero = new int[sizeX][sizeY];
    }

    public boolean canShoot(int x, int y) {
        if (x > 0 && y > 0) {
            if (x < sizeX && y < sizeY) {
                if (tablero[x][y] == this.CELL_NULL) {
                    return true;
                }
            }
        }
        return false;
    }
    public void updateCell(int x, int y, int state){
        tablero[x][y] = state;
    }
}