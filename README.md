### Projeto: Sistema de Processamento em Fila com Threads

Descrição

Este projeto é um sistema de processamento em fila baseado em threads, desenvolvido em Java. Ele utiliza uma interface gráfica simples para adicionar tarefas à fila, que são processadas de forma assíncrona por threads. O sistema é ideal para simular o envio em massa de informações ou a execução de tarefas em segundo plano.

Funcionalidades

Interface Gráfica Simples: Permite a entrada de dados (nome e e-mail) e a execução de ações.

Processamento em Fila: Utiliza uma fila concorrente para armazenar as tarefas a serem processadas.

Execução Assíncrona: Processa os itens da fila em segundo plano utilizando threads.

Controle de Execução: Possui botões para iniciar e parar o processamento.

Estrutura do Projeto

ExemploThread/
## ├── TelaGrafica.java
## ├── StartRunThread.java
## ├── ObjetoFilaThread.java
## └── ImplementaçãoFila.java

## 1. TelaGrafica.java

Cria a interface gráfica para inserção de dados.

Possui botões para adicionar itens à fila e parar o processamento.

Utiliza eventos para capturar ações do usuário.

## 2. StartRunThread.java

Classe principal para executar o programa.

Inicia a interface gráfica.

## 3. ObjetoFilaThread.java

Representa o objeto que será processado na fila.

Contém atributos como nome e e-mail, além de métodos getters e setters.

Sobrescreve os métodos equals e hashCode para evitar duplicatas.

## 4. ImplementaçãoFila.java

Gerencia a fila de processamento.

Utiliza uma ConcurrentLinkedQueue para manipular a fila de forma segura em um ambiente multithread.

Implementa a lógica de processamento iterativo dos itens na fila.

Tecnologias Utilizadas

Java SE 8+: Linguagem de programação principal.

Swing: Biblioteca para criação da interface gráfica.

Java Threads: Para execução de tarefas em segundo plano.

ConcurrentLinkedQueue: Estrutura de dados para gerenciamento seguro de threads.

Como Executar o Projeto

Clonar o repositório:

git clone [ https://github.com/VitordevJava/ThreadQueueProcessor.git]

Importar no Eclipse:

Abra o Eclipse.

Vá para File > Import > Existing Projects into Workspace.

Selecione o diretório do projeto.

Clique em Finish.

Executar o programa:

Clique com o botão direito no arquivo StartRunThread.java.

Selecione Run As > Java Application.

Usar a Interface Gráfica:

Insira um nome e um e-mail.

Clique em Add Lista para adicionar itens à fila.

Clique em Stop para interromper o processamento.

Exemplos de Uso

Envio em massa de e-mails: Simula a inserção de até 100 registros para processamento em lote.

Processamento de dados em segundo plano: Ideal para tarefas que não exigem interação imediata com o usuário.

Melhorias Futuras

Adicionar persistência de dados.

Implementar um sistema de logs para monitorar os processos executados.

Melhorar a interface gráfica com mais opções de configuração.

Adicionar suporte a múltiplas threads para paralelismo avançado.

Autor

João Vitor Soares de Carvalho

LinkedIn: [ linkedin.com/in/vitorcrv ]

GitHub: [ github.com/VitordevJava ]

E-mail: [vitordev.java@gmail.com]
