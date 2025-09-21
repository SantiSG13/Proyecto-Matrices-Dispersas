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
        matrizTripleta = matrizTripleta;
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

    public void InsertarDato() {
        int filaDelnuevoDato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila del nuevo dato (0 a " + (matrizTripleta[0][0] - 1) + "):"));
        int columnaDelnuevoDato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna del nuevo dato (0 a " + (matrizTripleta[0][1] - 1) + "):"));
        int nuevoDato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del nuevo dato (diferente de 0):"));

        if (filaDelnuevoDato < 0 || filaDelnuevoDato >= matrizTripleta[0][0] || columnaDelnuevoDato < 0 || columnaDelnuevoDato >= matrizTripleta[0][1]) {
            JOptionPane.showMessageDialog(null, "Error: La fila o columna está fuera de los límites de la matriz original.");
            return;
        }
        if (nuevoDato == 0) {
            JOptionPane.showMessageDialog(null, "Error: El valor del nuevo dato debe ser diferente de 0.");
            return;
        }

        if (matrizTripleta[filaDelnuevoDato][columnaDelnuevoDato] != 0) {
            matrizTripleta[filaDelnuevoDato][columnaDelnuevoDato] += nuevoDato;
        }
        else {
            int[][] nuevaMatrizTripleta = new int[matrizTripleta[0][2] + 2][3];

            for (int i = 0; i <= matrizTripleta[0][2]; i++) {
                for (int j = 0; j < 3; j++) {
                    nuevaMatrizTripleta[i][j] = matrizTripleta[i][j];
                }
            }

            nuevaMatrizTripleta[matrizTripleta[0][2] + 1][0] = filaDelnuevoDato;
            nuevaMatrizTripleta[matrizTripleta[0][2] + 1][1] = columnaDelnuevoDato;
            nuevaMatrizTripleta[matrizTripleta[0][2] + 1][2] += nuevoDato;
            nuevaMatrizTripleta[0][2] = matrizTripleta[0][2] + 1;

            matrizTripleta = nuevaMatrizTripleta;
        }
    }

    public void OrdenarTripleta() {
        int datos = matrizTripleta[0][2];
        for (int i = 1; i < datos; i++) {
            for (int j = i + 1; j <= datos; j++) {
                int filaI = matrizTripleta[i][0];
                int filaJ = matrizTripleta[j][0];
                int colI = matrizTripleta[i][1];
                int colJ = matrizTripleta[j][1];

                if (filaI > filaJ || (filaI == filaJ && colI > colJ)) {
                    // Intercambiar las tripletas
                    for (int k = 0; k < 3; k++) {
                        int temp = matrizTripleta[i][k];
                        matrizTripleta[i][k] = matrizTripleta[j][k];
                        matrizTripleta[j][k] = temp;
                    }
                }
            }
        }
    }

    public void EliminarDato() {
        int dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato que quiere eliminar"));

        int contadorDato = 0;
        for (int k = 1; k <= matrizTripleta[0][2]; k++) {
           if (matrizTripleta[k][2] == dato) {
               contadorDato++;
           }
        }

        if (contadorDato == 0) {
            JOptionPane.showMessageDialog(null, "El dato no se encuentra en la tripleta");
            return;
        }

        int[][] nuevaMatrizTripleta = new int[matrizTripleta[0][2] - contadorDato + 1][3];
        nuevaMatrizTripleta[0][0] = matrizTripleta[0][0];
        nuevaMatrizTripleta[0][1] = matrizTripleta[0][1];
        nuevaMatrizTripleta[0][2] = matrizTripleta[0][2] - contadorDato;

        int k = 1;
        for (int i = 1; i <= matrizTripleta[0][2]; i++) {
            if (matrizTripleta[i][2] != dato) {
                nuevaMatrizTripleta[k][0] = matrizTripleta[i][0];
                nuevaMatrizTripleta[k][1] = matrizTripleta[i][1];
                nuevaMatrizTripleta[k][2] = matrizTripleta[i][2];
                k++;
            }
        }

        matrizTripleta = nuevaMatrizTripleta;
        JOptionPane.showMessageDialog(null, "El dato ha sido eliminado correctamente");
    }

    public void EliminarPosicion() {
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila a eliminar (0 a " + (matrizTripleta[0][0] - 1) + "):"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna a eliminar (0 a " + (matrizTripleta[0][1] - 1) + "):"));

        if (fila < 0 || fila >= matrizTripleta[0][0] || columna < 0 || columna >= matrizTripleta[0][1]) {
            JOptionPane.showMessageDialog(null, "Error: La fila o columna está fuera de los límites.");
            return;
        }

        boolean posicionEncontrada = false;
        for (int k = 1; k <= matrizTripleta[0][2]; k++) {
            if (matrizTripleta[k][0] == fila && matrizTripleta[k][1] == columna) {
                posicionEncontrada = true;
                break;
            }
        }

        if (!posicionEncontrada) {
            JOptionPane.showMessageDialog(null, "No existe dato en esa posición.");
            return;
        }

        int[][] nuevaMatrizTripleta = new int [matrizTripleta[0][2]] [3];
        nuevaMatrizTripleta[0][0] = matrizTripleta[0][0];
        nuevaMatrizTripleta[0][1] = matrizTripleta[0][1];
        nuevaMatrizTripleta[0][2] = matrizTripleta[0][2] - 1;

        int k = 1;
        for (int i = 1; i <= matrizTripleta[0][2]; i++) {
            if (matrizTripleta[i][0] != fila || matrizTripleta[i][1] != columna) {
                nuevaMatrizTripleta[k][0] = matrizTripleta[i][0];
                nuevaMatrizTripleta[k][1] = matrizTripleta[i][1];
                nuevaMatrizTripleta[k][2] = matrizTripleta[i][2];
                k++;
            }
        }

        matrizTripleta = nuevaMatrizTripleta;
        JOptionPane.showMessageDialog(null, "Dato eliminado en la posición indicada.");
    }

    public void SumarMatricesTripleta(Tripleta T2) {
    }

    public void MultiplicarMatricesTripleta(Tripleta T3) {
        int filasInicialesA = matrizTripleta[0][0];
        int columnasInicialesA = matrizTripleta[0][1];
        int filasInicialesB = T3.matrizTripleta[0][0];
        int columnasInicialesB = T3.matrizTripleta[0][1];
        
        if (columnasInicialesA != filasInicialesB) {
            JOptionPane.showMessageDialog(null, "Error: Las matrices no son compatibles para multiplicación. Columnas de A (" + columnasInicialesA + ") es diferente de Filas de B (" + filasInicialesB + ").", "Matrices Incompatibles", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Proceder con la multiplicación
        int filasResultado = filasInicialesA;
        int columnasResultado = columnasInicialesB;

        // Crear matriz temporal para almacenar el resultado denso (pequeña y simple)
        int[][] matrizTemporal = new int[filasResultado][columnasResultado];

        // Para cada elemento no cero en A y B
        for (int i = 1; i <= matrizTripleta[0][2]; i++) {
            int filaA = matrizTripleta[i][0];
            int columnaA = matrizTripleta[i][1];
            int valorA = matrizTripleta[i][2];

            for (int j = 1; j <= T3.matrizTripleta[0][2]; j++) {
                int filaB = T3.matrizTripleta[j][0];
                int columnaB = T3.matrizTripleta[j][1];
                int valorB = T3.matrizTripleta[j][2];

                if (columnaA == filaB) {
                    matrizTemporal[filaA][columnaB] += valorA * valorB;
                }
            }
        }

        // Contar elementos no ceros
        int datosNoCeros = 0;
        for (int i = 0; i < filasResultado; i++) {
            for (int j = 0; j < columnasResultado; j++) {
                if (matrizTemporal[i][j] != 0) datosNoCeros++;
            }
        }

        // Crear tripleta resultado
        Tripleta nuevaMatrizTripleta = new Tripleta(filasResultado, columnasResultado, datosNoCeros);
        int k = 1;
        for (int i = 0; i < filasResultado; i++) {
            for (int j = 0; j < columnasResultado; j++) {
                if (matrizTemporal[i][j] != 0) {
                    nuevaMatrizTripleta.matrizTripleta[k][0] = i;
                    nuevaMatrizTripleta.matrizTripleta[k][1] = j;
                    nuevaMatrizTripleta.matrizTripleta[k][2] = matrizTemporal[i][j];
                    k++;
                }
            }
        }

        matrizTripleta = nuevaMatrizTripleta.matrizTripleta;
    }
}
