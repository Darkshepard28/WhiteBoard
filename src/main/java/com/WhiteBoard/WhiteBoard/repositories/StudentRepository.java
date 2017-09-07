package com.WhiteBoard.WhiteBoard.repositories;

import com.WhiteBoard.WhiteBoard.model.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by bly01854 on 9/1/2017.
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
}
