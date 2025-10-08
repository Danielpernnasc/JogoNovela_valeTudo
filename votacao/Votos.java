package Detetive.votacao;
import Detetive.killer.Oassassino;
import Detetive.suspeitos.osSupeitos;
import java.util.ArrayList;
import java.util.List;



public class Votos {
    public void apurar(osSupeitos assassinos) {
        Oassassino[] suspeitos = assassinos.getSuspeitos();
        int[] voto = assassinos.getVotos();

        int totalVotos = 0;
        for (int v : voto) totalVotos += v;

        System.out.println("=== Resultado da Vota\u00E7\u00E3o ===");
        int maior = -1;
        for (int i = 0; i < suspeitos.length; i++) {
            System.out.println(suspeitos[i].getNome() + ": " + voto[i] + " voto" + (voto[i] == 1 ? "" : "s"));
            if (voto[i] > maior) maior = voto[i];
        }

        if (totalVotos == 0) {
            System.out.println("\nNenhum voto registrado.");
            return;
        }

        List<Integer> vencedores = new ArrayList<>();
        for (int i = 0; i < voto.length; i++) {
            if (voto[i] == maior) vencedores.add(i);
        }

        if (vencedores.size() == 1) {
            int idx = vencedores.get(0);
            System.out.println("Suspeito escolhido: " + suspeitos[idx].getNome() + " (" + maior + " voto" + (maior == 1 ? "" : "s") + ")");
        } else {
            System.out.println("\nEmpate entre " + vencedores.size() + " suspeitos (cada um com " + maior + " votos):");
            for (int idx : vencedores) {
                System.out.println("- " + suspeitos[idx].getNome());
            }
        }

        int idxAssassinoReal = -1;
        for (int i = 0; i < suspeitos.length; i++) {
            if (suspeitos[i].isAssassino()) {
                idxAssassinoReal = i;
                break;
            }
        }

        System.out.println("\n=== Revela\u00E7\u00E3o ===");
        if (idxAssassinoReal == -1) {
            System.out.println("Nenhum assassino real foi definido.");
        } else {
            System.out.println("O assassino real \u00E9: " + suspeitos[idxAssassinoReal].getNome());
            boolean acertou = vencedores.contains(idxAssassinoReal); // compara pelo índice
            if (acertou) {
                System.out.println("Parab\u00E9ns! Voc\u00EA acertou o assassino: " + suspeitos[idxAssassinoReal].getNome() + ".");
            } else {
                System.out.println("Pena! Voc\u00EA n\u00E3o acertou o assassino.");
            }
        }
    }
}
// ...existing code...