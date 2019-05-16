#!/bin/bash

if [ ! "$PROFILE" ];
then
        PROFILE='default'
fi

if [ -z "${APP_NAME}" ] ;
    then java -jar product-core.jar --spring.profiles.active=$PROFILE;
else
        java -jar -Dspring.cloud.bootstrap.location=/var/run/bootstrap.yml product-core.jar --spring.profiles.active=$PROFILE;
fi