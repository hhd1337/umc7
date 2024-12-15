package umc.study.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import umc.study.domain.common.Restaurant;


import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score) {
        StringBuilder jpql = new StringBuilder("SELECT r FROM Restaurant r WHERE 1=1");
        List<Object> parameters = new ArrayList<>();

        // 조건 추가 (이름 필터링)
        if (name != null && !name.isEmpty()) {
            jpql.append(" AND LOWER(r.name) LIKE LOWER(?1)");
            parameters.add("%" + name + "%");
        }

        // 조건 추가 (점수 필터링)
        if (score != null) {
            jpql.append(" AND r.score >= ?2");
            parameters.add(score);
        }

        TypedQuery<Restaurant> query = entityManager.createQuery(jpql.toString(), Restaurant.class);

        // 파라미터 설정
        for (int i = 0; i < parameters.size(); i++) {
            query.setParameter(i + 1, parameters.get(i));
        }

        return query.getResultList();
    }
}
