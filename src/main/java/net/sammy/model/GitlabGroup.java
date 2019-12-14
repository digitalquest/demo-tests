package net.sammy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitlabGroup {
    private Long id;
    private String name;
    private String path;
    @JsonProperty("description")
    private String desc;
}
