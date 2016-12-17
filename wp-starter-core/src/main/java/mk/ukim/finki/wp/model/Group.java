package mk.ukim.finki.wp.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by ristes on 12/2/16.
 */
@Entity
@Table(name = "wp_groups")
public class Group extends BaseEntity {

  public static class FIELDS {
    public static String ID = "id";
    public static String NAME = "name";
    public static String GROUP_SIZE = "groupSize";
    public static String COURSE = "course";
    public static String PROFESSORS = "professor";
  }

  @NotNull
  public String name;

  @Min(value = 0)
  public Integer groupSize;

  // generates foreign key; if absent, exception will be thrown; FetchType.EAGER is default
  @ManyToOne(fetch = FetchType.EAGER)
  // sets the column name to the default value; optional annotation
  @JoinColumn(name = "course_id")
  public Course course;

  @ManyToOne
  public Professor professor;

  @Override
  public String toString() {
    return String.format("\n[%d] %s", id, name);
  }
}
