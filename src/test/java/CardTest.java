import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardTest {

    @BeforeMethod
    public void setupAll() {
        open("http://localhost:9999/");
    }

    SelenideElement form = $(".form");

    @Test
    public void sendingFromWithValidData() {
        form.$("[data-test-id=name] input").setValue("Иванов Олег");
        form.$("[data-test-id=phone] input").setValue("+79884555555");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }


}
