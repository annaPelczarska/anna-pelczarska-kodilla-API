package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailCreatorService {

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    AdminConfig adminConfig;

    @Autowired
    private TaskRepository taskRepository;


    public String buildTrelloCardEmail(String message){
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8080/v1/task");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye_message", "Have a great day " + adminConfig.getAdminName()+ "!");
        context.setVariable("company_details","We are "+ adminConfig.getCompanyName()+". "+adminConfig.getCompanyGoal()+". "+"You can write to us anytime: "+adminConfig.getCompanyEmail());
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

}
