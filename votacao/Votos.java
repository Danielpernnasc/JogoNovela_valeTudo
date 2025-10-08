// Ensure the package declaration is at the top of the file and no misplaced braces exist before this line
package Detetive.votacao;
import Detetive.killer.Oassassino;
import Detetive.suspeitos.osSupeitos;
import java.util.ArrayList;
import java.util.List;

// Import the Assassinos class if it exists in another package
 // Update the package path as needed

public class Votos {
   
   
    public void apurar(osSupeitos assassinos) {
       Oassassino[] suspeitos = assassinos.getSuspeitos();
        int[] voto = assassinos.getVotos();

        int totalVotos = 0;
        for (int v : voto) totalVotos += v;

        System.out.println("=== Resultado da Votação ===");
        int seuVoto = -1;
        for (int i = 0; i < suspeitos.length; i++) {
            System.out.println(suspeitos[i].getNome() + ": " + voto[i] + " voto");
            if (voto[i] > seuVoto) seuVoto = voto[i];
        }

        if (totalVotos == 0) {
            System.out.println("\nNenhum voto registrado.");
            return;
        }

        // lista de vencedores (pode haver empate)
        List<Integer> vencedores = new ArrayList<>();
        for (int i = 0; i < voto.length; i++) {
            if (voto[i] == seuVoto) vencedores.add(i);
        }

        if (vencedores.size() == 1) {
            int idx = vencedores.get(0);
            System.out.println(suspeitos[idx].getNome() + " (" + seuVoto + " voto)");
        } else {
            System.out.println("\nEmpate entre " + vencedores.size() + " suspeitos (cada um com " + seuVoto + " votos):");
            for (int idx : vencedores) {
                System.out.println("- " + suspeitos[idx].getNome());
            }
        }

        // descobrir o assassino real
        int idxAssassinoReal = -1;
        for (int i = 0; i < suspeitos.length; i++) {
            if (suspeitos[i].isAssassino()) {
                idxAssassinoReal = i;
                break;
            }
        }

        System.out.println("\n=== Revelação ===");
        if (idxAssassinoReal == -1) {
            System.out.println("Nenhum assassino real foi definido.");
        } else {
            System.out.println("O assassino real é: " + suspeitos[idxAssassinoReal].getNome());
            // checar se votação acertou
            boolean acertou = vencedores.contains(idxAssassinoReal);
            if (acertou) {
                System.out.println("Parabéns! a todos que acertaram "+ suspeitos[idxAssassinoReal].getNome() + ".");
              
            } else {
                System.out.println("Pena! Voçê não acertou o assassino.");
               
            }
        }
    }
}
