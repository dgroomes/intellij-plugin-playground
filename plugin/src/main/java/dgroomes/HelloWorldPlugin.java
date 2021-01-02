package dgroomes;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

/**
 * This class should be the entrypoint (or, "core") of the Intellij plugin.
 */
public class HelloWorldPlugin implements ToolWindowFactory {

    private final ContentFactory contentFactory;

    public HelloWorldPlugin() {
        contentFactory = ContentFactory.SERVICE.getInstance();
    }

    public String sayHello() {
        return "Hello world!";
    }

    /**
     * This wires the plugin code to the IDE.
     */
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        var window = new HelloWorldWindow(toolWindow);
        window.setMessage(sayHello());

        var content = contentFactory.createContent(window.getRootElement(), "", false);
        toolWindow.getContentManager().addContent(content);
    }
}
