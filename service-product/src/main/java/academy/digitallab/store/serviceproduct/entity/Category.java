package academy.digitallab.store.serviceproduct.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_categories") //Si el nombre de la clase es distinta a la de la base de datos
@Data @AllArgsConstructor @NoArgsConstructor @Builder//genera getters and setters, etc
public class Category {
    @Id //Definir llave primaria
    @GeneratedValue (strategy = GenerationType.IDENTITY)//Volver autoincremental
    private Long id;
    private String name;


}
