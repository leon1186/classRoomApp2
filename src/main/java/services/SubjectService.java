package services;

import com.example.classRoomAPI.models.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ISubjectRepository;

@Service
public class SubjectService {
    @Autowired
    ISubjectRepository repository;

    //metodo para guardar

    public Subject saveSubject(Subject subjectData) throws Exception{
        try {
            return this.repository.save(subjectData);

        }catch (Exception error){
            throw  new Exception();
        }

    }
}
