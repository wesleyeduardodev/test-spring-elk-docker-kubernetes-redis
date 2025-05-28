# Verificar a versão do kubectl
kubectl version --client

# Verificar a versão do minikube
minikube version

# Iniciar o cluster Kubernetes usando Docker
minikube start --driver=docker
minikube start --driver=docker --cpus=2 --memory=4096

# Verificar se o nó do cluster está funcionando
kubectl get nodes

# Verificar os pods (depois de aplicar seus manifests)
kubectl get pods -A

# Verificar serviços
kubectl get svc -A

# Verificar contextos (opcional)
kubectl config get-contexts


#Aplica todos os manifests válidos do diretório atual;
kubectl apply -f .

#Diretório do meu projeto
cd "/mnt/c/Users/Wesley Eduardo/Documents/Repositórios/crud-usuario-elk"

#Para acompanhar em tempo real o status das pods subindo no Kubernetes, use:
kubectl get pods -w

# Deletar tudo
kubectl delete -f .

Se quiser zerar geral e começar com um Minikube limpo:
minikube delete





----O QUE EU TINHA ANTES


## API
http://localhost:8080

## Kibana
http://localhost:5601

## Elasticsearch
http://localhost:9200

## Logstash API
http://localhost:9600


## Comandos K8S

# cria todos os recursos do Kubernetes — namespace, pods, serviços, tudo!
kubectl apply -f k8s/

# Verifica os pods
kubectl get pods -n crud-elk


#  Verifica os serviços
kubectl get svc -n crud-elk


Verifica se tá rodando
kubectl get nodes



Instalar o Chocolatey (caso queira)
Set-ExecutionPolicy Bypass -Scope Process -Force; `
[System.Net.ServicePointManager]::SecurityProtocol = `
[System.Net.ServicePointManager]::SecurityProtocol -bor 3072; `
iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))


instalar minikube
choco install minikube -y

- saber versão do minikube
- minikube version


kubectl logs -f logstash-5669bb9494-f9pkw

kubectl logs -f spring-elk-app-59c5ffbbdd-s9ndj


abri uma porta
minikube service spring-elk-app --url

curl http://127.0.0.1:40481/api/usuarios

# Verifica se está instalado
minikube version

# Inicia o cluster com Docker
minikube start --driver=docker

# Redireciona Docker local pro Minikube
eval $(minikube docker-env)

# Builda a imagem da API
docker build -t crud-usuario-elk-api ./app

# Aplica os YAMLs
kubectl apply -f k8s/

# Verifica pods
kubectl get pods -n crud-elk

# Verifica e acessa serviços
minikube service api-usuario -n crud-elk --url
minikube service kibana -n crud-elk --url


Isso apaga o cluster anterior.
minikube delete


kubectl get pods -n crud-elk



kubectl logs -n crud-elk -f postgres-c5cccb496-jvqzh

kubectl logs -n crud-elk -f elasticsearch-6ffb765796-bd7s6

kubectl logs -n crud-elk -f kibana-5dfff5b7fb-wjrx9

kubectl logs -n crud-elk -f api-usuario-77bdcbc547-wprh8


kubectl apply -f ingress.yaml


Remove todos os deployments, services e ingress do namespace:

kubectl delete all --all -n crud-elk



Remove também ingress, configmaps e outros objetos:

kubectl delete ingress --all -n crud-elk
kubectl delete configmap --all -n crud-elk


Verifica:

kubectl get pods -n crud-elk
kubectl get svc -n crud-elk
kubectl get ingress -n crud-elk


curl http://192.168.49.2/api/api/usuarios

