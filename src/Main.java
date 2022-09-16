import backend.Juego;
import frontend.IU;

public class Main {
    public static void main(String[] args){
        Juego juego = new Juego();
        IU iu = new IU(juego);
        iu.jugar();
    }
}
