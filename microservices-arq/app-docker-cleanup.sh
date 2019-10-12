#!/bin/sh

echo " --> Limpieza de las docker..."

docker rm $(docker ps -q -f status=exited)
docker rmi $(docker images -aq)

echo " --> Fin du nettoyage"
