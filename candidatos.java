import java.util.*;

public class problema_candidatos {

    public static void main(String[] args) {
        if (args == null) {
            return;
        }
        problema_candidatos problema_candidatos = new problema_candidatos();
        int[] Ranked;
        Ranked = new int[] {2, 4, 6, 3, 9, 5, 7, 8};
  
        System.out.printf("Orden de clasificación en el que entran los candidatos: %s%n", Arrays.toString(Ranked));

        int númeroDeCandidatosContratados = problema_candidatos.contratar(Ranked);
        System.out.printf("Número de candidatos contratados: %d%n", númeroDeCandidatosContratados);
	
        int Número_de_candidatos_contratados_al_azar = problema_candidatos.aleatorizacion_trabajadores(Ranked);
        System.out.printf("Después de algoritmos aleatorios, número de candidatos a contratar: %d%n", Número_de_candidatos_contratados_al_azar);
    }

    public int contratar(int[] candidatos) {
        int mejor = 0;
        int contratados = 0;
        for (int i = 0; i < candidatos.length; ++i) {
            if (candidatos[i] > mejor) {
                mejor = candidatos[i];
                contratados ++;
            }
        }
        return contratados;
    }

    public int aleatorizacion_trabajadores(int[] candidatos) {
        int[] lista_candidatos = Arrays.copyOf(candidatos, candidatos.length);
        aleatorizar_lugar(lista_candidatos);
        return contratar(lista_candidatos);
    }

    private void aleatorizar_lugar(int[] candidatos) {
        Random random = new Random();
        int n = candidatos.length;
        for (int i = 0; i < n; ++i) {
            intercambio(candidatos, i, random.nextInt(n - i) + i);
        }
    }

    private void intercambio(int[] candidatos, int a, int b) {
        int aux = candidatos[a];
        candidatos[a] = candidatos[b];
        candidatos[b] = aux;
    }
}
