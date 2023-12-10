## Stop any running containers and remove them.
# docker stop $(docker ps -aq)
# docker rm $(docker ps -aq)

sudo docker build -t spring-boot:1.0 .
sudo docker run -d -p 8080:8080 -t spring-boot:1.0
