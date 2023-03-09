package com.codeup.deramussweedenvillegascapstone.controllers;

import com.codeup.deramussweedenvillegascapstone.models.Note;
import com.codeup.deramussweedenvillegascapstone.models.Property;
import com.codeup.deramussweedenvillegascapstone.models.User;
import com.codeup.deramussweedenvillegascapstone.repositories.NoteRepository;
import com.codeup.deramussweedenvillegascapstone.repositories.PropertyRepository;
import com.codeup.deramussweedenvillegascapstone.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {

    private final UserRepository userDao;

    private final PropertyRepository propDao;

    private final NoteRepository noteDao;


    public NoteController(UserRepository userDao, PropertyRepository propDao, NoteRepository noteDao) {
        this.userDao = userDao;
        this.propDao = propDao;
        this.noteDao = noteDao;
    }

    @GetMapping("/notes")
    public String showAllNotes(Model model) {
        model.addAttribute("notes", noteDao.findAll());
        return "notes/index";
    }

    @GetMapping("/notes/create")
    public String showCreateNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "notes/create";
    }

    @PostMapping("/notes/create")
    public String createNote(@ModelAttribute Note note) {
        Property property = new Property(1);
        System.out.println("note.getBody() = " + note.getBody());
//        Property property = propDao.findPropertiesById(id);
        note.setProperty(property);
        noteDao.save(note);
        return "redirect:/current-weather";
    }


    @GetMapping("/notes/search")
    public String showAllProps(@RequestParam String query, Model model) {
        model.addAttribute("notes", noteDao.searchByNoteLike(query));
        return "notes/index";
    }


}
