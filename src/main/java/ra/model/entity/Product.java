package ra.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Table(name = "product")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID")
    private int productID;
    @Column(name = "productName",unique = true,nullable = false)
    private String productName;
    @Column(name = "CreateDate")
    private Date createDate;
    @Column(name = "quantity",nullable = false)
    private int quantity;
    @Column(name = "Image",nullable = false)
    private String image ;
    @Column(name = "title")
    private String title;
    @Column(name = "status")
    private boolean status=true;

    @Column(name = "DistCount")
    private int distCount;
    @Column(name = "StartDistCount")
    private Date startDistCount;
    @Column(name = "EndDistCount")
    private Date endDistCount;
    @ManyToOne
    @JoinColumn(name = "catalogID")
    private Catalog catalog;
    @ManyToOne
    @JoinColumn(name = "detaiId")
    private OrDerDetail orDerDetail;
}
