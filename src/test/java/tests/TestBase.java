package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void configBrowser(){
        Configuration.startMaximized = true;
    }
}
