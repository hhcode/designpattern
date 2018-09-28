package com.create.factory.method;

/**
 * @Author huangjihui
 * @Date 2018/9/28 11:14
 */
public class FactoryA extends Factory {
    @Override
    public Product factoryMethod() {
        Product pro = new ProductA();
        pro.setProductName("ProductA");
        return pro;
    }
}