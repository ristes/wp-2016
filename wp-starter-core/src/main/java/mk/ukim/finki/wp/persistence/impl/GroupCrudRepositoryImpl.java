package mk.ukim.finki.wp.persistence.impl;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.persistence.GroupCrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by ristes on 12/9/16.
 */
@Repository
public class GroupCrudRepositoryImpl implements GroupCrudRepository {

  @PersistenceContext(name = "wp")
  EntityManager entityManager;

  public List<Group> findAll() {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Group> cq = cb.createQuery(Group.class);
    Root<Group> from = cq.from(Group.class);
    Join<Object, Object> fromCourse = from.join(
      Group.FIELDS.COURSE
    );
    return entityManager.createQuery(cq).getResultList();

  }
}
