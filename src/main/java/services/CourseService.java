package services;


import com.example.classRoomAPI.helper.APImessages;
import com.example.classRoomAPI.models.Attendance;
import com.example.classRoomAPI.models.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ICourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    ICourseRepository repository;

    //metodo para guardar

        public Course saveCourse(Course courseData) throws Exception {
            try {
                return this.repository.save(courseData);

            } catch (Exception error) {
                throw new Exception();
            }
        }

        public List<Course>courseList() throws Exception{
            try{
                return this.repository.findAll();

            }catch (Exception error){
                throw new Exception();

            }
        }
        public Course searchAttendanceById(Integer id) throws Exception {
            try {
                Optional<Course> courseToSearchFor  = this.repository.findById(id);
                if (courseToSearchFor.isPresent()) {
                    return courseToSearchFor.get();
                } else {
                    throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());// AQUI LLAMAMOS AL ENUM
                }
    
                //PROGRAMACION FUNCIONAL CON JAVA. VER LA FORMA DE HACERLO COMO OPERADOR TERNARIO
                //PULIR EN SPRINGBOOT
    
            } catch (Exception error) {
                throw new Exception(error.getMessage());
            }
        }
        public Course modifyCourse (Integer id, Course newDataCourse) throws Exception {
            try {
                Optional<Course> courseSearchToEdit = this.repository.findById(id);
                if (courseSearchToEdit.isPresent()) {
                    // I MODIFY THE PROFFESOR
                    //aqui estoy abriendo toda la bosla con el get
                    // uso el set para camnbiar y no puede ser el id
                    courseSearchToEdit.get().setName(newDataCourse.getName());// EN ESTE CASO ESTAMOS TRABAJANDO CON EL DATE OF ATTENDANCE.ELEGIR EL DATO CORRESPONDIENTE  E
    
                    //HOW I KEEP THE NEW MODIFY INFO
                    return this.repository.save(courseSearchToEdit.get());
    
    
                } else {
                    throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());
                }
            } catch (Exception error) {
                throw new Exception(error.getMessage());
            }
        }
    
        //METODO PARA ELIMINAR
        public Boolean deleteAttendance(Integer id) throws Exception {
            try {
    
                Optional<Course> courseToSearch = this.repository.findById(id);
                if (courseToSearch.isPresent()) {
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
    
