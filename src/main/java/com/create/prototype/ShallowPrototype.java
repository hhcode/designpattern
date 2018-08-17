package com.create.prototype;

public class ShallowPrototype implements Cloneable{
	private String name;
	private BeanDemo type = new BeanDemo();

	public BeanDemo getType() {
		return type;
	}

	public void setType(BeanDemo type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public ShallowPrototype clone(){
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (ShallowPrototype)obj;
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		ShallowPrototype proto = new ShallowPrototype();
		proto.setName("haha");
		ShallowPrototype clone = (ShallowPrototype)proto.clone();
		System.out.println(proto == clone);
		System.out.println(proto.getType() == clone.getType());
		
		System.out.println(proto.getName().equals(clone.getName()));
	}
}
