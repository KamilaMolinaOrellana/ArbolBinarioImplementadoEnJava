package programacion3.pkg1;

import javax.swing.JOptionPane;

/**
 * @author kamila
 */
public class ArbolesBinariosImplemetacion {

    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = 0, elemento;
        String nombre;
        //CREAMOS EL ARBOL BINARIO
        ArbolBinario arbolito = new ArbolBinario();

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. AGREGAR NODO\n"
                        + "2. RECORRER EN In-ORDEN\n"
                        + "3. RECORRER EN Pre-ORDEN\n"
                        + "4. RECORRER EN Post-ORDEN\n"
                        + "5. BUSCAR UN NODO EN EL ARBOL\n"
                        + "6. ELIMINIAR EL NODO DEL ARBOL\n"
                        + "7. SALIR\n"
                        + "Elige una opcion",
                        JOptionPane.QUESTION_MESSAGE));
                switch (opcion) {
                    case 1:
                        System.out.println("");
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero del nodo", JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del nodo", JOptionPane.QUESTION_MESSAGE);
                        arbolito.agregarNodo(elemento, nombre);
                        break;
                    case 2: //VA A RECORRER EL ARBOL SOLO SI ESTA VACIO
                        if (!arbolito.estaVacio()) {
                            System.out.println("");
                            arbolito.inOrden(arbolito.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "El Arbol Esta Vacio", "", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3: //VA A RECORRER EL ARBOL SOLO SI ESTA VACIO
                        if (!arbolito.estaVacio()) {
                            System.out.println("");
                            arbolito.preOrden(arbolito.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "El Arbol Esta Vacio", "", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4://VA A RECORRER EL ARBOL SOLO SI ESTA VACIO
                        System.out.println("");
                        if (!arbolito.estaVacio()) {
                            arbolito.postOrden(arbolito.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "El Arbol Esta Vacio", "", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 5:
                        System.out.println("");
                        if (!arbolito.estaVacio()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero del nodo Buscado", JOptionPane.QUESTION_MESSAGE));
                            if (arbolito.buscarNodo(elemento) == null) {
                                JOptionPane.showMessageDialog(null, "El Nodo No Se Encuentra En El Arbol", "", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                System.out.println(arbolito.buscarNodo(elemento));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El Arbol Esta Vacio", "", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 6:
                        System.out.println("");
                        if (!arbolito.estaVacio()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero del nodo a Eliminar", JOptionPane.QUESTION_MESSAGE));
                            if (arbolito.eliminar(elemento) == false) {
                                JOptionPane.showMessageDialog(null, "El Nodo No Se Encuentra En El Arbol", "", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "El Nodo Ha Sido Eliminado Del Arbol", "", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El Arbol Esta Vacio", "", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7:
                        System.out.println("");
                        JOptionPane.showMessageDialog(null, "Aplicacion Finalizada", "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Incorrecta", "", JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "ERROR" + n.getMessage());
            }
        } while (opcion != 7);
    }
}
