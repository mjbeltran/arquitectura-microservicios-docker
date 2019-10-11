#!/bin/sh

#
# Script para contruir las imágenes docker de los microservicios
#

set -e

# gestión del patrón **/*.sh
#shopt -s globstar

echo " --> Construcción de las imágenes docker ..."

echo " ----> Modo de ejecuión script shell"

#chmod +x **/*.sh

docker-compose -f app-docker-compose.yml build --no-cache --force-rm --pull \
 	&& docker-compose -f app-docker-compose.yml push


echo " --> Imágenes docker creadas con exito"
