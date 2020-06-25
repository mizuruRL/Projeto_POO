# Programação Orientada por Objetos

## BlockuDoku

#### A B C D E F G H I

#### 1 2 3 4 5 6 7 8 9

**Ano Letivo: 201 9 /20 20**

**Época Normal e de Recurso**

**2ª Fase**


## Indice

- 1. Introdução
- 2. Objetivos
- 3. Funcionalidades e requisitos de implementação
   - 3.1. Interface gráfica
   - 3.1. Requisitos da Implementação
- 4. Fases de desenvolvimento e entrega
- 5. Implementação e codificação
- 6. Constituição de grupos
- 7. Entrega do projeto
- 8. Regras e Critérios de Avaliação do Projeto
   - 8.1. Regras de Avaliação
   - 8.2. Critérios de Avaliação
- 9. Resumo das Datas Importantes
   - 9.1. Entrega da 2ª fase
   - 9.2. Avaliações da 2ª fase


## 1. Introdução

O objetivo deste projeto passa pelo desenvolvimento, utilizando a linguagem Java e a Programação
Orientada por Objetos (POO), de uma versão de um jogo de blocos chamado **BlockuDoku**.

O jogo **BlockuDoku** consiste numa mistura de Sudoku com jogo de blocos em que o principal objetivo do
jogo passa por efetuar o preenchimento de linhas, colunas ou quadrados, mantendo o tabuleiro com o
mínimo de blocos possíveis.

O projeto será desenvolvido em duas fases. A primeira fase consiste na modelação e implementação de
um conjunto de classes que permitam representar a lógica da aplicação e que permitam a sua utilização
em modo **consola**. A segunda fase será dedicada à criação da **interface gráfica** com o utilizador.

Tenha particular atenção ao uso do paradigma de POO na modelação das classes, i.e., ao correto uso dos
conceitos de encapsulamento, herança, classes abstratas, polimorfismo, interfaces, maximização da
coesão (responsabilidade única), minimização do acoplamento, desenho orientado por
responsabilidades, etc. Uma modelação bem pensada facilitará todo o processo de desenvolvimento e
manutenção.

**O presente documento refere-se apenas à segunda-fase do projeto.**


## 2. Objetivos

Na segunda fase do projeto o objetivo passa por desenvolver a interface gráfica, em JavaFx, que permita
ao utilizador interagir com o sistema concebido na primeira fase.

A interface gráfica **deve incluir todos os requisitos desenvolvidos na primeira fase** mais os indicados no
ponto 3.

## 3. Funcionalidades e requisitos de implementação

### 3.1. Interface gráfica

Deverá ser implementada uma interface gráfica, em JavaFX, que permita ao jogador efetuar todas as
opções relacionadas com o jogo. Em relação à primeira fase deverão também ser adaptados os seguintes
requisitos:

1. Deverá ser possível escolher o nome do ficheiro quando se grava o jogo
2. Deverá ser possível escolher qual o jogo que se pretende continuar
3. Deverá existir uma opção para reiniciar o ranking

### 3.1. Requisitos da Implementação

Para a implementação do **desenrolar do jogo** deverão obrigatoriamente ser utilizadas:

1. Coleções observáveis
2. Propriedades ( _Properties_ ), sempre que seja pertinente
3. Eventos para executar as alterações no ecrã
4. Efeitos ou animações (por exemplo na “limpeza dos quadrados”)


## 4. Fases de desenvolvimento e entrega

O projeto está dividido em 2 fases, com a cotação distribuída da seguinte forma:

- Fase I – 60% da avaliação final
- Fase II – 40% da avaliação final

Conforme referido na ficha da disciplina, poderá alternativamente entregar o projeto numa só data, na
época de recurso (sem possibilidade de incorporar componente de avaliação contínua), contemplando as
duas fases do projeto.

## 5. Implementação e codificação

O programa deve ser desenvolvido utilizando a linguagem Java, colocando em prática os conceitos
fundamentais do paradigma de Programação Orientada por Objetos.

Em relação às regras de codificação, siga as convenções adotadas normalmente para a linguagem Java:

- A notação _camelCase_ para o nome das variáveis locais e identificadores de atributos e métodos;
- A notação _PascalCase_ para os nomes das classes e interfaces;
- Utilização de maiúsculas para os nomes das constantes e dos valores enumerados;
- Não utilize o símbolo ‘_’ nos identificadores (exceto nas constantes), nem abreviaturas.

É necessário que o projeto cumpra o que é pedido no seu enunciado, sendo deixado ao critério do
programador qualquer pormenor de implementação que não seja referido, o qual deverá ser
devidamente documentado.

## 6. Constituição de grupos

Cada projeto deverá ser elaborado em grupos de dois alunos, podendo eventualmente ser elaborado
individualmente. Não serão permitidos, em nenhum caso, grupos com mais do que dois alunos.

Os grupos dos alunos já se encontram determinados através da metodologia de _pair programming_ que
está a ser utilizada nos laboratórios.

## 7. Entrega do projeto

O projeto será entregue em duas fases:


- Uma primeira fase ( **até às 23:55:00 do dia 1 de junho de 20 20** ) com a implementação da lógica
    da aplicação (descrita no presente documento);
- A segunda fase ( **até às 23:55:00 do dia 29 de junho de 20 20** ) com a parte gráfica.

O projeto deverá ser entregue até à data limite especificada por **via exclusivamente eletrónica utilizando
a área dos trabalhos no Moodle**. Todos os ficheiros que compõem o projeto deverão estar guardados
num único ficheiro compactado em **formato ZIP**. Em caso de dificuldades no acesso à plataforma Moodle,
o envio dos ficheiros poderá ser feito por correio eletrónico para o respetivo docente de laboratório,
dentro do prazo acima indicado.

**Não serão aceites quaisquer projetos entregues fora do prazo!**

Todos os materiais do projeto devem ser devidamente identificados com nome, número e endereço de
correio eletrónico dos alunos.

Os materiais do projeto deverão incluir:

- Um Manual Técnico onde conste uma breve descrição do programa, incluindo a explicação das
    classes/interfaces implementadas, principais atributos e métodos e suas relações.
- A documentação do programa em JavaDoc (não converta o documento gerado automaticamente
    em HTML para DOC!).
- O código fonte do programa na forma de projeto em _NetBeans_ ou _IntelliJ_ , com um _main_ de testes
    a funcionar e com todas as funcionalidades implementadas.
- Todos os ficheiros que compõem o projeto deverão estar guardados num único ficheiro
    compactado em formato ZIP cujo nome deverá ter a seguinte nomenclatura:
    _<curso>_<numAluno1>_<numAluno2>_ .zip.


## 8. Regras e Critérios de Avaliação do Projeto

### 8.1. Regras de Avaliação

A avaliação do projeto está sujeita às seguintes regras:

- Caso o aluno falte ao momento de supervisão, terá essa componente avaliada com zero valores.
- **Não serão aceites quaisquer projetos entregues fora do prazo!**
- A classificação do programa terá em conta a qualidade da programação (fatores de qualidade do
    software), a estrutura do código criado segundo os princípios da Programação Orientada por
    Objetos, tendo em conta conceitos como a coesão de classes e métodos, o grau de acoplamento
    entre classes e o desenho de classes orientado pela responsabilidade, e a
    utilização/conhecimento da linguagem Java.
- Serão premiadas a facilidade de utilização, a apresentação, a imaginação e a criatividade.
- O projeto terá uma componente de avaliação oral obrigatória com classificação individual dos
    elementos do grupo.
- Os alunos que não comparecerem à discussão serão classificados com zero na fase respetiva.
    Nesta discussão será apurada a capacidade do aluno de produzir o código apresentado. Nos casos
    em que essa capacidade não for demonstrada, a nota atribuída será zero.
- A avaliação oral é realizada pelo respetivo professor de laboratório e irá ser feita uma marcação
    prévia para cada grupo de trabalho.
- Todos os projetos serão submetidos a um sistema automático de deteção de cópias. Os projetos
    que forem identificados como possíveis cópias, e verificando-se serem realmente cópias, serão
    anulados.
- As avaliações da primeira fase do projeto serão realizadas na segunda semana de junho de 2020.

### 8.2. Critérios de Avaliação

A primeira fase do projeto será avaliada segundo os seguintes critérios:

**Funcionalidades 45 %**


```
Implementação 35 %
Estrutura de classes 20%
Conhecimento e boa utilização da linguagem 5%
Bom estilo (nomes, comentários, indentação) 5%
Definição de testes unitários 5%
```
```
Documentação 10%
JavaDOC 5%
Manual técnico 5%
```
**Avaliação qualitativa 10%**

## 9. Resumo das Datas Importantes

### 9.1. Entrega da 2ª fase

A entrega da 2 ª fase do projeto será até **às 23:55:00 de segunda-feira, dia 29 de junho de 2020.**

### 9.2. Avaliações da 2ª fase

As avaliações da primeira fase do projeto serão realizadas,se possível, entre os dias **01 e 03 de julho de
2020**.


