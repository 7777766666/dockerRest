Отправить сообщения в кафку:
docker exec -it kafka-broker /opt/kafka/bin/kafka-console-producer.sh --topic test-topic --bootstrap-server localhost:9092

Прочитать сообщения из кафки:
docker exec -it kafka-broker kafka-console-consumer --topic test-topic --from-beginning --bootstrap-server localhost:9092

Доступ к сервисам:
http://localhost:8888/ Приложение
http://localhost:8080/ Кафка UI
