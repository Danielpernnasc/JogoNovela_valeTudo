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
- Um número definido de votantes (padrão: 1) vota digitando um número entre 1 a 5.
- Cada voto válido incrementa a contagem do suspeito escolhido.
- Entradas inválidas (não numéricas ou fora do intervalo 1–5) não contam e o sistema pede novamente.
- Ao final:
  - O sistema imprime o voto escolhido.
  - Revela o assassino real e informa se acertou ou não.

## Fluxo do Jogo
1. Mostrar os 5 suspeitos.
2. O jogaor escolhe um do deles
3. O console roda o algoritmo e mostra o Assassino
4. Imprime no terminal se você acertou ou erro

## Como definir o assassino real
No arquivo Main.java:
- Marque exatamente um suspeito como assassino real, por índice (0-based):
- Exemplo para marcar “César” (posição 1 na lista):

O sistema fara a logica da probabilidade e mostara o assassino 

int quantidadeVotantes = 0; // altere aqui
