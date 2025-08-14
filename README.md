# GFT Board API — Desafio de Projeto

API REST simples para gerenciar **cards** de um board estilo Kanban (TODO → DOING → DONE).  
Entrega adaptada para o **Bootcamp GFT**, mantendo tudo **simples** e fiel ao conteúdo da aula.

> **Baseado** no projeto da DIO: https://github.com/digitalinnovationone/board

---

## Como executar

### Maven
```bash
./mvnw spring-boot:run
```

Acesse:
- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **H2 Console:** http://localhost:8080/h2-console  
  JDBC: `jdbc:h2:mem:lab` • User: `sa` • Password: *(vazio)*

---

## Endpoints principais (exemplos)

> Ajuste os paths se o seu controller usar nomes diferentes.

- **GET `/cards`** — lista os cards  
- **POST `/cards`** — cria um card  
  ```json
  { "title": "Novo card", "description": "texto opcional", "status": "TODO" }
  ```
- **PUT `/cards/{id}`** — atualiza título/descrição/status  
- **PUT `/cards/{id}/move?to=DOING|DONE|TODO`** — move o card entre colunas  
- **DELETE `/cards/{id}`** — remove

Status sugeridos: `TODO`, `DOING`, `DONE`.

---

## Tecnologias
Java • Spring Boot • Spring Web • Spring Data JPA • H2 • Springdoc OpenAPI (Swagger UI)

---

## Notas
- Projeto **intencionalmente simples** para o desafio (sem Docker, segurança, etc.).  
- Banco **em memória**: dados se perdem ao reiniciar (ideal para avaliação).

---

## Autor
**Reginaldo**  
GitHub: https://github.com/reginaldojr-dev  
LinkedIn: https://www.linkedin.com/in/reginaldo-junior-175148188/
