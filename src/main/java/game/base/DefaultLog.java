package game.base;

import cn.hutool.core.lang.caller.CallerUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.level.Level;

/**
 * @author Yunzhe.Jin
 * 2021/3/9 18:00
 */
public class DefaultLog   {
    private static final String FQCN = DefaultLog.class.getName();

    public static Log get(Class<?> clazz) {
        return Log.get(clazz);
    }

    public static Log get(String name) {
        return Log.get(name);
    }

    public static Log get() {
        return Log.get();
    }

    public String getName() {
        return log.getName();
    }

    public boolean isEnabled(Level level) {
        return log.isEnabled(level);
    }

    public void log(Level level, String format, Object... arguments) {
        log.log(level, format, arguments);
    }

    public void log(Level level, Throwable t, String format, Object... arguments) {

        log.log(level, t, format, arguments);
    }

    public void log(String fqcn, Level level, Throwable t, String format, Object... arguments) {
        log.log(fqcn, level, t, format, arguments);
    }

    public boolean isTraceEnabled() {
        return log.isTraceEnabled();
    }

    public void trace(Throwable t) {
        log.trace(t);
    }

    public void trace(String format, Object... arguments) {
        log.trace(format, arguments);
    }

    public void trace(Throwable t, String format, Object... arguments) {
        log.trace(t, format, arguments);
    }

    public void trace(String fqcn, Throwable t, String format, Object... arguments) {
        log.trace(fqcn, t, format, arguments);
    }

    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    public void debug(Throwable t) {
        log.debug(t);
    }

    public void debug(String format, Object... arguments) {
        log.debug(format, arguments);
    }

    public void debug(Throwable t, String format, Object... arguments) {
        log.debug(t, format, arguments);
    }

    public void debug(String fqcn, Throwable t, String format, Object... arguments) {
        log.debug(fqcn, t, format, arguments);
    }

    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    public void info(Throwable t) {
        log.info(t);
    }

    public void info(String format, Object... arguments) {
        log.info(format, arguments);
    }

    public void info(Throwable t, String format, Object... arguments) {
        log.info(t, format, arguments);
    }

    public void info(String fqcn, Throwable t, String format, Object... arguments) {
        log.info(fqcn, t, format, arguments);
    }

    public boolean isWarnEnabled() {
        return log.isWarnEnabled();
    }

    public void warn(Throwable t) {
        log.warn(t);
    }

    public void warn(String format, Object... arguments) {
        log.warn(format, arguments);
    }

    public void warn(Throwable t, String format, Object... arguments) {
        log.warn(t, format, arguments);
    }

    public void warn(String fqcn, Throwable t, String format, Object... arguments) {
        log.warn(fqcn, t, format, arguments);
    }

    public boolean isErrorEnabled() {
        return log.isErrorEnabled();
    }

    public void error(Throwable t) {
        log.error(t);
    }

    public void error(String format, Object... arguments) {
        log.error(format, arguments);
    }

    public void error(Throwable t, String format, Object... arguments) {
        log.error(t, format, arguments);
    }

    public void error(String fqcn, Throwable t, String format, Object... arguments) {
        log.error(fqcn, t, format, arguments);
    }

    private Log log;

    private String prefix = "";

    public DefaultLog(String name) {
        this.log = LogFactory.get(CallerUtil.getCallerCaller());
    }

    public DefaultLog(Log log) {
        this.log = log;
    }

    public DefaultLog(String name, String prefix) {
        this.log = LogFactory.get(CallerUtil.getCallerCaller());
        this.prefix = prefix;
    }

    public DefaultLog(Log log, String prefix) {
        this.log = log;
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

}
