import mk.ukim.finki.wp.exceptions.UnexistingUpdateException;
import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.persistence.GroupCrudRepository;
import mk.ukim.finki.wp.service.GroupService;
import mk.ukim.finki.wp.service.impl.InMemoryGroupService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by ristes on 12/16/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:group-service-config.xml")
public class GroupServiceTest {


  @Autowired
  public GroupService groupService;

  public GroupService serviceWithMockRepository;

  Group testGroup;
  GroupCrudRepository mockRepo;

  @Before
  public void init() {
    testGroup = new Group();
    testGroup.name = "Test";
    testGroup = groupService.insert(testGroup);
    mockRepo = Mockito.mock(GroupCrudRepository.class);
    Mockito.when(mockRepo.findById(-1l)).thenReturn(null);
    Group groupWithSize100 = new Group();
    groupWithSize100.groupSize = 100;
    Mockito.when(mockRepo.findById(1l)).thenReturn(groupWithSize100);
    serviceWithMockRepository = new InMemoryGroupService(mockRepo);
  }

  @After
  public void finish() {
//    groupService.deleteById(testGroup.id);
  }

  @Test
  public void integrationTestExistingUpdate() {
    testExistingUpdateWithService(groupService);
  }

  @Test(expected = UnexistingUpdateException.class)
  public void integrationTestUnexistingUpdate() {
    groupService.update(-1l, null);
  }


  @Test(expected = UnexistingUpdateException.class)
  public void unitTestMockedExistingUpdate() {
    testExistingUpdateWithService(serviceWithMockRepository);
  }

  @Test(expected = UnexistingUpdateException.class)
  public void unitTestMockedUnexistingUpdate() {
    serviceWithMockRepository.update(-1l, null);
  }


  private void testExistingUpdateWithService(GroupService groupService) {
    Group groupForUpdate = new Group();
    groupForUpdate.id = testGroup.id;
    groupForUpdate.name = testGroup.name;
    groupForUpdate.groupSize = 100;

    groupService.update(testGroup.id, groupForUpdate);

    Group inserted = groupService.findById(testGroup.id);

    Assert.assertNotNull("No group with id", inserted);

    Assert.assertEquals(
      "Invalid group size",
      100,
      (Object) inserted.groupSize
    );
  }

}
