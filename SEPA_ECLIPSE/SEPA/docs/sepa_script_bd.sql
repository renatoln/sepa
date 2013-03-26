-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.49-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sepa
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ sepa;
USE sepa;

--
-- Table structure for table `sepa`.`agendamento`
--

DROP TABLE IF EXISTS `agendamento`;
CREATE TABLE `agendamento` (
  `idAgendamento` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `hora` time NOT NULL,
  `Paciente_idPaciente` int(11) NOT NULL,
  `Profissional_idProfissional` int(11) NOT NULL,
  PRIMARY KEY (`idAgendamento`),
  KEY `fk_AgendamentoConsulta_Pacientes1` (`Paciente_idPaciente`),
  KEY `fk_AgendamentoConsulta_Profissionais1` (`Profissional_idProfissional`),
  CONSTRAINT `fk_AgendamentoConsulta_Pacientes1` FOREIGN KEY (`Paciente_idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_AgendamentoConsulta_Profissionais1` FOREIGN KEY (`Profissional_idProfissional`) REFERENCES `profissional` (`idProfissional`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`agendamento`
--

/*!40000 ALTER TABLE `agendamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `agendamento` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`area`
--

DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `idArea` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`idArea`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`area`
--

/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` (`idArea`,`nome`,`descricao`) VALUES 
 (1,'Ortopedia','Ortopedia total');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`area_x_doenca`
--

DROP TABLE IF EXISTS `area_x_doenca`;
CREATE TABLE `area_x_doenca` (
  `Area_idArea` int(11) NOT NULL,
  `Doenca_idDoenca` int(11) NOT NULL,
  KEY `fk_Areas_has_Doencas_Doencas1` (`Doenca_idDoenca`),
  KEY `fk_Areas_has_Doencas_Areas1` (`Area_idArea`),
  CONSTRAINT `fk_Areas_has_Doencas_Areas1` FOREIGN KEY (`Area_idArea`) REFERENCES `area` (`idArea`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Areas_has_Doencas_Doencas1` FOREIGN KEY (`Doenca_idDoenca`) REFERENCES `doenca` (`idDoenca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`area_x_doenca`
--

/*!40000 ALTER TABLE `area_x_doenca` DISABLE KEYS */;
/*!40000 ALTER TABLE `area_x_doenca` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`area_x_orientacao`
--

DROP TABLE IF EXISTS `area_x_orientacao`;
CREATE TABLE `area_x_orientacao` (
  `Area_idArea` int(11) NOT NULL,
  `Orientacao_idOrientacao` int(11) NOT NULL,
  KEY `fk_Areas_has_Orientacoes_Orientacoes1` (`Orientacao_idOrientacao`),
  KEY `fk_Areas_has_Orientacoes_Areas1` (`Area_idArea`),
  CONSTRAINT `fk_Areas_has_Orientacoes_Areas1` FOREIGN KEY (`Area_idArea`) REFERENCES `area` (`idArea`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Areas_has_Orientacoes_Orientacoes1` FOREIGN KEY (`Orientacao_idOrientacao`) REFERENCES `orientacao` (`idOrientacao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`area_x_orientacao`
--

/*!40000 ALTER TABLE `area_x_orientacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `area_x_orientacao` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`atendimento`
--

DROP TABLE IF EXISTS `atendimento`;
CREATE TABLE `atendimento` (
  `idAtendimento` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `hora` time DEFAULT NULL,
  `descricao` text,
  `Prontuario_idProntuario` int(11) NOT NULL,
  PRIMARY KEY (`idAtendimento`),
  KEY `fk_Atendimento_Prontuario1` (`Prontuario_idProntuario`),
  CONSTRAINT `fk_Atendimento_Prontuario1` FOREIGN KEY (`Prontuario_idProntuario`) REFERENCES `prontuario` (`idProntuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`atendimento`
--

/*!40000 ALTER TABLE `atendimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `atendimento` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`atendimento_x_orientacao`
--

DROP TABLE IF EXISTS `atendimento_x_orientacao`;
CREATE TABLE `atendimento_x_orientacao` (
  `Atendimento_idAtendimento` int(11) NOT NULL,
  `Orientacao_idOrientacao` int(11) NOT NULL,
  KEY `fk_Atendimento_has_Orientacao_Orientacao1` (`Orientacao_idOrientacao`),
  KEY `fk_Atendimento_has_Orientacao_Atendimento1` (`Atendimento_idAtendimento`),
  CONSTRAINT `fk_Atendimento_has_Orientacao_Atendimento1` FOREIGN KEY (`Atendimento_idAtendimento`) REFERENCES `atendimento` (`idAtendimento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Atendimento_has_Orientacao_Orientacao1` FOREIGN KEY (`Orientacao_idOrientacao`) REFERENCES `orientacao` (`idOrientacao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`atendimento_x_orientacao`
--

/*!40000 ALTER TABLE `atendimento_x_orientacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `atendimento_x_orientacao` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`doenca`
--

DROP TABLE IF EXISTS `doenca`;
CREATE TABLE `doenca` (
  `idDoenca` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`idDoenca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`doenca`
--

/*!40000 ALTER TABLE `doenca` DISABLE KEYS */;
/*!40000 ALTER TABLE `doenca` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`ficha_avaliacao`
--

DROP TABLE IF EXISTS `ficha_avaliacao`;
CREATE TABLE `ficha_avaliacao` (
  `idFicha_avaliacao` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` text,
  `Area_idArea` int(11) NOT NULL,
  PRIMARY KEY (`idFicha_avaliacao`),
  KEY `fk_Ficha_avaliacao_Areas1` (`Area_idArea`),
  CONSTRAINT `fk_Ficha_avaliacao_Areas1` FOREIGN KEY (`Area_idArea`) REFERENCES `area` (`idArea`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`ficha_avaliacao`
--

/*!40000 ALTER TABLE `ficha_avaliacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `ficha_avaliacao` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`hospital`
--

DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital` (
  `idHospital` int(11) NOT NULL AUTO_INCREMENT,
  `nome_hospital` varchar(100) NOT NULL DEFAULT '',
  `endereco_hospital` varchar(200) NOT NULL DEFAULT '',
  `responsavel` varchar(100) DEFAULT NULL,
  `marca` blob,
  `telefone_hospital` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idHospital`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`hospital`
--

/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` (`idHospital`,`nome_hospital`,`endereco_hospital`,`responsavel`,`marca`,`telefone_hospital`) VALUES 
 (1,'HGE','Salvador','Maria',0x2A2A2A2A2A2A2A,'3216-5894'),
 (2,'São Camilo','Candeias','Maria',0x2A2A2A2A2A2A2A,'3216-5894');
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`orientacao`
--

DROP TABLE IF EXISTS `orientacao`;
CREATE TABLE `orientacao` (
  `idOrientacao` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `imagem` blob NOT NULL,
  `descricao` text NOT NULL,
  PRIMARY KEY (`idOrientacao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`orientacao`
--

/*!40000 ALTER TABLE `orientacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `orientacao` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`orientacao_x_parte_do_corpo`
--

DROP TABLE IF EXISTS `orientacao_x_parte_do_corpo`;
CREATE TABLE `orientacao_x_parte_do_corpo` (
  `Orientacao_idOrientacao` int(11) NOT NULL,
  `Parte_do_corpo_idParte_do_corpo` int(11) NOT NULL,
  KEY `fk_Orientacoes_has_PartesDoCorpo_PartesDoCorpo1` (`Parte_do_corpo_idParte_do_corpo`),
  KEY `fk_Orientacoes_has_PartesDoCorpo_Orientacoes1` (`Orientacao_idOrientacao`),
  CONSTRAINT `fk_Orientacoes_has_PartesDoCorpo_Orientacoes1` FOREIGN KEY (`Orientacao_idOrientacao`) REFERENCES `orientacao` (`idOrientacao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orientacoes_has_PartesDoCorpo_PartesDoCorpo1` FOREIGN KEY (`Parte_do_corpo_idParte_do_corpo`) REFERENCES `parte_do_corpo` (`idParte_do_corpo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`orientacao_x_parte_do_corpo`
--

/*!40000 ALTER TABLE `orientacao_x_parte_do_corpo` DISABLE KEYS */;
/*!40000 ALTER TABLE `orientacao_x_parte_do_corpo` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`paciente`
--

DROP TABLE IF EXISTS `paciente`;
CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `rg` varchar(10) NOT NULL,
  `dtNasc` date NOT NULL,
  `cpf` varchar(11) NOT NULL,
  PRIMARY KEY (`idPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`paciente`
--

/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`parte_do_corpo`
--

DROP TABLE IF EXISTS `parte_do_corpo`;
CREATE TABLE `parte_do_corpo` (
  `idParte_do_corpo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`idParte_do_corpo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`parte_do_corpo`
--

/*!40000 ALTER TABLE `parte_do_corpo` DISABLE KEYS */;
/*!40000 ALTER TABLE `parte_do_corpo` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`profissao`
--

DROP TABLE IF EXISTS `profissao`;
CREATE TABLE `profissao` (
  `idProfissao` int(11) NOT NULL AUTO_INCREMENT,
  `nome_profissao` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`idProfissao`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`profissao`
--

/*!40000 ALTER TABLE `profissao` DISABLE KEYS */;
INSERT INTO `profissao` (`idProfissao`,`nome_profissao`) VALUES 
 (1,'Medico'),
 (2,'Enfermeiro'),
 (3,'Vigilante');
/*!40000 ALTER TABLE `profissao` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`profissional`
--

DROP TABLE IF EXISTS `profissional`;
CREATE TABLE `profissional` (
  `idProfissional` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `senha` varchar(200) NOT NULL,
  `data_nascimento` date NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `numero_conselho` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `tipo_profissional` int(11) DEFAULT NULL COMMENT '0 - administrador do sistema;\n1 - usuario do sistema;\n2 - profissional de saúde;\n\n',
  `Profissao_idProfissao` int(11) NOT NULL,
  `Hospital_idHospital` int(11) NOT NULL,
  PRIMARY KEY (`idProfissional`),
  KEY `fk_Profissionais_Profissao1` (`Profissao_idProfissao`),
  KEY `fk_Profissional_Hospital1` (`Hospital_idHospital`),
  CONSTRAINT `fk_Profissionais_Profissao1` FOREIGN KEY (`Profissao_idProfissao`) REFERENCES `profissao` (`idProfissao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Profissional_Hospital1` FOREIGN KEY (`Hospital_idHospital`) REFERENCES `hospital` (`idHospital`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`profissional`
--

/*!40000 ALTER TABLE `profissional` DISABLE KEYS */;
INSERT INTO `profissional` (`idProfissional`,`nome`,`usuario`,`senha`,`data_nascimento`,`cpf`,`endereco`,`telefone`,`numero_conselho`,`email`,`tipo_profissional`,`Profissao_idProfissao`,`Hospital_idHospital`) VALUES 
 (3,'Wellgton','wel','71b3b26aaa319e0cdf6fdb8429c112b0','1981-06-06','01539503585','rua a','12131213212','1321321','wellgton@gmail.com',2,1,1);
/*!40000 ALTER TABLE `profissional` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`profissional_x_area`
--

DROP TABLE IF EXISTS `profissional_x_area`;
CREATE TABLE `profissional_x_area` (
  `Profissional_idProfissional` int(11) NOT NULL,
  `Area_idArea` int(11) NOT NULL,
  KEY `fk_Profissionais_has_Areas_Areas1` (`Area_idArea`),
  KEY `fk_Profissionais_has_Areas_Profissionais1` (`Profissional_idProfissional`),
  CONSTRAINT `fk_Profissionais_has_Areas_Areas1` FOREIGN KEY (`Area_idArea`) REFERENCES `area` (`idArea`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Profissionais_has_Areas_Profissionais1` FOREIGN KEY (`Profissional_idProfissional`) REFERENCES `profissional` (`idProfissional`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`profissional_x_area`
--

/*!40000 ALTER TABLE `profissional_x_area` DISABLE KEYS */;
/*!40000 ALTER TABLE `profissional_x_area` ENABLE KEYS */;


--
-- Table structure for table `sepa`.`prontuario`
--

DROP TABLE IF EXISTS `prontuario`;
CREATE TABLE `prontuario` (
  `idProntuario` int(11) NOT NULL AUTO_INCREMENT,
  `Profissional_idProfissional` int(11) NOT NULL,
  `Paciente_idPaciente` int(11) NOT NULL,
  PRIMARY KEY (`idProntuario`),
  KEY `fk_Prontuario_Profissionais1` (`Profissional_idProfissional`),
  KEY `fk_Prontuario_Pacientes1` (`Paciente_idPaciente`),
  CONSTRAINT `fk_Prontuario_Pacientes1` FOREIGN KEY (`Paciente_idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prontuario_Profissionais1` FOREIGN KEY (`Profissional_idProfissional`) REFERENCES `profissional` (`idProfissional`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sepa`.`prontuario`
--

/*!40000 ALTER TABLE `prontuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `prontuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
