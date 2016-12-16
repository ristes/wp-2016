package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.exceptions.UnexistingUpdateException;
import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by ristes on 12/2/16.
 */
@Service
public class InMemoryGroupService implements GroupService {

  static final Logger logger = LoggerFactory.getLogger(GroupService.class);


  private Map<Long, Group> idToGroup = new HashMap<Long, Group>();

  private long idSequence = 1;

  public Group insert(Group group) {
    logger.debug("insert {}", group);

    group.id = idSequence;
    idToGroup.put(idSequence, group);
    idSequence++;
    return null;
  }

  public void update(Long id, Group group) {
    logger.debug("update for id[{}]: {}", id, group);
    if (idToGroup.containsKey(id)) {
      idToGroup.put(id, group);
    } else {
      throw new UnexistingUpdateException();
    }
  }

  public List<Group> findAll() {
    logger.debug("find All");
    return new ArrayList<Group>(idToGroup.values());
  }

  public Group findById(Long id) {
    logger.debug("find by id: {}", id);
    return idToGroup.get(id);
  }

  public void deleteById(Long id) {
    logger.debug("delete by id: {}", id);
    if(idToGroup.containsKey(id)) {
      idToGroup.remove(id);
    } else {
      throw new UnexistingUpdateException();
    }
  }
}
