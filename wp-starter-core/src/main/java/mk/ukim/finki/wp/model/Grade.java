package mk.ukim.finki.wp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by ristes on 12/9/16.
 */
@Entity
@Table(name = "wp_grades")
public class Grade extends BaseEntity{

  @NotNull
  @ManyToOne
  public Student student;

  @NotNull
  @ManyToOne
  public Group group;

  @ManyToOne
  public Professor professor;

  @Column(name = "grade_value")
  public Integer gradeValue;
}
