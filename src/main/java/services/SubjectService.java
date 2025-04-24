package services;

import com.example.classRoomAPI.helper.APImessages;
import com.example.classRoomAPI.models.Attendance;
import com.example.classRoomAPI.models.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ISubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    ISubjectRepository repository;

    //metodo para guardar

        public Subject saveSubject(Subject subjectData) throws Exception {
            try {
                return this.repository.save(subjectData);

            } catch (Exception error) {
                throw new Exception();
            }

        }

        public List<Subject> subjectList() throws Exception{
            try{
                return this.repository.findAll();

            }catch (Exception error){
                throw new Exception();

            }
        }

    public Subject searchSubjectById(Integer id) throws Exception {
        try {
            Optional<Subject> subjectToSearchFor = this.repository.findById(id);
            if (subjectToSearchFor.isPresent()) {
                return subjectToSearchFor.get();
            } else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage()); // AQUI LLAMAMOS AL ENUM
            }

            // PROGRAMACION FUNCIONAL CON JAVA. VER LA FORMA DE HACERLO COMO OPERADOR TERNARIO
            // PULIR EN SPRINGBOOT

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Subject modifySubject(Integer id, Subject newDataSubject) throws Exception {
        try {
            Optional<Subject> subjectSearchToEdit = this.repository.findById(id);
            if (subjectSearchToEdit.isPresent()) {
                // I MODIFY THE SUBJECT
                // uso el set para cambiar y no puede ser el id
                subjectSearchToEdit.get().setName(newDataSubject.getName()); // ELEGIR EL DATO CORRESPONDIENTE

                //HOW I KEEP THE NEW MODIFY INFO
                return this.repository.save(subjectSearchToEdit.get());

            } else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // METODO PARA ELIMINAR
    public Boolean deleteSubject(Integer id) throws Exception {
        try {
            Optional<Subject> subjectToSearch = this.repository.findById(id);
            if (subjectToSearch.isPresent()) {
                // LO ELIMINO
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception();
        }
    }


}



