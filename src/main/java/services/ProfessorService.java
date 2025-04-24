package services;

import com.example.classRoomAPI.helper.APImessages;
import com.example.classRoomAPI.models.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    IProfessorRepository repository;

    // metodo para guardar ....
    public Professor saveProfessor(Professor professorData) throws Exception {
        try {
            return this.repository.save(professorData);

        } catch (Exception error) {
            throw new Exception();

        }
    }


    //metodo para buscar todos

    public List<Professor> professorList() throws Exception {
        try {
            return this.repository.findAll();

        } catch (Exception error) {
            throw new Exception();
        }
    }

    //metodo para buscarUnoPorID
    //siempre que hay busquedas por uno se utiliza el Optional


    public Professor searchProfessorById(Integer id) throws Exception {
        try {
            Optional<Professor> professorToSearchFor = this.repository.findById(id);
            if (professorToSearchFor.isPresent()) {
                return professorToSearchFor.get();
            } else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());// AQUI LLAMAMOS AL ENUM
            }

            //PROGRAMACION FUNCIONAL CON JAVA. VER LA FORMA DE HACERLO COMO OPERADOR TERNARIO
            //PULIR EN SPRINGBOOT

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

//   try {
//        return this.repository.findById(id)
//                .orElseThrow(() -> new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage()));
//    } catch (Exception error) {
//        throw new Exception(error.getMessage());
//    }

    //metodo para modificar
    public Professor modifyProfessor(Integer id, Professor newDataProfessor) throws Exception {
        try {
            Optional<Professor> professorSearchToEdit = this.repository.findById(id);
            if (professorSearchToEdit.isPresent()) {
                // I MODIFY THE PROFFESOR
                //aqui estoy abriendo toda la bosla con el get
                // uso el set para camnbiar y no puede ser el id
                professorSearchToEdit.get().setSpeciality(newDataProfessor.getSpeciality());

                //HOW I KEEP THE NEW MODIFY INFO
                return this.repository.save(professorSearchToEdit.get());


            } else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


    // id llegaria a ser un parametro de busqueda

    //METODO PARA ELIMINAR
    public Boolean deleteProfessor(Integer id) throws Exception {
        try {

            Optional<Professor> professorToSearch = this.repository.findById(id);
            if (professorToSearch.isPresent()) {
                //LO ELIMINO
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());
            }




        } catch (Exception error) {
            throw new Exception();

        }

    }
}




    //

