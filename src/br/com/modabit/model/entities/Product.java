package br.com.modabit.model.entities;

import java.util.Objects;

import br.com.modabit.model.enums.Category;
import br.com.modabit.model.enums.Color;
import br.com.modabit.model.enums.Department;
import br.com.modabit.model.enums.Size;
import br.com.modabit.model.enums.TypeName;

public class Product {
	private TypeName type;
	private Size size;
	private Color color;
	private Category category;
	private Department department;
	private Double price;

	public Product() {
		super();
	}

	public Product(TypeName type, Size size, Color color, Category category, Department department, Double price) {
		super();
		this.type = type;
		this.size = size;
		this.color = color;
		this.category = category;
		this.department = department;
		this.price = price;
	}

	public TypeName getType() {
		return type;
	}

	public void setType(String type) {
		this.type =  TypeName.valueOf(type);
	}

	public Size getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = Size.valueOf(size);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = Color.valueOf(color);
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = Category.valueOf(category);
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = Department.valueOf(department);
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
		return " type= " + type + ", size= " + size + ", color= " + color + ", category= " + category
				+ ", department= " + department;
	}


	
	
	

}
