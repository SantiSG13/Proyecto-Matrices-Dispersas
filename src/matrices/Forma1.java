package matrices;

import javax.swing.*;

public class Forma1 {
    private Nodo cabeza;

    public Forma1() {
        this.cabeza = null;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public void Construir(int[][] matrizOriginal) {
        // Implementación para construir la Forma 1 a partir de la matriz original
        Nodo actual = new Nodo (matrizOriginal.length, matrizOriginal[0].length, 0);
        cabeza = actual;

        // Encontrar el mayor entre filas y columnas
        int mayor = matrizOriginal.length;
        if (matrizOriginal[0].length > mayor) {
            mayor = matrizOriginal[0].length;
        }

        CrearRegistrosCabeza(mayor);
        LlenarFilas(matrizOriginal);
        LlenarLigasColumnas();
    }

    public void CrearRegistrosCabeza(int mayor) {
        Nodo actual = cabeza;

        for (int i = 0; i < mayor; i++) {
            Nodo nuevo = new Nodo(i, i, 0);
            actual.setLiga(nuevo);
            actual = nuevo;
        }
        actual.setLiga(cabeza);
    }

    public void LlenarFilas(int[][] matrizOriginal) {
        Nodo registroCabeza = cabeza.getLiga(), actual = registroCabeza;

        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                if (matrizOriginal[i][j] != 0) {
                    Nodo nuevo = new Nodo(i, j, matrizOriginal[i][j]);
                    actual.setLigaFila(nuevo);
                    actual = nuevo;
                }
            }
            actual.setLigaFila(registroCabeza);
            registroCabeza = registroCabeza.getLiga();
            actual = registroCabeza;
        }
    }

    public void LlenarLigasColumnas(){
        Nodo registroCabeza = cabeza.getLiga();
        Nodo ultimaColumna = registroCabeza;
        Nodo actualFilaRc = cabeza.getLiga();
        Nodo siguienteFila = actualFilaRc.getLigaFila();

        while (registroCabeza != cabeza) {
            while (actualFilaRc != cabeza) {
                while (siguienteFila != actualFilaRc) {
                    if (siguienteFila.getColumna() == registroCabeza.getColumna()) {
                        ultimaColumna.setLigaColumna(siguienteFila);
                        ultimaColumna = siguienteFila;
                    }
                    siguienteFila = siguienteFila.getLigaFila();
                }
                // Avanzar a la siguiente fila
                actualFilaRc = actualFilaRc.getLiga();
                siguienteFila = actualFilaRc.getLigaFila();
            }
            // Cerrar la columna
            ultimaColumna.setLigaColumna(registroCabeza);
            registroCabeza = registroCabeza.getLiga();
            ultimaColumna = registroCabeza;
            actualFilaRc = cabeza.getLiga();
            siguienteFila = actualFilaRc.getLigaFila();
        }
    }

    //--------------------------------------------------
    // Mostrar Forma 1
    //--------------------------------------------------
    public void MostrarForma1() {
        Nodo registroCabeza = cabeza.getLiga();
        Nodo actualFilaRc = cabeza.getLiga();
        Nodo siguienteFila = actualFilaRc.getLigaFila();
        StringBuilder salida = new StringBuilder();

        while (registroCabeza != cabeza) {
            salida.append("Fila ")
                    .append(registroCabeza.getColumna())
                    .append(":\n");

            boolean tieneElementos = false;

            while (actualFilaRc != cabeza) {
                while (siguienteFila != actualFilaRc) {
                    if (siguienteFila.getFila() == registroCabeza.getFila()) {
                        salida.append(String.format("   ↳ Columna %-3d → Dato: %d\n",
                                siguienteFila.getColumna(),
                                siguienteFila.getDato()));
                        tieneElementos = true;
                    }
                    siguienteFila = siguienteFila.getLigaFila();
                }
                actualFilaRc = actualFilaRc.getLiga();
                siguienteFila = actualFilaRc.getLigaFila();
            }

            if (!tieneElementos) {
                salida.append("   (sin elementos en esta fila)\n");
            }

            salida.append("\n");
            registroCabeza = registroCabeza.getLiga();
            actualFilaRc = cabeza.getLiga();
            siguienteFila = actualFilaRc.getLigaFila();
        }

        JOptionPane.showMessageDialog(null, salida.toString(), "Forma 1", JOptionPane.INFORMATION_MESSAGE);
    }

    //--------------------------------------------------
    //Sumar filas de la Forma 1
    //--------------------------------------------------
    public void SumarFilasForma1() {
        Nodo registroCabeza = cabeza.getLiga();
        Nodo siguienteFila = registroCabeza.getLigaFila();
        int[] vectorSumaFilas = new int[cabeza.getFila()];

        while (registroCabeza != cabeza) {
            while (siguienteFila != registroCabeza) {
                vectorSumaFilas[siguienteFila.getFila()] += siguienteFila.getDato();
                siguienteFila = siguienteFila.getLigaFila();
            }
            registroCabeza = registroCabeza.getLiga();
            siguienteFila = registroCabeza.getLigaFila();
        }

        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < vectorSumaFilas.length; i++) {
            salida.append(String.format("Fila %2d |    %4d\n", i, vectorSumaFilas[i]));
        }

        JOptionPane.showMessageDialog(null, salida.toString(), "Suma por Filas", JOptionPane.INFORMATION_MESSAGE);
    }

    //--------------------------------------------------
    //Sumar columnas de la Forma 1
    //--------------------------------------------------
    public void SumarColumnasForma1() {
        Nodo registroCabeza = cabeza.getLiga();
        Nodo siguienteColumna = registroCabeza.getLigaColumna();
        int[] vectorSumaColumnas = new int[cabeza.getColumna()];

        while (registroCabeza != cabeza) {
            while (siguienteColumna != registroCabeza) {
                vectorSumaColumnas[siguienteColumna.getColumna()] += siguienteColumna.getDato();
                siguienteColumna = siguienteColumna.getLigaColumna();
            }
            registroCabeza = registroCabeza.getLiga();
            siguienteColumna = registroCabeza.getLigaColumna();
        }

        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < vectorSumaColumnas.length; i++) {
            salida.append(String.format("Columna %2d |    %4d\n", i, vectorSumaColumnas[i]));
        }

        JOptionPane.showMessageDialog(null, salida.toString(), "Suma por Columnas", JOptionPane.INFORMATION_MESSAGE);
    }

    //--------------------------------------------------
    // Insertar dato en la Forma 1
    //--------------------------------------------------
    public void InsertarDatoForma1(int fila, int columna, int dato) {
        if (dato == 0) {
            JOptionPane.showMessageDialog(null, "El dato a insertar debe ser diferente de cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Nodo nuevoNodo = new Nodo(fila, columna, dato);

        // Insertar en la fila correspondiente
        Nodo registroCabeza = cabeza.getLiga();
        while (registroCabeza != cabeza) {
            if (registroCabeza.getFila() == fila) {
                // Encontrar la posición correcta en la fila
                Nodo anterior = registroCabeza;
                Nodo actual = registroCabeza.getLigaFila();
                while (actual != registroCabeza) {
                    if (actual.getColumna() == columna) {
                        actual.setDato(actual.getDato() + dato); //Sumar al dato existente
                        return;
                    }
                    if (actual.getColumna() > columna) {
                        break;
                    }
                    anterior = actual;
                    actual = actual.getLigaFila();
                }
                // Enlazar las ligaa de las filas
                anterior.setLigaFila(nuevoNodo);
                nuevoNodo.setLigaFila(actual);
                break;
            }
            registroCabeza = registroCabeza.getLiga();
        }

        // Insertar en la columna correspondiente
        registroCabeza = cabeza.getLiga();
        while (registroCabeza != cabeza) {
            if (registroCabeza.getColumna() == columna) {
                // Encontrar la posición correcta en la columna
                Nodo anterior = registroCabeza;
                Nodo actual = registroCabeza.getLigaColumna();
                while (actual != registroCabeza) {
                    if (actual.getFila() > fila) {
                        break;
                    }
                    anterior = actual;
                    actual = actual.getLigaColumna();
                }
                // Enlazar las ligas de las columnas
                anterior.setLigaColumna(nuevoNodo);
                nuevoNodo.setLigaColumna(actual);
                break;
            }
            registroCabeza = registroCabeza.getLiga();
        }
    }

    //--------------------------------------------------
    // Eliminar dato en la Forma 1
    //--------------------------------------------------
    public void EliminarDatoForma1(int dato) {

    }
}
