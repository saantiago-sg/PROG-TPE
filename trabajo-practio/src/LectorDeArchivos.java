import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LectorDeArchivos {
    public static Pair<Integer, List<Maquina>> leerConfiguracion(String ruta) throws IOException {
        List<String> lineas = Files.readAllLines(Paths.get(ruta));
        int piezasTotales = Integer.parseInt(lineas.get(0).trim());
        List<Maquina> maquinas = new ArrayList<>();

        for (int i = 1; i < lineas.size(); i++) {
            String[] partes = lineas.get(i).split(",");
            maquinas.add(new Maquina(partes[0].trim(), Integer.parseInt(partes[1].trim())));
        }

        return new Pair<>(piezasTotales, maquinas);
    }

    public static class Pair<K, V> {
        public final K primero;
        public final V segundo;

        public Pair(K primero, V segundo) {
            this.primero = primero;
            this.segundo = segundo;
        }
    }
}
