package hellojpa.jpaBasic;

import jakarta.persistence.*;

@Entity
public class BasicMember {

    @Id
    private Long id;
    private String name;
//    private Integer age;
//
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date LastModifiedDate;
//    @Lob
//    private String description;

    public BasicMember(){}

    public BasicMember(Long id, String name){
        this.id = id;
        this.name = name;

    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Date getLastModifiedDate() {
//        return LastModifiedDate;
//    }
//
//    public void setLastModifiedDate(Date lastModifiedDate) {
//        LastModifiedDate = lastModifiedDate;
//    }
//
//    public RoleType getRoleType() {
//        return roleType;
//    }
//
//    public void setRoleType(RoleType roleType) {
//        this.roleType = roleType;
//    }
}
