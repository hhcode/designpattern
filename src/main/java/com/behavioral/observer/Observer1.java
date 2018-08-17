package com.behavioral.observer;

/**
 * 观察者
 * @author hWX456381
 *
 */
interface Observer1 {
    /**
     * 声明响应方法
     */
    public void update();
}

/**
 * 在具体观察者ConcreteObserver中实现了update()方法，其典型代码如下所示：
 * 
 * @author hWX456381
 *
 */
class ConcreteObserver implements Observer1 {
    /**
     * 实现响应方法
     */
    public void update() {
        // 具体响应代码
    }
}
