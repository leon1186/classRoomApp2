package services;

import com.example.classRoomAPI.models.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IProfessorRepository;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    IProfessorRepository repository;

    // metodo para guardar ....
    public Professor saveProfessor(Professor professorData)throws Exception{
        try{
            return  this.repository.save(professorData);

        }catch (Exception error){
            throw new Exception();

        }
    }


    //metodo para buscar todos

    public List<Professor>professorList() throws Exception{
        try{
            return this.repository.findAll();

        }catch (Exception error){
            throw new Exception();
        }
    }

    //metodo para buscarUnoPorID

    //metodo para modificar

    //metodo para eliminar

    //
}
