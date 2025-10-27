# 🏪 Projeto Final — Bloco 02 | Farmácia Generation

Este projeto foi desenvolvido como parte do **Bootcamp Java Full-Stack da Generation Brasil**, durante o **Bloco 02 — Spring Boot**.  
O objetivo é aplicar os conceitos de **API REST**, **Modelagem de Dados**, **Validação**, **Relacionamentos entre Entidades**, e **Spring Security com JWT**.

---

## 💡 Objetivo do Projeto

Desenvolver um sistema de **Comércio Eletrônico para uma Farmácia**, implementando os recursos de CRUD (Create, Read, Update e Delete) para **Categorias**, **Produtos** e **Usuários**, além de um **sistema de autenticação e autorização com JWT**, garantindo segurança nos endpoints da aplicação.

---

## 🧱 Estrutura do Projeto

```
com.generation.farmacia
 ┣ 📁 controller
 ┃ ┣ 📄 CategoriaController.java
 ┃ ┣ 📄 ProdutoController.java
 ┃ ┗ 📄 UsuarioController.java
 ┣ 📁 model
 ┃ ┣ 📄 Categoria.java
 ┃ ┣ 📄 Produto.java
 ┃ ┣ 📄 Usuario.java
 ┃ ┗ 📄 UsuarioLogin.java
 ┣ 📁 repository
 ┃ ┣ 📄 CategoriaRepository.java
 ┃ ┣ 📄 ProdutoRepository.java
 ┃ ┗ 📄 UsuarioRepository.java
 ┣ 📁 service
 ┃ ┗ 📄 UsuarioService.java
 ┣ 📁 security
 ┃ ┣ 📄 JwtAuthFilter.java
 ┃ ┣ 📄 JwtService.java
 ┃ ┣ 📄 SecurityConfig.java
 ┃ ┣ 📄 UserDetailsImpl.java
 ┃ ┗ 📄 UserDetailsServiceImpl.java
 ┗ 📄 FarmaciaApplication.java
```

---

## ⚙️ Funcionalidades Implementadas

### 🧩 CRUD Categoria
- `GET /categorias` — Lista todas as categorias  
- `GET /categorias/{id}` — Busca categoria por ID  
- `GET /categorias/nome/{nome}` — Busca por nome  
- `POST /categorias` — Cria nova categoria  
- `PUT /categorias` — Atualiza categoria existente  
- `DELETE /categorias/{id}` — Deleta categoria  

### 💊 CRUD Produto
- `GET /produtos` — Lista todos os produtos  
- `GET /produtos/{id}` — Busca produto por ID  
- `GET /produtos/nome/{nome}` — Busca por nome  
- `GET /produtos/receita/{receitaObrigatoria}` — Filtra produtos que exigem ou não receita médica  
- `POST /produtos` — Cadastra novo produto vinculado a uma categoria  
- `PUT /produtos` — Atualiza produto existente  
- `DELETE /produtos/{id}` — Remove produto  

### 👤 CRUD Usuário + Autenticação (Spring Security com JWT)
- `POST /usuarios/cadastrar` — Cria novo usuário com senha criptografada (BCrypt)  
- `POST /usuarios/logar` — Gera token JWT para autenticação  
- `GET /usuarios/all` — Lista usuários (apenas com token válido)  

---

## 🔐 Segurança Implementada

O projeto utiliza **Spring Security 6** com **JWT (JSON Web Token)** para autenticação e autorização.  

- As rotas públicas (`/usuarios/cadastrar` e `/usuarios/logar`) são liberadas.  
- Todas as demais rotas exigem um **token JWT válido** no header `Authorization`.  

**Exemplo de header no Insomnia:**
```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

---

## 🧠 Tecnologias Utilizadas

| Tecnologia | Descrição |
|-------------|------------|
| ☕ Java 17 | Linguagem principal |
| 🌱 Spring Boot 3 | Framework principal |
| 🧩 Spring Data JPA | Persistência e ORM |
| 🧰 Hibernate | Mapeamento objeto-relacional |
| 🧑‍💻 Spring Security 6 | Autenticação e autorização |
| 🔐 JWT (JSON Web Token) | Segurança com token |
| 🐬 MySQL | Banco de dados relacional |
| 🧪 Insomnia | Testes dos endpoints REST |
| 📘 Swagger | Documentação da API (opcional) |

---

## 🧾 Exemplo de JSON — Cadastro de Produto

```json
{
  "nome": "Amoxicilina 500mg",
  "descricao": "Antibiótico indicado para o tratamento de infecções bacterianas.",
  "preco": 29.90,
  "quantidade": 80,
  "laboratorio": "EMS",
  "foto": "https://exemplo.com/imagens/amoxicilina.jpg",
  "receitaObrigatoria": true,
  "categoria": {
    "id": 1
  }
}
```

---

## 🔑 Exemplo de JSON — Cadastro de Usuário

```json
{
  "nome": "Administrador",
  "usuario": "admin@email.com.br",
  "senha": "admin123",
  "foto": "https://exemplo.com/foto.jpg"
}
```

---

## 🚀 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone git@github.com:jessicatinguely/projeto_final_bloco_02_farmacia.git
   ```

2. Abra no **Spring Tool Suite (STS)** ou **IntelliJ IDEA**.

3. Configure o arquivo `application.properties` com suas credenciais MySQL:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/db_farmacia
   spring.datasource.username=root
   spring.datasource.password=suasenha
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   api.security.token.secret=segredoSuperSecreto
   ```

4. Execute a classe `FarmaciaApplication.java`.

5. Teste os endpoints no **Insomnia**.

### 🧪 Coleção do Insomnia
Para facilitar os testes, importe a coleção:

- **Import From URL** (no Insomnia):  
  `https://github.com/jessicatinguely/projeto_final_bloco_02_farmacia/blob/main/Insomnia/ProjetoFarmacia.yaml`

- **Ou** baixe o arquivo e use **Import From File**:  
  [`/Insomnia/ProjetoFarmacia.yaml`](https://github.com/jessicatinguely/projeto_final_bloco_02_farmacia/blob/main/Insomnia/ProjetoFarmacia.yaml)

**Após importar**, configure o ambiente:
- `baseURL`: `http://localhost:8080`  
- `token`: cole o JWT obtido em **POST /usuarios/logar**  
O header `Authorization` já está preparado como `Bearer {{ token }}`.

---

## 📚 Autora

👩‍💻 **Jessica Ghirardelli Tinguely**  
Bootcamp Java Full-Stack — Generation Brasil  
Bloco 02 — Projeto Farmácia com Spring Boot + JWT  
📅 Outubro / 2025  

