## building docker image
docker build -t my-spring-boot-app .

## running docker image to test
docker run -p 8888:8888 my-spring-boot-app