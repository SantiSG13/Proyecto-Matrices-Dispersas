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

    //--------------------------------------------------
    // Construir Forma 1
    //--------------------------------------------------
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
    // Mostrar Forma 1 por filas
    //--------------------------------------------------
    public void MostrarForma1PorFilas() {
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

        JOptionPane.showMessageDialog(null, salida.toString(), "Forma 1 - Por Filas", JOptionPane.INFORMATION_MESSAGE);
    }

    //--------------------------------------------------
    // Mostrar Forma 1 por columnas
    //--------------------------------------------------
    public void MostrarForma1PorColumnas() {
        Nodo registroCabeza = cabeza.getLiga();
        Nodo actualColumnaRc = cabeza.getLiga();
        Nodo siguienteColumna = actualColumnaRc.getLigaColumna();
        StringBuilder salida = new StringBuilder();

        while (registroCabeza != cabeza) {
            salida.append("Columna ")
                    .append(registroCabeza.getColumna())
                    .append(":\n");

            boolean tieneElementos = false;

            while (actualColumnaRc != cabeza) {
                while (siguienteColumna != actualColumnaRc) {
                    if (siguienteColumna.getColumna() == registroCabeza.getColumna()) {
                        salida.append(String.format("   ↳ Fila %-3d → Dato: %d\n",
                                siguienteColumna.getFila(),
                                siguienteColumna.getDato()));
                        tieneElementos = true;
                    }
                    siguienteColumna = siguienteColumna.getLigaColumna();
                }
                actualColumnaRc = actualColumnaRc.getLiga();
                siguienteColumna = actualColumnaRc.getLigaColumna();
            }

            if (!tieneElementos) {
                salida.append("   (sin elementos en esta columna)\n");
            }

            salida.append("\n");
            registroCabeza = registroCabeza.getLiga();
            actualColumnaRc = cabeza.getLiga();
            siguienteColumna = actualColumnaRc.getLigaColumna();
        }

        JOptionPane.showMessageDialog(null, salida.toString(), "Forma 1 - Por Columnas", JOptionPane.INFORMATION_MESSAGE);
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
    public void InsertarDatoForma1() {
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Digite la fila del nuevo nodo (entre 0 y " + (cabeza.getFila() - 1) + "):"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Digite la columna del nuevo nodo (entre 0 y " + (cabeza.getColumna() - 1) + "):"));
        int dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el dato del nuevo nodo:"));

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
    public void EliminarDatoForma1() {
        int dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el dato que desea eliminar:"));

        if (dato == 0) {
            JOptionPane.showMessageDialog(null, "El dato a eliminar debe ser diferente de cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean encontrado = false;
        Nodo registroCabeza = cabeza.getLiga();

        while (registroCabeza != cabeza) {
            // Eliminar de la fila
            Nodo anterior = registroCabeza;
            Nodo actual = registroCabeza.getLigaFila();

            while (actual != registroCabeza) {
                if (actual.getDato() == dato) {
                    anterior.setLigaFila(actual.getLigaFila());
                    encontrado = true;
                    actual = anterior.getLigaFila();
                } else {
                    anterior = actual;
                    actual = actual.getLigaFila();
                }
            }

            // Eliminar de la columna
            anterior = registroCabeza;
            actual = registroCabeza.getLigaColumna();

            while (actual != registroCabeza) {
                if (actual.getDato() == dato) {
                    anterior.setLigaColumna(actual.getLigaColumna());
                    actual = anterior.getLigaColumna();
                } else {
                    anterior = actual;
                    actual = actual.getLigaColumna();
                }
            }

            registroCabeza = registroCabeza.getLiga();
        }

        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Dato(s) eliminado(s)");
        } else {
            JOptionPane.showMessageDialog(null, "Dato no encontrado");
        }
    }

    //--------------------------------------------------
    // Eliminar posición en la Forma 1
    //--------------------------------------------------
    public void EliminarPosicionForma1() {
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Digite la fila del nodo que desea eliminar (entre 0 y " + (cabeza.getFila() - 1) + "):"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Digite la columna del nodo que desea eliminar (entre 0 y " + (cabeza.getColumna() - 1) + "):"));

        boolean encontrado = false;
        Nodo registroCabeza = cabeza.getLiga();

        while (registroCabeza != cabeza) {
            // Eliminar de la fila
            if (registroCabeza.getFila() == fila) {
                Nodo anterior = registroCabeza;
                Nodo actual = registroCabeza.getLigaFila();

                while (actual != registroCabeza) {
                    if (actual.getColumna() == columna) {
                        anterior.setLigaFila(actual.getLigaFila());
                        encontrado = true;
                        break;
                    }
                    anterior = actual;
                    actual = actual.getLigaFila();
                }
            }

            // Eliminar de la columna
            if (registroCabeza.getColumna() == columna) {
                Nodo anterior = registroCabeza;
                Nodo actual = registroCabeza.getLigaColumna();

                while (actual != registroCabeza) {
                    if (actual.getFila() == fila) {
                        anterior.setLigaColumna(actual.getLigaColumna());
                        break;
                    }
                    anterior = actual;
                    actual = actual.getLigaColumna();
                }
            }

            registroCabeza = registroCabeza.getLiga();
        }

        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Posición eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "Posición no encontrada o sin dato en esa posición");
        }
    }

    //--------------------------------------------------
    // Sumar dos matrices en forma 1
    //--------------------------------------------------
    public void SumarMatricesForma1(Forma1 matrizB) {
        Nodo registroCabezaA = cabeza.getLiga();
        Nodo registroCabezaB = matrizB.getCabeza().getLiga();
        int filas = cabeza.getFila();
        int columnas = cabeza.getColumna();

        int[][] matrizResultado = new int[filas][columnas];
        // Llenar matrizResultado con los datos de la matriz A
        while (registroCabezaA != cabeza) {
            Nodo siguienteFilaA = registroCabezaA.getLigaFila();
            while (siguienteFilaA != registroCabezaA) {
                matrizResultado[siguienteFilaA.getFila()][siguienteFilaA.getColumna()] += siguienteFilaA.getDato();
                siguienteFilaA = siguienteFilaA.getLigaFila();
            }
            registroCabezaA = registroCabezaA.getLiga();
        }

        // Sumar los datos de la matriz B
        while (registroCabezaB != matrizB.getCabeza()) {
            Nodo siguienteFilaB = registroCabezaB.getLigaFila();
            while (siguienteFilaB != registroCabezaB) {
                matrizResultado[siguienteFilaB.getFila()][siguienteFilaB.getColumna()] += siguienteFilaB.getDato();
                siguienteFilaB = siguienteFilaB.getLigaFila();
            }
            registroCabezaB = registroCabezaB.getLiga();
        }

        Forma1 resultado = new Forma1();
        resultado.Construir(matrizResultado);
        cabeza = resultado.getCabeza();
    }

    //--------------------------------------------------
    // Multiplicar dos matrices en forma 1
    //--------------------------------------------------
    public void MultiplicarMatricesForma1(Forma1 matrizC) {
        int filas = cabeza.getFila();
        int columnas = matrizC.getCabeza().getColumna();
        int[][] matrizResultado = new int[filas][columnas];

        Nodo registroCabezaA = cabeza.getLiga();
        while (registroCabezaA != cabeza) {

            Nodo siguienteFilaA = registroCabezaA.getLigaFila();
            while (siguienteFilaA != registroCabezaA) {

                Nodo registroCabezaC = matrizC.getCabeza().getLiga();
                while (registroCabezaC != matrizC.getCabeza()) {

                    Nodo siguienteColumnaC = registroCabezaC.getLigaColumna();
                    while (siguienteColumnaC != registroCabezaC) {
                        if (siguienteFilaA.getColumna() == siguienteColumnaC.getFila()) {
                            matrizResultado[siguienteFilaA.getFila()][siguienteColumnaC.getColumna()] += siguienteFilaA.getDato() * siguienteColumnaC.getDato();
                        }
                        siguienteColumnaC = siguienteColumnaC.getLigaColumna();
                    }

                    registroCabezaC = registroCabezaC.getLiga();
                }

                siguienteFilaA = siguienteFilaA.getLigaFila();
            }

            registroCabezaA = registroCabezaA.getLiga();
        }

        Forma1 resultado = new Forma1();
        resultado.Construir(matrizResultado);
        cabeza = resultado.getCabeza();

    }
}
