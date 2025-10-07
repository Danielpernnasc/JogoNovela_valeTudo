package Detetive.killer;

// Ensure the file is saved in the directory: c:/Users/Daniel/Desktop/JavaSpringBoot/ValeTudo/Detetive/killer/

public class Oassassino {
    private String nome;
    private boolean assassino;

    public Oassassino(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public boolean isAssassino() { return assassino; }
    public void setAssassino(boolean assassino) { this.assassino = assassino; }

    @Override
    public String toString() {
        return nome + (assassino ? " (ASSASSINO REAL)" : "");
    }
}