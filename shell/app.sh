#!/usr/bin/env bash
cd `dirname $0`
source ./config.sh

JAVA_VM_OPTION="-XX:+UseG1GC"
APP_JAR="$APP_NAME.jar"
CMD=""
psid=0
function param(){
    count=$#
    p1=$1
    p2=$2
    if [[ $count == 2 ]]
    then
        if [ -z $p2 ]
        then
            ehco ""
        else
            echo "$p1$p2"
        fi
    elif [ $count == 1 ]
    then
        echo "$p1"
    fi

    return 0
}
function init(){
##############################JAVA_VM_OPTION###############################
if [ -n "$JAVA_VM_Xmx" ]
then
result=`param -Xmx $JAVA_VM_Xmx`
echo $result
JAVA_VM_OPTION="$JAVA_VM_OPTION $result"
fi

if [ -n "$JAVA_VM_Xms" ]
then
result=`param -Xms $JAVA_VM_Xms`
echo $result
JAVA_VM_OPTION="$JAVA_VM_OPTION $result"
fi

if [ -n "$JAVA_VM_InitiatingHeapOccupancyPercent" ]
then
result=`param -XX:InitiatingHeapOccupancyPercent= $JAVA_VM_InitiatingHeapOccupancyPercent`
echo $result
JAVA_VM_OPTION="$JAVA_VM_OPTION $result"
fi

if [ -n "$JAVA_VM_Xlog" ]
then
result=`param $JAVA_VM_Xlog`
echo $result
JAVA_VM_OPTION="$JAVA_VM_OPTION $result"
fi

if [ -n "$JAVA_VM_Verbgx" ]
then
result=`param $JAVA_VM_Verbgx`
echo $result
JAVA_VM_OPTION="$JAVA_VM_OPTION $result"
fi

if [ -n "$JAVA_VM_Xloggc" ]
then
result=`param -Xloggc: $JAVA_VM_Xloggc`
echo $result
JAVA_VM_OPTION="$JAVA_VM_OPTION $result"
fi

if [ -n "$JAVA_VM_MaxGCPauseMillis" ]
then
result=`param -XX:MaxGCPauseMillis= $JAVA_VM_MaxGCPauseMillis`
echo $result
JAVA_VM_OPTION="$JAVA_VM_OPTION $result"
fi

if [ -n "$JAVA_VM_PrintGCTimeStamps" ]
then
result=`param $JAVA_VM_PrintGCTimeStamps`
echo $result
JAVA_VM_OPTION="$JAVA_VM_OPTION $result"
fi

if [ -n "$JAVA_VM_PrintGCDateStamps" ]
then
result=`param $JAVA_VM_PrintGCDateStamps`
echo $result
JAVA_VM_OPTION="$JAVA_VM_OPTION $result"
fi


##############################JAVA_PARAM###############################
JAVA_PARAM="-Dfile.encoding=UTF-8"
JAVA_PARAM="$JAVA_PARAM $PARAM"

CMD="$JAVA_CMD $JAVA_VM_OPTION  --add-opens java.base/java.lang=ALL-UNNAMED  $JAVA_PARAM $APP_JAR >/dev/null 2>&1 &"
echo ${CMD}
}

checkpid() {
	javaps=$(ps aux | grep -w ${APP_JAR} | grep -v grep | awk '{print $2}h')

   if [ -n "$javaps" ]; then
      psid=$javaps
   else
      psid=0
   fi

}


function start(){
init
checkpid
 if [ $psid -ne 0 ]; then
      echo "==========================================="
      echo "error: $APP_JAR already started! (pid=$psid)"
      echo "==========================================="
	#exit 1
   else
      echo "Starting $APP_JAR ..."


      eval ${CMD}


      checkpid
      if [ $psid -ne 0 ]; then
         echo "(pid=$psid) [OK]"
      else
         echo "[Failed]"
      fi
   fi
}

function stop(){
   checkpid

   if [ $psid -ne 0 ]; then
      echo -n "Stopping $APP_JAR ...(pid=$psid) "
      kill  $psid

      if [ $? -eq 0 ]; then
         echo "[OK]"
      else
         echo "[Failed]"
      fi
      sleep 3
      checkpid
      if [ $psid -ne 0 ]; then
         stop
      else
          echo "[Stopped]"
       fi
   else
      echo "================================"
      echo "warn: $APP_JAR is not running"
      echo "================================"
   fi
}

function restart(){
    checkpid
    if [ $psid -ne 0 ]; then
      stop
    fi
    start
}

function info(){
    checkpid

     if [ $psid -ne 0 ]; then
        jinfo $psid
     else
      echo "================================"
      echo "warn: $APP_JAR is not running"
      echo "================================"
   fi
}


status() {
   checkpid

   if [ $psid -ne 0 ];  then
      echo "$APP_JAR is running! (pid=$psid)"
   else
      echo "$APP_JAR is not running"
   fi
}

case "$1" in
   'start')
      start
      ;;
   'stop')
     stop
     ;;
   'restart')
     restart
     ;;
   'status')
     status
     ;;
   'info')
     info
     ;;
    *)
    echo "Usage: $0 {start|stop|restart|status|info}"
exit 1
esac