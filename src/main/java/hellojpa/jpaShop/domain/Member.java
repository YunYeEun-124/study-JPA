package hellojpa.jpaShop.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode ;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
