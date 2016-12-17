package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.exceptions.UnexistingUpdateException;
import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.persistence.GroupCrudRepository;
import mk.ukim.finki.wp.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by ristes on 12/2/16.
 */
@Service
public class InMemoryGroupService implements GroupService {

  static final Logger logger = LoggerFactory.getLogger(GroupService.class);

  GroupCrudRepository repository;

  @Autowired
  public InMemoryGroupService(GroupCrudRepository repository) {
    this.repository = repository;
  }

  public Group insert(Group group) {
    logger.debug("insert {}", group);
    return repository.insert(group);
  }

  public void update(Long id, Group group) {
    logger.debug("update for id[{}]: {}", id, group);
    Group old = repository.findById(id);
    if (old != null) {
      repository.update(group);
    } else {
      throw new UnexistingUpdateException();
    }
  }

  public List<Group> findAll() {
    logger.debug("find All");
    return repository.findAll();
  }

  public Group findById(Long id) {
    logger.debug("find by id: {}", id);
    return repository.findById(id);
  }

  public void deleteById(Long id) {
    logger.debug("delete by id: {}", id);
    Group group = repository.findById(id);
    if (group != null) {
      repository.deleteById(id);
    } else {
      throw new UnexistingUpdateException();
    }
  }
}
