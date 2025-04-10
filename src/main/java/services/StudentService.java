package services;

import com.example.classRoomAPI.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IStudentRepository;

import java.security.PublicKey;

@Service
public class StudentService {
    @Autowired
    IStudentRepository repository;

    //metodo para guardar

    public Student saveStudent(Student studentData) throws Exception{
        try {
            return this.repository.save(studentData);

        }catch (Exception error){
            throw  new Exception();
        }

    }

}
