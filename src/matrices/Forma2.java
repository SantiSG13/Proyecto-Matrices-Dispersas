package matrices;

import javax.swing.*;

public class Forma2 {
    private Nodo cabeza;

    public Forma2() {
        cabeza = null;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    //---------------------------------------------------
    //Construir Forma 2
    //---------------------------------------------------
    public void ConstruirForma2(int[][] matrizOriginal) {
        Nodo actual = new Nodo(matrizOriginal.length, matrizOriginal[0].length, 0);
        cabeza = actual;

        CrearNodosYEnlazarFilas(matrizOriginal);
        EnlazarColumnas();
    }

    public void CrearNodosYEnlazarFilas(int[][] matrizOriginal) {
        Nodo actual = cabeza;

        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                if (matrizOriginal[i][j] != 0) {
                    Nodo nuevo = new Nodo(i, j, matrizOriginal[i][j]);
                    actual.setLigaFila(nuevo);
                    actual = nuevo;
                }
            }
        }
        actual.setLigaFila(cabeza);
    }

    public void EnlazarColumnas() {
        Nodo anterior = cabeza, actual;

        for (int c = 0; c < cabeza.getColumna(); c++) {
            actual = cabeza.getLigaFila();
            while (actual != cabeza) {
                if (actual.getColumna() == c) {
                    anterior.setLigaColumna(actual);
                    anterior = actual;
                }
                actual = actual.getLigaFila();
            }
        }
        anterior.setLigaColumna(cabeza);
    }

    //---------------------------------------------------
    //Mostrar Forma 2 por filas
    //---------------------------------------------------
    public void MostrarForma2PorFilas() {
        Nodo actual = cabeza.getLigaFila();
        StringBuilder salida = new StringBuilder();

        salida.append(String.format("MATRIZ %d x %d\n\n\n", cabeza.getFila(), cabeza.getColumna()));

        while (actual != cabeza) {
            salida.append(String.format("〔%d, %d, %d〕  →  ", actual.getFila(), actual.getColumna(), actual.getDato()));
            actual = actual.getLigaFila();
        }
        salida.delete(salida.length() - 5, salida.length());// Eliminar la última flecha

        JOptionPane.showMessageDialog(null, salida.toString(), "Forma 2 - Por Filas", JOptionPane.INFORMATION_MESSAGE);
    }

    //---------------------------------------------------
    //Mostrar Forma 2 por columnas
    //---------------------------------------------------
    public void MostrarForma2PorColumnas() {
        Nodo actual = cabeza.getLigaColumna();
        StringBuilder salida = new StringBuilder();

        salida.append(String.format("MATRIZ %d x %d\n\n\n", cabeza.getFila(), cabeza.getColumna()));

        while (actual != cabeza) {
            salida.append(String.format("〔%d, %d, %d〕\n", actual.getFila(), actual.getColumna(), actual.getDato()));
            salida.append("         ↓\n");
            actual = actual.getLigaColumna();
        }
        salida.delete(salida.length() - 7, salida.length());// Eliminar la última flecha

        JOptionPane.showMessageDialog(null, salida.toString(), "Forma 2 - Por Columnas", JOptionPane.INFORMATION_MESSAGE);
    }

    //---------------------------------------------------
    //Sumar filas de Forma 2
    //---------------------------------------------------
    public void SumarFilasForma2() {
        Nodo actual = cabeza.getLigaFila();
        int totalFilas = cabeza.getFila();
        int[] vectorSumaFilas = new int[totalFilas];

        while (actual != cabeza) {
            vectorSumaFilas[actual.getFila()] += actual.getDato();
            actual = actual.getLigaFila();
        }

        StringBuilder salida = new StringBuilder();
        salida.append("SUMA DE FILAS:\n\n");
        for (int i = 0; i < totalFilas; i++) {
            salida.append(String.format("Fila %d: %d\n", i, vectorSumaFilas[i]));
        }

        JOptionPane.showMessageDialog(null, salida.toString(), "Suma de Filas - Forma 2", JOptionPane.INFORMATION_MESSAGE);
    }

    //---------------------------------------------------
    //Sumar columnas de Forma 2
    //---------------------------------------------------
    public void SumarColumnasForma2() {
        Nodo actual = cabeza.getLigaColumna();
        int totalColumnas = cabeza.getColumna();
        int[] vectorSumaColumnas = new int[totalColumnas];

        while (actual != cabeza) {
            vectorSumaColumnas[actual.getColumna()] += actual.getDato();
            actual = actual.getLigaColumna();
        }

        StringBuilder salida = new StringBuilder();
        salida.append("SUMA DE COLUMNAS:\n\n");
        for (int j = 0; j < totalColumnas; j++) {
            salida.append(String.format("Columna %d: %d\n", j, vectorSumaColumnas[j]));
        }

        JOptionPane.showMessageDialog(null, salida.toString(), "Suma de Columnas - Forma 2", JOptionPane.INFORMATION_MESSAGE);
    }

    //---------------------------------------------------
    //Insertar dato en forma 2
    //---------------------------------------------------
    public void InsertarDatoForma2() {
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Digite la fila del nuevo nodo (entre 0 y " + (cabeza.getFila() - 1) + ") :"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Digite la columna del nuevo nodo (entre 0 y " + (cabeza.getColumna() - 1) + ") :"));
        int dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el dato del nuevo nodo:"));

        if (dato == 0) {
            JOptionPane.showMessageDialog(null, "El dato a insertar debe ser diferente de cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Nodo nuevo = new Nodo(fila, columna, dato);

        // Insertar en la lista de filas
        Nodo actualFila = cabeza.getLigaFila();
        Nodo anteriorFila = cabeza;

        while (actualFila != cabeza) {
            // Si ya existe un nodo en esa posición, sumar los datos
            if (actualFila.getFila() == fila && actualFila.getColumna() == columna) {
                actualFila.setDato(actualFila.getDato() + dato);
                if (actualFila.getDato() == 0) {
                    EliminarPosicionForma2(fila, columna);
                    JOptionPane.showMessageDialog(null, "El nodo en la posición (" + fila + ", " + columna + ") ha sido eliminado porque su valor es cero.", "Nodo Eliminado", JOptionPane.INFORMATION_MESSAGE);
                }
                return;
            }

            // Ordenar por fila primero, luego por columna
            if (actualFila.getFila() > fila || (actualFila.getFila() == fila && actualFila.getColumna() > columna)) {
                break;
            }

            anteriorFila = actualFila;
            actualFila = actualFila.getLigaFila();
        }

        // Enlazar el nuevo nodo en la lista de filas
        anteriorFila.setLigaFila(nuevo);
        nuevo.setLigaFila(actualFila);

        // Insertar en la lista de columnas
        Nodo actualColumna = cabeza.getLigaColumna();
        Nodo anteriorColumna = cabeza;

        while (actualColumna != cabeza) {
            // Ordenar por columna primero, luego por fila
            if (actualColumna.getColumna() > columna || (actualColumna.getColumna() == columna && actualColumna.getFila() > fila)) {
                break;
            }
            anteriorColumna = actualColumna;
            actualColumna = actualColumna.getLigaColumna();
        }

        // Enlazar el nuevo nodo en la lista de columnas
        anteriorColumna.setLigaColumna(nuevo);
        nuevo.setLigaColumna(actualColumna);
    }


    //---------------------------------------------------
    //Eliminar dato en forma 2
    //---------------------------------------------------
    public void EliminarDatoForma2() {
        int dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el dato del nodo a eliminar:"));

        if (dato == 0) {
            JOptionPane.showMessageDialog(null, "El dato a eliminar debe ser diferente de cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buscar todos los nodos con ese dato y guardar sus posiciones
        Nodo actual = cabeza.getLigaFila();
        int nodosEliminados = 0;

        // Recorrer la lista y eliminar todos los nodos con ese dato
        while (actual != cabeza) {
            if (actual.getDato() == dato) {
                int fila = actual.getFila();
                int columna = actual.getColumna();

                // Guardar el siguiente nodo antes de eliminar
                Nodo siguiente = actual.getLigaFila();

                // Eliminar el nodo
                EliminarPosicionForma2(fila, columna);
                nodosEliminados++;

                // Continuar con el siguiente nodo
                actual = siguiente;
            } else {
                actual = actual.getLigaFila();
            }
        }

        if (nodosEliminados > 0) {
            JOptionPane.showMessageDialog(null, "Se eliminaron " + nodosEliminados + " nodo(s) con el dato " + dato + ".", "Nodos Eliminados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún nodo con el dato " + dato + ".", "Sin Coincidencias", JOptionPane.WARNING_MESSAGE);
        }
    }

    //---------------------------------------------------
    //Eliminar por posición en forma 2
    //---------------------------------------------------
    public void EliminarPosicionForma2(int fila, int columna) {
        // Eliminar de la lista de filas
        Nodo actualFila = cabeza.getLigaFila();
        Nodo anteriorFila = cabeza;

        while (actualFila != cabeza) {
            if (actualFila.getFila() == fila && actualFila.getColumna() == columna) {
                anteriorFila.setLigaFila(actualFila.getLigaFila());
                break;
            }
            anteriorFila = actualFila;
            actualFila = actualFila.getLigaFila();
        }

        // Eliminar de la lista de columnas
        Nodo actualColumna = cabeza.getLigaColumna();
        Nodo anteriorColumna = cabeza;

        while (actualColumna != cabeza) {
            if (actualColumna.getFila() == fila && actualColumna.getColumna() == columna) {
                anteriorColumna.setLigaColumna(actualColumna.getLigaColumna());
                break;
            }
            anteriorColumna = actualColumna;
            actualColumna = actualColumna.getLigaColumna();
        }
    }

    //---------------------------------------------------
    //Sumar dos matrices en Forma2
    //---------------------------------------------------
    public void SumarMatricesForma2(Forma2 matrizB) {
        Nodo actualA = cabeza.getLigaFila();
        Nodo actualB = matrizB.getCabeza().getLigaFila();
        int filas = cabeza.getFila();
        int columnas = cabeza.getColumna();

        int[][] MatrizResultado = new int[filas][columnas];

        // Sumar elementos de la matriz A
        while (actualA != cabeza) {
            MatrizResultado[actualA.getFila()][actualA.getColumna()] += actualA.getDato();
            actualA = actualA.getLigaFila();
        }

        // Sumar elementos de la matriz B
        while (actualB != matrizB.getCabeza()) {
            MatrizResultado[actualB.getFila()][actualB.getColumna()] += actualB.getDato();
            actualB = actualB.getLigaFila();
        }

        // Construir la matriz resultado en Forma2
        Forma2 resultado = new Forma2();
        resultado.ConstruirForma2(MatrizResultado);
        cabeza = resultado.getCabeza();
    }

    //---------------------------------------------------
    //Multiplicar dos matrices en Forma2
    //---------------------------------------------------
    public void MultiplicarMatricesForma2(Forma2 matrizB) {
        int filas = cabeza.getFila();
        int columnas = matrizB.getCabeza().getColumna();
        int[][] MatrizResultado = new int[filas][columnas];

        Nodo actualA = cabeza.getLigaFila();
        while (actualA != cabeza) {
            Nodo actualB = matrizB.getCabeza().getLigaFila();
            while (actualB != matrizB.getCabeza()) {
                if (actualA.getColumna() == actualB.getFila()) {
                    MatrizResultado[actualA.getFila()][actualB.getColumna()] += actualA.getDato() * actualB.getDato();
                }
                actualB = actualB.getLigaFila();
            }
            actualA = actualA.getLigaFila();
        }

        // Construir la matriz resultado en Forma2
        Forma2 resultado = new Forma2();
        resultado.ConstruirForma2(MatrizResultado);
        cabeza = resultado.getCabeza();
    }
}
