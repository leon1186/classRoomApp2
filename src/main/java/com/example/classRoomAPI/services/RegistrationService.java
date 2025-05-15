package com.example.classRoomAPI.services;

import com.example.classRoomAPI.helper.APImessages;
import com.example.classRoomAPI.models.Professor;
import com.example.classRoomAPI.models.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.classRoomAPI.repository.IRegistrationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    IRegistrationRepository  repository;

    //metodo para guardar

    public Registration saveRegistration(Registration registrationData) throws Exception{
        try {
            return this.repository.save(registrationData);

        }catch (Exception error){
            throw  new Exception();
        }

    }

    //metodo para buscar todos

    public List<Registration> registrationListList() throws Exception {
        try {
            return this.repository.findAll();

        } catch (Exception error) {
            throw new Exception();
        }
    }

    //metodo para buscarUnoPorID
    //siempre que hay busquedas por uno se utiliza el Optional


    public Registration searchRegistrationById(Integer id) throws Exception {
        try {
            Optional<Registration> registrationToSearchFor = this.repository.findById(id);
            if (registrationToSearchFor.isPresent()) {
                return registrationToSearchFor.get();
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
    public Registration modifyRegistration(Integer id, Registration newDataRegistration) throws Exception {
        try {
            Optional<Registration> registrationSearchToEdit = this.repository.findById(id);
            if (registrationSearchToEdit.isPresent()) {
                // I MODIFY THE PROFFESOR
                //aqui estoy abriendo toda la bosla con el get
                // uso el set para camnbiar y no puede ser el id
                registrationSearchToEdit.get().setDOR(newDataRegistration.getDOR());

                //HOW I KEEP THE NEW MODIFY INFO
                return this.repository.save(registrationSearchToEdit.get());


            } else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


    // id llegaria a ser un parametro de busqueda

    //METODO PARA ELIMINAR
    public Boolean deleteRegistration(Integer id) throws Exception {
        try {

            Optional<Registration> registrationToSearch = this.repository.findById(id);
            if (registrationToSearch.isPresent()) {
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
