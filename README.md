Essa foi uma pratica realizada no Laboratorio de programacao 03 do Instituto Federal da Paraiba (IFPB), da cadeira de Estrutura de Dados. 
O desafio era implementar um programa Loja de Camisas que recebe uma base de Dados TXT, escolhendo a Estrutura de Dados mais adequada. 

A estrutura de dados escolhida foi o Arraylist. Como evidenciado no enunciado, o catálogo não sofrerá múltiplas inserções e remoções de camisas 
e também a ordem que esses dados serão dispostos não faz diferença. Por isso a escolha do Arraylist é apropriada, pois esta estrutura de dados 
é capaz de alocar esses dados muito facilmente graças aos seus métodos. 

Em Java há um conjunto de Classes e Interfaces chamadas de coleções (collections) que são coleções de estrutura de dados de diferentes aplicabilidades. 
A qual escolhemos para implementar em nosso projeto foi o Arraylist. Diferentemente do array convencional que é estático e quando tem sua capacidade atingida 
necessita de uma série de manipulações para aumentar (mais código).

O Arraylist traz consigo uma gama de métodos para facilitar a escalabilidade do projeto, além disso o arraylist por conta própria se redimensiona dinamicamente 
podendo aumentar e diminuir o tamanho em runtime conforme a necessidade. Internamente isso acontece porque nos bastidores do arraylist há uma série de array genéricos que trabalham 
criando um array maior e copiando o array menor para dentro do novo array. No entanto, para um grande fluxo de dados se torna inviável o uso do arraylist porque demanda de tempo 
e processamento para redimensionar todos esses dados, o que pode ocasionar um tráfego lento e pesado.

Em resumo, vantagens (quantidade de dados conhecida) o redimensionamento dinâmico, escalabilidade, aplicabilidade, fácil de manipular, a ordem de disposição dos dados não faz diferença.
Desvantagens se a quantidade de dados for desconhecida, havendo múltiplas inserções e remoções, no ato de se redimensionar ocasionará um tráfego muito grande 
gerando assim um maior processamento desses dados tornando lento o programa.
