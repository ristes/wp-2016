package mk.ukim.finki.wp.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by ristes on 12/16/16.
 * <p>
 * CREATE VIEW `student_average` AS
 * SELECT
 * s.id,
 * s.student_index,
 * s.firstName,
 * s.lastName,
 * avg(g.grade_value)
 * FROM wp_students s
 * JOIN wp_grades g ON g.student_id = s.id
 * GROUP BY s.id, s.student_index,
 * s.firstName,
 * s.lastName;
 * </p>
 */
@Entity
@Table(name = "student_average")
@Immutable
public class StudentAverage extends Person {

  @Transient
  public String invalidField;
}
