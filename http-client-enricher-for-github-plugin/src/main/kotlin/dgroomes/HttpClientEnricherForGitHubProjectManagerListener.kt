package dgroomes

import com.intellij.httpClient.http.request.run.HttpRequestGlobalContext
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener

class HttpClientEnricherForGitHubProjectManagerListener : ProjectManagerListener {

    /**
     * When a project is opened, initialize the global HTTP context with a "page size preference" value.
     * This method is actually deprecated and marked for removal. The docs point you to use Kotlin and implement [com.intellij.openapi.startup.ProjectActivity].
     * See [this page.](https://plugins.jetbrains.com/docs/intellij/plugin-components.html#project-open).
     *
     *
     * Also, adding work to the project startup time is not great because it adds to the startup time for all projects,
     * which is especially wasteful for projects that don't even have '.http' files. I'm not sure the other options yet,
     * but consider learning more.
     */
    override fun projectOpened(project: Project) {
        val instance = HttpRequestGlobalContext.getInstance(project)
        instance.global["page_size_preference"] = "2"
    }
}
