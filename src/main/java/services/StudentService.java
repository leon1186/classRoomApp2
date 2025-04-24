package services;

import com.example.classRoomAPI.helper.APImessages;
import com.example.classRoomAPI.models.Attendance;
import com.example.classRoomAPI.models.Grade;
import com.example.classRoomAPI.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IStudentRepository;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepository repository;

    //metodo para guardar

        public Student saveStudent(Student studentData) throws Exception {
            try {
                return this.repository.save(studentData);

            } catch (Exception error) {
                throw new Exception();
            }
        }

        public List<Student> studentList() throws Exception{
            try{
                return this.repository.findAll();

            }catch (Exception error){
                throw new Exception();

            }
        }


    public Student searchStudentById(Integer id) throws Exception {
        try {
            Optional<Student> studentToSearchFor = this.repository.findById(id);
            if (studentToSearchFor.isPresent()) {
                return studentToSearchFor.get();
            } else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());// AQUI LLAMAMOS AL ENUM
            }

            //PROGRAMACION FUNCIONAL CON JAVA. VER LA FORMA DE HACERLO COMO OPERADOR TERNARIO
            //PULIR EN SPRINGBOOT

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    public Student modifyStudent(Integer id, Student newDataStudent) throws Exception {
        try {
            Optional<Student> studentSearchToEdit = this.repository.findById(id);
            if (studentSearchToEdit.isPresent()) {
                // I MODIFY THE PROFFESOR
                //aqui estoy abriendo toda la bosla con el get
                // uso el set para camnbiar y no puede ser el id
                studentSearchToEdit.get().setDOB(newDataStudent.getDOB());// EN ESTE CASO ESTAMOS TRABAJANDO CON EL DATE OF ATTENDANCE.ELEGIR EL DATO CORRESPONDIENTE  E

                //HOW I KEEP THE NEW MODIFY INFO
                return this.repository.save(studentSearchToEdit.get());


            } else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //METODO PARA ELIMINAR
    public Boolean deleteStudent(Integer id) throws Exception {
        try {

            Optional<Student> studentToSearch = this.repository.findById(id);
            if (studentToSearch.isPresent()) {
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


