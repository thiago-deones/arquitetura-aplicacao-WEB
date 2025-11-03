````markdown
# 🔒 Spring Security com JWT e Keycloak – Exemplo Prático

Este repositório demonstra como integrar **Spring Boot (3+)**, **JWT (JSON Web Token)** e **Keycloak (21+)** para autenticação e autorização de APIs REST.  
O projeto mostra como proteger rotas públicas, privadas e administrativas usando o **OAuth2 Resource Server** e o **Keycloak** como servidor de autenticação.

Este exemplo foi desenvolvido como parte da disciplina **Arquitetura de Aplicações Web**, ministrada pelo professor **Leonardo Vieira**, no curso de **Análise e Desenvolvimento de Sistemas**.  
**Autor:** Thiago Deones Jesus

---

## 🚀 Tecnologias e Ferramentas

- **Java 17+**
- **Spring Boot 3**
- **Spring Security / OAuth2 Resource Server**
- **Keycloak 21+**
- **Maven**
- **Postman** ou **curl** para testes

---

## ⚙️ Configurando o Keycloak

### 1. Instalação
Baixe o Keycloak e execute-o em modo de desenvolvimento:

```bash
bin/kc.sh start-dev
````

Por padrão, o console administrativo estará disponível em:

```
http://localhost:8080
```

---

### 2. Criando o Realm

No console do Keycloak, acesse com o usuário administrador e crie um novo **Realm** chamado `app-realm`.

---

### 3. Criando o Client

* Vá em **Clients → Create**
* **Client ID:** api-backend
* **Access Type:** confidential
* **Standard Flow Enabled:** true
* **Direct Access Grants Enabled:** true
* **Valid Redirect URIs:** `http://localhost:8080/*`

Salve e copie o **Client Secret** gerado.

---

### 4. Criando Roles

Em **Realm Roles → Add Role**, adicione as seguintes permissões:

* `user`
* `admin`

---

### 5. Criando Usuários

Crie dois usuários em **Users → Add User**:

* `usuario_teste`
* `admin_teste`

Em **Role Mappings**, atribua as roles correspondentes:

* `usuario_teste` → `user`
* `admin_teste` → `admin`

---

### 6. Obtendo o Issuer URI

Após configurar o Realm, copie o valor do **Issuer URI**, por exemplo:

```
http://localhost:8080/realms/app-realm
```

Esse valor será necessário no arquivo `application.yml` do projeto.

---

## 🧩 Estrutura do Projeto

```
src/
 └── main/
     ├── java/
     │   └── com.exemplo.apisegura/
     │       ├── config/
     │       │   └── SecurityConfiguration.java
     │       ├── controller/
     │       │   └── ApiController.java
     │       └── ApiSeguraApplication.java
     └── resources/
         └── application.yml
```

---

## ⚙️ Exemplo de Configuração (`application.yml`)

```yaml
server:
  port: 8083

spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: http://localhost:8080/realms/app-realm
```

---

## ▶️ Executando o Projeto

Com o Keycloak rodando, configure o `issuer-uri` no `application.yml` e inicie o projeto:

```bash
./mvnw spring-boot:run
```

A aplicação ficará acessível em:

```
http://localhost:8083
```

---

## 🔑 Obtendo o Token JWT

Para gerar um token de acesso, use o comando:

```bash
curl --location --request POST 'http://localhost:8080/realms/app-realm/protocol/openid-connect/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'client_id=api-backend' \
--data-urlencode 'client_secret=<SEU_CLIENT_SECRET>' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=usuario_teste' \
--data-urlencode 'password=<SENHA_USUARIO>'
```

A resposta incluirá o campo `access_token`:

```json
{
  "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",
  "expires_in": 300
}
```

Copie o token retornado para usá-lo nas requisições.

---

## 🧪 Testando os Endpoints

Inclua o token JWT nas requisições com o cabeçalho:

```
Authorization: Bearer <seu_token_jwt>
```

### 🌐 Endpoint Público

```bash
curl http://localhost:8083/api/public
```

**Resposta:**
`Acesso público liberado`

---

### 👤 Endpoint Protegido

```bash
curl -H "Authorization: Bearer <token_user>" http://localhost:8083/api/user
```

**Resposta:**
`Acesso autorizado para usuários autenticados`

---

### 🔒 Endpoint Administrativo

```bash
curl -H "Authorization: Bearer <token_admin>" http://localhost:8083/api/admin
```

**Resposta:**
`Acesso exclusivo para administradores`

---

## 🧰 Dicas

* Garanta que o **JDK 17+** está configurado corretamente no seu ambiente.
* Você pode renovar o token utilizando o endpoint de *refresh token* do Keycloak.
* Verifique logs de autenticação diretamente no console do Spring Boot.

---

## 📄 Licença

Projeto de uso **educacional e livre**, podendo ser modificado conforme suas necessidades.

---

👨‍💻 **Autor:** Thiago Deones Jesus

```

---

Agora é só copiar **tudo entre os blocos de código** (incluindo o conteúdo) e colar no seu arquivo `README.md`.  
Quer que eu adicione um exemplo de controller (`ApiController.java`) e `SecurityConfiguration.java` também pra deixar o projeto pronto pra rodar?
```

