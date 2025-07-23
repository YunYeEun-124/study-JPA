package hellojpa;

import jakarta.persistence.*;

import java.util.List;

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
            Member member1 = new Member(1L,"yeeun");
            Member member2 = new Member(2L,"haeun");

            Member member = em.find(Member.class,1L);
            member.setName("newYeeun");

            System.out.println(member.getName() +","+member1.getName());

            tx.commit(); //DB에 sql 전송
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
