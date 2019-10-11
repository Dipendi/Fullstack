import { Component, OnInit } from '@angular/core';
import { Recipe } from '../recipes/recipes.component';
import { ActivatedRoute, Router } from '@angular/router';
import { RecipeDataService } from '../service/data/recipe-data.service';

@Component({
  selector: 'app-update-recipe',
  templateUrl: './update-recipe.component.html',
  styleUrls: ['./update-recipe.component.css']
})
export class UpdateRecipeComponent implements OnInit {

  id: number
  recipe: Recipe

  constructor(private recipeDataService: RecipeDataService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.recipe = new Recipe(this.id, '', '', '', '', '', '', new Date(Date.now()), '');

    if(this.id!=-1) {
      this.recipeDataService.retrieveRecipe(this.id)
      .subscribe (
        data => this.recipe = data
      )
    }  
  }

  saveRecipe() {
    if(this.id == -1) {
      //Create Recipe
        this.recipeDataService.createRecipe('Dipendi', this.recipe)
          .subscribe (
            data => {
              console.log(data)
              this.router.navigate(['recipes'])
            }
          )
    } else {
      this.recipeDataService.updateRecipe('Dipendi', this.id, this.recipe)
      .subscribe (
        data => {
          console.log(data)
          this.router.navigate(['recipes'])
        }
      )
    }
  }
}
