package backend;
public class Juego {
    private final Tablero tablero;
    private int sig;
    private int subsig;
    private EstadoJuego estadoJuego;
    public enum EstadoJuego{
        ganado,perdido,sinEspacioC,enJuego;
    }
    public Juego(){
        estadoJuego = EstadoJuego.enJuego;
        tablero=new Tablero(5,6);
        int limite =256;
        actualizarSigSubSig();
    }
    public EstadoJuego aniadirJuego(int c){
        return EstadoJuego.enJuego;
    }
    public int getSig() {
        return sig;
    }
    public int getSubsig() {
        return subsig;
    }
    public EstadoJuego getEstadoJuego(){return estadoJuego;}

    public Tablero getTablero() {
        return tablero;
    }
    public void actualizarSigSubSig() {
        subsig = generarNumero();
        sig = subsig;
        subsig = generarNumero();
    }
    private int generarNumero() {
        return (int) (Math.pow(2, (int) (Math.random() * 5 + 1)));
    }
}
