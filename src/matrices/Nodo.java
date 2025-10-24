package matrices;

public class Nodo {
    private int fila,columna, dato;
    private Nodo liga, ligaFila, ligaColumna;

    public Nodo(int fila, int columna, int dato) {
        this.fila = fila;
        this.columna = columna;
        this.dato = dato;
        this.liga = null;
        this.ligaFila = null;
        this.ligaColumna = null;
    }

    // Getters and Setters
    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getDato() {
        return dato;
    }
    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getLiga() {
        return liga;
    }
    public void setLiga(Nodo liga) {
        this.liga = liga;
    }

    public Nodo getLigaFila() {
        return ligaFila;
    }
    public void setLigaFila(Nodo ligaFila) {
        this.ligaFila = ligaFila;
    }

    public Nodo getLigaColumna() {
        return ligaColumna;
    }
    public void setLigaColumna(Nodo ligaColumna) {
        this.ligaColumna = ligaColumna;
    }


}
