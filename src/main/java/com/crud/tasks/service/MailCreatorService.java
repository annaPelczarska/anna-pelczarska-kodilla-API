package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

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

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8080/v1/task");
        context.setVariable("button", "Visit website");
        context.setVariable("show_button", false);
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye_message", "Have a great day " + adminConfig.getAdminName()+ "!");
        context.setVariable("company_details","We are "+ adminConfig.getCompanyName()+". "+adminConfig.getCompanyGoal()+". "+"You can write to us anytime: "+adminConfig.getCompanyEmail());
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    String buildDailyEmail(String message) {
        List<Task> tasks = taskRepository.findAll();

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_list_message", "Following tasks could be found in the database:");
        context.setVariable("tasks_list", tasks);
        context.setVariable("show_tasks", taskRepository.count());
        context.setVariable("tasks_url", "http://localhost:8080/v1/task");
        context.setVariable("button", "Go to Application");
        context.setVariable("show_button", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye_message", "Have a great day " + adminConfig.getAdminName()+ "!");
        context.setVariable("company_details","We are "+ adminConfig.getCompanyName()+". "+adminConfig.getCompanyGoal());
        return templateEngine.process("mail/tasks-status-mail", context);
    }

}
