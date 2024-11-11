package com.larosa.librarysystem.controller;
import com.larosa.librarysystem.entity.Logbook;
import com.larosa.librarysystem.repository.LogBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "Library")
@AllArgsConstructor
public class LogbookController {
    private final LogBookRepository logBookRepository;


    @PostMapping(value = "logbook")
    public String newLogbook(Logbook logbook, Model model) {

        logBookRepository.save(logbook);
        model.addAttribute("logbook", new Logbook());
        model.addAttribute("logAdded", true);
        return "Library/logbook";
    }

    @GetMapping(value = "logbook")
    public String getLogbook(Model model) {
        Logbook logbook = new Logbook();
        model.addAttribute("logbook", logbook);
        return "Library/logbook";
    }


}

