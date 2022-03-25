create database bdpresenteranm 
default character set = utf8
default collate utf8_general_ci;

create user 'anmadmin'@'%' identified by 'epanm2022';

grant all on *.* to 'admin'@'%' with grant option;

flush privileges;

-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24-Mar-2022 às 01:54
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bdpresenter`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_alunos`
--

CREATE TABLE `tb_alunos` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `id_equipe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_equipes`
--

CREATE TABLE `tb_equipes` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `projeto` varchar(100) DEFAULT NULL,
  `turma` varchar(100) DEFAULT NULL,
  `pontuacao` double DEFAULT NULL,
  `apresentou` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_equipes`
--

INSERT INTO `tb_equipes` (`id`, `nome`, `projeto`, `turma`, `pontuação`, `apresentou`) VALUES
(1, 'Amigos do Kim Kardashian', 'Semáforo', '2° inf', 9.8, 0),
(2, 'Eclipse Club', 'Hidriponia', '1° inf', 5.5, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_alunos`
--
ALTER TABLE `tb_alunos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_equipe` (`id_equipe`);

--
-- Índices para tabela `tb_equipes`
--
ALTER TABLE `tb_equipes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_alunos`
--
ALTER TABLE `tb_alunos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tb_equipes`
--
ALTER TABLE `tb_equipes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tb_alunos`
--
ALTER TABLE `tb_alunos`
  ADD CONSTRAINT `tb_alunos_ibfk_1` FOREIGN KEY (`id_equipe`) REFERENCES `tb_equipes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
