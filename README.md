# Presenter Admin  [![NPM](https://img.shields.io/npm/l/react)](https://github.com/HenriqueSenaDev/presenter-admin/blob/main/LICENSE)

![Java](https://img.shields.io/badge/Java-CA4245?style=for-the-badge&logo=openjdk&logoColor=white)

Presenter Admin é um projeto acadêmico, desenvolvido na [EEEP Alfredo Nunes de Melo](https://www.instagram.com/eeepalfredonunes/), Acopiara-CE.

Tem como função disponibilizar um sistema de competição e avaliação de equipes, estando estas em um determinado evento. Tais equipes serão avaliadas por jurados: qualquer usuário que tiver o código de acesso para avaliar.

O gerenciamento das informações do evento, das equipes e suas determinadas apresentações é feito por um usuário administrador, através do mesmo.

É uma aplicação desktop, feita com a linguagem Java, a partir da biblioteca de renderização gráfica Swing.

Consta de um ecossistema integrado junto ao projeto [presenter-web](https://github.com/HenriqueSenaDev/presenter-admin), o qual conta com dois subprojetos: uma aplicação frontend-web responsável pela avaliação do jurados e um backend com uma restful api central.

## Páginas
- Cadastro e gerenciamento de equipes (CRUD)
- Temporizador para contagem de tempo por apresentação
- Sorteador da ordem de apresentação e confirmação das mesmas
- Ranking do evento

## Layout
![Cadastro](https://github.com/HenriqueSenaDev/assets/blob/main/presenter-admin/cadastro.png)

![Menu](https://github.com/HenriqueSenaDev/assets/blob/main/presenter-admin/menu.png)

![Temporizador](https://github.com/HenriqueSenaDev/assets/blob/main/presenter-admin/temporizador.png)

![Sorteador](https://github.com/HenriqueSenaDev/assets/blob/main/presenter-admin/sorteador.png)

![Ranking](https://github.com/HenriqueSenaDev/assets/blob/main/presenter-admin/ranking.png)

## Executando o projeto
Pré-requisitos: 
- Java +17
- variável de ambiente API_HOST: URL do host da api
- biblioteca jackson-annotations +2.12.7
- biblioteca jackson-core +2.12.7
- biblioteca jackson-databind +2.12.7
- biblioteca AbsoluteLayout-RELEASE140

```bash
# clonar repositório
git clone https://github.com/HenriqueSenaDev/presenter-admin.git

# entrar na pasta do modal de login
cd src/gov/edu/anm/presenter/view/login

# executar o projeto
java ./LoginFrame.java
```