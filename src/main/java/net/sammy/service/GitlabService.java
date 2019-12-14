package net.sammy.service;

import net.sammy.model.GitlabGroup;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GitlabService {
    private final RestTemplate restTemplate;

    private final String gitlabToken;

    private final String gitlabUrl;

    private final String requestUrl;

    private final ParameterizedTypeReference<List<GitlabGroup>> listOfGitlabGroups = new ParameterizedTypeReference<List<GitlabGroup>>() {};

    public GitlabService(RestTemplate restTemplate, String gitlabToken, String gitlabUrl) {
        this.restTemplate = restTemplate;
        this.gitlabToken = gitlabToken;
        this.gitlabUrl = gitlabUrl;

        this.requestUrl = gitlabUrl + "/?token=" + gitlabToken;
    }

    public List<GitlabGroup> findAllGroups() {
        return restTemplate.exchange(requestUrl, HttpMethod.GET, null, listOfGitlabGroups).getBody();
    }
}
