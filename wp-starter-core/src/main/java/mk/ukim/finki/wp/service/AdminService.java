package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Professor;
import mk.ukim.finki.wp.model.Student;

/**
 * Created by ristes on 12/16/16.
 */
public interface AdminService {

  Student saveStudent(Student student);

  Student updateStudent(String index, String firstName, String lastName, String email);

  Professor saveProfessor(Professor professor);

  Professor updateProfessor(Long id, String firstName, String lastName, String email);
  
  

}
