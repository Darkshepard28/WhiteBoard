package com.WhiteBoard.WhiteBoard.bootstrap;


import com.WhiteBoard.WhiteBoard.model.Staff;
import com.WhiteBoard.WhiteBoard.model.Student;
import com.WhiteBoard.WhiteBoard.repositories.StaffRepository;
import com.WhiteBoard.WhiteBoard.repositories.StudentRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by bly01854 on 9/5/2017.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private StaffRepository staffRepository;
    private StudentRepository studentRepository;

    public DevBootstrap(StaffRepository staffRepository, StudentRepository studentRepository) {
        this.staffRepository = staffRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();

    }




    private void initData(){

        //Teacher
        Staff professor = new Staff("Doc","Professor" );
        Student student = new Student("Big", "Kid");
        professor.getStudents().add(student);
        student.getTeachers().add(professor);

        staffRepository.save(professor);
        studentRepository.save(student);

    }
}

