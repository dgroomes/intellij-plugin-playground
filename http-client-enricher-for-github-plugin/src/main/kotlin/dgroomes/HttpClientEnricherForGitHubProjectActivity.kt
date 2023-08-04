package dgroomes

import com.intellij.httpClient.http.request.run.HttpRequestGlobalContext
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

class HttpClientEnricherForGitHubProjectActivity : ProjectActivity {

    /**
     * When a project is opened, initialize the global HTTP context with a "page size preference" value.
     *
     * Note: adding work to the project startup time is not great because it adds to the startup time for all projects,
     * which is especially wasteful for projects that don't even have '.http' files. I'm not sure the other options yet,
     * but consider learning more.
     */
    override suspend fun execute(project: Project) {
        val instance = HttpRequestGlobalContext.getInstance(project)
        instance.global["page_size_preference"] = "2"
    }
}
