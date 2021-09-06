package academy.digitallab.store.serviceproduct.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name= "tbl_products")
@Data @AllArgsConstructor @NoArgsConstructor @Builder //Bilder = Permite hacer nuevas instancias de la entidad
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "nombre") ~~ Por si el nombre de un atributo no coincide con el del campo
    @NotEmpty(message = "El nombre no debe ser vacio")
    private String name;
    private String description;
    @Positive(message = "El stock debe ser mayor que cero")
    private double stock;
    private double price;
    private String status;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)// Formato para date
    private Date createAt;

    @ManyToOne(fetch = FetchType.LAZY)//crear relacion LAZY = carga las categorias cuando se necesite, EAGER las carga todas.
    @JoinColumn(name = "category_id")//Mapear columna en la tabla categoria
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @NotNull(message = "La categria no debe ser vacia")
    private Category category;


}
