# Encurtador de Links - Spring Boot

Este é um projeto simples de **encurtador de links** desenvolvido em **Java com Spring Boot**.\
Ele permite criar links curtos que redirecionam automaticamente para a URL original.

---

## 🔹 Funcionalidades

- Criar um link curto a partir de uma URL original.
- Redirecionar automaticamente para a URL original ao acessar o shortCode.
- Normalização automática da URL adicionando `http://` caso o usuário não inclua.

---

## 🔹 Tecnologias

- Java 17
- Spring Boot
- H2 Database (em memória)
- Maven
- Postman (para testes)

---

## 🔹 Endpoints

### 1. Criar link encurtado

```
POST /link/encurtar
Content-Type: application/json

Body:
"google.com.br"
```

**Resposta:**

```
http://localhost:8080/link/52ee2e
```

> Observação: se a URL não começar com `http://` ou `https://`, o sistema adiciona automaticamente `http://`.

---

### 2. Redirecionar pelo shortCode

```
GET /link/{shortCode}
```

- Exemplo: `GET http://localhost:8080/link/52ee2e`

- Retorna **302 Redirect** para a URL original (`http://google.com.br`).

- O navegador segue automaticamente para a URL final.

- Caso o shortCode não exista, retorna **404 Not Found**.

---

## 🔹 Como rodar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/seuUsuario/encurtador-links.git
cd encurtador-links
```

2. Execute com Maven:

```bash
mvn spring-boot:run
```

3. O projeto estará disponível em:

```
http://localhost:8080
```

---

## 🔹 Testando no Postman

1. **POST /link/encurtar**

   - Enviar URL original no corpo da requisição.
   - Receberá o link encurtado diretamente como texto.

2. **GET /link/{shortCode}**

   - Copie o shortCode retornado no POST.
   - Cole no navegador ou no Postman.
   - O navegador abrirá automaticamente a página original.

---

## 🔹 Observações

- O banco H2 é em memória, então **os dados se perdem ao reiniciar a aplicação**.
- O shortCode é gerado automaticamente de forma aleatória.

---

## 🔹 Melhorias futuras

- Armazenar links em banco persistente (MySQL, PostgreSQL).
- Criar dashboard web para gerenciar links.
- Implementar contagem de cliques por link.

---

Feito por Leonardo Meyer
