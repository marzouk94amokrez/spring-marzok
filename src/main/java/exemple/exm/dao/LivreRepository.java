package exemple.exm.dao;

import exemple.exm.entite.livre;
import exemple.exm.entite.produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface LivreRepository extends JpaRepository<livre, Long> {
    @RestResource (path = "/selectedProduts")
    public List<livre> findBySelectedIsTrue();
}
