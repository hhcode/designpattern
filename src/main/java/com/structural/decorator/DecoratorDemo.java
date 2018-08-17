package com.structural.decorator;

public class DecoratorDemo {

	public static void main(String args[]) {
		Component component, componentSB, componentBB; // 使用抽象构件定义
		component = new TextBox(); // 定义具体构件
		componentSB = new ScrollBarDecorator(component); // 定义装饰后的构件
//		componentSB.display();
		componentBB = new BlackBorderDecorator(componentSB); // 装饰后的类作为构件再次装饰
		componentBB.display();
	}

}
