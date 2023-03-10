package com.codeup.deramussweedenvillegascapstone.controllers;

import com.codeup.deramussweedenvillegascapstone.models.User;
import com.codeup.deramussweedenvillegascapstone.repositories.NoteRepository;
import com.codeup.deramussweedenvillegascapstone.repositories.PropertyRepository;
import com.codeup.deramussweedenvillegascapstone.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserRepository userDao;
    private final NoteRepository noteDao;
    private final PropertyRepository repoDao;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, NoteRepository noteDao, PropertyRepository repoDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.noteDao = noteDao;
        this.repoDao = repoDao;
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
    public String showProfile() {return "users/profile";}


//    the following code is for editing user's profile details and deleting their account:
    @GetMapping("/profile/edit")
    public String showEditProfileForm(Model model) {
        User user = userDao.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("user", user);
        return "users/edit-profile"; //what will the return be?
    }

    @PostMapping("/profile/edit")
    public String saveEditedProfile(@ModelAttribute User user) {
        userDao.save(user);
        return "redirect:/profile";
    }

    @PostMapping("/profile/delete")
    public String deleteProfile() {
        User user = userDao.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//        noteDao.deleteByUser(user); //I do not know if this needs to be here
//        repoDao.deleteByUser(user); //I do not know if this needs to be here
        userDao.delete(user);
        SecurityContextHolder.clearContext();
        return "redirect:/";
    }


}



