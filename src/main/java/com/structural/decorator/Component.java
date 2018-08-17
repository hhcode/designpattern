package com.structural.decorator;

/**
 * 抽象界面构件类：抽象构件类，为了突出与模式相关的核心代码，对原有控件代码进行了大量的简化
 */
public abstract class Component {
	public abstract void display();
}

/**
 * 窗体类：具体构件类
 */
class Window extends Component {
	public void display() {
		System.out.println("显示窗体！");
	}
}

/**
 * 文本框类：具体构件类
 */
class TextBox extends Component {
	public void display() {
		System.out.println("显示文本框！");
	}
}

/**
 * 列表框类：具体构件类
 */
class ListBox extends Component {
	public void display() {
		System.out.println("显示列表框！");
	}
}

/**
 * 构件装饰类：抽象装饰类
 */
class ComponentDecorator extends Component {
	private Component component; // 维持对抽象构件类型对象的引用
	// 注入抽象构件类型的对象
	public ComponentDecorator(Component component) {
		this.component = component;
	}

	public void display() {
		component.display();
	}
}

/**
 * 滚动条装饰类：具体装饰类
 */
class ScrollBarDecorator extends ComponentDecorator {
	public ScrollBarDecorator(Component component) {
		super(component);
	}

	public void display() {
		this.setScrollBar();
		super.display();
	}

	public void setScrollBar() {
		System.out.println("为构件增加滚动条！");
	}
}

/**
 * 黑色边框装饰类：具体装饰类
 */
class BlackBorderDecorator extends ComponentDecorator {
	public BlackBorderDecorator(Component component) {
		super(component);
	}

	public void display() {
		this.setBlackBorder();
		super.display();
	}

	public void setBlackBorder() {
		System.out.println("为构件增加黑色边框！");
	}
}
