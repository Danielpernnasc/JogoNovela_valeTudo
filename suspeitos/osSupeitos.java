package Detetive.suspeitos;
import Detetive.killer.Oassassino;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class osSupeitos {
    private Oassassino[] suspeitos;
    private int[] votos;
    private final Scanner scanner = new Scanner(System.in);
    private static final boolean DEBUG = false;




    public osSupeitos() {
        suspeitos = new Oassassino[] {
            new Oassassino("Maria de Fátima"),
            new Oassassino("César"),
            new Oassassino("Heleninha Roitman"),
            new Oassassino("Tia Celina"),
            new Oassassino("Marco Aurélio")
        };
        votos = new int[suspeitos.length];
    }


    public void iniciarVotacao(int quantidadeVotantes) {
        System.out.println("=== Votação: Quem matou Odete Roitman? ===");
        System.out.println("Serão " + quantidadeVotantes + " votantes. Digite o número do suspeito (1-" + suspeitos.length + ").");

        for (int i = 0; i < suspeitos.length; i++) {
            System.out.println((i + 1) + ". " + suspeitos[i].getNome());
        }

        int votosRegistrados = 0;
        while (votosRegistrados < quantidadeVotantes) {
            System.out.print("Voto " + (votosRegistrados + 1) + " de " + quantidadeVotantes + " (1-" + suspeitos.length + "): ");
            String line = scanner.nextLine().trim();
            int escolha;
            try {
                escolha = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número entre 1 e " + suspeitos.length + ".");
                continue;
            }

            // FIX: validar intervalo corretamente
            if (escolha >= 1 && escolha <= suspeitos.length) {
                votos[escolha - 1]++;
                votosRegistrados++;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("Votação finalizada.");
    }

    public int[] getVotos() {
        return votos;
    }


    /**
     * Escolhe um assassino baseado em probabilidades fornecidas.
     * @param probs Array de probabilidades (não normalizadas) para cada suspeito.
     *              Deve ter o mesmo tamanho que o array de suspeitos.
     *              Valores negativos são inválidos.
     *              Se a soma for 0, retorna erro.
     * @return Índice do suspeito escolhido como assassino, ou -1 em caso de erro.
     */

     public Oassassino[] getSuspeitos() {
        return suspeitos;
    }
    public int escolherAssassinoPorProbabilidade(double[] probs){
        if(probs == null || probs.length != suspeitos.length){
            System.out.println("Probs invalido: ");
            return -1;
        }

        double soma = 0;
        for (double p: probs){
            if (p < 0) {
                System.out.println("Probs inválidas: valores não podem ser negativos.");
                return -1;
            }
            soma += p;
        }
        if (soma == 0.0) {
            System.out.println("Probs inválidas: soma = 0. Use probs com pelo menos um valor > 0 ou chamar escolherAssassinoUniforme().");
            return -1;
        }

        double[] culpado = new double[probs.length];
        double acc = 0.0;
        for (int i  = 0; i < probs.length; i++){
            acc += (double) probs[i] / soma;
            culpado[i] = acc;
        }

        Random rand = new Random();
        double r = rand.nextDouble();

        int escolhido = 0;
        for (int i = 0; i < culpado.length; i++) {
            if (r < culpado[i]) {
                escolhido = i;
                break;
            }
        }

        resetarAssassino();
        suspeitos[escolhido].setAssassino(true);

        // Mostrar para debug
        System.out.printf(Locale.US, "Valor aleatório = %.4f -> escolhido: %s (índice %d)\n",
                r, suspeitos[escolhido].getNome(), escolhido);

        return escolhido;
    }

    public int escolherAssassinoUniforme(){
        Random rnd = new Random();
        double v = rnd.nextDouble();
        int idx = (int) Math.floor(v * suspeitos.length);
        if(idx >= suspeitos.length) idx = suspeitos.length - 1;
        if(DEBUG) {
            System.out.printf(Locale.US, "Valor aleat\u00F3rio = %.4f -> escolhido: %s (\\u00EDndice %d)%n",
             v, suspeitos[idx].getNome(), idx);
        }
        return idx;
    }


    // private void logEscolhaAleatoria(double v, int idx){
    //     if(DEBUG) {
    //         System.out.printf(Locale.US, "Valor aleat\u00F3rio = %.4f -> escolhido: %s (\\u00EDndice %d)%n",
    //          v, suspeitos[idx].getNome(), idx);
    //     }
    // }

    private void resetarAssassino() {
        for (Oassassino s : suspeitos) {
            s.setAssassino(false);
        }
    }


  
}