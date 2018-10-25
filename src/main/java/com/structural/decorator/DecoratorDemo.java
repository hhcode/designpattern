package com.structural.decorator;

public class DecoratorDemo {

    public static void main(String args[]) {
        // 定义具体构件
        Component component = new TextBox();
        // 定义装饰后的构件
        Component componentSB = new ScrollBarDecorator(component);
        componentSB.display();
        // 装饰后的类作为构件再次装饰
        Component componentBB = new BlackBorderDecorator(componentSB);
        componentBB.display();
    }

}
