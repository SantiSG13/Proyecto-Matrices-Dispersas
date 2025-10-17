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

        int datos = matrizTripleta[0][2];
        // 1) Buscar si ya existe la posición; si existe sumar y eliminar si queda 0
        for (int k = 1; k <= datos; k++) {
            if (matrizTripleta[k][0] == filaDelnuevoDato && matrizTripleta[k][1] == columnaDelnuevoDato) {
                matrizTripleta[k][2] += nuevoDato;
                // Si la suma da 0, eliminar esa tripleta
                if (matrizTripleta[k][2] == 0) {
                    int[][] nuevaMatricesTripleta = new int[datos][3]; // datos-1 + 1 para encabezado
                    nuevaMatricesTripleta[0][0] = matrizTripleta[0][0];
                    nuevaMatricesTripleta[0][1] = matrizTripleta[0][1];
                    nuevaMatricesTripleta[0][2] = datos - 1;

                    int l = 1;
                    for (int m = 1; m <= datos; m++) {
                        if (m == k) {
                            continue;
                        }
                        nuevaMatricesTripleta[l][0] = matrizTripleta[m][0];
                        nuevaMatricesTripleta[l][1] = matrizTripleta[m][1];
                        nuevaMatricesTripleta[l][2] = matrizTripleta[m][2];
                        l++;
                    }
                    matrizTripleta = nuevaMatricesTripleta;
                }
                return;
            }
        }

        // 2) No existe: insertar en orden (fila, luego columna)
        int[][] nuevaMatrizTripleta = new int[datos + 2][3]; // +1 para encabezado, +1 para nuevo dato
        nuevaMatrizTripleta[0][0] = matrizTripleta[0][0];
        nuevaMatrizTripleta[0][1] = matrizTripleta[0][1];
        nuevaMatrizTripleta[0][2] = datos + 1;

        // Determinar posición de inserción (pos entre 1 y datos+1)
        int pos = 1;
        while (pos <= datos) {
            int fil = matrizTripleta[pos][0];
            int col = matrizTripleta[pos][1];
            if (filaDelnuevoDato < fil || (filaDelnuevoDato == fil && columnaDelnuevoDato < col)) {
                break; // Encontrada la posición
            }
            pos++;
        }

        // Copiar elementos hasta pos-1
        int w = 1;
        for (int i = 1; i < pos; i++) {
            nuevaMatrizTripleta[w][0] = matrizTripleta[i][0];
            nuevaMatrizTripleta[w][1] = matrizTripleta[i][1];
            nuevaMatrizTripleta[w][2] = matrizTripleta[i][2];
            w++;
        }

        // Insertar el nuevo dato en w
        nuevaMatrizTripleta[w][0] = filaDelnuevoDato;
        nuevaMatrizTripleta[w][1] = columnaDelnuevoDato;
        nuevaMatrizTripleta[w][2] = nuevoDato;
        w++;

        // Copiar el resto
        for (int i = pos; i <= datos; i++) {
            nuevaMatrizTripleta[w][0] = matrizTripleta[i][0];
            nuevaMatrizTripleta[w][1] = matrizTripleta[i][1];
            nuevaMatrizTripleta[w][2] = matrizTripleta[i][2];
            w++;
        }

        matrizTripleta = nuevaMatrizTripleta;
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
        int [][] A = this.matrizTripleta;
        int [][] B = T2.matrizTripleta;
        int filas = A[0][0];
        int columnas = A[0][1];

        int[][] matrizAuxiliar = new int[filas][columnas];
        // 1. Copiar los valores de A
        for (int i = 1; i <= A[0][2]; i++) {
            matrizAuxiliar[A[i][0]][A[i][1]] = A[i][2];
        }
        // 2. Sumar los valores de B
        for (int j = 1; j <= B[0][2]; j++) {
            matrizAuxiliar[B[j][0]][B[j][1]] += B[j][2];
        }

        int datosNoCeros = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matrizAuxiliar[i][j] != 0) {
                    datosNoCeros++;
                }
            }
        }

        Tripleta nuevaTripleta = new Tripleta(filas, columnas, datosNoCeros);
        nuevaTripleta.Construir(matrizAuxiliar);

        this.matrizTripleta = nuevaTripleta.getMatrizTripleta();
    }

    public void MultiplicarMatricesTripleta(Tripleta T3) {
        int[][] A = this.matrizTripleta;
        int[][] B = T3.matrizTripleta;

        int filasResultado = A[0][0];
        int columnasResultado = B[0][1];

        int matrizAuxiliar[][] = new int[filasResultado][columnasResultado];
        for (int i = 1; i <= A[0][2]; i++) {
            for (int j = 1; j <= B[0][2]; j++) {
                if (A[i][1] == B[j][0]) {
                    matrizAuxiliar[A[i][0]][B[j][1]] += A[i][2] * B[j][2];
                }
            }
        }

        int datosNoCeros = 0;
        for (int i = 0; i < matrizAuxiliar.length; i++) {
            for (int j = 0; j < matrizAuxiliar[0].length; j++) {
                if (matrizAuxiliar[i][j] != 0) {
                    datosNoCeros++;
                }
            }
        }

        Tripleta nuevaTripleta = new Tripleta(filasResultado, columnasResultado, datosNoCeros);
        nuevaTripleta.Construir(matrizAuxiliar);

        this.matrizTripleta = nuevaTripleta.getMatrizTripleta();
    }
}
