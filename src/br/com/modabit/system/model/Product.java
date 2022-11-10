package br.com.modabit.system.model;

import java.util.Objects;

import br.com.modabit.system.enumeration.Category;
import br.com.modabit.system.enumeration.Color;
import br.com.modabit.system.enumeration.Department;
import br.com.modabit.system.enumeration.Size;
import br.com.modabit.system.enumeration.Type;

public class Product {
	private Type type;
	private Size size;
	private Color color;
	private Category category;
	private Department department;
	private Double price;

	public Product() {
		super();
	}

	public Product(Type type, Size size, Color color, Category category, Department department, Double price) {
		super();
		this.type = type;
		this.size = size;
		this.color = color;
		this.category = category;
		this.department = department;
		this.price = price;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, color, department, price, size, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return category == other.category && color == other.color && department == other.department
				&& Objects.equals(price, other.price) && size == other.size && type == other.type;
	}

	@Override
	public String toString() {
		return "Product [type=" + type + ", size=" + size + ", color=" + color + ", category=" + category
				+ ", department=" + department + ", price=" + price + "]";
	}


	
	
	

}
