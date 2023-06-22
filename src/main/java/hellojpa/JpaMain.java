package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 조회시
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");

            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();


        // 수정시
//        Member findMember = em.find(Member.class, 1L);
//        System.out.println("findMember.id = " + findMember.getId());  // 확인 한번 해보고
//
//        findMember.setName("HelloZ");
        // em.persist(findMember); 필요하지 않음, 자바 컬렉션에서 수정할 때 처럼
    }
}
