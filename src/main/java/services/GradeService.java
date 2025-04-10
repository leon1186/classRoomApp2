package services;

import com.example.classRoomAPI.models.Grade;
import com.example.classRoomAPI.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IGradeRepository;
import repository.IUserRepository;

@Service
public class GradeService {
    @Autowired
    IGradeRepository repository;

    //metodo para guardar

    public Grade saveGrade(Grade gradeData) throws Exception{
        try {
            return this.repository.save(gradeData);

        }catch (Exception error){
            throw  new Exception();
        }

    }
}
