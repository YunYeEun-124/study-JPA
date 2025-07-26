package hellojpa.jpaBasic;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        //로딩시점에 하나만 만들어둬야함. db당 하나씩만 사용함.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager(); //트랜잭션마다 만들어( 요청마다 사용 )
        //실제 code
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            //new , transient 상태
            BasicMember basicMember = new BasicMember();
            basicMember.setName("Yeeun");
        //    basicMember.setRoleType(RoleType.Admin);
            em.persist(basicMember);
            tx.commit(); //DB에 sql 전송
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
