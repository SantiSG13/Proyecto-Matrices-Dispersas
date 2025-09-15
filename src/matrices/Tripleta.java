package matrices;

import javax.swing.JOptionPane;

public class Tripleta {
    //Atributos
    private int[][] matrizTripleta;

    //Constructor
    public Tripleta(int filas, int columnas, int datos) {
        matrizTripleta = new int[datos + 1][3];
        matrizTripleta[0][0] = filas;
        matrizTripleta[0][1] = columnas;
        matrizTripleta[0][2] = datos;
    }

    //Getters
    public int[][] getMatrizTripleta() {
        return matrizTripleta;
    }

    //Setters
    public void setMatrizTripleta(int[][] matrizTripleta) {
        this.matrizTripleta = matrizTripleta;
    }

    //Getters sobrecarga para un dato puntual
    public int getMatrizTripleta(int k, int j) {
        return matrizTripleta[k][j];
    }

    //Setters sobrecarga para un dato puntual
    public void setMatrizTripleta(int k, int j, int dato) {
        matrizTripleta[k][j] = dato;
    }

    public void Construir(int [][] matrizOriginal) {
        int k = 1;
        for (int i = 0; i < matrizOriginal.length; i++) {  // Corregido: usar matrizOriginal.length
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                if (matrizOriginal[i][j] != 0) {
                    matrizTripleta[k][0] = i;
                    matrizTripleta[k][1] = j;
                    matrizTripleta[k][2] = matrizOriginal[i][j];
                    k++;
                }
            }
        }
    }

    public void MostrarTripleta(String titulo) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < matrizTripleta.length; i++) {
            for (int j = 0; j < matrizTripleta[0].length; j++) {
                resultado.append(String.format("%12d  ", matrizTripleta[i][j]));
            }
            resultado.append("\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString(), titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public void SumarFilas() {
        int[] vectorSumaFilas = new int[matrizTripleta[0][0]];

        for (int k = 1; k <= matrizTripleta[0][2]; k++) {
            vectorSumaFilas[matrizTripleta[k][0]] += matrizTripleta[k][2];
        }

        StringBuilder resultado2 = new StringBuilder();
        resultado2.append("SUMA DE FILAS:\n\n");

        for (int i = 0; i < vectorSumaFilas.length; i++) {
            resultado2.append(String.format("Fila %2d: %4d\n", i, vectorSumaFilas[i]));
        }

        JOptionPane.showMessageDialog(null, resultado2.toString(), "Suma por Filas", JOptionPane.INFORMATION_MESSAGE);
    }

    public void SumarColumnas() {
        int[] vectorSumaColumnas = new int[matrizTripleta[0][1]];

        for (int k = 1; k <= matrizTripleta[0][2]; k++) {
            vectorSumaColumnas[matrizTripleta[k][1]] += matrizTripleta[k][2];
        }

        StringBuilder resultado3 = new StringBuilder();
        resultado3.append("SUMA DE COLUMNAS:\n\n");

        for (int i = 0; i < vectorSumaColumnas.length; i++) {
            resultado3.append(String.format("Columna %2d: %4d\n", i, vectorSumaColumnas[i]));
        }

        JOptionPane.showMessageDialog(null, resultado3.toString(), "Suma por Columnas", JOptionPane.INFORMATION_MESSAGE);
    }
}
