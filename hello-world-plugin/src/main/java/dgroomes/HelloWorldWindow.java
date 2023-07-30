package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * The "binding class" for our plugin's custom Intellij "tool window".
 * <p>
 * Note: You might be wondering, "how does this class interface with the GUI framework (i.e. Swing)"? After all, this class
 * doesn't extend from another class, it has no annotations and it doesn't have initialization code that references any
 * framework-like objects. So, unfortunately this source code file does not lend much "discoverability" to a reader that
 * is unfamiliar with Swing or the Intellij GUI stuff (like me!). After inspecting the build output and finding a brief
 * note in the official Intellij docs (https://www.jetbrains.com/help/idea/gui-designer-output-options.html) I've figured
 * out that this class will be instrumented with special Java bytecode to tie itself to the GUI framework. Specifically,
 * the build will output a version of this class in `build/classes/java/main-instrumented/` that is instrumented with
 * calls to a setup method `$$$setupUI$$$` to actually initialize the Swing fields (e.g. the fields of type JPanel,
 * JLabel, etc.) and other stuff. You can see the definition of `$$$setupUI$$$` yourself by using `javap` to show the
 * bytecode but strangely Intellij's built-in Java decompiler (FernFlower) will not show the `$$$setupUI$$$` method. This
 * had me spinning in circles for a long time because I was looking elsewhere for "how does this class tie-in to the framework"
 * but it was under my nose the whole time.
 */
public class HelloWorldWindow {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldWindow.class);

    private String messageString = "Hello World!";
    private JLabel messageLabel;
    private JPanel root;

    public HelloWorldWindow() {
        root.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                log.info("The plugin window was clicked!");
                messageString += "!";
                HelloWorldWindow.this.messageLabel.setText(messageString);
                super.mouseClicked(e);
            }
        });
        this.messageLabel.setText(messageString);
    }


    public JPanel getRootElement() {
        return root;
    }
}
