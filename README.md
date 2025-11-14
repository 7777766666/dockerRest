Создать топик
docker exec kafka-broker1 /opt/kafka/bin/kafka-topics.sh --create --topic test-topic --bootstrap-server kafka1:9092 --partitions 3 --replication-factor 3

Отправить сообщения в кафку:
docker exec -it kafka-broker1 /opt/kafka/bin/kafka-console-producer.sh --topic test-topic --bootstrap-server kafka1:9092

Прочитать сообщения из кафки:
docker exec -it kafka-broker1 /opt/kafka/bin/kafka-console-consumer.sh --topic test-topic --from-beginning --bootstrap-server kafka1:9092

docker composeДоступ к сервисам:
http://localhost:8888/ Приложение
http://localhost:8080/ Кафка UI
