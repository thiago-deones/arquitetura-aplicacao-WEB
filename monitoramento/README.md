# 🧾 Pedido Service — Monitoramento com Prometheus e Grafana

Este projeto é um **serviço de pedidos** desenvolvido com **Spring Boot 3.3.5**, integrando **Prometheus** e **Grafana** para monitoramento de métricas em tempo real.  
O objetivo é demonstrar o uso de **Spring Boot Actuator** e **Micrometer** na exposição de métricas da aplicação.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.5**
  - Spring Web
  - Spring Boot Actuator
- **Micrometer Prometheus**
- **Springdoc OpenAPI (Swagger UI)**
- **Lombok**
- **Maven**

---

## ⚙️ Funcionalidades

- Exposição de métricas da aplicação via `/actuator/prometheus`
- Monitoramento de desempenho e uso de recursos (CPU, memória, threads etc.)
- Integração com **Prometheus** e visualização via **Grafana**
- Documentação automática da API com **Swagger UI**
- Health check e endpoints de gerenciamento

---

## 🧩 Arquitetura de Monitoramento

| Componente  | Descrição |
|--------------|------------|
| **Spring Boot Actuator** | Expõe métricas e status da aplicação |
| **Micrometer** | Coleta e padroniza as métricas |
| **Prometheus** | Coleta e armazena as métricas |
| **Grafana** | Visualiza e cria dashboards personalizados |

---


###  Compilar e executar a aplicação

```bash
mvn clean package
mvn spring-boot:run
```

A aplicação será iniciada em:  
👉 **http://localhost:8080**

---

## 📊 Endpoints Principais

| Endpoint | Descrição |
|-----------|------------|
| `/actuator` | Lista os endpoints de monitoramento disponíveis |
| `/actuator/health` | Verifica o status da aplicação |
| `/actuator/prometheus` | Exposição das métricas para Prometheus |
| `/swagger-ui.html` | Interface de documentação da API (Swagger UI) |

---

## 🧠 Configuração do Prometheus

Adicione o seguinte trecho ao seu arquivo `prometheus.yml`:

```yaml
scrape_configs:
  - job_name: 'pedido-service'
    metrics_path: '/actuator/prometheus'
    static_configs:
      - targets: ['host.docker.internal:8080']
```

> 💡 Altere o `target` de acordo com o endereço da sua aplicação.

---

## 📈 Configuração do Grafana

1. Acesse o Grafana em `http://localhost:3000`
2. Vá até **Connections > Data Sources > Add data source**
3. Escolha **Prometheus** e configure a URL (ex: `http://localhost:9090`)
4. Crie um **Dashboard**
5. Adicione gráficos com métricas como:
   - `http_server_requests_seconds_count`
   - `jvm_memory_used_bytes`
   - `process_cpu_usage`
   - `system_cpu_usage`

---

## 🧰 Dependências Principais

| Dependência | Descrição |
|--------------|------------|
| `spring-boot-starter-web` | Criação de APIs REST |
| `spring-boot-starter-actuator` | Métricas e monitoramento |
| `micrometer-registry-prometheus` | Exportação das métricas para Prometheus |
| `springdoc-openapi-starter-webmvc-ui` | Documentação da API (Swagger) |
| `lombok` | Simplificação do código Java |
| `spring-boot-starter-test` | Testes automatizados |

---

## 📦 Estrutura Básica do Projeto

```
pedido-service/
 ├── src/
 │   ├── main/
 │   │   ├── java/com/example/pedidoservice/
 │   │   └── resources/
 │   └── test/
 ├── pom.xml
 └── README.md
```

---

## 🖼️ Visão Geral da Arquitetura

```
+-------------------+
| Pedido Service    |
| (Spring Boot)     |
+-------------------+
          |
          v
+-------------------+
| Micrometer        |
| (Métricas)        |
+-------------------+
          |
          v
+-------------------+
| Prometheus        |
| (Coleta & Armaz.) |
+-------------------+
          |
          v
+-------------------+
| Grafana           |
| (Dashboards)      |
+-------------------+
```


