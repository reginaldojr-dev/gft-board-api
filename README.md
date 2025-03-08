# Avanade Decola Tech 2025
Java RESTful API criada para o Decola Tech Avanade 2025.

## Diagrama de Classes

```mermaid
classDiagram
    class User {
        - String name
        - Expense[] expenses
    }

    class Expense {
        - String category
        - float amount
        - String date
        - String description
    }

    class FixedExpense {
        - String type  // Water, Electricity, Internet
        - float amount
        - String dueDate
    }

    User --> Expense
    Expense <|-- FixedExpense
```
