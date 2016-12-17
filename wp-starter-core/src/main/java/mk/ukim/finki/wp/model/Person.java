package mk.ukim.finki.wp.model;

import javax.persistence.MappedSuperclass;

/**
 * Created by ristes on 12/16/16.
 */
@MappedSuperclass
public class Person extends BaseEntity {

  public String firstName;

  public String lastName;

  public String email;
}
