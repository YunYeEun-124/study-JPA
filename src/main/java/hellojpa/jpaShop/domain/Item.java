package hellojpa.jpaShop.domain;

import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

}
