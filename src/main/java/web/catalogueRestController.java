package web;

import exemple.exm.dao.ProduitRepository;
import exemple.exm.entite.produit;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class catalogueRestController {
    private ProduitRepository produitRepository;

    public catalogueRestController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
    @GetMapping (path="/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws IOException {

     produit p=produitRepository.findById(id).get();
       return Files.readAllBytes(Paths.get(System.getProperty("Users/home")+"/ecom/livres/"));
    }
}
