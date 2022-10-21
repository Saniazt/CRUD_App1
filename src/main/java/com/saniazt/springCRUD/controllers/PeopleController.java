package com.saniazt.springCRUD.controllers;


import com.saniazt.springCRUD.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {


    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        //Получим всех людей из DAO и передадим на отображение в views
        model.addAttribute("people",personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")//id поместится в аргументы метода
    public String show(@PathVariable("id") int id, Model model){
        //Получим одного человека по его id DAO и передадим в views
        model.addAttribute("person",personDAO.show(id));
        return "people/show";
    }
}

