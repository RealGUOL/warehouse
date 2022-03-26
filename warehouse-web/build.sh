cd /root/warehouse-web
docker stop warehouse
docker container rm warehouse
docker image rm warehouse
docker build -t warehouse .
docker run -d --name warehouse -p 8080:8080 warehouse