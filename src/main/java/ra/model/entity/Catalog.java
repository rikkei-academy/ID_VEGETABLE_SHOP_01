package ra.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "catalog")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalogID")
    private int catalogID;
    @Column(name = "catalogName",unique = true,nullable = false)
    private String catalogName;
    @Column(name = "createDate")
    private Date createDate;
    @Column(name = "decription")
    private String decription;
    @Column(name = "status")
    private boolean status =true;
    @Column(name = "ParentID",nullable = false)
    private int parentID;
    @OneToMany(mappedBy = "catalog",cascade = CascadeType.ALL)
    private List<Product>productList=new ArrayList<>();

}
