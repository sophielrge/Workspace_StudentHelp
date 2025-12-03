# Workspace_StudentHelp

<img width="615" height="486" alt="Capture d’écran 2025-12-03 à 11 22 45" src="https://github.com/user-attachments/assets/27b9edb5-5246-458b-900f-6d8676bb2b0c" />


Nous avons 5 microservices : 

### **1. StudentManager**
Le service **StudentManager** permet de gérer tout ce qui se réfère aux étudiants.

**Fonctionnalités :**
- Création d’un nouvel étudiant  
- Modification des informations d’un étudiant  
- Récupération de la liste de tous les étudiants  
- Ajout de notes entre étudiants (avis après une aide)

**Base de données :**
- Table *Student*


### **2. RequestManager**
Le service **RequestManager** gère les demandes d’aide.

**Fonctionnalités :**
- Création d’une demande  
- Récupération de toutes les demandes  
- Recommandation d’étudiants pour une demande donnée  

Pour effectuer une recommandation, **RequestManager** envoie une requête GET à **StudentManager** afin de récupérer les informations nécessaires.

**Base de données :**
- Table *Request*

### **3. AuthManager**
Le service **AuthManager** gère toute la partie authentification.

**Fonctionnalités :**
- Inscription  
- Connexion  
- Changement de mot de passe  
- Récupération des informations de l’étudiant associé à un compte utilisateur  

Pour cela, AuthManager envoie une requête GET avec l'adresse mail de l'utilisateur à **StudentManager** pour vérifier qu’un étudiant existe avec cette adresse.

**Base de données :**
- Table *User*

Deux classes sont utilisées :
- *UserEntity* : entité stockée en base (mot de passe inclus)  
- *User* : DTO exposé aux utilisateurs (mot de passe masqué)

### **4. ConfigServer**
Le **ConfigServer** centralise l’ensemble des fichiers de configuration des microservices.

**Rôle :**
- Fournir la configuration à chaque microservice au démarrage  
- Gérer plusieurs environnements (default et dev)  
- Permettre la mise à jour dynamique (Spring Cloud Config)

Il utilise un dépôt Git externe contenant tous les fichiers *.properties* .
Dépôt gitHub de configuration :  
*https://github.com/sophielrge/StudentHelpConfig.git*

### **5. shDiscovery (Eureka Server)**
Le service **shDiscovery** est le serveur Eureka utilisé pour l’enregistrement et la découverte des microservices.

**Rôle :**
- Enregistrement automatique des services au démarrage  
- Découverte dynamique des services (Service Discovery)  
- Facilite la résilience et la communication entre microservices  
