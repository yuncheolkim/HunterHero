#!/usr/bin/env bash
JAVA_CMD="java -jar"

# java vm option
JAVA_VM_Xmx="1g"
JAVA_VM_Xms="1g"
JAVA_VM_InitiatingHeapOccupancyPercent="35"
JAVA_VM_Xlog="-XX:+PrintGCDetails"
JAVA_VM_PrintGCTimeStamps="-XX:+PrintGCTimeStamps"
JAVA_VM_PrintGCDateStamps="-XX:+PrintGCDateStamps"
JAVA_VM_Verbgx="-verbose:gc"
JAVA_VM_Xloggc="./gc.log"
JAVA_VM_MaxGCPauseMillis="100"

# Application parameter
APP_NAME="info-performance-1.0.0"

APP_PARAM=(\
# http 端口
"-Dserver.port=9001" \
"-Dcom.sun.management.jmxremote.ssl=false" \
"-Dcom.sun.management.jmxremote.port=9400" \
"-Dcom.sun.management.jmxremote.rmi.port=9300" \
"-Dcom.sun.management.jmxremote.authenticate=true" \
"-Dcom.sun.management.jmxremote.password.file=/data/info/jmxremote.password" \
"-Dcom.sun.management.jmxremote.access.file=/data/info/jmxremote.access" \
# "-Djava.rmi.server.hostname=10.1.60.26" \
"-Duser.timezone=GMT+08"
)

PARAM=""
for var in ${APP_PARAM[@]}
do
PARAM="$var $PARAM"
done