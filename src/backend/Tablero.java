package backend;

public class Tablero {
    private final int cantFilas;
    private final int cantColumnas;
    private final String[][] matriz;
    private final int[] posicionesLibres;
    public Tablero(int cantFilas, int cantColumnas ){
        this.cantFilas = cantFilas;
        this.cantColumnas = cantColumnas;
        matriz = new String[cantFilas][cantColumnas];
        llenarMatriz();
        posicionesLibres = new int[cantColumnas];
        for (int i = 0; i < cantColumnas; i++) {
            posicionesLibres[i]=cantFilas;
        }
    }
    private void llenarMatriz(){
        for (int i = 0; i < cantFilas; i++) {
            for (int j = 0; j < cantColumnas; j++) {
                matriz[i][j]="   ";
            }
        }
    }
    public int getCantFilas() {
        return cantFilas;
    }
    public int getCantColumnas() {
        return cantColumnas;
    }
    public String[][] getMatriz() {
        return matriz;
    }
    public int[] getPosicionesLibres() {
        return posicionesLibres;
    }
}
