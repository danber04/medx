# 🚀 Setup Eureka Server (Clean Notes)

## 1. Create Spring Boot Project

Create project: `eureka-server`

**Dependencies:**

* `spring-cloud-starter-netflix-eureka-server`
* `spring-boot-starter-actuator`
* `spring-cloud-starter-config`
* `spring-cloud-starter-bootstrap` *(enables bootstrap.yml)*

---

## 2. Enable Eureka Server

In main class:

```java
@EnableEurekaServer
```

---

## 3. Configure `bootstrap.yml`

Used to fetch config from Config Server.

```yaml
spring:
  application:
    name: eureka-server

cloud:
  config:
    uri: http://localhost:8888
    fail-fast: true   # fail startup if config server is down
```

---

## 4. Add Config in Config Server

### 📁 Path:

```
config-server → /src/main/resources/config/eureka-server/
```

⚠️ Folder name **must match** `spring.application.name`

---

### Create `application.yml`

```yaml
spring:
  application:
    name: eureka-server

server:
  port: 8761

eureka:
  instance:
    hostname: localhost
    prefer-ip-address: false

  client:
    fetch-registry: false
    register-with-eureka: false

    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```

---

### (Optional) Actuator Info

```yaml
management:
  info:
    env:
      enabled: true

info:
  app:
    name: Eureka Server
    description: Service Discovery Server
    version: 1.0.0
```

---

## 5. Start Order (Important)

1. Start **Config Server**
2. Start **RabbitMQ** (if using bus refresh)

   ```bash
   docker-compose up -d
   ```
3. Start **Eureka Server**

---

## 6. Verify Config Loading

Check via Config Server:

* [http://localhost:8888/eureka-server/default](http://localhost:8888/eureka-server/default)
* [http://localhost:8888/eureka-server/dev](http://localhost:8888/eureka-server/dev)

✔ Returns properties based on profile

---

## 7. Access Eureka Dashboard

```
http://localhost:8761/eureka
```

---

## ✅ Final State

* Eureka Server is up
* Connected to Config Server
* Ready for service registration

---

## ⚡ Quick Memory Hooks

* `bootstrap.yml → config server connection`
* `@EnableEurekaServer → activate server`
* `fetch-registry=false` + `register-with-eureka=false → standalone server`
* **Start order matters**