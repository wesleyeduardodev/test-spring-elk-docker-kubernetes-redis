# 🚀 Projeto Spring Boot + ELK + Kubernetes com Minikube no WSL

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