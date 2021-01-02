package dgroomes;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloWorldPluginTest {

    @Test
    void sayHello() {
        HelloWorldPlugin plugin = new HelloWorldPlugin();

        assertThat(plugin.sayHello()).isEqualTo("Hello world!");
    }
}
