package com.create.singleton;
/**
 * 单例模式 饿汉式 初始化时直接创建实例
 * @author hWX456381
 *
 */
public class EagerSingleton {
	private static EagerSingleton instance = new EagerSingleton();
	private EagerSingleton(){
	}
	public static EagerSingleton getInstance(){
		return instance;
	}
	
	public static void main(String args[]) {  
		EagerSingleton s1, s2;   
            s1 = EagerSingleton.getInstance();  
        s2 = EagerSingleton.getInstance();  
        System.out.println(s1==s2);  
    }  
}
