# Android Java & PHP – Gestion des Étudiants

## 📖 Description
Ce projet illustre une application **Android Java** connectée à une **API PHP/MySQL** pour gérer les étudiants.  
Il combine une interface mobile permettant l’ajout d’étudiants avec **Volley** et **Gson**, et une API PHP qui assure la persistance des données dans une base MySQL.

---

## 📂 Structure du projet

```
ProjetWS/
├── Android/
    ├── ma/fst/projetws/beans/Etudiant.java
    └── ma/fst/projetws/AddEtudiant.java

├── PHP/
    ├── classes/
    │   └── Etudiant.php
    ├── connexion/
    │   └── Connexion.php
    ├── dao/
    │   └── IDao.php
    ├── services/
    │   └── EtudiantService.php
    └── ws/
        ├── createEtudiant.php
        └── loadEtudiant.php

```
---
## 📲 Installation de l’APK

Pour installer l’APK de ce projet Android :

1. **Compiler l’application**  
   - Ouvrir le projet dans **Android Studio**.  
   - Aller dans le menu **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
   - <img width="960" height="540" alt="image" src="https://github.com/user-attachments/assets/f8013d07-8ca0-44f1-ba68-70147e031e22" />
   - Le fichier APK sera généré dans le dossier :  
     ```
     app/build/outputs/apk/debug/app-debug.apk
     ```
2. **Transférer l’APK sur votre appareil Android**  
   - Copier le fichier `app-debug.apk` sur votre smartphone (via câble USB, Bluetooth,...).  

3. **Autoriser les sources inconnues**  
   - Sur votre appareil Android, aller dans **Paramètres > Sécurité**.  
   - Activer l’option **Installer des applications depuis des sources inconnues**.  

4. **Installer l’APK**  
   - Ouvrir le fichier `app-debug.apk` sur votre smartphone.  
   - Suivre les instructions pour installer l’application.  

5. **Lancer l’application**  


---

## ⚙️ Fonctionnalités

### 📱 Côté Android
- **AddEtudiant Activity**  
  - Formulaire avec champs `nom`, `prenom`, `ville` (Spinner), `sexe` (RadioButton).  
  - Bouton **Ajouter** déclenche une requête POST vers l’API PHP.  
  - Utilisation de **Volley** pour la communication réseau.  
  - Utilisation de **Gson** pour parser la réponse JSON et afficher les étudiants dans les logs.  

- **Etudiant Bean**  
  - Classe Java représentant un étudiant avec `id`, `nom`, `prenom`, `ville`, `sexe`.  
  - Méthode `toString()` pour affichage lisible.  

### 💻 Côté PHP
- **Etudiant.php** : Classe modèle avec getters.  
- **Connexion.php** : Classe utilitaire pour établir une connexion PDO à MySQL.  
- **IDao.php** : Interface définissant les méthodes CRUD.  
- **EtudiantService.php** : Implémentation CRUD (create, update, delete, findAll, findById).  
- **createEtudiant.php** : Endpoint API pour insérer un étudiant via POST et retourner la liste en JSON.  
- **loadEtudiant.php** : Endpoint API pour charger tous les étudiants en JSON.  

---

## 🖥️ Exemple d’exécution


https://github.com/user-attachments/assets/7436e3a4-5fd7-4301-9a23-f448d2a5fbb6

---

## 💡 Concepts pratiqués
- Communication **Android ↔ PHP/MySQL** via API REST.  
- Utilisation de **Volley** pour requêtes HTTP.  
- Parsing JSON avec **Gson**.  
- Architecture **DAO/Service** côté PHP.  
- Persistance des données avec **PDO/MySQL**.  
- Gestion des formulaires et événements côté Android.  

---

## 🧑‍💻 Auteur
👤 **Agouram Hassan**  
📱 Développement Android Java & PHP  
🎓 Instructor : **Mr. LACHGAR**  
📅 6 Avril 2026
