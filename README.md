# Presenter Admin  [![NPM](https://img.shields.io/npm/l/react)](https://github.com/HenriqueSenaDev/presenter-admin/blob/main/LICENSE)

![Java](https://img.shields.io/badge/Java-CA4245?style=for-the-badge&logo=openjdk&logoColor=white)

Aplicação desktop construída a partir da linguagem Java e sua biblioteca de renderização gráfica Swing. É um sistema de competição e avaliação de equipes em eventos através de jurados e espectadores. Gerencia as informações do evento, suas equipes e determinadas apresentações com um usuário administrador. Presenter Admin é um projeto acadêmico, desenvolvido na [EEEP Alfredo Nunes de Melo](https://www.instagram.com/eeepalfredonunes/), Acopiara-CE.

## Ecossistema
Consta de um ecossistema integrado junto ao projeto [presenter-web](https://github.com/HenriqueSenaDev/presenter-admin), um mono-repo com dois subprojetos: uma aplicação frontend-web responsável pela avaliação do jurados e um backend com uma restful api central (core).

## Páginas
- Cadastro e gerenciamento de equipes (CRUD)
- Temporizador para contagem de tempo por apresentação
- Sorteador da ordem e confirmação de apresentação
- Ranking do evento

## Layout
![Cadastro](https://github.com/HenriqueSenaDev/assets/blob/main/presenter-admin/cadastro.png)

![Menu](https://github.com/HenriqueSenaDev/assets/blob/main/presenter-admin/menu.png)

![Temporizador](https://github.com/HenriqueSenaDev/assets/blob/main/presenter-admin/temporizador.png)

![Sorteador](https://github.com/HenriqueSenaDev/assets/blob/main/presenter-admin/sorteador.png)

![Ranking](https://github.com/HenriqueSenaDev/assets/blob/main/presenter-admin/ranking.png)

## Execute o projeto
Pré-requisitos: 
- Java +17
- [Api Backend](https://github.com/HenriqueSenaDev/presenter-web/tree/main/backend-web) rodando no host
- Variável de Ambiente API_HOST: URL do host da api
  - (caso feito o restore do dump disponibilizado, utilizar usuário com nome e senha iguais a "admin")

[Baixe o Jar](https://github.com/HenriqueSenaDev/assets/blob/main/presenter-admin/presenter-admin-20240122.jar)

Ou clone o projeto (necessário Apache Ant +10):

```bash
git clone https://github.com/HenriqueSenaDev/presenter-admin.git
cd presenter-admin
# cria um jar na pasta dist/lib
ant
```

E execute o Jar em seu diretório:
```bash
java -jar presenter-admin-[timestamp].jar
```
