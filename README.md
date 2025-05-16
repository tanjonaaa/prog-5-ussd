# prog-5-ussd

## Présentation

`prog-5-ussd` est une application Java destinée à simuler un menu USSD interactif.

---

## Objectif

Librairie pour créer des menus USSD interactifs
- Créer une `UssdApp`
- Définir des menus imbriqués ou des menus qui activent des actions

Exemple avec la mise en place d'un menu USSD de Mobile Money

Conventions
- Une convention de nommage claire et uniforme
- L'application d'un linter pour garantir la qualité du code
- L'intégration continue via **GitHub Actions**

---

## Conventions de développement

### Nommage

| Élément   | Convention         |
|-----------|--------------------|
| Classe    | `UpperCamelCase`   |
| Méthode   | `lowerCamelCase`   |
| Variable  | `lowerCamelCase`   |
| Constante | `UPPER_SNAKE_CASE` |

> Références : conventions standard Java + [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)

---

## Linting

### Outil utilisé

- **Checkstyle**, configuré selon le style Google

### Lancement manuel du linter

```bash
./mvn checkstyle:check
