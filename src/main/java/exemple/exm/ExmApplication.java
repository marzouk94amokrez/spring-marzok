package exemple.exm;

import exemple.exm.dao.LivreRepository;
import exemple.exm.dao.ProduitRepository;
import exemple.exm.dao.CategorieRepository;
import exemple.exm.entite.Categorie;
import exemple.exm.entite.livre;
import exemple.exm.entite.produit;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Random;
@CrossOrigin("localhost:4200")
@SpringBootApplication
public class ExmApplication implements CommandLineRunner {
    @Autowired
    private LivreRepository livreRepository;
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(ExmApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Categorie.class);
        restConfiguration.exposeIdsFor(produit.class);
        categorieRepository.save(new Categorie(null, "Temp-Reel", null));
        categorieRepository.save(new Categorie(null, "Theories-des-graphs", null));
        categorieRepository.save(new Categorie(null, "Spring-Angular", null));
        categorieRepository.save(new Categorie(null, "System d'Exploitation", null));
        categorieRepository.save(new Categorie(null, "Android ", null));
        categorieRepository.save(new Categorie(null, "Mahtimatique", null));
        categorieRepository.save(new Categorie(null, "Physique", null));
        categorieRepository.save(new Categorie(null, "Histoir ", null));
        categorieRepository.save(new Categorie(null, "Musique", null));
        Random rnd = new Random();
        categorieRepository.findAll().forEach(c -> {
            for (int i=0; i< 4; i++) {
              livre p = new livre();
                p.setName(RandomString.make(13));
                p.setDescription(RandomString.make(10));
                p.setAvailabl(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setCategory(c);
                livreRepository.save(p);
            }
        });
    }
}
