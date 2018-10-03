package laboratorio2.johanburgos;

import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johan
 */
public class FloydWarshall {
    static int[][] M = {};
    static int nVertices = M.length;
    static int[][] distancia = new int[nVertices][nVertices];
    static int[][] recorridos = new int[nVertices][nVertices];
    
    static void llenarMatrizRecorridos(){        
        for (int i = 0; i < nVertices; i++) 
            for (int j = 0; j< nVertices; j++) 
                recorridos[i][j]=j;                    
    }
    
    static void llenarMatrizDistancia(){
        int infinito=999;
        for (int i = 0; i < nVertices; i++) 
            for (int j = 0; j< nVertices; j++) 
                if (M[i][j]!=0) 
                    distancia[i][j]=M[i][j];
                else
                    if (i==j) 
                        distancia[i][j]=0;
                    else
                        distancia[i][j]=infinito;
    }
    static void algoritmoFloydWarshall(){
        int tmp;
        for (int k = 0; k < nVertices; k++) {
            for (int i = 0; i < nVertices; i++) {
                for (int j = 0; j < nVertices; j++) {    
                    tmp = distancia[i][k]+distancia[k][j];
                    if (tmp<distancia[i][j]) {
                        distancia[i][j]=tmp;
                        recorridos[i][j]=k;
                    }
                }
            }
        }    
    }
    
    
    
    public static void escribirMatriz(int matriz[][], int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j]+"|");
            }
            System.out.println("");
        }
    }
    
    static boolean[] visitado = new boolean[M.length];
    
    public static void DFS(int u){
        System.out.print(u+" ");
        visitado[u]=true;
        for (int v = 0; v < nVertices; v++) 
            if (M[u][v]==1) 
                if (!visitado[v]) 
                    DFS(v);
    }
    
    public static void BFS(int u){
        Queue<Integer> cola = new LinkedList<Integer>();//FIFO
        visitado[u]=true;
        cola.add(u);
        while(!cola.isEmpty()){
            u = cola.remove();
            System.out.print(u+" ");
            for (int v = 0; v < nVertices; v++) 
                if (M[u][v]==1) 
                    if (!visitado[v]) {
                        visitado[v]=true;
                        cola.add(v);
                    }
        }
    }
}
