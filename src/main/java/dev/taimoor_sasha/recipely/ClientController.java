package dev.taimoor_sasha.recipely;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class ClientController {
    @Autowired
    private ClientService clientService;
//    @GetMapping
//    public ResponseEntity<List<Recipe>> getAllRecipes() {
//        return new ResponseEntity<List<Recipe>>(recipeService.allRecipes(), HttpStatus.OK);
//    }

    @PostMapping("register")
    public ResponseEntity<String> registerClient(@RequestBody Map<String, String> payload) {
        List<Client> clients = clientService.allClients();
        ResponseEntity<String> result = new ResponseEntity<String>("", HttpStatus.NOT_ACCEPTABLE);
        Boolean found = false;
//        new ResponseEntity<Client>(clientService.createClient( payload.get("firstName"), payload.get("lastName"), payload.get("userName"), payload.get("password")), HttpStatus.CREATED);
        for (Client client : clients) {
            if (client.getUserName().equals(payload.get("userName"))) {
                found = true;
                result = new ResponseEntity<String>("User with this username already exists.", HttpStatus.NOT_ACCEPTABLE);;
                break;
            }
        }

        if(!found) {
            clientService.createClient( payload.get("firstName"), payload.get("lastName"), payload.get("userName"), payload.get("password"));

            result = new ResponseEntity<String>("User has been created!", HttpStatus.CREATED);
        }

         return result;
    }

    @PostMapping("login")
    public ResponseEntity<ClientSecure> loginClient(@RequestBody Map<String, String> payload) {
        List<Client> clients = clientService.allClients();
        ResponseEntity<ClientSecure> result = new ResponseEntity<ClientSecure>(new ClientSecure("", "Not found"), HttpStatus.NOT_FOUND);
        Boolean found = false;
        for (Client client : clients) {
            if (client.getUserName().equals(payload.get("userName")) && client.getPassword().equals(payload.get("password"))) {
                result = new ResponseEntity<ClientSecure>(new ClientSecure(client.getId(), client.getFirstName()), HttpStatus.OK);
                found = true;
                break;
            }
        }


        return result;
    }


}