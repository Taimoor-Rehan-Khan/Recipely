package dev.taimoor_sasha.recipely;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, ObjectId> {
    Optional<Recipe> findRecipeByName(String name);
    Optional<Recipe> deleteRecipeByName(String name);

    List<Recipe> findByUserId(String id);
}
