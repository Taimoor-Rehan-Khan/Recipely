package dev.taimoor_sasha.recipely;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, ObjectId> {
//    Optional<Recipe> findRecipeByName(String name);
    Optional<Recipe> findRecipeById(String id);
    Optional<Recipe> deleteRecipeById(String id);
//    Optional<Recipe> deleteRecipeByName(String name);
}
