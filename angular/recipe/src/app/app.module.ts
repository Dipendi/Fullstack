import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { ErrorComponent } from './error/error.component';
import { RecipesComponent } from './recipes/recipes.component';
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';
import { FavouritesComponent } from './favourites/favourites.component';
import { LogoutComponent } from './logout/logout.component';
import { HttpClient } from 'selenium-webdriver/http';
import { HttpClientModule } from '@angular/common/http';
import { UpdateRecipeComponent } from './update-recipe/update-recipe.component';
import { MyRecipesComponent } from './my-recipes/my-recipes.component';


@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    LoginComponent,
    ErrorComponent,
    RecipesComponent,
    MenuComponent,
    FooterComponent,
    FavouritesComponent,
    LogoutComponent,
    UpdateRecipeComponent,
    MyRecipesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
