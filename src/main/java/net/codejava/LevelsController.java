package net.codejava;

import net.codejava.levels.Levels;
import net.codejava.levels.LevelsService;
import net.codejava.product.Product;
import net.codejava.subjects.Subjects;
import net.codejava.subjects.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LevelsController {

    @Autowired
    private LevelsService levelsService;

    @Autowired
    private SubjectsService subjectsService;

    @RequestMapping("/sub/select/{id}")
    public ModelAndView viewLevelsPage(@PathVariable(name = "id") int id) { //вывод таблицы
        ModelAndView mav = new ModelAndView("levels");
        List<Levels> listLevels = levelsService.listAll();
        Subjects subject =subjectsService.get(id);

        mav.addObject("listLevels", listLevels);
        mav.addObject("nameSubject",subject.getName());

        return mav;
    }
}
