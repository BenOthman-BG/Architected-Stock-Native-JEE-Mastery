# J-Core Mastery: Pattern-Driven JEE Architecture 🚀

## 📌 Présentation
Ce projet est une application web de gestion de stock développée entièrement en **Java EE Natif**. L'objectif principal est de démontrer une maîtrise absolue des concepts fondamentaux du développement backend en Java, en refusant l'utilisation de tout framework externe.

**Ici, tout est manuel :** Pas de Spring, pas de JPA, pas d'Hibernate. Toute l'architecture, la configuration et l'injection de dépendances ont été codées "from scratch" pour garantir un contrôle total et une compréhension profonde du fonctionnement d'une application d'entreprise.

## 🏗️ Architecture & Design Patterns
Le projet respecte rigoureusement la séparation des responsabilités à travers une architecture en couches (N-Tier) :

* **Respect strict des couches :** Séparation claire entre la couche DAO (accès aux données), la couche Métier (Entités) et la couche Présentation/Web (Servlets & JSP).
* **Singleton Pattern :** Implémentation d'une classe `SingletonConnection` pour garantir qu'une seule instance de connexion JDBC est partagée par toute l'application, optimisant ainsi les performances.
* **IoC & DI (Inversion of Control & Dependency Injection) Manuelles :** Utilisation d'un `ApplicationInitializer` (Listener) qui se charge d'instancier la couche DAO et de l'injecter manuellement dans le contexte de l'application, assurant un **couplage faible**.
* **Pattern MVC :** Le flux de données est orchestré proprement entre le `ControlerServlet` (Contrôleur), le `ProduitModel` (Modèle) et les pages JSP (Vues).

## ⚙️ Choix Techniques & "Manual Work"
* **Persistance Manuelle :** Aucune utilisation de JPA ou Hibernate. Le dialogue avec la base de données se fait via **JDBC** et du **SQL Natif** (avec `PreparedStatement` pour la sécurité). Le mapping entre le `ResultSet` SQL et les objets Java est entièrement fait à la main.
* **Configuration Manuelle :** Pas de magie de framework. Tout le câblage de l'application est explicite et maîtrisé.

## 🚀 Fonctionnalités Clés (CRUD Complet)
L'application gère le cycle de vie complet des données :
- **Create (Création) :** Ajout de nouveaux produits dans la base de données.
- **Read (Lecture) :** Affichage de la liste des produits et système de recherche dynamique par mot-clé.
- **Update (Modification) :** Mise à jour des informations d'un produit existant (Désignation, Prix, Quantité).
- **Delete (Suppression) :** Retrait d'un produit de la base de données.

## 🧪 Tests & Exécution
Pour vérifier le bon fonctionnement du projet, deux approches sont disponibles :

1. **Tests Unitaires (Isolés) :** Un dossier `src/test/java` contient les tests JUnit permettant de valider la logique du DAO (connexion Singleton, requêtes SQL) sans avoir besoin de lancer le serveur.
2. **Déploiement Complet (Vue globale) :** Déployez l'application sur un serveur **Apache Tomcat** pour naviguer dans l'interface finale (JSP) et voir tous les résultats des opérations CRUD en temps réel.

## 🔧 Installation
1. Cloner ce dépôt.
2. Importer dans Eclipse en tant que "Dynamic Web Project".
3. Créer la base de données MySQL et ajuster les identifiants dans la classe `SingletonConnection`.
4. Run As > Run on Server (Tomcat 9/10).
