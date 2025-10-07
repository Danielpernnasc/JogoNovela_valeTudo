# Detetive — Quem matou Odete Roitman?

Jogo de votação em console onde um grupo de pessoas vota em suspeitos e, ao final, o sistema apura os votos e revela se a votação acertou o assassino real.

## Regras do Jogo
- Há uma lista fixa de suspeitos:
  - 1. Maria de Fátima
  - 2. César
  - 3. Heleninha Roitman
  - 4. Tia Celina
  - 5. Marco Aurélio
- Exatamente um suspeito deve ser marcado como assassino real (no código).
- Um número definido de votantes (padrão: 20) vota digitando um número entre 1 a 5.
- Cada voto válido incrementa a contagem do suspeito escolhido.
- Entradas inválidas (não numéricas ou fora do intervalo 1–5) não contam e o sistema pede novamente.
- Ao final:
  - O sistema imprime os votos de cada suspeito.
  - Identifica o(s) mais votado(s). Em caso de empate, lista todos.
  - Revela o assassino real e informa se a votação acertou.

## Fluxo do Jogo
1. Definir o assassino real no início da execução.
2. Informar a quantidade de votantes.
3. Coletar votos no console até atingir o total.
4. Apurar e exibir o resultado, desempates e a revelação do assassino real.

## Como definir o assassino real
No arquivo Main.java:
- Marque exatamente um suspeito como assassino real, por índice (0-based):
- Exemplo para marcar “César” (posição 1 na lista):

```java
assassinos.getSuspeitos()[1].setAssassino(true);

int quantidadeVotantes = 20; // altere aqui