#!/bin/sh
          
          
echo "--> Eliminación del stack antiguo"
 docker stack rm app-microservicios

#echo "--> Attente de la fermeture de la stack et fermeture des conteneurs (30 secondes)"
#sleep 30

echo "--> Ejecuión del comando : docker stack deploy --compose-file app-docker-compose.yml app-microservicios"
#docker stack deploy --compose-file app-docker-compose.yml app-microservicios
docker-compose -f app-docker-compose.yml up -d

echo "--> Aplicaición lanzada"

#echo " --> Stack lanzado"