/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2.johanburgos;

import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author johan
 */
public class Grafo {
    public LinkedList<Vertice> vertices = new LinkedList<Vertice>();
    public void Vorigen(Vertice v) {
        vertices.add(v);
    }
    public void Vdestino(Vertice v, Vertice vDestino, int i) {
        vertices.get(BuscarV(v.getDato())).addAdyacentes(vDestino);
        vertices.get(BuscarV(v.getDato())).Pesos.add(i);
    }
    public int BuscarV(String dato) {
        int x=0;
        for (Vertice ve : vertices) {
            if (ve.getDato().equals(dato)) {
                return x;
            }else{
                x++;
            }
        }
        return 0;
    }
    public boolean VerificarV(Vertice v) {
        for (Vertice ve : vertices) {
            if (v.getDato().equals(ve.getDato())) {
                return true;
            }
        }
        return false;
    }
    public boolean VerificarCoordenadas(int x1, int y1, int FX1, int FY1) {
        for (Vertice ve : vertices) {
            //Buscar metodo
            if (new Rectangle(ve.x,ve.y,ve.FX,ve.FY).intersects(new Rectangle(x1, y1, FX1,FY1))) {
                return true;
            }
        }
        return false;
    }
    public String VerificarSeleccion(int x1, int y1) {
        for (Vertice ve : vertices) {
            if (new Rectangle(ve.x,ve.y,ve.FX,ve.FY).intersects(new Rectangle(x1, y1, ve.x,ve.y))) {
                return ve.getDato();
            }
        }
        return null;
    }
    public void eliminarV(int n){
        vertices.remove(n);
    }
}
