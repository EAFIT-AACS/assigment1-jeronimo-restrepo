import java.util.*;

public class Main {
    public static List<String> minimizarDFA(int n, int m, int[][] transiciones, Set<Integer> estadosFinales) {
        boolean[][] diferente = new boolean[n][n]; 


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (estadosFinales.contains(i) != estadosFinales.contains(j)) {
                    diferente[i][j] = true;
                }
            }
        }

        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (!diferente[i][j]) {
                        for (int k = 0; k < m; k++) {
                            int nextI = transiciones[i][k];
                            int nextJ = transiciones[j][k];
                            if (nextI != nextJ && diferente[Math.min(nextI, nextJ)][Math.max(nextI, nextJ)]) {
                                diferente[i][j] = true;
                                changed = true;
                                break;
                            }
                        }
                    }
                }
            }
        } while (changed);

        // Obtener los pares equivalentes en formato (sX, sY)
        List<String> paresEquivalentes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!diferente[i][j]) {
                    paresEquivalentes.add("(s" + i + ", s" + j + ")");
                }
            }
        }

        return paresEquivalentes;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de casos de prueba: ");
        int casos = scanner.nextInt();

        List<String> resultados = new ArrayList<>();  
        for (int c = 0; c < casos; c++) {
            System.out.print("Ingrese el número de estados: ");
            int numeroEstados = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese el alfabeto separado por espacios: ");
            String[] alfabeto = scanner.nextLine().split(" ");

            System.out.print("Ingrese los estados finales separados por espacios: ");
            Set<Integer> estadosFinales = new HashSet<>();
            String entradaEstadosFinales = scanner.nextLine().trim();
            if (!entradaEstadosFinales.isEmpty()) {
                for (String s : entradaEstadosFinales.split(" ")) {
                    estadosFinales.add(Integer.parseInt(s));
                }
            }


            int[][] transiciones = new int[numeroEstados][alfabeto.length];
            System.out.println("Ingrese la tabla de transiciones, cada fila es un estado: ");
            for (int i = 0; i < numeroEstados; i++) {
                System.out.print("Estado s" + i + ": ");
                String[] partes = scanner.nextLine().split(" ");
                for (int j = 0; j < alfabeto.length; j++) {
                    transiciones[i][j] = Integer.parseInt(partes[j]);
                }
            }


            List<String> paresEquivalentes = minimizarDFA(numeroEstados, alfabeto.length, transiciones, estadosFinales);


            resultados.add(String.join(" ", paresEquivalentes));
        }


        System.out.println("\nResultados:");
        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    }

   
}    
