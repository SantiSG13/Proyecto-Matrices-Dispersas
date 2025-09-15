package matrices;

import javax.swing.JOptionPane;
import java.sql.SQLOutput;
import java.util.Random;

public class Principal {

    public static void main(String[] args) {
        int opc = 0;
        int opc2 = 0;

        int filas = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de filas: \n"));
        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de columnas: \n"));

        int[][] matrizOriginal = new int[filas][columnas];
        LlenarMatrizDispersa(matrizOriginal);
        MostrarMatriz("Matriz original",matrizOriginal);

        int datos = ContadorDatos(matrizOriginal);
        Tripleta T1 = new Tripleta(matrizOriginal.length, matrizOriginal[0].length, datos);

        do {
            opc = MenuFormas();
            switch (opc) {
                case 1:
                    T1.Construir(matrizOriginal);
                    do {
                        opc2 = SubMenu();
                        switch (opc2) {
                            case 1:
                                T1.MostrarTripleta("TRIPLETA        Fila    Columna   Dato\n");
                                break;
                            case 2:
                                T1.SumarFilas();
                                break;
                            case 3:
                                T1.SumarColumnas();
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                                break;
                            case 0:
                                JOptionPane.showMessageDialog(null, "Saliendo del submenú");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida");
                        }
                    } while (opc2 != 0);
                    break;
                case 2:
                    //F1.Construir(matrizOriginal);
                    //F1.Mostrar();
                    break;
                case 3:
                    //F3.Construir(matrizOriginal);
                    //F3.Mostrar();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opc != 0);
    }

    public static int MenuFormas() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("Digite la opción que desea realizar: \n"
                + "1. Tripleta \n"
                + "2. Forma 1 \n"
                + "3. Forma 3 \n"
                + "0. Salir \n"));
        return opc;
    }

    public static int SubMenu() {
        int opc2 = Integer.parseInt(JOptionPane.showInputDialog("Digite la opción que desea realizar: \n"
                + "1. Mostrar forma\n"
                + "2. Sumar filas\n"
                + "3. Sumar Columnas\n"
                + "4. Insertar un dato\n"
                + "5. Eliminar un dato\n"
                + "6. Eliminar una posición\n"
                + "7. Sumar dos matrices de la misma forma\n"
                + "8. Multiplicar dos matrices de la misma forma\n"
                + "0. Salir\n"));
        return opc2;
    }

    public static void LlenarMatrizDispersa(int[][] matriz) {
        Random r = new Random();

        // Calcular el número total de posiciones y cuántas deben tener datos (40%)
        int totalPosiciones = matriz.length * matriz[0].length;
        int posicionesConDatos = totalPosiciones * 40 / 100;

        // Seleccionar aleatoriamente las posiciones que tendrán datos
        int datosColocados = 0;
        while (datosColocados < posicionesConDatos) {
            int filaAleatoria = r.nextInt(matriz.length);
            int columnaAleatoria = r.nextInt(matriz[0].length);

            // Solo colocar dato si la posición está vacía (es 0)
            if (matriz[filaAleatoria][columnaAleatoria] == 0) {
                // Generar número aleatorio entre -20 y 20 (excluyendo el 0)
                int valor = 0;
                while (valor == 0) {
                    valor = r.nextInt(19) - 9; // Genera números entre -20 y 20
                }
                matriz[filaAleatoria][columnaAleatoria] = valor;
                datosColocados++;
            }
        }
    }

    public static void MostrarMatriz(String titulo, int[][] matriz) {
        StringBuilder resul = new StringBuilder();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                resul.append(String.format("%8d  ", matriz[i][j]));
            }
            resul.append("\n");
        }
        System.out.println(resul.toString());
        JOptionPane.showMessageDialog(null, resul.toString(), titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static int ContadorDatos(int[][] matriz) {
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != 0) {
                    contador++;
                }
            }
        }
        return contador;
    }
}
