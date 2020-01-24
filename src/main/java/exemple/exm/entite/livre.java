package exemple.exm.entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class livre implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private  String name;
    private  String description;
    private boolean promotion;
    private boolean selected;
    private boolean availabl;
    @ManyToOne
    private Categorie category ;

}
