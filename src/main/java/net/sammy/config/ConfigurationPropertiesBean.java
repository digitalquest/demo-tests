package net.sammy.config;

import net.sammy.service.GitlabService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigurationPropertiesBean {
    private final GitlabConfigurationProperties gitlabConfigurationProperties;

    public ConfigurationPropertiesBean(GitlabConfigurationProperties gitlabConfigurationProperties) {
        this.gitlabConfigurationProperties = gitlabConfigurationProperties;
    }

    @Bean
    RestTemplate restTemplate() {
        return new  RestTemplate();
    }

    @Bean
    GitlabService gitlabService() {
        return new GitlabService(restTemplate(),
                gitlabConfigurationProperties.getGitlabToken(), gitlabConfigurationProperties.getGitlabUrl());
    }
}
