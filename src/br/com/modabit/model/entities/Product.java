package br.com.modabit.model.entities;

import java.util.Objects;

import br.com.modabit.model.enums.CategoryEnum;
import br.com.modabit.model.enums.ColorEnum;
import br.com.modabit.model.enums.DepartmentEnum;
import br.com.modabit.model.enums.SizeEnum;
import br.com.modabit.model.enums.TypeNameEnum;

public class Product {
	private Integer id;
	private TypeNameEnum type;
	private SizeEnum size;
	private ColorEnum color;
	private CategoryEnum category;
	private DepartmentEnum department;
	private Double price;

	public Product() {
		super();
	}

	public Product(TypeNameEnum type, SizeEnum size, ColorEnum color, CategoryEnum category, DepartmentEnum department, Double price) {
		super();
		this.type = type;
		this.size = size;
		this.color = color;
		this.category = category;
		this.department = department;
		this.price = price;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TypeNameEnum getType() {
		return type;
	}

	public void setType(String type) {
		this.type =  TypeNameEnum.valueOf(type);
	}

	public SizeEnum getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = SizeEnum.valueOf(size);
	}

	public ColorEnum getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = ColorEnum.valueOf(color);
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = CategoryEnum.valueOf(category);
	}

	public DepartmentEnum getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = DepartmentEnum.valueOf(department);
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(category, color, department, size, type);
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
				&& size == other.size && type == other.type;
	}

	@Override
	public String toString() {
		return " type= " + type + ", size= " + size + ", color= " + color + ", category= " + category
				+ ", department= " + department;
	}


	
	
	

}
