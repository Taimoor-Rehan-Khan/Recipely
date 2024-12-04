package dev.taimoor_sasha.recipely;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    public List<Recipe> allRecipes() {
        return recipeRepository.findAll();
    }

//    public Optional<Recipe> singleRecipe(ObjectId id) {
//        return recipeRepository.findById(id);
//    }
    public Optional<Recipe> singleRecipe(String id) {
        return recipeRepository.findRecipeById(id);
    }

    public Recipe createRecipe(String userId, String firstName, String lastName, String name, String description, String ingredients) {
        Recipe recipe =  recipeRepository.insert(new Recipe(userId, firstName, lastName, name, description, ingredients));
        return recipe;
    }

    public Optional<Recipe> deleteRecipe(String id) {
        Optional<Recipe> recipe = recipeRepository.deleteRecipeById(id);
        return recipe;
    }

}
