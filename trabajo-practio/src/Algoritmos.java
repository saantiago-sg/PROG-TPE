import java.util.ArrayList;
import java.util.List;

public class Algoritmos {

    /*
     * Estrategia Backtracking:
     * - Se genera un arbol de exploracion donde cada nodo representa una activacion de una máquina.
     * - Se exploran todas las combinaciones posibles de cada una de las maquinas, sumando las piezas que produce cada una.
     * - Un estado solucion es aquel donde la suma total de piezas alcanza exactamente el objetivo.
     * - Se utiliza la poda cuando la suma parcial de piezas supera el objetivo, ya que no puede seguir en una solucion valida.
     * - Se guarda la mejor solucion como aquella con menor cantidad de puestas en funcionamiento (menor tamaño de la lista).
     * - Se mide el costo de la solucion como la cantidad total de estados generados durante la busqueda.
     */
    public static Solucion backtracking(int piezasObjetivo, List<Maquina> maquinas) {
        Solucion mejor = new Solucion();
        backtrack(new ArrayList<>(), 0, piezasObjetivo, maquinas, mejor, new int[]{0});
        return mejor;
    }

    private static void backtrack(List<String> actual, int suma, int objetivo, List<Maquina> maquinas, Solucion mejor, int[] costo) {
        costo[0]++;
        if (suma == objetivo) {
            if (mejor.getSecuencia().isEmpty() || actual.size() < mejor.getPuestasEnFuncionamiento()) {
                mejor.setSecuencia(new ArrayList<>(actual));
                mejor.setTotalPiezas(suma);
                mejor.setPuestasEnFuncionamiento(actual.size());
                mejor.setCosto(costo[0]);
            }
            return;
        }

        if (suma > objetivo) return;

        for (Maquina m : maquinas) {
            actual.add(m.getNombre());
            backtrack(actual, suma + m.getPiezas(), objetivo, maquinas, mejor, costo);
            actual.remove(actual.size() - 1);
        }
    }

    /*
     * Estrategia Greedy:
     * - En cada paso, se selecciona la maquina que produzca la mayor cantidad de piezas posible sin superar el objetivo restante.
     * - Los candidatos son todas las maquinas que la  producción no exceda el valor restante.
     * - Se va armando la solucion paso a paso, sumando una maquina a la vez, eligiendo en cada paso la mejor opcion disponible en ese momento.
     * - Puede no encontrar una solución exacta si ninguna combinacion "codiciosa" suma justo el objetivo.
     * - La metrica del costo es la cantidad total de candidatos evaluados durante la seleccion.
     */
    public static Solucion greedy(int piezasObjetivo, List<Maquina> maquinas) {
        Solucion sol = new Solucion();
        int restante = piezasObjetivo;

        while (restante > 0) {
            Maquina mejor = null;
            for (Maquina m : maquinas) {
                sol.setCosto(sol.getCosto() + 1); // se incrementa por cada candidato considerado
                if (m.getPiezas() <= restante && (mejor == null || m.getPiezas() > mejor.getPiezas())) {
                    mejor = m;
                }
            }
            if (mejor == null) break;

            sol.agregarMaquina(mejor.getNombre());
            sol.setTotalPiezas(sol.getTotalPiezas() + mejor.getPiezas());
            sol.setPuestasEnFuncionamiento(sol.getPuestasEnFuncionamiento() + 1);
            restante -= mejor.getPiezas();
        }

        return sol;
    }
}
