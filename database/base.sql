-- MySQL dump 10.13  Distrib 8.0.42, for Linux (x86_64)
--
-- Host: localhost    Database: bases
-- ------------------------------------------------------
-- Server version	8.0.42-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Cours`
--

DROP TABLE IF EXISTS `Cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cours` (
  `id_cours` int NOT NULL AUTO_INCREMENT,
  `intitule` varchar(100) NOT NULL,
  `code_matiere` varchar(20) DEFAULT NULL,
  `type_cours` enum('CM','TD','TP') DEFAULT NULL,
  `volume_horaire` time DEFAULT NULL,
  `credit` int DEFAULT NULL,
  PRIMARY KEY (`id_cours`),
  UNIQUE KEY `code_matiere` (`code_matiere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cours`
--

LOCK TABLES `Cours` WRITE;
/*!40000 ALTER TABLE `Cours` DISABLE KEYS */;
/*!40000 ALTER TABLE `Cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Enseignants`
--

DROP TABLE IF EXISTS `Enseignants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Enseignants` (
  `id_enseignant` int NOT NULL AUTO_INCREMENT,
  `matricule` varchar(15) DEFAULT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(60) DEFAULT NULL,
  `specialite` varchar(100) DEFAULT NULL,
  `grade` varchar(30) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_enseignant`),
  UNIQUE KEY `matricule` (`matricule`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Enseignants`
--

LOCK TABLES `Enseignants` WRITE;
/*!40000 ALTER TABLE `Enseignants` DISABLE KEYS */;
/*!40000 ALTER TABLE `Enseignants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Etudiants`
--

DROP TABLE IF EXISTS `Etudiants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Etudiants` (
  `id_etudiant` int NOT NULL AUTO_INCREMENT,
  `matricule` varchar(10) DEFAULT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(60) DEFAULT NULL,
  `niveau` varchar(25) DEFAULT NULL,
  `filiere` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_etudiant`),
  UNIQUE KEY `matricule` (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Etudiants`
--

LOCK TABLES `Etudiants` WRITE;
/*!40000 ALTER TABLE `Etudiants` DISABLE KEYS */;
/*!40000 ALTER TABLE `Etudiants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Examen`
--

DROP TABLE IF EXISTS `Examen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Examen` (
  `id_examen` int NOT NULL AUTO_INCREMENT,
  `id_cours` int DEFAULT NULL,
  `id_salle` int DEFAULT NULL,
  `type_examen` enum('CC','SN','RATTRAPAGE') DEFAULT NULL,
  `session` varchar(15) DEFAULT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `heure_debut` time DEFAULT NULL,
  `heure_fin` time DEFAULT NULL,
  PRIMARY KEY (`id_examen`),
  KEY `fk_examen_cours` (`id_cours`),
  KEY `fk_examen_salle` (`id_salle`),
  CONSTRAINT `fk_examen_cours` FOREIGN KEY (`id_cours`) REFERENCES `Cours` (`id_cours`),
  CONSTRAINT `fk_examen_salle` FOREIGN KEY (`id_salle`) REFERENCES `Salles` (`id_salle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Examen`
--

LOCK TABLES `Examen` WRITE;
/*!40000 ALTER TABLE `Examen` DISABLE KEYS */;
/*!40000 ALTER TABLE `Examen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Planning`
--

DROP TABLE IF EXISTS `Planning`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Planning` (
  `id_planning` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(20) DEFAULT NULL,
  `semestre` varchar(2) DEFAULT NULL,
  `annee_acad` varchar(10) DEFAULT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  PRIMARY KEY (`id_planning`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Planning`
--

LOCK TABLES `Planning` WRITE;
/*!40000 ALTER TABLE `Planning` DISABLE KEYS */;
/*!40000 ALTER TABLE `Planning` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Salles`
--

DROP TABLE IF EXISTS `Salles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Salles` (
  `id_salle` int NOT NULL AUTO_INCREMENT,
  `nom_salle` varchar(30) NOT NULL,
  `capacite` int DEFAULT NULL,
  `type_salle` varchar(30) DEFAULT NULL,
  `batiment` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_salle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Salles`
--

LOCK TABLES `Salles` WRITE;
/*!40000 ALTER TABLE `Salles` DISABLE KEYS */;
/*!40000 ALTER TABLE `Salles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Seance`
--

DROP TABLE IF EXISTS `Seance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Seance` (
  `id_seance` int NOT NULL AUTO_INCREMENT,
  `id_planning` int DEFAULT NULL,
  `id_enseignant` int DEFAULT NULL,
  `id_cours` int DEFAULT NULL,
  `id_salle` int DEFAULT NULL,
  `jour` enum('lundi','mardi','mercredi','jeudi','vendredi','samedi') DEFAULT NULL,
  `heure_debut` time DEFAULT NULL,
  `heure_fin` time DEFAULT NULL,
  PRIMARY KEY (`id_seance`),
  KEY `fk_seance_planning` (`id_planning`),
  KEY `fk_seance_enseignant` (`id_enseignant`),
  KEY `fk_seance_cours` (`id_cours`),
  KEY `fk_seance_salle` (`id_salle`),
  CONSTRAINT `fk_seance_cours` FOREIGN KEY (`id_cours`) REFERENCES `Cours` (`id_cours`),
  CONSTRAINT `fk_seance_enseignant` FOREIGN KEY (`id_enseignant`) REFERENCES `Enseignants` (`id_enseignant`),
  CONSTRAINT `fk_seance_planning` FOREIGN KEY (`id_planning`) REFERENCES `Planning` (`id_planning`),
  CONSTRAINT `fk_seance_salle` FOREIGN KEY (`id_salle`) REFERENCES `Salles` (`id_salle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Seance`
--

LOCK TABLES `Seance` WRITE;
/*!40000 ALTER TABLE `Seance` DISABLE KEYS */;
/*!40000 ALTER TABLE `Seance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Utilisateur`
--

DROP TABLE IF EXISTS `Utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Utilisateur` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `role` enum('admin','planif','enseignant','etudiant') NOT NULL,
  `actif` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Utilisateur`
--

LOCK TABLES `Utilisateur` WRITE;
/*!40000 ALTER TABLE `Utilisateur` DISABLE KEYS */;
/*!40000 ALTER TABLE `Utilisateur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-13 23:25:36