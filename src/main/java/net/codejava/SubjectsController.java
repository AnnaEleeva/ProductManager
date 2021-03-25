package net.codejava;

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
public class SubjectsController {

    @Autowired
    private SubjectsService subjectsService;

    @RequestMapping("/sub")
    public String viewSubjectsPage(Model model) { //вывод таблицы
        List<Subjects> listSubjects = subjectsService.listAll();
        model.addAttribute("listSubjects", listSubjects);

        return "subjects";
    }

  /*  @RequestMapping("/sub/select/{id}")
    public String showPlayProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("playView");
        Subjects subject = subjectsService.get(id);
        mav.addObject("subject", subject);
        //mav.addObject("id",id);

        return "index";
        //return "playView";
    }*/
}
