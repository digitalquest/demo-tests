package net.sammy.config;

import org.springframework.context.annotation.Configuration;

@Configuration("gitlab")
public class GitlabConfigurationProperties {
    private String gitlabUrl;
    private String gitlabToken;

    public String getGitlabUrl() {
        return gitlabUrl;
    }

    public void setGitlabUrl(String gitlabUrl) {
        this.gitlabUrl = gitlabUrl;
    }

    public String getGitlabToken() {
        return gitlabToken;
    }

    public void setGitlabToken(String gitlabToken) {
        this.gitlabToken = gitlabToken;
    }
}
