package com.codeup.deramussweedenvillegascapstone.controllers;

import com.codeup.deramussweedenvillegascapstone.models.Property;
import com.codeup.deramussweedenvillegascapstone.models.User;
import com.codeup.deramussweedenvillegascapstone.repositories.NoteRepository;
import com.codeup.deramussweedenvillegascapstone.repositories.PropertyRepository;
import com.codeup.deramussweedenvillegascapstone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PropertyController {
    private final UserRepository userDao;
    private final PropertyRepository propDao;
    private final NoteRepository noteDao;

    @Value("${api.filestack.key}")
    public String apiKey;

    public PropertyController(UserRepository userDao, PropertyRepository propDao, NoteRepository noteDao) {
        this.userDao = userDao;
        this.propDao = propDao;
        this.noteDao = noteDao;
    }
    //    private final EmailService emailService;



    @GetMapping("/props")
    public String showAllProps(Model model) {
        model.addAttribute("props", propDao.findAll());
        return "props/index";
    }


    @GetMapping("/props/{id}")
    public String getOneProp(@PathVariable long id, Model model) {
        Property prop = propDao.findPropertiesById(id);
        model.addAttribute("prop", prop);
        return "props/show";
    }

    @GetMapping("/props/create")
    public String showPropForm(Model model) {
        model.addAttribute("prop", new Property());
        model.addAttribute("apikey", apiKey);
        return "props/create";
    }

    @PostMapping("/props/create")
    public String saveProp(@ModelAttribute Property prop) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.getId());
        System.out.println(prop.getCity());
//        Property origProp = propDao.findPropertiesById(prop.getId());
//        if(origProp == null || user.getId() == origProp.getUser().getId()) {
            prop.setUser(user);
            propDao.save(prop);
//            emailService.preparedAndSendProp(prop);
//        }

        return "redirect:/current-weather";
    }

    @GetMapping("/props/{id}/edit")
    public String editPropForm(Model model, @PathVariable long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Property prop = propDao.findPropertiesById(id);
        if (user.getId() == prop.getUser().getId()) {
            model.addAttribute("prop", prop);
            return "props/create";
        } else {
            return "redirect:/props";
        }
    }

    @GetMapping("/props/{id}/delete")
    public String confirmDelete(@PathVariable long id, Model model) {
        model.addAttribute("prop", propDao.findPropertiesById(id));
        return "props/delete";
    }

    @PostMapping("/props/{id}/delete")
    public String deleteProp(@PathVariable long id, @RequestParam(name="prop-id") long propId) {
        System.out.println(propId);
        System.out.println(id);
        if (id == propId) {
            Property prop = propDao.findPropertiesById(id);
            propDao.delete(prop);
        }
        return "redirect:/props";
    }

}
