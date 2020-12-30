package dgroomes;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyIntellijPluginTest {

    @Test
    void doIt() {
        MyIntellijPlugin plugin = new MyIntellijPlugin();
        assertThat(plugin.pluginDescription()).contains("not been implemented yet");
    }
}
