#!/bin/sh

clear
cd $1
cd $2

echo "************ UNDEPLOYING *******************"
asadmin undeploy $2
echo "************ BUILDING **********************"
mvn clean package
echo "************ DEPLOYING *********************"
asadmin deploy target/$2.war

cd ../..