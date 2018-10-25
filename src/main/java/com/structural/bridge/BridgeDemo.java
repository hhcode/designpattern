package com.structural.bridge;

import com.util.Utils;

public class BridgeDemo {
    public static void main(String args[]) {
        // 获取扩充抽象类
        Image image = (Image) Utils.getBean("image");
        // 获取具体实现类
        ImageImp imp = (ImageImp) Utils.getBean("os");
        // 向抽象类中注入具体实现类
        image.setImageImp(imp);
        // 通过扩充抽象类调用具体实现类方法
        image.parseFile("小龙女");
    }
}
