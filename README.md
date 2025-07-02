# 🚀 Projeto Spring Boot + ELK + Kubernetes com Minikube no WSL

Abaixo usar quando pela ide ou Docker

## API
http://localhost:8080

## Kibana
http://localhost:5601

## Elasticsearch
http://localhost:9200

## Logstash API
http://localhost:9600

Este projeto descreve todos os passos para configurar uma aplicação Spring Boot integrada com Elasticsearch, Logstash e Kibana (ELK), usando Minikube com driver Docker no WSL (Ubuntu), sem depender do Docker Desktop.

---

## ✅ Etapas de Instalação

### 1. Atualizar o Ubuntu e instalar dependências:
```bash
sudo apt update && sudo apt upgrade -y
sudo apt install -y docker.io
sudo usermod -aG docker $USER
newgrp docker
```

### 2. Instalar `kubectl`
```bash
KUBECTL_VERSION=$(curl -sL https://dl.k8s.io/release/stable.txt)
curl -LO https://dl.k8s.io/release/${KUBECTL_VERSION}/bin/linux/amd64/kubectl
chmod +x kubectl
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

### 3. Instalar `minikube`
```bash
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
sudo install minikube-linux-amd64 /usr/local/bin/minikube
```

---

## 🚀 Inicializando o Cluster Minikube

### Iniciar com 2 CPUs e 4GB RAM
```bash
minikube start --driver=docker --cpus=2 --memory=4096
```

### Habilitar Ingress Controller
```bash
minikube addons enable ingress
```

### Ativar túnel para expor Ingress em localhost
```bash
minikube tunnel
```
> Esse comando precisa ficar rodando em um terminal separado.

---

## 📦 Build da aplicação
```bash
eval $(minikube docker-env)
docker build -t wesleyeduardodev/crud-usuario-elk-api ./app
```

---

## 📂 Aplicação de Manifests
```bash
cd k8s/
kubectl apply -f .
```

---

## 🔍 Verificações úteis
```bash
kubectl get nodes
kubectl get pods -w
kubectl get svc
kubectl get ingress
```

---

## 🧹 Resetar completamente o cluster (opcional)
```bash
minikube delete
minikube stop
minikube start --driver=docker --cpus=2 --memory=4096
kubectl delete -f .
```

---

## 🔧 Logs
```bash
kubectl logs -f -l app=spring-elk-app
kubectl logs -f -l app=logstash
kubectl logs -f -l app=elasticsearch
```

---

## 🌐 Acesso via Ingress (com minikube tunnel ativo)

- API: http://localhost/api/usuarios

### Teste via terminal:
```bash
curl http://localhost/api/usuarios
```

## Abrir uma porta para usar
minikube service spring-elk-app --url
curl http://127.0.0.1:40481/api/usuarios


## API Spring Boot
minikube service spring-elk-app --url

## Kibana
minikube service kibana --url

## Elasticsearch (API de consulta e status)
minikube service elasticsearch --url

## Elasticsearch (API de consulta e status)
minikube service logstash --url

## ver chaves no redis
docker exec -it redis-api-football redis-cli

## Ver as chaves do redis
KEYS *

## Ver o valor de uma chave
GET "team::33"

## Limpar chaves valor
FLUSHALL


## Parar containers docker
docker stop $(docker ps -q)

## Parar todos os containers em execução:
docker stop $(docker ps -aq)

## Remover todos os containers (parados e em execução):
docker rm $(docker ps -aq)

## Para container
docker stop api-teams

## Forçar remover containers
docker rm -f $(docker ps -aq)

## Remover volumes
docker volume prune -f

## Ver logs da API - nome do container
docker logs -f api-teams
docker logs -f logstash

## Remova o volume antigo para forçar criação limpa:
docker-compose down -v

## Verificar se o banco foi criado
docker exec -it postgres psql -U postgres -l

## SUbir um determiado container
docker start api-teams

## remover imagens
docker rmi -f $(docker images -aq)

## Apagar uma imagem em especifico
docker rmi api-teams

## Subir gerando imagem de novo
docker compose up --build -d

## verificar status ate com falhas
docker ps -a

### Teste via Postman:
```
GET http://localhost/api/usuarios
POST http://localhost/api/usuarios
Content-Type: application/json

{
  "nome": "Wesley",
  "email": "wesley@exemplo.com",
  "documento": "12345678900"
}
```

---

## ✅ Observações

- Sempre mantenha o `minikube tunnel` rodando ao usar Ingress com driver Docker.
- A porta muda em NodePort, mas Ingress com `localhost` é fixo.

---

Com isso, sua aplicação Spring Boot integrada ao stack ELK está acessível e orquestrada via Kubernetes com Minikube! 🎉


TODO
- Primeiro ver se já tem a informaçã na minha base 
- Se já tiver so recupera, se não vai na api do ApiFootball para atualizadr..
- 
