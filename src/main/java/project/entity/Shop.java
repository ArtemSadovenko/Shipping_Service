package project.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "shops")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "address")
    private String address;


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Document> documents;


    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
//        for (Document doc: documents) {
//            products.add(doc.getProduct());
//        }
        documents.forEach(e -> products.add(e.getProduct()));
        return products;
    }
}
