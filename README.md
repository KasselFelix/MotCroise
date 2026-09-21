---

# 🧩 MotCroise — Générateur et Solveur de Mots Croisés en Java

**MotCroise** est un logiciel de **construction et de résolution automatique de mots croisés**, développé en **Java**.  
Il implémente un **algorithme de satisfaction de contraintes (CSP)** capable de résoudre un mot croisé en **moins de deux minutes**, grâce à des **heuristiques intelligentes** et à l’utilisation d’un **dictionnaire lexical**.

---

## 🎯 Objectif du projet

Ce projet vise à démontrer l’efficacité des **algorithmes de satisfaction de contraintes** appliqués à un problème combinatoire réel : la **résolution de grilles de mots croisés**.  
Il met en œuvre des techniques d’optimisation et de recherche heuristique pour trouver une solution cohérente et complète à partir d’un ensemble de contraintes lexicales.

---

## ⚙️ Fonctionnalités principales

- 🧠 **Résolution automatique** de grilles de mots croisés à partir d’un dictionnaire.  
- 🧩 **Construction de grilles personnalisées** (taille, disposition, mots imposés).  
- ⚡ **Algorithme CSP** performant basé sur :
  - Backtracking intelligent  
  - Heuristiques de choix de variables et de domaines  
  - Propagation de contraintes  
- 📚 **Chargement dynamique du dictionnaire** pour adapter la difficulté.  
- 🖥️ Interface console simple et claire (possibilité d’extension graphique).  

---

## Architecture du projet

Le projet est organisé autour de plusieurs classes principales :

```
MotCroise/
├── src/
│   ├── Dictionnaire.java       # Gestion du dictionnaire et des mots valides
│   ├── Grille.java             # Structure de la grille de mots croisés
│   ├── Case.java               # Représentation d’une case (lettre, contrainte)
│   ├── CSP.java                # Algorithme de satisfaction de contraintes
│   ├── Heuristique.java        # Choix des variables et des domaines
│   ├── Solveur.java            # Lancement et orchestration de la résolution
│   └── Main.java               # Point d’entrée du programme
├── data/
│   └── dictionnaire.txt        # Fichier de mots utilisés pour la résolution
└── README.md
```

---

## Principe de fonctionnement

1. **Lecture du dictionnaire** et initialisation des variables.  
2. **Création de la grille** avec les contraintes de position et d’intersection.  
3. **Application de l’algorithme CSP** :
   - Sélection de la variable la plus contrainte (heuristique MRV).  
   - Sélection du mot le plus compatible (heuristique LCV).  
   - Propagation des contraintes pour réduire le domaine.  
4. **Résolution complète** ou retour en arrière (backtracking) si nécessaire.  
5. **Affichage du résultat** sous forme de grille remplie.

---

## 🚀 Exécution

### 1. Compilation
```bash
javac -d bin src/*.java
```

### 2. Lancement
```bash
java -cp bin Main
```

### 3. Exemple de sortie
```
Résolution en cours...
Grille complétée en 1 min 42 s
```

---

## Performances

- Résolution typique : **< 2 minutes** pour une grille standard (10x10).  
- Optimisation par heuristiques MRV et LCV.  
- Possibilité d’adapter la taille du dictionnaire pour ajuster la complexité.

---

## 🛣️ Améliorations possibles

- Interface graphique JavaFX pour visualiser la grille.  
- Ajout de dictionnaires thématiques (animaux, géographie, etc.).  
- Export des grilles en format texte ou image.  
- Intégration d’un mode “création de grille” interactif.

---

## Auteur

Développé par **Wycherley-Kassel Felix**  
Projet académique en Java — démonstration d’un solveur CSP appliqué aux mots croisés.

