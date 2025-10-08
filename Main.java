package Detetive;
import Detetive.suspeitos.osSupeitos;
import Detetive.votacao.Votos;



public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao jogo de detetive!");
        System.out.println("Quem matou Odete Roitman?");
        osSupeitos saoSuspeitos = new osSupeitos();

        // Aqui você decide qual é o assassino REAL.
        // Ex.: marcar César como assassino real:
        // assassinos.getSuspeitos()[1].setAssassino(true);

        // Defina apenas UM verdadeiro assassino:
        saoSuspeitos.getSuspeitos()[saoSuspeitos.escolherAssassinoUniforme()].setAssassino(true);
         //saoSuspeitos.getSuspeitos()[0].setAssassino(true); // <-- exemplo: César

        // Iniciar votação com exatamente 20 pessoas:
        int quantidadeVotantes = 1;
        saoSuspeitos.iniciarVotacao(quantidadeVotantes);

        // Apurar e mostrar resultados:
        Votos apurador = new Votos();
        apurador.apurar(saoSuspeitos);
    }
}
