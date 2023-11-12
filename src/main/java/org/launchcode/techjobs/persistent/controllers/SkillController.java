package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//modeled EmployerController - modified routing and methods to use data for skills
@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired

    // Add private field of SkillRepository type called skillRepository
    private SkillRepository skillRepository;

    //Add index method at /skills
    @GetMapping("/")
    public String index(Model model) {
        //pass skills to the "view" using model.addAttribute to display list of all employers using findAll()
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }
    //modeled EmployerController
    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        // changed routing to /skills/add
        return "skills/add";
    }
    //modeled EmployerController
    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                      Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "skills/add";
        }
        // add a method to save a valid employer object using the newSkill object
        skillRepository.save(newSkill);
        return "redirect:";
    }
    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {
        Optional<Skill> optSkills = skillRepository.findById(skillId);
        if (optSkills.isPresent()) {
            Skill skills = optSkills.get();
            model.addAttribute("skill", skills);
            return "skills/view";
        } else {
            return "redirect:../";
        }

    }
}
