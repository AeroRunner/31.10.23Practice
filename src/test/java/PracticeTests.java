import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void qaguruHWGIT() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        open("/selenide/selenide/wiki/SoftAssertions");
        String primerJUnit5 = String.join(
                "\n"+ "@ExtendWith({SoftAssertsExtension.class})\n"
                        + "class Tests {\n"
                        + "@Test\n" + "void test() {\n"
                        + "Configuration.assertionMode = SOFT;\n"
                        + "open(\"page.html\");\n"
                        +"\n"
                        + "$(\"#first\").should(visible).click();\n"
                        + "$(\"#second\").should(visible).click();\n"
                        + "}\n"
                        + "}"           );
        $$("#user-content-3-using-junit5-extend-test-class").shouldHave(texts(primerJUnit5));
    }
}