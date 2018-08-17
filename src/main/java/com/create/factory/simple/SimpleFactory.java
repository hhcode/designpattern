package com.create.factory.simple;
/**
 * 简单工厂模式
 * @author hWX456381
 *
 */
public class SimpleFactory {
	public static void main(String[] args) {
		Product productA = Factory.getProduct("A");
		System.out.println(productA.getProductName());
		productA.publicMethod();
		productA.diffMethod();
		
		Product productB = Factory.getProduct("B");
		System.out.println(productB.getProductName());
		productB.publicMethod();
		productB.diffMethod();
	}
}
/**
 * 抽象产品类
 * @author hWX456381
 *
 */
abstract class Product{
	protected String productName;
	
	public void publicMethod(){
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
 * @author hWX456381
 *
 */
class ProductA extends Product{
	public ProductA(){
		System.out.println("初始化产品A");
	}
	@Override
	public void diffMethod() {
		System.out.println("产品A实现业务");
	}
}
/**
 * 产品B实现具体业务
 * @author hWX456381
 *
 */
class ProductB extends Product{
	public ProductB() {
		System.out.println("初始化产品B");
	}
	@Override
	public void diffMethod() {
		System.out.println("产品B实现业务");
	}
}
class Factory{
	public static Product getProduct(String arg){
		Product product = null;
		switch (arg) {
		case "A":
			product = new ProductA();
			product.setProductName("ProductA");
			break;
		case "B":
			product = new ProductB();
			product.setProductName("ProductB");
			break;

		default:
			break;
		}
		return product;
	}
}

