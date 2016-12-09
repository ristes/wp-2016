package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Group;

import java.util.List;

/**
 * Created by ristes on 12/2/16.
 */
public interface GroupService {

  Group insert(Group group);

  void update(Long id, Group group);

  List<Group> findAll();

  Group findById(Long id);

  void deleteById(Long id);
}
