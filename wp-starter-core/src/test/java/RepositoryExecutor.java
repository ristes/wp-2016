import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.persistence.GroupCrudRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ristes on 12/9/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:spring/persistence-config.xml")
public class RepositoryExecutor {

  @Autowired
  GroupCrudRepository repository;
 

  @Test
  public void showAllGroups() {
    List<Group> results = repository.findAll();

    System.out.println(results);
  }
}
