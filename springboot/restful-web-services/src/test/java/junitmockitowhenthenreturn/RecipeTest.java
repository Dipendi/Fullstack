package junitmockitowhenthenreturn;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import com.dipendi.rest.webservices.restfulwebservices.recipe.Recipe;
import com.dipendi.rest.webservices.restfulwebservices.recipe.RecipeDaoService;

//https://examples.javacodegeeks.com/core-java/junit/junit-mockito-when-thenreturn-example/


@RunWith(MockitoJUnitRunner.class)
public class RecipeTest {
	private static final java.util.Date Date = null;
	
	private static RecipeDaoService mockRecipeDao;
	private static Recipe recipe1;
	private static Recipe recipe2;
	
	@BeforeClass
	public static void init() {
		
		mockRecipeDao = mock(RecipeDaoService.class);
		
		recipe1 = new Recipe((long) 5, "Samosa", "veg", "Potato Stuffed Samosa", "mockito test ingredients", "mockito test instructions", "Dipendi", (Date) , "http://www.titikshapublicschool.com/wp-content/uploads/2018/11/developer-api.jpg");
	
		recipe2 = new Recipe((long) 6, "Chole", "veg", "chole yumm", "mockito test ingredients", "mockito test instructions", "Dipendi", (Date) , "http://www.titikshapublicschool.com/wp-content/uploads/2018/11/developer-api.jpg");
		
		when(mockRecipeDao.findAll()).thenReturn(Arrays.asList(recipe1, recipe2));
		when(mockRecipeDao.findOne(5)).thenReturn(recipe1);
	}
	
	@Test
	public void findAllTest() {
		List<Recipe> allRecipes = mockRecipeDao.findAll();
		assertNotNull(allRecipes);
		assertEquals(2, allRecipes.size());
	}

	@Test
	public void findOneTest() {
		Long recipeId = (long) 5;
		Recipe recipe = mockRecipeDao.findOne(recipeId);
		
		assertNotNull(recipe);
		assertEquals(Long.valueOf("5"), recipe.getId());
		assertEquals("Samosa", recipe.getName());
		assertEquals("veg", recipe.getType());
		assertEquals("Potato Stuffed Samosa", recipe.getDescription());
		assertEquals("mockito test ingredients", recipe.getIngredients());
		assertEquals("mockito test instructions", recipe.getInstructions());
		assertEquals(Date, recipe.getCreateDate());
		assertEquals("http://www.titikshapublicschool.com/wp-content/uploads/2018/11/developer-api.jpg", recipe.getImgsrc());

	}
	
	@Test
	public void deleteRecipeTest() {
		Long recipeId = (long) 5;
		Recipe deleterecipe = mockRecipeDao.deleteById(recipeId);
		
		assertNull(deleterecipe);
    }
}
