package mk.ukim.finki.wp.persistence;

import mk.ukim.finki.wp.model.Group;

import java.util.List;

/**
 * Created by ristes on 12/9/16.
 */
public interface GroupCrudRepository {

  List<Group> findAll();

  Group findById(Long id);

  Group insert(Group group);

  void update(Group group);

  void deleteById(Long id);

  List<Group> findByCourseName(String name);
}
