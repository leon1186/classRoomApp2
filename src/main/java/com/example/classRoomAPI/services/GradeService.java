package com.example.classRoomAPI.services;

import com.example.classRoomAPI.helper.APImessages;
import com.example.classRoomAPI.models.Grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.classRoomAPI.repository.IGradeRepository;


import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    @Autowired
    IGradeRepository repository;

    //metodo para guardar

    public Grade saveGrade(Grade gradeData) throws Exception {
        try {
            return this.repository.save(gradeData);

        } catch (Exception error) {
            throw new Exception();
        }

    }

    public List<Grade> gradeList() throws Exception{
        try{
            return this.repository.findAll();

        }catch (Exception error){
            throw new Exception();

        }

    }
    public Grade searchGradeById(Integer id) throws Exception {
        try {
            Optional<Grade> gradeToSearchFor = this.repository.findById(id);
            if (gradeToSearchFor.isPresent()) {
                return gradeToSearchFor.get();
            } else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());// AQUI LLAMAMOS AL ENUM
            }

            //PROGRAMACION FUNCIONAL CON JAVA. VER LA FORMA DE HACERLO COMO OPERADOR TERNARIO
            //PULIR EN SPRINGBOOT

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    public Grade modifyGrade(Integer id, Grade newDataGrade) throws Exception {
        try {
            Optional<Grade> gradeSearchToEdit = this.repository.findById(id);
            if (gradeSearchToEdit.isPresent()) {
                // I MODIFY THE PROFFESOR
                //aqui estoy abriendo toda la bosla con el get
                // uso el set para camnbiar y no puede ser el id
                gradeSearchToEdit.get().setGrade(newDataGrade.getGrade());// EN ESTE CASO ESTAMOS TRABAJANDO CON EL DATE OF ATTENDANCE.ELEGIR EL DATO CORRESPONDIENTE  E

                //HOW I KEEP THE NEW MODIFY INFO
                return this.repository.save(gradeSearchToEdit.get());


            } else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //METODO PARA ELIMINAR
    public Boolean deleteGrade(Integer id) throws Exception {
        try {

            Optional<Grade> gradeToSearch = this.repository.findById(id);
            if (gradeToSearch.isPresent()) {
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

