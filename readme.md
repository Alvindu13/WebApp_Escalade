# Project GRAYSCALAD

## Contexte

Dans le cadre de mon projet 6 de la formation Openclassrooms, il m'a été demandé de réaliser une application WEB qui répond aux besoins suivants : 

* de partager des informations sur les sites, leurs secteurs et les
voies de chaque secteur (hauteur, cotation, nombre de points…)
* de faire une recherche multi-critères pour trouver votre prochain
site de grimpe
* de laisser des commentaires
* de présenter les topo qui existent et les sites/secteurs qu’ils
couvrent
* d’avoir un espace de prêt de topo (les propriétaires de topo
peuvent proposer le prêt de leur topo et les gens intéressés
peuvent voir les topo disponibles et les réserver pour une
période)

## Déploiement de l'application

1. Package de l'application et compilation war 

Si votre IDE vous le permet, vous pouvez exporter votre projet en .war directement. 
Sinon, il vous suffit de convertir votre projet en projet maven et d'utiliser la commande suivante dans votre terminal (en vous plaçant dans le répertoire) ou votre IDE :

> `mvn package` 

Cette commande terminée, vous verrez apparaître un dossier target dans lequel se trouvera une archive .war de l'application.

2. Lancement du war avec TOMCAT

Vous pouvez intégrez TOMCAT à votre IDE (via maven) ou directement dans la configuration du build et démarrer directement l'application.

Sinon, vous pouvez utiliser une méthode plus manuelle qui consiste à :
* vous positionner dans le bin de votre fichier tomcat 
* démarrer le serveur TOMCART en lançant le fichier startup.bat sur windows et startup.sh sur MacOS. Pour MacOS il faudra utiliser la commande suivante dans le terminal en se positionnant dans le bin : 
> `sh startup.sh` 
* copier l'archive .war qui se trouve dans le dossier target de votre application dans le dossier webapps de votre serveur tomcat.

3. Test de l'application

Vous devez alors constater que votre application fonctionne. Pour cela vous pouvez vous rendre sur le lien suivant pour tester l'application :

http://localhost:8080/Project6_war/

## Accès à la base de données

Par défaut, l'application fonctionne sous drivers postgreSQL. La base de données et les informations mentionées dans le fichier properties sont fonctionnelles et accessible à tous.

Vous pouvez modifier l'accès à la base de données et intégrer la votre directement en modifiant le fichier db.properties.

Vous pouvez charger vos propres drivers et les dépendances nécessaires à votre application avec maven et modifier le fichier db.properties en fonction du SGBD utilisé.



