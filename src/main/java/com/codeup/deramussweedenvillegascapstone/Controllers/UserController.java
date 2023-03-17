package com.codeup.deramussweedenvillegascapstone.controllers;

import com.codeup.deramussweedenvillegascapstone.models.Note;
import com.codeup.deramussweedenvillegascapstone.models.Property;
import com.codeup.deramussweedenvillegascapstone.models.User;
import com.codeup.deramussweedenvillegascapstone.repositories.NoteRepository;
import com.codeup.deramussweedenvillegascapstone.repositories.PropertyRepository;
import com.codeup.deramussweedenvillegascapstone.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserRepository userDao;
    private final NoteRepository noteDao;
    private final PropertyRepository propDao;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, NoteRepository noteDao, PropertyRepository repoDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.noteDao = noteDao;
        this.propDao = repoDao;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }


    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userDetails =  userDao.findUserById(userDetails.getId());
//        userDetails.setUsername(username);
//        userDetails.setEmail(email);
//        userDetails.setPassword(hash);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Property prop = propDao.findById(user.getId());
//        Property prop = propDao.findAll();
//        model.addAttribute("props", propDao.findByUser_Id(user.getId()));
//        System.out.println("propDao.searchByPropertyLike(user.getId()) = " + propDao.searchByPropertyLike(user.getId()));
//        model.addAttribute("props", propDao.searchByPropertyLike(user.getId()));
        model.addAttribute("props", userDetails.getProperty());
        return "users/profile";}
    public String showProfile() {return "users/profile";}

//    the following code is for editing user's profile details and deleting their account:
    @GetMapping("/profile/edit")
    public String showEditProfileForm() {
        return "users/editProfile"; //this is the html name
    }

//    @PostMapping("/profile/edit")
//    public String saveEditedProfile(@RequestParam(name="name") String username, @RequestParam(name="email") String email) {
//        User user = userDao.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//        user.setUsername(username);
//        user.setEmail(email);
//        userDao.save(user);
//        return "redirect:/profile";
//    }

    @PostMapping("/profile/edit")
    public String saverEditProfile(@ModelAttribute User user, @RequestParam(name = "username") String username, @RequestParam(name = "name") String name,  @RequestParam(name = "email") String email) {
        user = userDao.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//        String hash = passwordEncoder.encode(password);
//        user.setPassword(hash);
        user.setUsername(username);
        user.setName(name);
        user.setEmail(email);
        userDao.save(user);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userDetails = (User) authentication.getPrincipal();
        userDetails.setUsername(username);
        userDetails.setName(name);
        userDetails.setEmail(email);
//        userDetails.setPassword(hash);
        return "redirect:/profile";
    }


//    not using this functionality currently?
    @PostMapping("/profile/delete")
    public String deleteProfile() {
        User user = userDao.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        userDao.delete(user);
        SecurityContextHolder.clearContext();
        return "redirect:/";
    }

    }




