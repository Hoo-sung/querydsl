package study.querydsl.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // @COMMIT을 빼면, test가 끝나고 롤백을 한다. DB에 데이터가 없어진다.
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Test
    public void testEntity() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member memeber1 = new Member("member1", 10, teamA);
        Member memeber2 = new Member("member2", 20, teamA);

        Member memeber3 = new Member("member3", 30, teamB);
        Member memeber4 = new Member("member4", 40, teamB);
        em.persist(memeber1);
        em.persist(memeber2);
        em.persist(memeber3);
        em.persist(memeber4);

        //초기화
        em.flush();
        em.clear();//플러쉬하고, 영속성 커텍스트 초기화(캐시 날라감)

        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("-> member.team" + member.getTeam());
        }

    }
}