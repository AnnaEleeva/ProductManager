package net.codejava;

import net.codejava.versions.Versions;
import net.codejava.versions.VersionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class VersionsController {

    @Autowired
    private VersionsService versionsService;

    @RequestMapping("/ver/select/{id}")
    public String viewSubjectsPage(Model model) { //вывод таблицы
        List<Versions> listVersions = versionsService.listAll();
        model.addAttribute("listVersions", listVersions);

        return "versions";
    }
}
