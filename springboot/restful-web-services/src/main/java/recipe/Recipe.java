package recipe;

import java.util.Date; 

public class Recipe {
	
	private Integer id;
	
	private String name;
	
	private Date recipeDate;
	

	public Recipe(Integer id, String name, Date recipeDate) {
		super();
		this.id = id;
		this.name = name;
		this.recipeDate = recipeDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRecipeDate() {
		return recipeDate;
	}

	public void setRecipeDate(Date recipeDate) {
		this.recipeDate = recipeDate;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", recipeDate=" + recipeDate + "]";
	}
	

}
