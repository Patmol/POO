# Question 2

## Définition du principe de substitution de Liskov

Si S est un sous-type de T les objets de type S doivent pouvoir être utilisés dans tout contexte qui requiert des objets de type T. 

Plus précisément, 3 règles doivent être respecté:
- règle des signatures
"Les sous-types doivent avoir toutes les méthodes du super-type et leur signature doivent être compatible"
- règle des méthodes
"Les appels aux méthodes du sous-type doivent se comporter comme des appels aux méthodes du super-type" 
- règle des propriétés
"Le sous-type doit préserver toutes les propriétés qui sont vérifiées par le super-type"

## La classe Compteur1 est-elle un sous-type légitime de la classe Compteur0 ?

En partant du principe que Compteur1 n'_extends_ pas de Compteur0, Compteur1 ne peut pas être considéré comme un sous-type de Compteur0.

Si nous considéré maintenant que Compteur1 est bien un sous-type de Compteur0 (et l'_extends_). Oui, on peut dire que Compteur1 est bien un sous-type valide de Compteur0, les méthodes de Compteur1 n'augmentant pas la pré-condition ou ne diminuant pas la post-condition des méthodes de Compteur0 et celles-ci ne vont pas contre la rep de Compteur0.

## La classe Compteur2 est-elle un sous-type légitime de la classe Compteur0

Non, Compteur2 n'est pas un sous-type valide, en effet, les pré-condition de la méthode incr() on été augmenté par Compteur2, on va donc contre la règle 2 du principe de substitution de Liskov.