package net.sammy.controller;

import net.sammy.model.GitlabGroup;
import net.sammy.service.GitlabService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitlabController {
    private final GitlabService gitlabService;

    public GitlabController(GitlabService gitlabService) {
        this.gitlabService = gitlabService;
    }

    @GetMapping("/groups")
    List<GitlabGroup> findAllGroups() {
       return gitlabService.findAllGroups();
    }
}
