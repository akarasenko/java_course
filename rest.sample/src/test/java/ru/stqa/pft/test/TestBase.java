package ru.stqa.pft.test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.SkipException;


import java.io.IOException;
import java.util.Set;

public class TestBase {

    public void skipIfNotFixed(int issueId) throws IOException {
        if (!isIssueClosed(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    private boolean isIssueClosed(int issueId) throws IOException {
        Issue issueForCheck = getIssueById(issueId);
        return issueForCheck.getStateName().equals("Closed");
    }

    private Issue getIssueById(int id) throws IOException {
        String json = getExecutor().execute(Request.Get(String.format("http://bugify.stqa.ru/api/issues/%s.json", id)))
                .returnContent().toString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issue = parsed.getAsJsonObject().get("issues");
        return ((Set<Issue>) (new Gson().fromJson(issue, new TypeToken<Set<Issue>>() {
        }.getType()))).iterator().next();
    }

    private Executor getExecutor() {
        return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
    }

    /* private Set<Issue> getIssues() throws IOException {
        String json = getExecutor().execute(Request.Get("http://bugify.stqa.ru/api/issues.json")).returnContent().toString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
    }
    */

     /*   private int createIssue(Issue issue) throws IOException {
        String json = getExecutor().execute(Request.Post("http://demo.bugify.stqa.ru/api/issues.json")
                .bodyForm(new BasicNameValuePair("subject", issue.getSubject()))
                .bodyForm(new BasicNameValuePair("description", issue.getDescription())))
                .returnContent().toString();
        JsonElement parsed = new JsonParser().parse(json);
        return parsed.getAsJsonObject().get("issue_id").getAsInt();
    }
 */
}
