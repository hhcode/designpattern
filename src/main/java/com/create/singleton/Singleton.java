package com.create.singleton;

/**
 * 单例模式 IoDH 通过内部类初始化时创建实例 即实现延时加载又由JVM保证线程安全
 * 
 * @author hWX456381
 *
 */
public class Singleton {
	private Singleton() {
	}

	private static class HolderClass {
		private final static Singleton instance = new Singleton();
	}

	public static Singleton getInstance() {
		return HolderClass.instance;
	}

	public static void main(String args[]) {
		Singleton s1, s2;
		s1 = Singleton.getInstance();
		s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
	}
}
