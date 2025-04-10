package services;

import com.example.classRoomAPI.models.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ICourseRepository;

@Service
public class CourseService {
    @Autowired
    ICourseRepository repository;

    //metodo para guardar

    public Course saveCourse(Course courseData) throws Exception{
        try {
            return this.repository.save(courseData);

        }catch (Exception error){
            throw  new Exception();
        }

    }
}
