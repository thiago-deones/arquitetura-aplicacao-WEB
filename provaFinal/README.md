# Sistema Acadêmico - Backend (Spring Boot 3)

## Descrição
Aplicação REST que simula um sistema acadêmico com entidades Aluno e Curso, autenticação, monitoramento com Prometheus/Grafana, testes e documentação OpenAPI.

## Tecnologias
- Java 17, Spring Boot 3
- Spring Data JPA (H2)
- Spring Security
- Spring Boot Actuator
- springdoc-openapi
- Prometheus & Grafana
- Gatling ou JMeter para testes de carga

## Como rodar localmente
1. Clone:
   git clone <repo>
2. Backend:
   cd backend
   mvn clean package
   java -jar target/<seu-jar>.jar

A aplicação roda em `http://localhost:8080`.

## Swagger / OpenAPI
Acesse: `http://localhost:8080/swagger-ui.html` ou `http://localhost:8080/swagger-ui/index.html`

## Actuator / Prometheus
Ative o Actuator em `application.yml`. O endpoint Prometheus:
`http://localhost:8080/actuator/prometheus`

## Prometheus + Grafana (local)
1. Coloque `prometheus.yml` na raiz do projeto e use o `docker-compose.yml` fornecido.
2. Rodar:
   docker-compose up -d
3. Grafana: `http://localhost:3000` (usuário padrão: admin/admin)

## Testes de carga
- Gatling: instruções no diretório `/performance` (ex.: `mvn gatling:test`)
- JMeter: arquivo `.jmx` em `/performance/jmeter`

## Deploy
- Render: seguir instruções em Render (build command `mvn -DskipTests package`, start `java -jar target/*.jar`)

## Referências
- Spring Boot: https://docs.spring.io/spring-boot/docs/current/reference/html
- Spring Security: https://docs.spring.io/spring-security
- Prometheus/Grafana docs
