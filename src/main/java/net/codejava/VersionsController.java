package net.codejava;

import net.codejava.levels.Levels;
import net.codejava.levels.LevelsService;
import net.codejava.subjects.Subjects;
import net.codejava.subjects.SubjectsService;
import net.codejava.versions.Versions;
import net.codejava.versions.VersionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VersionsController {


    @Autowired
    private SubjectsService subjectsService; //предмет

    @Autowired
    private LevelsService levelsService; //уровень

    @Autowired
    private VersionsService versionsService; //вариант обучения

    @RequestMapping("/sub/select/{idSubject}/level/select/{idLevel}")
    public ModelAndView viewVersionsPage(@PathVariable(name = "idSubject") int idSubject, @PathVariable(name = "idLevel") int idLevel ) { //вывод таблицы
        ModelAndView mav = new ModelAndView("versions");
        List<Versions> listVersions = versionsService.listAll();

        Subjects subject =subjectsService.get(idSubject); //знали предмет
        Levels level =levelsService.get(idLevel); // узнали уровень

        mav.addObject("listVersions", listVersions);

        mav.addObject("nameSubject",subject.getName());
        mav.addObject("idSubject",subject.getId());
        mav.addObject("idLevel",level.getId()); //

        return mav;
    }
}
