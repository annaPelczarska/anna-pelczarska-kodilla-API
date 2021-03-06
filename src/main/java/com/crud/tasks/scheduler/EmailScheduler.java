package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.ScheduledEmailService;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";
    private static final String MAIL_CONTENT = "Currently you have: ";

    @Autowired
    private ScheduledEmailService scheduledEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;


    public String displayMessageOnTasksSize() {
        long size = 0L;
        if(taskRepository==null) {
        }
            else {
            size=taskRepository.count();
        }
        String messageOnTasksSize = (size == 1) ? MAIL_CONTENT + size + " task" : MAIL_CONTENT + size + " tasks";
        return messageOnTasksSize;
    }

    //@Scheduled(fixedDelay = 20000)
    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        scheduledEmailService.send(new Mail(adminConfig.getAdminMail(),
                SUBJECT, displayMessageOnTasksSize(), adminConfig.getAdminMail()));
    }
}
