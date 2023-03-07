package com.codeup.deramussweedenvillegascapstone.Controllers;

import com.codeup.deramussweedenvillegascapstone.models.User;
import com.codeup.deramussweedenvillegascapstone.repositories.PropertyRepository;
import com.codeup.deramussweedenvillegascapstone.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PropertyController {
    private final UserRepository userDao;
    private final PropertyRepository propDao;
//    private final EmailService emailService;

    public PropController(UserRepository userDao, PropRepository propDao, EmailService emailService) {
        this.userDao = userDao;
        this.propDao = propDao;
        this.emailService = emailService;
    }

    @GetMapping("/props")
    public String showAllProps(Model model) {
        model.addAttribute("props", propDao.findAll());
        return "props/index";


    @GetMapping("/props/search")
    public String showAllProps(@RequestParam String query, Model model) {
        model.addAttribute("props", propDao.searchByTitleLike(query));
        return "props/index";
    }

    @GetMapping("/props/{id}")
    public String getOneProp(@PathVariable long id, Model model) {
        Prop prop = propDao.findAdById(id);
        model.addAttribute("prop", prop);
        return "props/show";
    }

    @GetMapping("/props/create")
    public String showPropForm(Model model) {
        model.addAttribute("prop", new Prop());
        return "props/create";
    }

    @PostMapping("/props/save")
    public String saveProp(@ModelAttribute Prop prop) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Prop origProp = propDao.findPropById(prop.getId());
        if(origProp == null || user.getId() == origProp.getUser().getId()) {
            prop.setUser(user);
            propDao.save(prop);
            emailService.preparedAndSendProp(prop);
        }
        return "redirect:/props";
    }

    @GetMapping("/props/{id}/edit")
    public String editPropForm(Model model, @PathVariable long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Prop prop = propDao.findPropById(id)
        if (user.getId() == prop.getUser().getId()) {
            model.addAttribute("prop", prop);
            return "props/create";
        } else {
            return "redirect:/props";
        }
    }

    @GetMapping("/props/{id}/delete")
    public String confirmDelete(@PathVariable long id, Model model) {
        model.addAttribute("prop", propDao.findPropById(id));
        return "props/delete";
    }

    @PostMapping("/props/{id}/delete")
    public String deleteProp(@PathVariable long id, @RequestParam(name="prop-id") long propId) {
        System.out.println(propId);
        System.out.println(id);
        if (id == propId) {
            Prop prop = propDao.findPropById(id);
            propDao.delete(prop);
        }
        return "redirect:/props";
    }

}
