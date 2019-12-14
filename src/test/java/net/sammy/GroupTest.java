package net.sammy;

import net.sammy.model.GitlabGroup;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@JsonTest
@Ignore
public class GroupTest {
    private GitlabGroup gitlabGroup;

    @Autowired
    private JacksonTester<GitlabGroup> json;

    private static String content;
    private static final String GITLAB_GROUP_FILE = "gitlab_group.json";

    @BeforeClass
    public static void setup() throws IOException {
//        content = new String(Files.readAllBytes(Paths.get(GITLAB_GROUP_FILE)));
        content.getClass().getClassLoader().getResource(GITLAB_GROUP_FILE);
        int i;
    }

    @Test
    public void testDeserializeGitlabGroup() throws IOException {
        GitlabGroup gitlabGroup = new GitlabGroup();
        gitlabGroup.setId(1L);
        gitlabGroup.setName("Foobar Group");
        gitlabGroup.setPath("foo-bar");
        gitlabGroup.setDesc("An interesting group");

        GitlabGroup parsedGroup = json.parseObject(Files.readAllBytes(Paths.get(GITLAB_GROUP_FILE)));

        assertEquals(gitlabGroup.getId(), parsedGroup.getId());
    }
}
