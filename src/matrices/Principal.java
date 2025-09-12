package matrices;

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        int opc = 0;

        int f = 4;
        int c = 5;
        //int filas = Integer.parseInt(JOptionPane.showInputDialog("Digite el nÃºmero de filas que quiere que tenga la matriz original: \n"));
        //int columnas = Integer.parseInt(JOptionPane.showInputDialog("Digite el nÃºmero de columnas que quiere que tenga la matriz original: \n"));
        int[][] matrizOriginal = new int[f][c];
        LlenarMatriz(matrizOriginal);
        MostrarMatriz(matrizOriginal);

        //Tripleta T1 = new Tripleta(matrizOriginal.length, matrizOriginal[0].length, 5);
        //F1.Construir(matrizOriginal);

        do {
            opc = MenuFormas();
            switch (opc) {
                case 1:
                    //T1.Construir(matrizOriginal);
                    //T1.Mostrar();
                    break;
                case 2:
                    //F1.Construir(matrizOriginal);
                    //F1.Mostrar();
                    break;
                case 3:
                    //F3.Construir(matrizOriginal);
                    //F3.Mostrar();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "OpciÃ³n invÃ¡lida");
            }
        } while (opc != 0);
    }

    public static int MenuFormas() {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Digite la opciÃ³n que desea realizar: \n"
                + "1. Tripleta \n"
                + "2. Forma 1 \n"
                + "3. Forma 3 \n"
                + "4. Salir \n"));
        return opcion;
    }

    public static void LlenarMatriz(int[][] matriz) {
        matriz[0][0] = 1;
        matriz[0][3] = 2;
        matriz[1][1] = 3;
        matriz[2][4] = -4;
        matriz[3][0] = 5;
        matriz[3][1] = -6;
    }

    public static void MostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }


}
