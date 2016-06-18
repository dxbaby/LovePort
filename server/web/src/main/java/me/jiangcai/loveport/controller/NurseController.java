package me.jiangcai.loveport.controller;

import me.jiangcai.lib.bracket.auth.AuthenticateService;
import me.jiangcai.loveport.entity.Login;
import me.jiangcai.loveport.entity.Nurse;
import me.jiangcai.loveport.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author CJ
 */
@Controller
public class NurseController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private AuthenticateService<Login> authenticateService;

    @RequestMapping(value = "/nurse", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public String index(Model model) {
        model.addAttribute("nurses", nurseRepository.findAll());
        return "users/nurse";
    }

    @RequestMapping(value = "/nurseDelete", method = RequestMethod.GET)
    @Transactional
    public String delete(Long id) {
        nurseRepository.delete(id);
        return "redirect:/nurse";
    }


    @RequestMapping(value = "/nurse", method = RequestMethod.POST)
    @Transactional
    public String add(String username, String password) {
        Nurse nurse = new Nurse();
        nurse.setEnabled(true);
        nurse.setUsername(username);
        nurse = nurseRepository.save(nurse);
        authenticateService.changePassword(nurse, password);

        return "redirect:/nurse";
    }

}
