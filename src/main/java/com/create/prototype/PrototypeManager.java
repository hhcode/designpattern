package com.create.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.common.base.Strings;

/**
 * 原型管理器
 * 
 * @author hWX456381
 *
 */
public class PrototypeManager {
	private static PrototypeManager instance = new PrototypeManager();
	private static Map<String, Document> prototypeMap = new ConcurrentHashMap<>();

	public static PrototypeManager getInstance() {
		return instance;
	}

	/**
	 * 新增原型
	 * 
	 * @param key
	 * @param doc
	 */
	public void putPrototy(String key, Document doc) {
		prototypeMap.put(key, doc);
	}

	/**
	 * 通过原型进行浅克隆
	 * 
	 * @param key
	 * @return
	 */
	public Document getClone(String key) {
		if (Strings.isNullOrEmpty(key) || !prototypeMap.containsKey(key)) {
			return null;
		}
		return prototypeMap.get(key).clone();
	}

	public Document getDeepClone(String key) {
		if (Strings.isNullOrEmpty(key) || !prototypeMap.containsKey(key)) {
			return null;
		}
		return prototypeMap.get(key).deepClone();
	}

	/**
	 * 通过原型进行深克隆
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PrototypeManager manager = PrototypeManager.getInstance();
		Word word = new Word();
		manager.putPrototy("word", word);
		Word cloneWord = (Word) manager.getDeepClone("word");
		System.out.println(cloneWord == word);
		cloneWord.doSomething();
		word.doSomething();
	}
}

abstract class Document implements Cloneable, Serializable {
	private static final long serialVersionUID = -3666673067714294115L;

	public Document clone() {
		Document doc = null;
		try {
			doc = (Document) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return doc;
	}

	public Document deepClone() {
		try {
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(bao);
			oos.writeObject(this);
			ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			return (Document) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public abstract void doSomething();
}

class Word extends Document {

	private static final long serialVersionUID = -5962837063600161416L;

	public void doSomething() {
		System.out.println("Word do something");
	}
}

class Excel extends Document {
	private static final long serialVersionUID = -188500621751552409L;

	public void doSomething() {
		System.out.println("Excel do something");
	}
}
