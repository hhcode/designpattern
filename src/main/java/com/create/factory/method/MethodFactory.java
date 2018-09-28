package com.create.factory.method;

import com.util.Utils;
import org.junit.Test;

/**
 * 工厂方法模式
 *
 * @author hWX456381
 */
public class MethodFactory {

    public static void main(String[] args) {
        Factory factory = (Factory) Utils.getBean("factoryuri");

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


/**
 * 抽象产品类
 *
 * @author hWX456381
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
