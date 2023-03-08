package com.codeup.deramussweedenvillegascapstone.Controllers;

import com.codeup.deramussweedenvillegascapstone.repositories.NoteRepository;
import com.codeup.deramussweedenvillegascapstone.repositories.PropertyRepository;
import com.codeup.deramussweedenvillegascapstone.repositories.UserRepository;
import org.springframework.stereotype.Controller;

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

    //    @GetMapping("/notes/search")
//    public String showAllProps(@RequestParam String query, Model model) {
//        model.addAttribute("props", noteDao.searchAllByTitleOrBodyOrPropertyZipContaining(query));
//        return "props/index";
//    }


}
