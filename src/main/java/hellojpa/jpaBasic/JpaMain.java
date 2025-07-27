package hellojpa.jpaBasic;

import hellojpa.jpaShop.domain.Member;
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
            Team team = new Team();
            team.setName("team1");
            em.persist(team);

            BasicMember member = new BasicMember();
            member.setName("yeeun");
            member.changeTeam(team); //team 기준으로 넣어도됨.

            em.persist(member);

            em.flush();
            em.close();

            BasicMember findMember = em.find(BasicMember.class,member.getId());
            List<BasicMember> members = findMember.getTeam().getMembers();

            for(BasicMember m : members){
                System.out.println(m.getName());
            }
            tx.commit(); //DB에 sql 전송
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
