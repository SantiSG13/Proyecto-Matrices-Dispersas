package matrices;

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

    }

    public void Mostrar() {

    }
}
