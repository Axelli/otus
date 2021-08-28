## ДЗ 01 - Основы работы с Kubernetes (часть 2)

### /simple-client 

Минимальный сервис, который отвечает на порту 8000 имеет http-метод `GET /health/` RESPONSE: `{"status": "OK"}` 
Образ запушен в dockerhub (`axelli/simple-client:v1`)

### /k8s

Манифесты k8s: Deployment, Service, Ingress. 

---
### ДЗ

В **Deployment** указаны Liveness, Readiness пробы. 
Количество реплик - 3. Image контейнера указан с Dockerhub.
Хост в **Ingress** указан как **arch.homework**. В итоге после применения манифестов GET запрос на http://arch.homework/health отдает:
`{"status": "OK"}.`

Итого:

0) Ссылка на github c манифестами: https://github.com/Axelli/otus/tree/master/homework01/k8s
1) url, по которому можно будет получить ответ от сервиса: http://arch.homework/health , http://arch.homework/hello
2) _Задание со звездой:_ В Ingress-е должно быть правило, которое форвардит все запросы с `/otusapp/{student name}/*` на сервис с rewrite-ом пути. Где `{student name}` - это имя студента: http://arch.homework/otusapp/{любое_имя}/health , http://arch.homework/otusapp/{любое_имя}/hello