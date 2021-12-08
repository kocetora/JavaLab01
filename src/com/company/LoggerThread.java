package com.company;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoggerThread  extends Thread {

    private Logger logger;
    private Method method;

    public LoggerThread(Logger logger, Method method) {
        this.logger = logger;
        this.method = method;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                method.invoke(logger);
            }
        } catch (IllegalAccessException | InvocationTargetException ex) {
        }
    }
}
