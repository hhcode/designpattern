package com.create.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Prototype implements Serializable, Cloneable {
	private static final long serialVersionUID = -4984728370158624258L;
	private String name;
	private BeanDemo beanDemo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BeanDemo getBeanDemo() {
		return beanDemo;
	}

	public void setBeanDemo(BeanDemo beanDemo) {
		this.beanDemo = beanDemo;
	}

	@Override
	public Prototype clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (Prototype) obj;
	}

	public Prototype deepClone() {
		ByteArrayOutputStream bao = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			bao = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bao);
			oos.writeObject(this);
			// 将对象从流中取出
			bis = new ByteArrayInputStream(bao.toByteArray());
			ois = new ObjectInputStream(bis);
			return (Prototype) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bao != null)
					bao.close();
				if(oos != null)
					oos.close();
				if(bis != null)
					bis.close();
				if(ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void main(String[] args) {

		Prototype prototype = new Prototype();
		prototype.setName("deepPrototype");
		prototype.setBeanDemo(new BeanDemo());
		// 深克隆
		System.out.println(prototype.deepClone().getBeanDemo() == prototype.getBeanDemo());
		// 浅克隆
		System.out.println(prototype.clone().getBeanDemo() == prototype.getBeanDemo());
	}
}
