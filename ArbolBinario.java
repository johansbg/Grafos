/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jsburgos
 */
public class ArbolBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Nodo raiz =null;
        /*
        Nodo hijoDerecho = new Nodo(3);
        Nodo hijoIzquierdo = new Nodo(2);
        hijoIzquierdo.setIzquierdo(new Nodo(4));
        hijoIzquierdo.setDerecho(new Nodo(5));
        hijoDerecho.setDerecho(new Nodo(6));
        raiz.setDerecho(hijoDerecho);
        raiz.setIzquierdo(hijoIzquierdo);
        System.out.print("preOrden");
        preOrden(raiz);
        System.out.println("");
        System.out.print("inOrden");
        inOrden(raiz);
        System.out.println("");
        System.out.print("postOrden");
        postOrden(raiz);
        */
        int vec[] = new int[5];
        vec[0]=14;
        vec[1]=13;
        vec[2]=12;
        vec[3]=15;
        for (int i = 4; i < vec.length; i++) {
            vec[i]= (int) (Math.random()*100);
        }
        for (int i = 0; i < vec.length; i++) {
            System.out.println("vector "+vec[i]);
        }
        for (int i = 0; i < vec.length; i++) {
            raiz= (insertar(raiz, vec[i]));
        }
        System.out.print("preOrden");
        preOrden(raiz);
        System.out.println("");
        System.out.println(Buscar(raiz, 15));
    }
    static void preOrden(Nodo raiz){
        if (raiz!=null) {
            System.out.print("{"+raiz.getInfo()+"}");
            preOrden(raiz.getIzquierdo());
            preOrden(raiz.getDerecho());
        }
    }
    
    static void inOrden(Nodo raiz){
        if (raiz!=null) {
            inOrden(raiz.getIzquierdo());
            System.out.print("{"+raiz.getInfo()+"}");
            inOrden(raiz.getDerecho());
        }
    }
    
    static void postOrden(Nodo raiz){
        if (raiz!=null) {
            postOrden(raiz.getIzquierdo());
            postOrden(raiz.getDerecho());
            System.out.print("{"+raiz.getInfo()+"}");
        }
    }
    
    static Nodo insertar(Nodo raiz, int x){
        if (raiz==null) {
            raiz = new Nodo(x);
            return raiz;
        }else{
            if (raiz.getInfo()>x) {
                raiz.setIzquierdo(insertar(raiz.getIzquierdo(), x));
            }else{
                if (raiz.getInfo() <x){
                    raiz.setDerecho(insertar(raiz.getDerecho(), x));
                }else{
                    return raiz;
                }
            } 
        }
        return raiz;
    }
    
    static boolean Buscar(Nodo raiz, int x){
        if (raiz!=null) {
            if (raiz.getInfo()== x) {
                 return true;
            }else{
                if (raiz.getInfo() >x) {
                     Buscar(raiz.getIzquierdo(),x);
                }else{
                    if (raiz.getInfo() <x) {
                        Buscar(raiz.getDerecho(),x);
                    }
               }
            }
        }
        return false;
        
    }
    
    public int altura(Nodo raiz){
		if(raiz==null){
			return -1;
		}
		else {
			return 1 + Math.max(altura(raiz.getIzquierdo()),altura(raiz.getDerecho()));
		}
	}

	private int contar(Nodo raiz){
		if (raiz==null) {
			return 0;
		}
		else {
			return (1 + contar(raiz.getIzquierdo()) + contar(raiz.getDerecho()));
		}
	}

	public boolean lleno(Nodo raiz) {
		System.out.println("Altura del arbol:" + altura(raiz));
		System.out.println("Cantidad de nodos: " + contar(raiz));
		return contar(raiz) == (Math.pow(2,altura(raiz)+1) - 1);
	}
	
	public boolean completo(Nodo raiz) {
		if(raiz == null)
			return true;
		else {
			LinkedList cola = new LinkedList();
			cola.addFirst(raiz);
			boolean NL = false;
			while (!cola.isEmpty()) {
				Nodo temp = (Nodo) cola.removeLast();
				// 
				if (temp.getIzquierdo()!=null) {
					if (NL) {
						return false;
					}
					cola.addFirst(temp.getIzquierdo());
				}
				else {
					NL = true; 
				}
				if (temp.getDerecho()!=null) {
					if (NL) {
						return false; 
					}
					cola.addFirst(temp.getDerecho());
				}
				else {
					NL = true;
				}
			}
			return true;
		}
	}
}
