# Trabajo Práctico Especial: Producción de Piezas con Backtracking y Greedy

Este proyecto resuelve un problema de planificación de producción en una fábrica de autopartes, utilizando las técnicas de algoritmos: **Backtracking** y **Greedy**.

## 📁 Estructura del proyecto
PROG-TPE/

trabajo-practio

└── src/

└── utils/
 
├── Algoritmos.java # Implementación de Backtracking y Greedy

├── LectorDeArchivos.java # Lectura del archivo de configuración

├── Main.java # 🔰 Punto de entrada del programa

├── Maquina.java # Representación de una máquina

├── Solucion.java # Clase que representa una solución

└── config.txt # Archivo con datos de las maquinas

## 🚀 Ejecución

El programa lee el archivo `config.txt`, y resuelve el problema usando:

- Algoritmo de **Backtracking**: encuentra todas las combinaciones posibles.
- Algoritmo **Greedy**: selecciona siempre la máquina que produce más piezas.

Luego imprime por pantalla:

- La secuencia de máquinas utilizadas.
- Total de piezas producidas.
- Cantidad de veces que se encendieron máquinas.
- Costo computacional (estados o candidatos considerados).

## 🧠 Técnicas aplicadas

- **Backtracking** con poda para evitar ramas inútiles.
- **Greedy** eligiendo la máquina con más piezas por iteración.

---

## ✍️ Autor

Santiago Gauna
