package mk.ukim.finki.wp.persistence.impl;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.persistence.GroupCrudRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ristes on 12/16/16.
 */
@Repository
public class InMemoryGroupRepository implements GroupCrudRepository {


  private Map<Long, Group> idToGroup = new HashMap<Long, Group>();

  private long idSequence = 1;

  public List<Group> findAll() {
    return new ArrayList<Group>(idToGroup.values());
  }

  public Group findById(Long id) {
    return idToGroup.get(id);
  }

  @Transactional
  public Group insert(Group group) {
    group.id = idSequence;
    idToGroup.put(idSequence, group);
    idSequence++;
    return group;
  }

  @Transactional
  public void update(Group group) {
    idToGroup.put(group.id, group);
  }

  @Transactional
  public void deleteById(Long id) {
    idToGroup.remove(id);
  }

  public List<Group> findByCourseName(String name) {
    return null;
  }
}
