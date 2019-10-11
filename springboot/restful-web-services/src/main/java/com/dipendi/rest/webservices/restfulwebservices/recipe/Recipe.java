package com.dipendi.rest.webservices.restfulwebservices.recipe;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	private String type;
	
	private String description;
	
	private String ingredients;
	
	private String instructions;
	
	private String username;
	
	private Date createDate;
	
	private String imgsrc;
	
	public Recipe() {
		
	}
	
	public Recipe(Long id, String name, String type, String description, String ingredients, String instructions,
			String username, Date createDate, String imgsrc) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.description = description;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.username = username;
		this.createDate = createDate;
		this.imgsrc = imgsrc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", type=" + type + ", description=" + description
				+ ", ingredients=" + ingredients + ", instructions=" + instructions + ", username=" + username
				+ ", createDate=" + createDate + ", imgsrc=" + imgsrc + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
