def PATTERN = "%d{yyyy-MM-dd HH:mm:ss.SSS}-[%35.35F:%4.4line] [%25.25thread] %-5level - %msg %n"
def PATTERN_GAME = "[game]%d{yyyy-MM-dd HH:mm:ss.SSS}-[%35.35F:%4.4line] [%25.25thread] %-5level - %msg %n%rEx"
def PATTERN_TRACE = "%d{yyyy-MM-dd HH:mm:ss.SSS}-[%20.20thread] - %msg %n%rEx"
def PATTERN_KLOG = "%d{yyyy-MM-dd HH:mm:ss.SSS} - %msg %n%rEx"
def PATTERN_EVIL_LOG = "%d{yyyy-MM-dd HH:mm:ss.SSS} - %msg %n%rEx"

def appenderList = ["server", "error"]
def console = true
def klogDir = System.getProperty("klog")
def logBaseDir = System.getProperty("baseLogDir")
if (klogDir == null) {
    klogDir = "logs/"
}
if (logBaseDir == null) {
    logBaseDir = "logs/"
}
if (console) {
    appenderList.add("stdout")
    appender("stdout", ConsoleAppender) {
        target = "System.out"
        encoder(PatternLayoutEncoder) {
            pattern = PATTERN
        }
    }
}


appender("game", RollingFileAppender) {
    file = "logs/game.log"
    encoder(PatternLayoutEncoder) {
        pattern = PATTERN_GAME
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "logs/game_%d{yyyy-MM-dd}.log"
    }
}

appender("server", RollingFileAppender) {
    file = "logs/server.log"
    encoder(PatternLayoutEncoder) {
        pattern = PATTERN
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "logs/server_%d{yyyy-MM-dd}.log"
        maxHistory = 3
    }
}

appender("error", RollingFileAppender) {
    file = "logs/error.log"
    encoder(PatternLayoutEncoder) {
        pattern = PATTERN
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "logs/error_%d{yyyy-MM-dd}.log"
    }
    filter(ch.qos.logback.classic.filter.ThresholdFilter) {
        level = WARN
    }
}

appender("klog", RollingFileAppender) {
    file = "$klogDir/klog.log"
    encoder(PatternLayoutEncoder) {
        pattern = PATTERN_KLOG
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "logs/klog_%d{yyyy-MM-dd}.log"
    }
}

appender("chat", RollingFileAppender) {
    file = "$klogDir/chat.log"
    encoder(PatternLayoutEncoder) {
        pattern = PATTERN_KLOG
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "logs/chat_%d{yyyy-MM-dd}.log"
    }
}

appender("evil", RollingFileAppender) {
    file = "$klogDir/evil.log"
    encoder(PatternLayoutEncoder) {
        pattern = PATTERN_EVIL_LOG
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "logs/evil_%d{yyyy-MM-dd}.log"
    }
}

logger("klog", INFO, ["klog"])
logger("chat", INFO, ["chat"])
logger("evil", INFO, ["evil"])
root(DEBUG, appenderList)

scan("30 seconds")
jmxConfigurator()
