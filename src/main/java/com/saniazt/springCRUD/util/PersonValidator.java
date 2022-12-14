package com.saniazt.springCRUD.util;

import com.saniazt.springCRUD.dao.PersonDAO;
import com.saniazt.springCRUD.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        //посмотреть есть ли человек с таким же имейлом в БД(через ДАО)
        if(personDAO.show(person.getEmail()).isPresent()){
            errors.rejectValue("email","","This email "+person.getEmail()+" is already exists");
        }
    }
}
