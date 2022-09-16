package frontend;
import backend.Juego;
import backend.Tablero;

import java.util.Scanner;

public class IU {
    private Scanner scanner;
    private Juego juego;
    public IU(Juego juego) {
        scanner = new Scanner(System.in);
        this.juego=juego;
    }
    public void jugar(){
        System.out.println("a jugar");
        boolean termine = false;
        while (!termine){
            mostrarTablero();
            mostrarSigSubSig(juego.getSig(), juego.getSubsig());
            int columna = pedirColumna(juego.getTablero().getCantColumnas());
            if (columna<0){
                termine =true;
            }else {
                if (columna<juego.getTablero().getCantColumnas()){
                    if(hayPosLibre(columna)){
                        int posColumna = hallarPosLibre(columna);
                        aniadirAlTablero(juego.getSig(), posColumna,columna);
                        juego.actualizarSigSubSig();
                    }else {
                        mostrarColumnaLlena();
                    }
                }else {
                    mostrarColumnaNoExiste();
                }
            }
        }
    }
    private int hallarPosLibre(int columna){
        int cont=0;
        boolean encontre = false;
        while (cont<juego.getTablero().getCantFilas() && !encontre){
            if (juego.getTablero().getMatriz()[cont][columna].equals("   ")){
                encontre = true;
            }else cont++;
        }
        return cont;
        //return tablero.getPosicionesLibres()[columna]- tablero.getCantFilas();
    }
    private boolean hayPosLibre(int columna) {
        return juego.getTablero().getPosicionesLibres()[columna]>0;
    }
    private void aniadirAlTablero(int siguente, int posColumna,int columna) {
        //boolean boolAux = esPosibleSumar(siguente, posColumna,columna);
        juego.getTablero().getMatriz()[posColumna][columna]=""+siguente+"";
        juego.getTablero().getPosicionesLibres()[columna]--;
        System.out.println(juego.getTablero().getPosicionesLibres()[columna]);
    }
    private void mostrarTablero(){
        Tablero tablero = juego.getTablero();
        for (int i = tablero.getCantFilas()-1; i >= 0; i--) {
            for (int j = 0; j < tablero.getCantColumnas(); j++) {
                String pos = tablero.getMatriz()[i][j];
                int tamanio = pos.length();
                if(tamanio==1){
                    pos="  "+pos;
                }else {
                    if (tamanio==2){
                        pos=" "+pos;
                    }
                }
                System.out.print("|"+pos+"|");
            }
            System.out.println();
        }
    }
    public int pedirColumna(int colMax){
        System.out.println("columna(solo entre 1 y "+colMax+")");
        return scanner.nextInt()-1;
    }
    public void mostrarSigSubSig(int sig,int subsig){
        System.out.println("siguiente: |"+sig+"| subsiguiente: |"+subsig+"|" );
    }
    public void mostrarColumnaNoExiste(){
        //System.out.println("el tablero solo tiene "+ columna +" columnas no te pases we");
        System.out.println("Esa Columna no existe, elige otra");
    }
    public void mostrarColumnaLlena(){
        //System.out.println("columna "+ (columna+1) +" esta llena, elige otra we");
        System.out.println("esa columna esta llena, elige otra");
    }

}
