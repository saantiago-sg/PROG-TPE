import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String ruta = "trabajo-practio/src/utils/config.txt";
            LectorDeArchivos.Pair<Integer, List<Maquina>> datos = LectorDeArchivos.leerConfiguracion(ruta);

            int piezasObjetivo = datos.primero;
            List<Maquina> maquinas = datos.segundo;

            Solucion sBack = Algoritmos.backtracking(piezasObjetivo, maquinas);
            Solucion sGreedy = Algoritmos.greedy(piezasObjetivo, maquinas);

            sBack.mostrar("Backtracking");
            sGreedy.mostrar("Greedy");
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}