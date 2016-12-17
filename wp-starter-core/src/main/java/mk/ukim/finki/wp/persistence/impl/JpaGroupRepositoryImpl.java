package mk.ukim.finki.wp.persistence.impl;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.persistence.GroupCrudRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by ristes on 12/9/16.
 */
@Primary
@Repository
public class JpaGroupRepositoryImpl implements GroupCrudRepository {

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

  @Transactional(readOnly = true)
  public Group findById(Long id) {
    Group group = entityManager.find(Group.class, id);
    if (group != null) {
      entityManager.refresh(group);
    }
    return group;
//    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//    CriteriaQuery<Group> cq = cb.createQuery(Group.class);
//    Root<Group> from = cq.from(Group.class);
//
//    cq.where(
//      cb.equal(
//        from.get(Group.FIELDS.ID),
//        id
//      )
//    );
//    return entityManager
//      .createQuery(cq)
//      .getSingleResult();
  }

  @Transactional
  public Group insert(Group group) {
    group = entityManager.merge(group);
    entityManager.flush();
    return group;
  }

  @Transactional
  public void update(Group group) {
    entityManager.merge(group);
    entityManager.flush();
  }

  @Transactional
  public void deleteById(Long id) {
    entityManager.remove(findById(id));
  }

  public List<Group> findByCourseName(String name) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Group> cq = cb.createQuery(Group.class);
    Root<Group> from = cq.from(Group.class);
    Join<Object, Object> courseJoin = from.join(
      Group.FIELDS.COURSE
    );

    cq.where(
      cb.equal(
        courseJoin.get("name"),
        name
      )
    );
    return entityManager.createQuery(cq).getResultList();

  }
}
