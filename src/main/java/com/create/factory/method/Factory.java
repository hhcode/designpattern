package com.create.factory.method;

/**
 * @Author huangjihui
 * @Date 2018/9/28 11:16
 */
public abstract class Factory {
    public static Factory getInstance(String className) {
        Object obj = null;
        try {
            Class<?> c = Class.forName(className);
            obj = c.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (Factory) obj;
    }

    public abstract Product factoryMethod();
}