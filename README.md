## Инфраструктурные паттерны

### Сделать простейший RESTful CRUD по созданию, удалению, просмотру и обновлению пользователей. 
Пример API - https://app.swaggerhub.com/apis/otus55/users/1.0.0


- Добавить базу данных для приложения.
- Конфигурация приложения должна хранится в Configmaps.
- Доступы к БД должны храниться в Secrets.
- Первоначальные миграции должны быть оформлены в качестве Job-ы, если это требуется.
- Ingress-ы должны также вести на url arch.homework/ (как и в прошлом задании)

### На выходе должны быть предоставлена

- ссылка на директорию в github, где находится директория с манифестами кубернетеса (в виде pull request).
- инструкция по запуску приложения.
- команда установки БД из helm, вместе с файлом values.yaml.
- команда применения первоначальных миграций
- команда kubectl apply -f, которая запускает в правильном порядке манифесты кубернетеса
- Postman коллекция, в которой будут представлены примеры запросов к сервису на создание, получение, изменение и удаление пользователя. Важно: в postman коллекции использовать базовый url - arch.homework.
- Проверить корректность работы приложения используя созданную коллекцию newman run коллекция_постман и приложить скриншот/вывод исполнения корректной работы

##### Задание со звездочкой:
- Добавить шаблонизацию приложения в helm чартах

### Решение
```
minikube start

kubectl apply -f k8s/manifests/01-secret.yaml

kubectl apply -f k8s/manifests/02-configmap.yaml

kubectl create namespace ng

helm install postgres oci://registry-1.docker.io/bitnamicharts/postgresql --namespace default --values k8s/helm/postgresql-values.yaml
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx/
helm repo update
helm install nginx ingress-nginx/ingress-nginx --namespace ng -f k8s/nginx-ingress.yaml

kubectl apply -f k8s/job/db-migration-job.yaml

kubectl apply -f k8s/manifests/04-deployment.yaml

kubectl apply -f k8s/manifests/05-service.yaml

kubectl apply -f k8s/manifests/06-ingress.yaml

minikube tunnel
```