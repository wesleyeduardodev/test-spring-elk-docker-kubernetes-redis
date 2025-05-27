# 🔨 Stage 1 - Build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /usr/src/app

# Copia o pom.xml e baixa dependências primeiro (para cache eficiente)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o restante do código fonte
COPY src ./src

# Faz o build da aplicação
RUN mvn clean package -DskipTests


# 🚀 Stage 2 - Imagem final, leve
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia o .jar gerado do build
COPY --from=build /usr/src/app/target/crud-usuario-1.0.jar app.jar

EXPOSE 8080

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
