cd /root/warehouse-web
docker network create warehouse-net
docker stop warehouse
docker container rm warehouse
docker image rm warehouse
docker build -t warehouse .
docker run -d --name warehouse -p 8080:8080 --network warehouse-net --network-alias warehouse  warehouse