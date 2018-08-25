#!/bin/bash
#这里可替换为你自己的执行程序，其他代码无需更改
APP_NAME=$2livecenter-0.0.1-SNAPSHOT_20180824.jar
OPTIONS=-Xms800m -Xmx800m -XX:PermSize=256m -XX:MaxPermSize=512m -XX:MaxNewSize=512m

usage() {
    echo "Usage: $APP_NAME [start|stop|restart|status]"
    exit 1
}

is_exist() {
    pid=`ps -ef | grep $APP_NAME | grep -v grep | awk '{print $2}' `
    #如果不存在返回1，存在返回0
    if [ -z "${pid}" ]; then
      return 1
    else
      return 0
    fi
}

start() {
   is_exist
   if [ $? -eq "0" ]; then
     echo "${APP_NAME} is already running. pid=${pid} ."
   else
     nohup java $OPTIONS -jar $APP_NAME > $APP_NAME.log 2>&1 &
   fi
}

stop() {
   is_exist
   if [ $? -eq "0" ]; then
     kill -9 $pid
   else
     echo "${APP_NAME} is not running"
   fi
}

status() {
   is_exist
   if [ $? -eq "0" ]; then
     echo "${APP_NAME} is running. Pid is ${pid}"
   else
     echo "${APP_NAME} is not running."
   fi
}

restart() {
   stop
   start
}

case "$1" in
   "start")
     start
     ;;
   "stop")
     stop
     ;;
   "status")
     status
     ;;
   "restart")
     restart
     ;;
   *)
     usage
     ;;
esac