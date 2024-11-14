package dev.taimoor_sasha.recipely;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    // Method to retrieve all recipes for the authenticated user
    public List<Recipe> getUserRecipes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return recipeRepository.findByUserId(user.getId());
    }

    // Method to retrieve a single recipe by name for the authenticated user
    public Optional<Recipe> singleRecipe(String name) {
        return recipeRepository.findRecipeByName(name);
    }

    // Method to create a recipe, automatically linking it to the authenticated user
    public Recipe createRecipe(String firstName, String lastName, String userPicturePath,
                               String picturePath, String name, String description,
                               String ingredients) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Recipe recipe = new Recipe(user.getId(), firstName, lastName, userPicturePath,
                picturePath, name, description, ingredients);

        return recipeRepository.insert(recipe);
    }

    // Method to delete a recipe by name
    public Optional<Recipe> deleteRecipe(String name) {
        return recipeRepository.deleteRecipeByName(name);
    }

    // (Optional) Method to retrieve all recipes (for admins, if needed)
    public List<Recipe> allRecipes() {
        return recipeRepository.findAll();
    }
}
