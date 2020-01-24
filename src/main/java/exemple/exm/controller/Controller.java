package exemple.exm.controller;

import exemple.exm.dao.CategorieRepository;
import exemple.exm.dao.LivreRepository;
import exemple.exm.dao.ProduitRepository;
import exemple.exm.entite.Categorie;
import exemple.exm.entite.livre;
import exemple.exm.entite.produit;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@CrossOrigin("*")
@RestController

public class Controller {
private LivreRepository livreRepository;
    private ProduitRepository produitRepository ;
    private CategorieRepository categorieRepository;
    @Autowired
    public Controller(ProduitRepository produitRepository,CategorieRepository categorieRepository,LivreRepository livreRepository   ) {
        this.produitRepository = produitRepository;
        this.categorieRepository =categorieRepository;
        this.livreRepository=livreRepository ;
    }

    @PutMapping(path = "/employ")
    public livre ajouterLivre(@RequestBody livre newProduit) {
       livre p = new livre();

        p.setName(newProduit.getName());
        p.setDescription(newProduit.getDescription());
        p.setAvailabl(newProduit.isAvailabl());
        p.setPromotion(newProduit.isPromotion());
        p.setSelected(newProduit.isSelected());
       Categorie j=categorieRepository.findById((long) 1).get();
        p.setCategory(j);

       // return this.produitRepository.save(p);

        return this.livreRepository.save(p);
    }

}
