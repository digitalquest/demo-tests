package net.sammy;

import net.sammy.model.GitlabGroup;
import net.sammy.service.GitlabService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    @Autowired
    private GitlabService gitlabService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            LOG.info("Retrieving all groups from gitlab");
            LOG.info("---------------------------------");
            for (GitlabGroup group : gitlabService.findAllGroups()) {
                LOG.info("Group name: {}", group.getName());
                LOG.info("Group id: {}", group.getId());
            }
        };
    }
}
