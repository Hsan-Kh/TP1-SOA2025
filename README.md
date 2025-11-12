# TP1-LSI3 – Ferme Intelligente Durable

**Modélisation XML • Validation XSD • Interrogation XPath**

---

## 👤 Informations sur le projet

| | |
|---|---|
| **Auteur** | Hsan Khecharem |
| **Filière** | Licence en Sciences de l'Informatique |
| **Spécialité** | Génie Logiciel et Systèmes d'Information |
| **Établissement** | Faculté des Sciences de Sfax |
| **Projet** | Ferme connectée – Validation XML/XSD et interrogation XPath |

---

## 📋 Description du TP

Ce TP a pour objectif de familiariser l'étudiant avec la **modélisation XML**, la **validation XSD** et l'**interrogation de documents XML avec XPath**.

### 🌾 Contexte du projet

Le projet consiste à concevoir un modèle de **ferme durable tunisienne**, incluant :

- 🌱 Des champs et cultures (oliviers, tomates, blé dur)
- 📡 Des capteurs intelligents (humidité, température, pH)
- 👥 Du personnel agricole
- ⚡ Des sources d'énergie renouvelable et certifications

### 🎯 Objectifs pédagogiques

L'étudiant apprend ainsi à :

1. Valider les données XML avec un schéma XSD
2. Interroger le XML avec XPath pour extraire des informations précises
3. Structurer un projet Maven pour automatiser la compilation et la gestion des ressources

---

## 💻 Environnement technique

- **Java JDK** : 1.8
- **IDE** : IntelliJ IDEA Community Edition
- **Outils** : Maven, API JAXP / XPath / DOM

---

## 📝 Déroulement du TP

### **Étape 1** : Modélisation XML

- Création du fichier `ferme.xml` représentant la ferme durable
- Définition des entités principales : champs, cultures, capteurs, personnel, énergie, certifications
- Utilisation d'attributs pertinents pour chaque élément

### **Étape 2** : Création du schéma XSD

- Définition du schéma `ferme.xsd`
- Validation des types de données (décimales, booléens, chaînes, années)
- Vérification de la conformité du XML au schéma

### **Étape 3** : Validation XML/XSD et interrogation XPath

- Implémentation en Java d'une validation XML/XSD avec `SchemaFactory` et `Validator`
- Interrogation des données XML avec XPath :
  - Cultures bio
  - Champs avec humidité inférieure à 50%
  - Employés actifs
  - *(Optionnel)* Certifications récentes
- Affichage des résultats dans la console

---

## 🛠️ Fonctionnalités clés

✅ Validation automatique du fichier XML selon le schéma XSD  
✅ Extraction d'informations via XPath  
✅ Utilisation de Maven pour structurer et compiler le projet  
✅ Code Java modulaire et facilement adaptable

---

## 📌 Résultats attendus

Le programme affiche un message de validation si le XML respecte le XSD. Les requêtes XPath sont extraites correctement et affichées dans la console :

```
✓ Validation du fichier XML :
  XML valide selon le schéma XSD ✓

📊 Requêtes XPath :

Cultures bio :
   - Oliviers bio
   - Tomates bio

Champs avec humidité < 50% :
   - C1
   - C3

Employés actifs :
   - Hatem
   - Amina
```

Les fichiers XML et XSD sont correctement structurés et validés.

---

## 📂 Structure du projet

```
TP1-LSI3/
├── src/
│   └── main/
│       ├── java/
│       └── resources/
│           ├── ferme.xml
│           └── ferme.xsd
├── pom.xml
└── README.md
```

---

## 🚀 Utilisation

### Compilation du projet

```bash
mvn clean compile
```

### Exécution du programme

```bash
mvn exec:java
```

---

## 📚 Ressources

- Documentation XML : [W3C XML](https://www.w3.org/XML/)
- Documentation XSD : [W3C XML Schema](https://www.w3.org/XML/Schema)
- Documentation XPath : [W3C XPath](https://www.w3.org/TR/xpath/)
- API JAXP : [Oracle JAXP Documentation](https://docs.oracle.com/javase/8/docs/api/javax/xml/package-summary.html)

---

## 📄 Licence

Ce projet est réalisé dans un cadre pédagogique à la Faculté des Sciences de Sfax.
