/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2.johanburgos;

import java.util.LinkedList;
/**
 *
 * @author johan
 */
public class Vertice {
    String dato;
    int x;
    int y;
    int FX;
    int FY;
    LinkedList<Vertice> adyacente = new LinkedList<Vertice>();;
    LinkedList<Integer> Pesos = new LinkedList<Integer>();;

    public Vertice(String dato, int x, int y, int FX, int FY) {
        this.dato = dato;
        this.x = x;
        this.y = y;
        this.FX = FX;
        this.FY = FY;
    }

    public String getDato() {
        return dato;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFX() {
        return FX;
    }

    public int getFY() {
        return FY;
    }
    
    public void addAdyacentes(Vertice x) {
        adyacente.add(x);
    }
    public void addPesos(int x) {
        Pesos.add(x);
    }
    public int BuscarAdyacente(int Dato) {
        int cont=0;
        for (Vertice ve : adyacente) {
            if (ve.getDato().equals(Dato)) {
                return cont;
            }else{
                cont++;
            }
        }
        return 0;
    }
    
    
}
