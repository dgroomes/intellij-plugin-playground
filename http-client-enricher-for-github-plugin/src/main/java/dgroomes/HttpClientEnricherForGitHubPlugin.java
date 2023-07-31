package dgroomes;

import com.intellij.httpClient.http.request.run.HttpRequestGlobalContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

/**
 * This class should be the entrypoint (or, "core") of the Intellij plugin.
 */
public class HttpClientEnricherForGitHubPlugin implements ToolWindowFactory {

    private final ContentFactory contentFactory;

    private volatile boolean isInitialized = false;

    public HttpClientEnricherForGitHubPlugin() {
        contentFactory = ContentFactory.getInstance();

        if (!isInitialized) {
            synchronized (this) {
                if (!isInitialized) {
                    // This is a little hacky but it works. We find *all* open projects and initialize a global
                    // variable in the HTTP context. I think it would be more natural to initialize this only when
                    // a project is opened.
                    Project[] openProjects = ProjectManager.getInstance().getOpenProjects();
                    for (Project project : openProjects) {
                        HttpRequestGlobalContext instance = HttpRequestGlobalContext.getInstance(project);
                        instance.getGlobal().set("page_size_preference", "2");
                    }
                    isInitialized = true;
                    System.out.println("HttpClientEnricherForGitHubPlugin is initialized!");
                }
            }
        }
    }

    /**
     * This wires the plugin code to the IDE.
     */
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        var window = new HttpClientEnricherForGitHubWindow();

        var content = contentFactory.createContent(window.getRootElement(), "", false);
        toolWindow.getContentManager().addContent(content);
    }
}
