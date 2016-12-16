package mk.ukim.finki.wp.web.rest;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.service.GroupService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ristes on 12/2/16.
 */
@RestController
@RequestMapping(value = "/api/groups", produces = "application/json")
public class GroupResource implements ApplicationContextAware {

  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    GroupService bean = applicationContext.getBean(GroupService.class);
    System.out.println(bean);
  }

  private GroupService service;

  @Autowired
  public GroupResource(GroupService service) {
    this.service = service;
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public Group insertGroup(@Valid @RequestBody Group group) {
    return service.insert(group);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void updateGroup(@PathVariable Long id, @RequestBody Group group) {
    service.update(id, group);
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<Group> getAll() {
    return service.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Group getById(@PathVariable Long id) {
    return service.findById(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteById(@PathVariable Long id) {
    service.deleteById(id);
  }
}