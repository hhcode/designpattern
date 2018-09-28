package com.create.factory.method;

/**
 * @Author huangjihui
 * @Date 2018/9/28 11:15
 */
public class FactoryC extends Factory {

    @Override
    public Product factoryMethod() {
        Product pro = new ProductC();
        pro.setProductName("ProductC");
        return pro;
    }
}
