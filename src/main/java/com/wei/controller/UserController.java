package com.wei.controller;

import com.wei.bo.User;
import com.wei.dao.UserDao;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.ldap.PagedResultsControl;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private Configuration configuration;
    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public String index(HttpServletRequest request)  {

       return "add";
    }



    @RequestMapping("/add")
    @Transactional
    public String getTem(User user, Model model, HttpServletRequest request) throws IOException, TemplateException {
        userDao.insert(user);
        Template template = configuration.getTemplate("index.ftl");
        HashMap<String, Object> map = new HashMap<>();
        map.put("context", request.getContextPath());
        map.put("user", user);
        String str = user.getId() + ".html";
        String fileName = this.getClass().getResource("/").getPath() + "/static/page/" ;
        String decode = URLDecoder.decode(fileName);
        File file = new File(fileName);
        if (!file.exists()) {
            file.mkdir();
        }
        Writer fileWriter = new FileWriter(decode+str);
        template.process(map,fileWriter );
        fileWriter.close();
        List<User> users = userDao.selectByExample(null);
        model.addAttribute("users", users);
        model.addAttribute("context", request.getContextPath());
        return "selectPage";
    }

}
