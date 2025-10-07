package Detetive.suspeitos;
import Detetive.killer.Oassassino;
import java.util.Scanner;

public class osSupeitos {
    private Oassassino[] suspeitos;
    private int[] votos;
    private final Scanner scanner = new Scanner(System.in);

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

    public Oassassino[] getSuspeitos() {
        return suspeitos;
    }

    public int[] getVotos() {
        return votos;
    }
}