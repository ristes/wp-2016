package mk.ukim.finki.wp.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ristes on 12/9/16.
 */
@Entity
@Table(name = "wp_professors")
public class Professor extends Person {

  /**
   * Courses for which the professor is assigned. It doesn't mean that he/she
   * has active group from that course
   */
  @ManyToMany
  @JoinTable(
    name = "wp_professor_courses",
    joinColumns = @JoinColumn(name = "professor_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id")
  )
  public Collection<Course> courses;

  /**
   * The groups that he/she teaches.
   */
  @OneToMany(mappedBy = "professor")
  public Collection<Group> groups;
}
