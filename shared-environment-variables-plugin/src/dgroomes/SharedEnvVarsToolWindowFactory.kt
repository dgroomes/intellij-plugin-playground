package dgroomes;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class SharedEnvVarsToolWindowFactory implements ToolWindowFactory {

    private final ContentFactory contentFactory;

    public SharedEnvVarsToolWindowFactory() {
        contentFactory = ContentFactory.getInstance();
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        var window = new SharedEnvVarsWindow();

        var content = contentFactory.createContent(window.getRootElement(), "", false);
        toolWindow.getContentManager().addContent(content);
    }
}
