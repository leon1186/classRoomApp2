package com.example.classRoomAPI.controlers;


import com.example.classRoomAPI.models.Professor;
import com.example.classRoomAPI.models.Student;
import com.example.classRoomAPI.services.ProfessorService;
import com.example.classRoomAPI.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Students")//aqui estamos llamando al endpoints/ all lower cases.
public class StudentController {



    @Autowired
    StudentService serviceStudent;// todos los metodos son publicos --pero los datos y atributos son lo que quiero proteger.
    //? simbolo representa que se le puede poner cual quiercosa y cualquier y respuesta


    //SAVE

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student dataSentByClient){
        try{

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.serviceStudent.saveStudent (dataSentByClient));//como es estatico no necesito llamar al objeto.

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }


    }// pido los datos al body sonde estan los datos tienen que cumplir con el modelo de datos.



}
