package com.create.singleton;

/**
 * 单例模式 懒汉式 延迟加载 考虑线程安全两次判断
 *
 * @author hWX456381
 */
public class LazySingleton {
    private volatile static LazySingleton instance;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            // 第一重判断
            synchronized (LazySingleton.class) {
                //第二重判断
                if (instance == null) {
                    //创建单例实例
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String args[]) {
        LazySingleton s1, s2;
        s1 = LazySingleton.getInstance();
        s2 = LazySingleton.getInstance();
        System.out.println(s1 == s2);
    }
}
