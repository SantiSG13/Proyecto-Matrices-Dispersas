package matrices;

import javax.swing.JOptionPane;
import java.util.Random;

public class Principal {

    public static void main(String[] args) {
        int opc = 0;
        int opc2 = 0;

        int filas = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de filas de la matriz A: \n"));
        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de columnas de la matriz A: \n"));

        int[][] matrizOriginal = new int[filas][columnas];
        LlenarMatrizDispersa(matrizOriginal);
        MostrarMatriz("Matriz original",matrizOriginal);

        do {
            opc = MenuFormas();
            switch (opc) {
                case 1:
                    int datos = ContadorDatos(matrizOriginal);
                    Tripleta T1 = new Tripleta(matrizOriginal.length, matrizOriginal[0].length, datos);
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
                                T1.InsertarDato();
                                T1.MostrarTripleta("TRIPLETA        Fila    Columna   Dato\n");
                                break;
                            case 5:
                                T1.EliminarDato();
                                T1.MostrarTripleta("TRIPLETA        Fila    Columna   Dato\n");
                                break;
                            case 6:
                                T1.EliminarPosicion();
                                T1.MostrarTripleta("TRIPLETA        Fila    Columna   Dato\n");
                                break;
                            case 7:
                                int FilasA = T1.getMatrizTripleta(0,0);
                                int ColumnasA = T1.getMatrizTripleta(0,1);

                                int FilasB, ColumnasB;
                                do {
                                    FilasB = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de filas de la matriz B: \n"));
                                    ColumnasB = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de columnas de la matriz B: \n"));

                                    if (FilasA != FilasB || ColumnasA != ColumnasB) {
                                        JOptionPane.showMessageDialog(null, "Matrices incompatibles: filas de A (" + FilasA + ") deben ser iguales a filas de B (" + FilasB + ") y columnas de A (" + ColumnasA + ") deben ser iguales a columnas de B (" + ColumnasB + ").\nIntente de nuevo.", "Suma no posible", JOptionPane.ERROR_MESSAGE);
                                    }
                                } while (FilasA != FilasB || ColumnasA != ColumnasB);

                                int[][] matrizOriginalB = new int[FilasB][ColumnasB];
                                LlenarMatrizDispersa(matrizOriginalB);
                                MostrarMatriz("Matriz original B", matrizOriginalB);

                                int datosB = ContadorDatos(matrizOriginalB);
                                Tripleta T2 = new Tripleta(matrizOriginalB.length, matrizOriginalB[0].length, datosB);
                                T2.Construir(matrizOriginalB);

                                T1.SumarMatricesTripleta(T2);
                                T1.MostrarTripleta("RESULTADO    Fila    Columna   Dato\n");
                                break;
                            case 8:
                                int columnasA = T1.getMatrizTripleta(0,1);

                                int filasC, columnasC;
                                do {
                                    filasC = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de filas de la matriz C: \n"));
                                    columnasC = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de columnas de la matriz C: \n"));

                                    if (columnasA != filasC) {
                                        JOptionPane.showMessageDialog(null, "Matrices incompatibles: columnas de A (" + columnasA + ") deben ser iguales a filas de C (" + filasC + ").\nIntente de nuevo.", "Multiplicación no posible", JOptionPane.ERROR_MESSAGE);
                                    }
                                } while (columnasA != filasC);

                                int[][] matrizOriginalC = new int[filasC][columnasC];
                                LlenarMatrizDispersa(matrizOriginalC);
                                MostrarMatriz("Matriz original C", matrizOriginalC);

                                int datosC = ContadorDatos(matrizOriginalC);
                                Tripleta T3 = new Tripleta(matrizOriginalC.length, matrizOriginalC[0].length, datosC);
                                T3.Construir(matrizOriginalC);

                                T1.MultiplicarMatricesTripleta(T3);
                                T1.MostrarTripleta("RESULTADO    Fila    Columna   Dato\n");
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
                    Forma1 F1_A = new Forma1();
                    F1_A.Construir(matrizOriginal);
                    do {
                        opc2 = SubMenu();
                        switch (opc2) {
                            case 1:
                                F1_A.MostrarForma1PorFilas();
                                F1_A.MostrarForma1PorColumnas();
                                break;
                            case 2:
                                F1_A.SumarFilasForma1();
                                break;
                            case 3:
                                F1_A.SumarColumnasForma1();
                                break;
                            case 4:
                                F1_A.InsertarDatoForma1();
                                F1_A.MostrarForma1PorFilas();
                                F1_A.MostrarForma1PorColumnas();
                                break;
                            case 5:
                                F1_A.EliminarDatoForma1();
                                F1_A.MostrarForma1PorFilas();
                                F1_A.MostrarForma1PorColumnas();
                                break;
                            case 6:
                                F1_A.EliminarPosicionForma1();
                                F1_A.MostrarForma1PorFilas();
                                F1_A.MostrarForma1PorColumnas();
                                break;
                            case 7:
                                int FilasA = F1_A.getCabeza().getFila();
                                int ColumnasA = F1_A.getCabeza().getColumna();

                                int FilasB, ColumnasB;
                                do {
                                    FilasB = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de filas de la matriz B: \n"));
                                    ColumnasB = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de columnas de la matriz B: \n"));

                                    if (FilasA != FilasB || ColumnasA != ColumnasB) {
                                        JOptionPane.showMessageDialog(null, "Matrices incompatibles: filas de A (" + FilasA + ") deben ser iguales a filas de B (" + FilasB + ") y columnas de A (" + ColumnasA + ") deben ser iguales a columnas de B (" + ColumnasB + ").\nIntente de nuevo.", "Suma no posible", JOptionPane.ERROR_MESSAGE);
                                    }
                                } while (FilasA != FilasB || ColumnasA != ColumnasB);

                                int[][] matrizOriginalB = new int[FilasB][ColumnasB];
                                LlenarMatrizDispersa(matrizOriginalB);
                                MostrarMatriz("Matriz original B", matrizOriginalB);

                                Forma1 F1_B = new Forma1();
                                F1_B.Construir(matrizOriginalB);

                                F1_A.SumarMatricesForma1(F1_B);
                                F1_A.MostrarForma1PorFilas();
                                F1_A.MostrarForma1PorColumnas();
                                break;
                            case 8:
                                int columnasA = F1_A.getCabeza().getColumna();

                                int filasC, columnasC;
                                do{
                                    filasC = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de filas de la matriz C: \n"));
                                    columnasC = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de columnas de la matriz C: \n"));
                                    if (columnasA != filasC) {
                                        JOptionPane.showMessageDialog(null, "Matrices incompatibles: columnas de A (" + columnasA + ") deben ser iguales a filas de C (" + filasC + ").\nIntente de nuevo.", "Multiplicación no posible", JOptionPane.ERROR_MESSAGE);
                                    }
                                } while (columnasA != filasC);

                                int[][] matrizOriginalC = new int[filasC][columnasC];
                                LlenarMatrizDispersa(matrizOriginalC);
                                MostrarMatriz("Matriz original C", matrizOriginalC);

                                Forma1 F1_C = new Forma1();
                                F1_C.Construir(matrizOriginalC);

                                F1_A.MultiplicarMatricesForma1(F1_C);
                                F1_A.MostrarForma1PorFilas();
                                F1_A.MostrarForma1PorColumnas();
                                break;
                            case 0:
                                JOptionPane.showMessageDialog(null, "Saliendo del submenú");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida");
                        }
                    } while (opc2 != 0);
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

        int porcentaje = Integer.parseInt(JOptionPane.showInputDialog("Digite el porcentaje de datos útiles que quiere para su matriz (Por ejemplo 40): "));
        if (porcentaje < 1 || porcentaje > 100) {
            JOptionPane.showMessageDialog(null, "Porcentaje inválido. Debe estar entre 1 y 100.");
            porcentaje = 40;
        }

        int totalPosiciones = matriz.length * matriz[0].length;
        int posicionesConDatos = totalPosiciones * porcentaje / 100;

        int datosColocados = 0;
        while (datosColocados < posicionesConDatos) {
            int filaAleatoria = r.nextInt(matriz.length);
            int columnaAleatoria = r.nextInt(matriz[0].length);

            if (matriz[filaAleatoria][columnaAleatoria] == 0) {
                int valor = 0;
                while (valor == 0) {
                    valor = r.nextInt(19) - 9;
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
