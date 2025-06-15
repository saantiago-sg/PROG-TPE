import java.util.ArrayList;
import java.util.List;

public class Solucion {
    protected List<String> secuencia;
    protected int totalPiezas;
    protected int puestasEnFuncionamiento;
    protected int costo;

    public Solucion(){
        this.secuencia = new ArrayList<String>();
        this.totalPiezas = 0;
        this.puestasEnFuncionamiento = 0;
        this.costo = 0;
    }

    public void mostrar(String metodo) {
        System.out.println(metodo);
        System.out.println("Solucion obtenida: secuencia de maquinas: " + secuencia);
        System.out.println("Solucion obtenida: cantidad de piezas producidas = " + totalPiezas +
                " y cantidad de puestas en funcionamiento requeridas = " + puestasEnFuncionamiento + ".");
        System.out.println("Metrica para analizar el costo de la solucion (" +
                (metodo.equals("Backtracking") ? "cantidad de estados generados" : "cantidad de candidatos considerados") +
                "): " + costo);
        System.out.println();
    }

}
