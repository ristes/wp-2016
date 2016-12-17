package mk.ukim.finki.wp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by ristes on 12/9/16.
 */
@Entity
@Table(name = "wp_students")
public class Student extends Person {

  @Column(unique = true, name = "student_index")
  public String index;

}
