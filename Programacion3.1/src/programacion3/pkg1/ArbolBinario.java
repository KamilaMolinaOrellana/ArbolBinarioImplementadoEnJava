/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion3.pkg1;

/**
 *
 * @author kamila
 */
public class ArbolBinario {

    NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    //METODO PARA INSERTTAR U NODO EN EL ARBOL
    public void agregarNodo(int d, String nom) {
        NodoArbol nuevo = new NodoArbol(d, nom);
        if (raiz == null) {  //CUANDO ESTA VACIO EL ARBOL
            raiz = nuevo;
        } else {
            NodoArbol aux = raiz;
            NodoArbol padre;
            while (true) {
                padre = aux;
                if (d < aux.dato) { //EL HIJO ES MENOR?
                    aux = aux.hijoIzquierdo;
                    if (aux == null) { //YA LLEGO AL FINAL , DONDE SE LO DEBE INSERTAR
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                } else {
                    aux = aux.hijoDerecho;
                    if (aux == null) { //DEBE INSERTARSE
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }

    //METODO PARA SABER SI UN ARBOL ESTA VACIO
    public boolean estaVacio() {
        return raiz == null;
    }

    //METODO IN-ORDEN
    public void inOrden(NodoArbol raiz) {
        if (raiz != null) {
            inOrden(raiz.hijoIzquierdo);
            System.out.print(raiz.dato + ", ");
            inOrden(raiz.hijoDerecho);
        }
    }

    //METODO PRE-ORDEN
    public void preOrden(NodoArbol raiz) {
        if (raiz != null) {
            System.out.print(raiz.dato + ", ");
            preOrden(raiz.hijoIzquierdo);
            preOrden(raiz.hijoDerecho);
        }
    }

    //METODO POST-ORDEN
    public void postOrden(NodoArbol raiz) {
        if (raiz != null) {
            postOrden(raiz.hijoIzquierdo);
            postOrden(raiz.hijoDerecho);
            System.out.print(raiz.dato + ", ");
        }
    }

    //METODO PARA BUSCAR UN NODO EN EL ARBOL
    public NodoArbol buscarNodo(int nodo) {
        NodoArbol aux = raiz;
        while (aux.dato != nodo) {
            if (nodo < aux.dato) {
                aux = aux.hijoIzquierdo;
            } else {
                aux = aux.hijoDerecho;
            }
            if (aux == null) { //EN EL CASO QUE NO HAYA ENCONTRADO NADA
                return null;
            }
        }
        return aux;
    }

    //METODO PARA ELIMINAR UN NODO DEL ARBOL
    public boolean eliminar(int nodo) {
        NodoArbol aux = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzquierdo = true;
        while (aux.dato != nodo) { //BUSCAR EL NODO A ELIMINAR
            padre = aux;
            if (nodo < aux.dato) { //DEBE IRSSE POR EL LADO IZQUIERDO
                esHijoIzquierdo = true;
                aux = aux.hijoIzquierdo;
            } else {
                esHijoIzquierdo = false;
                aux = aux.hijoDerecho;
            }
            if (aux == null) { //LLEGO AL FINAL Y NO LO ENCONTRO
                return false;
            }
        }
        if (aux.hijoIzquierdo == null && aux.hijoDerecho == null) {
            if (aux == raiz) { //ES EL UNICO NODO QUE TENEMOS
                raiz = null;
            } else if (esHijoIzquierdo) {
                padre.hijoIzquierdo = null;
            } else {
                padre.hijoDerecho = null;
            }
        } else if (aux.hijoDerecho == null) { //
            if (aux == raiz) {
                raiz = aux.hijoIzquierdo;
            } else if (esHijoIzquierdo) {
                padre.hijoIzquierdo = aux.hijoIzquierdo;
            } else {
                padre.hijoDerecho = aux.hijoIzquierdo;
            }
        } else if (aux.hijoIzquierdo == null) {
            if (aux == raiz) {
                raiz = aux.hijoDerecho;
            } else if (esHijoIzquierdo) {
                padre.hijoIzquierdo = aux.hijoDerecho;
            } else {
                padre.hijoDerecho = aux.hijoIzquierdo;
            }
        } else {
            NodoArbol reemplazo = obtenerNodoReemplazo(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzquierdo) {
                padre.hijoIzquierdo = reemplazo;
            } else {
                padre.hijoDerecho = reemplazo;
            }
            reemplazo.hijoIzquierdo = aux.hijoIzquierdo;
        }
        return true;
    }

    //METODO ENCARGADO DE DEVOLVER EL NODO REEMPLAZO
    public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReem) {
        NodoArbol reemplazoPadre = nodoReem;
        NodoArbol reemplazo = nodoReem;
        NodoArbol aux = nodoReem.hijoIzquierdo;
        while (aux != null) {//RECORRER PARA ENCOTRAR CUAL ES EL NODO CANDIDATO A ELIMINAR
            reemplazoPadre = reemplazo;
            reemplazo = aux;
            aux = aux.hijoIzquierdo;
        }
        if (reemplazo != nodoReem.hijoDerecho) {
            reemplazoPadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = nodoReem.hijoDerecho;
        }
        System.out.println("El Nodo REEMPLAZO Es: " + reemplazo);
        return reemplazo;
    }

}
