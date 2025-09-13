package matrices;

import javax.swing.JOptionPane;
import java.sql.SQLOutput;
import java.util.Random;

public class Principal {

    public static void main(String[] args) {
        int opc = 0;
        int opc2 = 0;

        int[][] matrizOriginal = {{10, 0, 0},{7, 0, 0},  {0, 1, 0},{0, 2, -6},{0, 0, -1}};
        MostrarMatriz(matrizOriginal);
        Tripleta T1 = new Tripleta(matrizOriginal.length, matrizOriginal[0].length, ContadorDatos(matrizOriginal));

//        int filas = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de filas: \n"));
//        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de columnas: \n"));
//        int[][] matrizOriginal = new int[filas][columnas];
//        LlenarMatriz(matrizOriginal);
//        MostrarMatriz(matrizOriginal);
//
//        int datos = ContadorDatos(matrizOriginal);
//        Tripleta T1 = new Tripleta(matrizOriginal.length, matrizOriginal[0].length, datos);

        do {
            opc = MenuFormas();
            switch (opc) {
                case 1:
                    T1.Construir(matrizOriginal);
                    do {
                        opc2 = SubMenu();
                        switch (opc2) {
                            case 1:
                                T1.MostrarTripletaConStringBuilder("TRIPLETA        Fila    Columna   Dato\n");
                                break;
                            case 2:
                                break;
                            case 3:
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

    public static void LlenarMatriz(int[][] matriz) {
        Random r = new Random(); //Creamos una instancia de random
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = r.nextInt(100);
            }
        }
    }

    public static void MostrarMatriz(int[][] matriz) {
        System.out.println("---------------------");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%3d | ", matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }

    public static int ContadorDatos(int[][] matriz) {
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != 0) {
                    contador++;
                }
            }
        }
        return contador;
    }
}
