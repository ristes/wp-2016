package mk.ukim.finki.wp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by ristes on 12/9/16.
 */
@Entity
@Table(name = "wp_courses")
public class Course extends BaseEntity {

  public String name;

  // mappedBy references to the field 'course' in the entity 'Group'
  @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
  @JsonIgnore
  public List<Group> groups;

}
