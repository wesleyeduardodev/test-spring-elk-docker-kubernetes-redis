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
