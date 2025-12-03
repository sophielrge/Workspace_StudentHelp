# Workspace_StudentHelp

<img width="615" height="486" alt="Capture d’écran 2025-12-03 à 11 22 45" src="https://github.com/user-attachments/assets/27b9edb5-5246-458b-900f-6d8676bb2b0c" />


Nous avons 5 microservices : 
- StudentManager : Il permet de gérer tout ce qui se réfère à l'étudiant. On peut créer un nouvel étudiant, modifier ses informations, avoir la liste de tous les étudiants. De plus, ce service s'occupe aussi de l'ajout des notes par d'autres étudiants (afin de donner un avis suite à une aide). Il utilise la table Student de notre base de données.
- RequesManager : Il permet de gérer tout ce qui se réfère aux demandes d'aides. On peut créer une demande, avoir une recommandation d'étudiants pour une demande donnée ou avoir la liste de toutes les demandes. Lorsque l'on recommande un étudiant, le service RequestManager envoie un GET au service StudentManager afin de récupérer les informations nécessaires. Il utilise la table Request de notre base de données.
- AuthManager : Il gére tout ce qui touche à l'authentification. On peut s'enregistrer, se connecter, changer son mot de passe ou encore récupérer les infoemations étudiantes associées à ce compte. Pour cela, le service AuthManager envoie une requête GET avec l'adresse mail de l'utilisateur, à StudentManager, qui cherche dans la base de donnée s'il y a un étudiant  avec cette adresse mail. Ce service utilise la table User de la base de donnée. Nous utilisons deux classes user : UserEntity et User, pour cacher le mot de passe aux utilisateurs.
- CondifServer :
- shDiscovery :

voici le lien de notre dépôt gitHub pour nos configurations : https://github.com/sophielrge/StudentHelpConfig.git

