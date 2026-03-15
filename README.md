# Gestion des Emplois du Temps

Projet réalisé dans le cadre du TP de programmation Java.

Ce projet permet de gérer les emplois du temps académiques en manipulant les informations suivantes :

- Cours
- Enseignants
- Étudiants
- Salles
- Séances
- Planning
- Examens
- Utilisateurs

Le projet utilise Java, MySQL/MariaDB et une interface graphique Swing.

# Membres du groupe

| Nom | Contribution |
|--|--------------|
| MAYADA EMMANUEL | 100%         |
| MENGUE OYIE CATHERINE KEREN ANN | 100%         |
| NGAMGA WAZI EMERAUDE ASHLEY | 90%          |
| ABDEL MALICK MAHAMAT SALEH | 100%         |
| DJUMAH TCHAMBESSI LAUREINE DIVINE | 60%          |
| FOMBEN CHAGHEN HILAIRE | 60%          |
| KAMANDA MBOZO'O FRANCK ALANE | 50%          |
| TELEP DÉSIRÉ JUNIOR | 40%          |
| MORE ANGE KORALIE | 50%          |


# Structure du projet

tree         
.
├── code
│   ├── DatabaseConnection.java
│   ├── Main.java
│   └── PlanningGes.java
├── DAO
│   ├── CoursDAO.java
│   ├── EnseignantDAO.java
│   ├── EtudiantDAO.java
│   ├── ExamenDAO.java
│   ├── PlanningDAO.java
│   ├── SalleDAO.java
│   ├── SeanceDAO.java
│   └── UtilisateursDAO.java
├── database
│   └── base.sql
├── docs
│   ├── ~$hier_des_charges_G15_v7-6.docx
│   ├── cahier_des_charges_G15_v7-6.docx
│   └── readme.txt
├── modelisations
│   ├── Cours.java
│   ├── Enseignant.java
│   ├── Etudiant.java
│   ├── Examen.java
│   ├── Planning.java
│   ├── Salle.java
│   ├── Seance.java
│   └── Utilisateur.java
├── README.md
├── servlet
│   ├── CoursServlet.java
│   ├── EnseignantServlet.java
│   ├── EtudiantServlet.java
│   ├── ExamenServlet.java
│   ├── LoginServlet.java
│   ├── PlanningServlet.java
│   ├── RegisterServlet.java
│   ├── SalleServlet.java
│   └── SeanceServlet.java
├── utilisateur
│   ├── cours.jsp
│   ├── dashboard.jsp
│   ├── enseignants.jsp
│   ├── etudiants.jsp
│   ├── examens.jsp
│   ├── login.jsp
│   ├── navbar.jsp
│   ├── planning.jsp
│   ├── register.jsp
│   ├── salles.jsp
│   ├── seances.jsp
│   └── style.css
└── WEB-INF
├── classes
│   ├── code
│   │   ├── DatabaseConnection.class
│   │   └── Main.class
│   ├── DAO
│   │   ├── CoursDAO.class
│   │   ├── EnseignantDAO.class
│   │   ├── EtudiantDAO.class
│   │   ├── ExamenDAO.class
│   │   ├── PlanningDAO.class
│   │   ├── SalleDAO.class
│   │   ├── SeanceDAO.class
│   │   └── UtilisateursDAO.class
│   ├── modelisations
│   │   ├── Cours.class
│   │   ├── Enseignant.class
│   │   ├── Etudiant.class
│   │   ├── Examen.class
│   │   ├── Planning.class
│   │   ├── Salle.class
│   │   ├── Seance.class
│   │   └── Utilisateur.class
│   └── servlet
│       ├── CoursServlet.class
│       ├── EnseignantServlet.class
│       ├── EtudiantServlet.class
│       ├── ExamenServlet.class
│       ├── LoginServlet.class
│       ├── PlanningServlet.class
│       ├── RegisterServlet.class
│       ├── SalleServlet.class
│       └── SeanceServlet.class
├── lib
└── web.xml

# procédure d'ouverture
    - cloner le repo https://github.com/Emmanuel-akatsuki/gestion_emplois_temps.git
    - ouvrir avec un ide
    - installé tomcat10 (sudo apt install tomcat10)
    - cée la base de données ( nom: base, user: utilisateur, password:"12345678") et copier 
    - le script de la bd présent dans daabase puis le coller dans la création de la base de données
    - démarré le serveur ( sudo systemctl start tomcat10)
    - allez sur le navigateur et entrer l'url du projet (http://8000/gestion_emplois_temps)