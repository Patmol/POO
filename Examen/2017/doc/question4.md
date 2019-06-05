# Question 4

## Qu'est ce qu'un dispatch vector

Le dispatch vector est un ensemble de pointeur lié à une instance d'une classe (donc un objet) qui vont pointer vers l'adresse des différentes méthodes de cet objet.
Les méthodes associés à l'objet sont les méthodes du type effectif. Ce qui signifie que si on écrit le code suivant ;
```Java
Object monObject = new String("Hello World!)
```
Les méthodes pointées par le dispatch vector sont celles de la classe `String`

## Usage d'exceptions non-vérifiées

Une exceptions non-vérifiées (extends RuntimeException) est a utiliser lorsqu'on a une exception qui sort du cadre normal de l'utilisation du programme. Maintenant, une exception de base ne devrait survenir que dans un cadre non normal d'exécution. 
Une RunTimeException, à la différence d'une Exception, est _unchecked_, c'est à dire qu'elle n'est pas vérifié par le compilateur.

## Utilisation de _final_ dans un type immutable

Pour moi, l'utilisation de final n'a pas pour même but qu'un type immutable. Un type immutable va avoir toutes ses propriétés initialisés au moment de la création de l'objet or le mot clé _final_ a pour but de ne plus pouvoir modifier un paramètre une fois que celui-ci a été initialisé mais cela ne signifie pas que c'est forcément au moment de la création de l'objet.