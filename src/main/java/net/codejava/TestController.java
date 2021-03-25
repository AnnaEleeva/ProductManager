package net.codejava;

import net.codejava.levels.Levels;
import net.codejava.subjects.Subjects;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TestController {

    ArrayList<String> ru1 =new ArrayList<>(Arrays.asList("один", "два", "три"));
    ArrayList<String> en1 =new ArrayList<>(Arrays.asList("one", "two", "three"));

    @RequestMapping("/sub/select/{idSubject}/level/select/{idLevel}/ver/select/{idVersion}")
    public ModelAndView viewTestPage(@PathVariable(name = "idSubject") int idSubject, @PathVariable(name = "idLevel") int idLevel, @PathVariable(name = "idVersion") int idVersion ) { //вывод таблицы
        ModelAndView mav = new ModelAndView("test");

       // mav.addObject("listLevels", listLevels);
       // mav.addObject("nameSubject",subject.getName());
        mav.addObject("ruList",ru1);
        mav.addObject("deList",en1);

        return mav;
    }
}
