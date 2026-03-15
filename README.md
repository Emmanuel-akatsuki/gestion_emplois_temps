# Gestion des Emplois du Temps (Spring Boot Version)

Projet de gestion d'emplois du temps académiques, migré d'une architecture Servlet/JDBC vers **Spring Boot 3** avec **JPA/Hibernate**.

## 🚀 Fonctionnalités

Le système permet de gérer l'intégralité du cycle de planification universitaire :
- **Authentification & Rôles** : Gestion des accès par rôle (Admin, Enseignant, Étudiant).
- **Gestion des Cours** : Création et suivi des matières.
- **Gestion des Enseignants & Étudiants** : (Accès réservé Admin).
- **Planification** : Gestion des salles, des séances de cours et des examens.
- **Tableau de Bord** : Visualisation globale des statistiques du système.

## 🛠 Technologies utilisées

- **Backend** : Java 17, Spring Boot 3.2.4
- **Persistence** : Spring Data JPA, Hibernate
- **Base de données** : H2 (en mémoire par défaut) ou MySQL (configurable)
- **Frontend** : JSP, JSTL, CSS3
- **Build Tool** : Maven

## 📋 Prérequis

- **Java 17** ou supérieur
- **Maven 3.6+**

## ⚙️ Configuration

Par défaut, l'application utilise une base de données **H2 en mémoire**. Les données sont réinitialisées à chaque redémarrage.

Pour utiliser **MySQL**, modifiez le fichier `src/main/resources/application.properties` :
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/base
spring.datasource.username=votre_user
spring.datasource.password=votre_password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

## 🏃 Lancer l'application

1. Ouvrez un terminal dans le dossier racine du projet.
2. Compilez et lancez l'application :
   ```bash
   mvn spring-boot:run
   ```
3. Accédez à l'application via : `http://localhost:8080`

## 👤 Accès par rôle

| Rôle | Capacités |
|------|-----------|
| **Admin** | Accès total, gestion des utilisateurs, enseignants, étudiants, cours, salles, plannings, examens. |
| **Enseignant** | Visualisation et ajout de cours, séances et examens. |
| **Étudiant** | Visualisation (lecture seule) des cours, salles, séances et plannings. |

## 📊 Console de base de données (H2)

Si vous utilisez la configuration par défaut (H2), vous pouvez inspecter la base de données en temps réel :
- **URL** : `http://localhost:8080/h2-console`
- **JDBC URL** : `jdbc:h2:mem:planningdb`
- **User** : `sa` (pas de mot de passe)

---
*Projet réalisé dans le cadre du TP de programmation Java.*
