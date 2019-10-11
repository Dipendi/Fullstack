import { Component, OnInit } from '@angular/core';
import { RecipeDataService } from '../service/data/recipe-data.service';
import { Router, ActivatedRoute } from '@angular/router';

export class Recipe {
  constructor(
    public id: number,
    public name: string,
    public type: string,
    public imgsrc: string,
    public ingredients: string,
    public instructions: string,
    public username: string,
    public createDate: Date,
    public description: string
  ){

  }
}

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css']
})
export class RecipesComponent implements OnInit {

  id: number
  recipe: Recipe
  public type: string
  
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

}
