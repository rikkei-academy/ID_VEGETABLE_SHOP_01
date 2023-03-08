package ra.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "OrDers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrDers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId")
    private int orDerId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String  lastName;
    @Column(name = "Total")
    private float total;
    @Column(name = "Status")
    private boolean status =true;
    @Column(name = "Country",nullable = false)
    private String country;
    @Column(name = "Adress",nullable = false)
    private String adress;
    @Column(name = "City",nullable = false)
    private String city;
    @Column(name = "PostCode")
    private int postCode;

    @OneToMany(mappedBy = "orDers",cascade = CascadeType.ALL)
    private List<OrDerDetail> orDerDetailList=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "UserId")
    private Users users;


}
