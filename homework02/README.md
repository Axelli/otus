## ДЗ 02 - Основы работы с Kubernetes (часть 3)

### /user-service 

CRUD по созданию, удалению, просмотру и обновлению пользователей.
Сервис работает на порту 8080. Имеет следующие эндпоинты:

`GET /` - выбор всех пользователей

`GET /{id}` - выбор пользователя по идентификатору

`POST /` - создание пользователя

`PUT /{id}` - обновление пользователя

`DELETE /{id}` - удаление пользователя

Образ запушен в dockerhub (`axelli/user-service:1.0`)

### /k8s

Манифесты

### /postman

Postman коллекция для тестирования

---

### ДЗ

1. Добавлена база данных для приложения (postgresql через репо helm чартов bitnami).
2. Манифесты приложения шаблонизированы в helm чартах:
   * Добавлен Job первоначальной миграции
   * Конфигурация/креды к БД занесены в ConfigMap/Secrets
   * Ингресс настроен на хост **arch.homework**
3. Добавлена postman-коллекция для вызова эндпоинтов (https://github.com/Axelli/otus/tree/master/homework02/postman)

### Для запуска
1. Корневая папка https://github.com/Axelli/otus/tree/master/homework02/k8s/helm
2. запустить скрипт `./run.sh`. Либо выполнить вручную:
   * `helm upgrade --install pg bitnami/postgresql -f pg/pg-helm-values.yml` - установка/обновление postgresql. При ошибке запуска выполнить:
     * `helm repo add bitnami https://charts.bitnami.com/bitnami` - добавить репозиторий bitnami, если не установлен
     * `helm repo update` - обновить зависимости 
   * `kubectl apply -f initdb` - применение джобы первоначальной миграции
   * `helm upgrade --install app user-service` - установка/обновление приложения user-service
3. Приложение готово. Можно выполнять запросы вручную из постмана (коллекция в папке postman) или прогнать автотесты. Для запуска автотестов:
   * Перейти в папку https://github.com/Axelli/otus/tree/master/homework02/postman
   * Выполнить `./run.sh`. Либо выполнить вручную: `docker run -it --rm --network host -v $(pwd):/etc/newman postman/newman run homework02.postman_collection.json`

### Для удаления
1. Корневая папка https://github.com/Axelli/otus/tree/master/homework02/k8s/helm
2. Запустить скрипт `./remove.sh` (!!! хранилище необходимо удалить вручную)