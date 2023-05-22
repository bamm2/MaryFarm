# Server Port 테이블

**Jenkins Server (Local)**

| Service(Container name) | IP address  | Port | contents |
| --- | --- | --- | --- |
| jenkins | 172.17.0.0/16 (dynamic) | 50000:50000
8080:8080 | docker container |
| node-android | 172.17.0.0/16 (dynamic) | 30122:22 | docker container |
| node-spring | 172.17.0.0/16 (dynamic) | 30022:22 | docker container |

**Ansible Server**

| Service(Container name) | IP address | Port | contents |
| --- | --- | --- | --- |
| ansible | EC2 Pulblic IP | - | host |

**AWS SSAFY Server**

| Service(Container name) | IP address (docker network) | Port | contents |
| --- | --- | --- | --- |
| rabbitmq | 172.18.0.0/16 (dynamic) | 5672, 15672 | docker container |
| kafka-docker_zookeeper_1 | 172.18.0.100 (static) | 2181 | docker container |
| kafka-docker_kafka_1 | 172.18.0.101 (static) | 9092 | docker container |
| mysqldb | 172.18.0.0/16 (dynamic) | 3307 | docker container |
| mongodb | 172.18.0.0/16 (dynamic) | 6379 | docker container |
| redis | 172.18.0.0/16 (dynamic) | 27017 | docker container |
| config-service | 172.18.0.0/16 (dynamic) | 8888 | docker container |
| discovery-service | 172.18.0.0/16 (dynamic) | 8761 | docker container |
| apigateway-service | 172.18.0.0/16 (dynamic) | 443(HTTPS) | docker container |
| user-service | 172.18.0.0/16 (dynamic) | 8081 | docker container |
| plant-service | 172.18.0.0/16 (dynamic) | 8084 | docker container |
| notify-service | 172.18.0.0/16 (dynamic) | 8082 | docker container |
| chat-service | 172.18.0.0/16 (dynamic) | 8083 | docker container |
| calendar-service | 172.18.0.0/16 (dynamic) | 8085 | docker container |
| board-service | 172.18.0.0/16 (dynamic) | 8086 | docker container |
| consumer-service | 172.18.0.0/16 (dynamic) | 8090 | docker container |