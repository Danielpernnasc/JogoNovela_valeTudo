package Detetive;
import Detetive.suspeitos.osSupeitos;
import Detetive.votacao.Votos;


public class Main {
    public static void main(String[] args) {
        osSupeitos saoSuspeitos = new osSupeitos();

        // Aqui você decide qual é o assassino REAL.
        // Ex.: marcar César como assassino real:
        // assassinos.getSuspeitos()[1].setAssassino(true);

        // Defina apenas UM verdadeiro assassino:
         saoSuspeitos.getSuspeitos()[0].setAssassino(true); // <-- exemplo: César

        // Iniciar votação com exatamente 20 pessoas:
        int quantidadeVotantes = 20;
        saoSuspeitos.iniciarVotacao(quantidadeVotantes);

        // Apurar e mostrar resultados:
        Votos apurador = new Votos();
        apurador.apurar(saoSuspeitos);
    }
}
