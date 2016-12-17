package mk.ukim.finki.wp.persistence;

import mk.ukim.finki.wp.model.BaseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ristes on 12/16/16.
 */
@Repository
public class CrudRepository {

  @PersistenceContext
  private EntityManager em;

  public <T extends BaseEntity> T save(T entity, boolean flush) {
    if (!em.contains(entity)) {
      entity = em.merge(entity);
    } else {
      em.persist(entity);
    }
    if (flush)
      em.flush();
    return entity;
  }
}
