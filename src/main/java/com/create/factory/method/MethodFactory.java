package com.create.factory.method;

import org.junit.Test;

import com.util.Utils;

/**
 * 工厂方法模式
 * 
 * @author hWX456381
 *
 */
public class MethodFactory {
	public static void main(String[] args) {
		Factory factory = (Factory) Utils.getBean("factoryuri", "/com/demo/factorymethod/factory.properties");

		Product profuct = factory.factoryMethod();

		System.out.println(profuct.getProductName());
		profuct.publicMethod();
		profuct.diffMethod();
	}

	@Test
	public void testFactory() {
		Factory factory = Factory.getInstance("com.create.factory.method.FactoryA");
		Product profuct = factory.factoryMethod();
		System.out.println(profuct.getProductName());
		profuct.publicMethod();
		profuct.diffMethod();

	}

}

abstract class Factory {
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

class FactoryA extends Factory {
	public Product factoryMethod() {
		Product pro = new ProductA();
		pro.setProductName("ProductA");
		return pro;
	}
}

class FactoryB extends Factory {
	public Product factoryMethod() {
		Product pro = new ProductB();
		pro.setProductName("ProductB");
		return pro;
	}
}

class FactoryC extends Factory {

	@Override
	public Product factoryMethod() {
		Product pro = new ProductC();
		pro.setProductName("ProductC");
		return pro;
	}
}

/**
 * 抽象产品类
 * 
 * @author hWX456381
 *
 */
abstract class Product {
	protected String productName;

	public void publicMethod() {
		System.out.println("公共方法");
	}

	public abstract void diffMethod();

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}

/**
 * 产品A实现具体业务
 * 
 * @author hWX456381
 *
 */
class ProductA extends Product {
	public ProductA() {
		System.out.println("初始化产品A");
	}

	@Override
	public void diffMethod() {
		System.out.println("产品A实现业务");
	}
}

/**
 * 产品B实现具体业务
 * 
 * @author hWX456381
 *
 */
class ProductB extends Product {
	public ProductB() {
		System.out.println("初始化产品B");
	}

	@Override
	public void diffMethod() {
		System.out.println("产品B实现业务");
	}
}

class ProductC extends Product {
	public ProductC() {
		System.out.println("初始化产品C");
	}

	@Override
	public void diffMethod() {
		System.out.println("产品C实线业务");
	}

}
