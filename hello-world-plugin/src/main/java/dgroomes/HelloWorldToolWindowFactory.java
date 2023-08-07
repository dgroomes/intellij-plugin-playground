package dgroomes;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class HelloWorldToolWindowFactory implements ToolWindowFactory {

    private final ContentFactory contentFactory;

    public HelloWorldToolWindowFactory() {
        contentFactory = ContentFactory.getInstance();
    }

    /**
     * This wires the plugin code to the IDE.
     */
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        var window = new HelloWorldWindow();

        var content = contentFactory.createContent(window.getRootElement(), "", false);
        toolWindow.getContentManager().addContent(content);
    }
}
