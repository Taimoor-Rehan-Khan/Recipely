package dev.taimoor_sasha.recipely;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<Client> allClients() {
        return clientRepository.findAll();
    }


    public Optional<Client> singleClient(String userName) {
        return clientRepository.findClientByUserName(userName);
    }

    public Client createClient(String firstName, String lastName, String userName, String password) {
        Client client =  clientRepository.insert(new Client(firstName, lastName, userName, password));
        return client;
    }

}
