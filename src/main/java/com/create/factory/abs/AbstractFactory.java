package com.create.factory.abs;

import com.util.Utils;

/**
 * 抽象工厂模式
 * 把工厂方法模式中的工厂抽象化，定义工厂接口
 * 
 * @author hWX456381
 *
 */
public class AbstractFactory {
	public static void main(String args[]) {
		// 使用抽象层定义
		SkinFactory factory = null;

		String className = Utils.readProperties("abstractClassName");
		try {
			Class<?> clazz = Class.forName(className);
			factory = (SkinFactory) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		Button bt = factory.createButton();
		TextField tf = factory.createTextField();
		ComboBox cb = factory.createComboBox();
		bt.display();
		tf.display();
		cb.display();
	}
}

// 按钮接口：抽象产品
interface Button {
	public void display();
}

// Spring按钮类：具体产品
class SpringButton implements Button {
	public void display() {
		System.out.println("显示浅绿色按钮。");
	}
}

// Summer按钮类：具体产品
class SummerButton implements Button {
	public void display() {
		System.out.println("显示浅蓝色按钮。");
	}
}

// 文本框接口：抽象产品
interface TextField {
	public void display();
}

// Spring文本框类：具体产品
class SpringTextField implements TextField {
	public void display() {
		System.out.println("显示绿色边框文本框。");
	}
}

// Summer文本框类：具体产品
class SummerTextField implements TextField {
	public void display() {
		System.out.println("显示蓝色边框文本框。");
	}
}

// 组合框接口：抽象产品
interface ComboBox {
	public void display();
}

// Spring组合框类：具体产品
class SpringComboBox implements ComboBox {
	public void display() {
		System.out.println("显示绿色边框组合框。");
	}
}

// Summer组合框类：具体产品
class SummerComboBox implements ComboBox {
	public void display() {
		System.out.println("显示蓝色边框组合框。");
	}
}

// 界面皮肤工厂接口：抽象工厂
interface SkinFactory {
	public Button createButton();

	public TextField createTextField();

	public ComboBox createComboBox();
}

// Spring皮肤工厂：具体工厂
class SpringSkinFactory implements SkinFactory {
	public Button createButton() {
		return new SpringButton();
	}

	public TextField createTextField() {
		return new SpringTextField();
	}

	public ComboBox createComboBox() {
		return new SpringComboBox();
	}
}

// Summer皮肤工厂：具体工厂
class SummerSkinFactory implements SkinFactory {
	public Button createButton() {
		return new SummerButton();
	}

	public TextField createTextField() {
		return new SummerTextField();
	}

	public ComboBox createComboBox() {
		return new SummerComboBox();
	}
}