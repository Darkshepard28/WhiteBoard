package com.WhiteBoard.WhiteBoard.bootstrap;


import com.WhiteBoard.WhiteBoard.model.Institution;
import com.WhiteBoard.WhiteBoard.model.Staff;
import com.WhiteBoard.WhiteBoard.model.Student;
import com.WhiteBoard.WhiteBoard.repositories.InstitutionRepository;
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
    private InstitutionRepository institutionRepository;


    public DevBootstrap(StaffRepository staffRepository, StudentRepository studentRepository, InstitutionRepository institutionRepository) {
        this.staffRepository = staffRepository;
        this.studentRepository = studentRepository;
        this.institutionRepository = institutionRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();

    }




    private void initData(){

        //Teacher
        Institution institution = new Institution();
        institution.setName("WKU");
        institutionRepository.save(institution);
        
        Staff professor = new Staff("Doc","Professor", institution );
        Student student = new Student("Big", "Kid", institution);
        professor.getStudents().add(student);
        student.getTeachers().add(professor);

        staffRepository.save(professor);
        studentRepository.save(student);


    }
}

