import java.util.ArrayList;
import java.util.List;

public class Solucion {
    private List<String> secuencia;
    private int totalPiezas;
    private int puestasEnFuncionamiento;
    private int costo;

    public Solucion(){
        this.secuencia = new ArrayList<String>();
        this.totalPiezas = 0;
        this.puestasEnFuncionamiento = 0;
        this.costo = 0;
    }
    public List<String> getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(List<String> secuencia) {
        this.secuencia = secuencia;
    }

    public void agregarMaquina(String nombre) {
        this.secuencia.add(nombre);
    }

    public int getTotalPiezas() {
        return totalPiezas;
    }

    public void setTotalPiezas(int totalPiezas) {
        this.totalPiezas = totalPiezas;
    }

    public int getPuestasEnFuncionamiento() {
        return puestasEnFuncionamiento;
    }

    public void setPuestasEnFuncionamiento(int puestas) {
        this.puestasEnFuncionamiento = puestas;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
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
