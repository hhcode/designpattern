package com.behavioral.observer;

import java.util.ArrayList;

/**
 * 目标 被观察者
 * @author hWX456381
 *
 */
abstract class Subject {
    // 定义一个观察者集合用于存储所有观察者对象
    protected ArrayList<Observer1> observers = new ArrayList<Observer1>();

    /**
     * 注册方法，用于向观察者集合中增加一个观察者
     * @param observer
     */
    public void attach(Observer1 observer) {
        observers.add(observer);
    }

    /**
     * 注销方法，用于在观察者集合中删除一个观察者
     * @param observer
     */
    public void detach(Observer1 observer) {
        observers.remove(observer);
    }

    /**
     * 声明抽象通知方法
     */
    public abstract void notifyObserver();
}

/**
 * 具体目标类ConcreteSubject是实现了抽象目标类Subject的一个具体子类，其典型代码如下所示：
 * @author hWX456381
 *
 */
class ConcreteSubject extends Subject {
    /**
     * 实现通知方法
     */
    public void notifyObserver() {
        // 遍历观察者集合，调用每一个观察者的响应方法
        for (Observer1 obs : observers) {
            ((Observer1) obs).update();
        }
    }
}
