# Description du problème

Imaginez-vous plongé dans une énigme complexe, où chaque détail compte. Vous avez devant vous \( n \) paquets de tailles variées, et votre mission est de les placer dans des boîtes fournies par l'un des \( m \) fournisseurs. Chaque fournisseur possède un nombre illimité de boîtes, chacune de tailles différentes. La règle est simple : un paquet peut entrer dans une boîte seulement si sa taille n'excède pas celle de la boîte. Votre objectif est de minimiser l'espace gaspillé total, c'est-à-dire la somme des différences entre les tailles des boîtes et celles des paquets qu'elles contiennent.

Les tailles des paquets sont listées dans un tableau d'entiers `packages`, et les tailles des boîtes des fournisseurs sont données dans un tableau 2D `boxes`. Votre tâche est de sélectionner les boîtes d'un fournisseur de manière à minimiser cet espace gaspillé total. Si vous ne pouvez pas faire rentrer tous les paquets dans les boîtes, vous devez retourner -1. Sinon, vous calculez l'espace gaspillé total et vous le retournez modulo \( 10^9 + 7 \) pour maintenir le résultat dans une plage raisonnable même pour de très grands nombres.

Prenons un exemple pour illustrer la situation : vous avez des paquets de tailles \([2, 3, 5]\) et un fournisseur propose des boîtes de tailles \([4, 8]\). Ici, l'espace gaspillé minimal est de 6. Comment ? En plaçant les paquets dans les boîtes de manière suivante : le paquet de taille 2 et celui de taille 3 dans des boîtes de taille 4, et le paquet de taille 5 dans une boîte de taille 8.

Pour résoudre ce problème, il vous faut une approche fine et optimisée. Il s'agit de vérifier soigneusement chaque fournisseur tout en évitant des calculs superflus, afin de trouver la solution dans un délai raisonnable. Chaque détail compte, chaque choix est crucial. Arriverez-vous à résoudre cette énigme sans gaspiller d'espace ?

# Intuition

Pour résoudre notre énigme, nous devons utiliser deux outils principaux : le tri et la recherche binaire.

**Premièrement**, nous devons établir une évidence : pour que tous les paquets rentrent dans les boîtes d'un fournisseur, la plus grande boîte doit être au moins aussi grande que le plus grand paquet. Si ce critère est respecté, nous pouvons alors passer au calcul de l'espace gaspillé total en utilisant les boîtes de ce fournisseur.

**Deuxièmement**, nous devons aligner nos suspects – les paquets et les boîtes – par ordre croissant. Pourquoi ? Parce que cela simplifie notre recherche de la plus petite boîte qui peut contenir chaque paquet. Pour cela, nous utilisons une méthode rapide et efficace : la recherche binaire.

Chaque boîte devient une piste à suivre. En itérant sur chaque taille de boîte pour le fournisseur choisi, nous suivons combien de paquets ont été placés (i représente l'index dans le tableau des paquets) et combien d'espace gaspillé a été accumulé (s est le gaspillage cumulatif). Pour chaque taille de boîte b, nous trouvons l'index j jusqu'où nous pouvons placer les paquets à partir de l'index i. Ensuite, nous multiplions simplement b par le nombre de paquets qui peuvent entrer dans cette boîte (j - i) et l'ajoutons à l'accumulateur de gaspillage total s.

Chaque étape est une comparaison méticuleuse. Nous confrontons le gaspillage total s avec la meilleure réponse trouvée jusqu'à présent (ans). Si s est plus petit, nous mettons à jour ans.

Enfin, nous faisons le bilan. Si après avoir vérifié tous les fournisseurs possibles, ans détient toujours la valeur inf, cela signifie qu'aucun fournisseur ne peut faire rentrer tous les paquets. Nous retournons alors -1. Si nous avons trouvé une configuration valide, nous retournons ans - sum(packages) modulo \(10^9 + 7\).

Cette approche est méthodique. Elle réduit efficacement le nombre de fournisseurs à examiner et calcule le gaspillage sans vérifications ou itérations inutiles, optimisant ainsi le processus. Chaque détail compte dans cette enquête, et chaque choix est crucial pour résoudre le mystère de l'espace gaspillé.
w
# Approche de la solution

Imaginez-vous dans une pièce sombre, une lampe de bureau éclaire des dossiers éparpillés. Vous êtes un détective, et votre mission est de résoudre l'énigme des paquets et des boîtes. Pour cela, nous allons utiliser deux techniques essentielles : le tri et la recherche binaire. Ces outils nous aideront à minimiser l'espace gaspillé. Suivez-moi dans cette enquête méthodique.

**1. Trier les tailles de paquets**
Pour commencer, nous mettons de l'ordre dans nos preuves. Nous trions les paquets par ordre croissant. Ce classement est essentiel pour nos recherches futures.

**2. Examiner les fournisseurs**
Ensuite, nous passons en revue chaque fournisseur de boîtes, un par un.

- **Trier les tailles de boîtes**
  Nous trions également les tailles des boîtes de chaque fournisseur. Cela nous permet de vérifier rapidement de la plus petite à la plus grande boîte pour voir où chaque paquet peut rentrer.

- **Vérifier la plus grande boîte**
  Avant d'aller plus loin, nous vérifions si la plus grande boîte d'un fournisseur peut contenir le plus grand paquet. Si ce n'est pas le cas, ce fournisseur est écarté. Simple, non ?

- **Initialiser les variables**
  Nous commençons par initialiser deux variables : `s` pour l'espace gaspillé cumulé et `i` pour l'index actuel des paquets.

**3. Placer les paquets dans les boîtes**
Nous allons maintenant placer chaque paquet dans la boîte la plus petite possible qui peut le contenir.

- **Calculer l'espace gaspillé**
  Pour chaque boîte, nous trouvons combien de paquets peuvent y rentrer. Nous ajoutons l'espace gaspillé correspondant à notre total `s`.

- **Mettre à jour l'index des paquets**
  Nous avançons dans notre liste de paquets, en mettant à jour notre index `i`.

**4. Mettre à jour la réponse**
Après avoir examiné toutes les boîtes d'un fournisseur, nous comparons l'espace gaspillé total `s` avec la meilleure réponse trouvée jusqu'à présent (`ans`). Si `s` est plus petit, nous mettons à jour `ans`.

**5. Vérification finale**
Enfin, après avoir examiné tous les fournisseurs possibles, nous faisons le point. Si aucun fournisseur ne peut contenir tous les paquets, nous retournons -1. Sinon, nous retournons l'espace gaspillé total minimal, ajusté avec une opération modulo \(10^9 + 7\) pour les très grands nombres.

Avec cette approche, nous optimisons notre enquête. Chaque étape est soigneusement planifiée pour éviter les vérifications et calculs inutiles, nous menant efficacement à la solution de l'énigme de l'espace gaspillé. Voilà comment un détective résout les mystères, un indice à la fois.