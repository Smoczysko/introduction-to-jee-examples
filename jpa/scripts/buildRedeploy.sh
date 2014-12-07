#!/bin/sh

clear
cd $1

echo "************ UNDEPLOYING *******************"
asadmin undeploy $1
echo "************ BUILDING **********************"
mvn clean package
echo "************ DEPLOYING *********************"
asadmin deploy target/$1.war

cd ..