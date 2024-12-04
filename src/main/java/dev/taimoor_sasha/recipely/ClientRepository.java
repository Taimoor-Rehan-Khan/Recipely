package dev.taimoor_sasha.recipely;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<Client, ObjectId> {

    Client findClientById(String id);

}