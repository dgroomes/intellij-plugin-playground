package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * The "binding class" for our plugin's custom Intellij "tool window".
 * <p>
 */
public class HttpClientEnricherForGitHubWindow {

    private static final Logger log = LoggerFactory.getLogger(HttpClientEnricherForGitHubWindow.class);

    private String messageString = "Not yet implemented!";
    private JLabel messageLabel;
    private JPanel root;

    public HttpClientEnricherForGitHubWindow() {
        root.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                log.info("The plugin window was clicked!");
                messageString += "!";
                HttpClientEnricherForGitHubWindow.this.messageLabel.setText(messageString);
                super.mouseClicked(e);
            }
        });
        this.messageLabel.setText(messageString);
    }


    public JPanel getRootElement() {
        return root;
    }
}
