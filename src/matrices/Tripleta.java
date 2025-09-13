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

    public void MostrarTripleta() {
        for (int i = 0; i < matrizTripleta.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matrizTripleta[0].length; j++) {
                System.out.printf("%3d | ", matrizTripleta[i][j]);
            }
            System.out.println();
        }
    }

    public void MostrarTripletaConStringBuilder(String titulo) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < matrizTripleta.length; i++) {
            for (int j = 0; j < matrizTripleta[0].length; j++) {
                resultado.append(String.format("%12d  ", matrizTripleta[i][j]));
            }
            resultado.append("\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString(), titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
