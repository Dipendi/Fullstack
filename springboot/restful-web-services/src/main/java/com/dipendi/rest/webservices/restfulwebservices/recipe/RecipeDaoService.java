package com.dipendi.rest.webservices.restfulwebservices.recipe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RecipeDaoService {

	private static List<Recipe> recipes = new ArrayList<Recipe>();
	
	private static long recipeCount = 0;
	
	static {
		recipes.add(new Recipe(++recipeCount, "Pizza", "nonveg", "Here's an appetizer that's exciting and unique!", "1 tablespoon sesame oil, 1 skinless, boneless chicken breast half, ¼ cup barbeque sauce, divided, ½ cup marinara sauce, 1 (16 ounce) package pre-baked pizza crust, 1 cup shredded mozzarella cheese, ⅓ cup thinly sliced red onion, 2 tablespoons chopped fresh cilantro", "Heat the sesame oil in a skillet over medium heat. Place the chicken breast in the skillet, and top with 1 tablespoon barbeque sauce. Cook 10 minutes, turn, and top with 1 tablespoon barbeque sauce. Continue cooking 10 minutes, until juices run clear. Cool slightly, and cut into chunks.", "Dipendi", new Date(), "https://img4.nbstatic.in/tr:w-500/5b0868accff47e000dcbe568.jpg"));
		recipes.add(new Recipe(++recipeCount, "Pancake", "veg", "Tall, fluffy pancakes make the best breakfast", "3/4 cup milk, 2 tablespoons white vinegar, 1 cup all-purpose flour, 2 tablespoons white sugar, 1 teaspoon baking powder, cooking spray, 2 tablespoons butter, melted, 1 egg, 1/2 teaspoon salt, 1/2 teaspoon baking soda", "Heat a large skillet over medium heat, and coat with cooking spray. Pour 1/4 cupfuls of batter onto the skillet, and cook until bubbles appear on the surface. Flip with a spatula, and cook until browned on the other side.", "Dipendi", new Date(), "https://upload.wikimedia.org/wikipedia/commons/4/43/Blueberry_pancakes_%283%29.jpg"));
		recipes.add(new Recipe(++recipeCount, "Lasagne", "veg", "Layers and layers of deliciosness.", "12 uncooked lasagna noodles, 1 tablespoon olive oil, 1 cup chopped shallots, 2 garlic cloves, minced, 1 cup diced red bell pepper, 1 teaspoon crushed red pepper flakes, 4 cups sliced fresh mushrooms, salt and ground black pepper to taste, 1 1/2 cups ricotta cheese, 1/4 cup butter, 2 tablespoons all-purpose flour, 4 cups milk, 1 cup grated Parmesan cheese, 1 cup shredded mozzarella cheese, 1/4 cup chopped fresh flat-leaf parsley", "Bake in the preheated oven until cheese is melted and sauce is bubbly, 30 to 40 minutes. Allow lasagna to rest for 10 minutes before slicing and serving.", "Dipendi", new Date(), "https://s2.best-wallpaper.net/wallpaper/3840x2160/1712/Tomatoes-lasagna-food_3840x2160.jpg"));

		//recipes.add(new Recipe(++recipeCount, "Pancake", "veg", "Tall, fluffy pancakes make the best breakfast"));
		//recipes.add(new Recipe(++recipeCount, "Lasagne", "nonveg", "Layers and layers of deliciosness."));
	}
	
	  //   new Recipe(1, 'Pizza', "Here's an appetizer that's exciting and unique!"),
	  //   new Recipe(2, 'Pancake', "Tall, fluffy pancakes make the best breakfast"),
	  //   new Recipe(3, 'Lasagne', "Layers and layers of deliciosness.")
	
	public List<Recipe> findAll() {
		return recipes;
	}

	//SAVE
	
	public Recipe save(Recipe recipe) {
		if(recipe.getId()==-1 || recipe.getId()==0) {
			recipe.setId(++recipeCount);
			recipes.add(recipe);
			
		} else {
			deleteById(recipe.getId());
			recipes.add(recipe);
		}
		return recipe;
	}
	
	
	// DELETE 
	public Recipe deleteById(long id) {
		Recipe recipe = findOne(id);
		
		if(recipe==null) return null;
		
		if(recipes.remove(recipe)) {
			return recipe;
		}
		
		return null;
	}
	
	//public Recipe findOne(int id)	
	public Recipe findOne(long id) {
		for(Recipe recipe:recipes) {
			if(recipe.getId()==id) {
				return recipe;
			}
		}
		return null;
	}
	
	//public Recipe findByName(int id)	
	
	public Recipe findByName(String name) {
		for(Recipe recipe:recipes) {
			if(recipe.getName()==name) {
				return recipe;
			}
		}
		return null;
	}
	
}
