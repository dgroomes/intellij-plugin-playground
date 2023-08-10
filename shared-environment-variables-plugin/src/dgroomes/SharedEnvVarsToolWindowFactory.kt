package dgroomes

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory

class SharedEnvVarsToolWindowFactory : ToolWindowFactory {

    private val contentFactory: ContentFactory = ContentFactory.getInstance()

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val window = SharedEnvVarsWindow()
        val content = contentFactory.createContent(window.rootElement, "", false)
        toolWindow.contentManager.addContent(content)
    }
}
