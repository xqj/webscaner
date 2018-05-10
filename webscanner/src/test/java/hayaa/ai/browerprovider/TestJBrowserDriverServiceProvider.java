package hayaa.ai.browerprovider;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestJBrowserDriverServiceProvider {
    JBrowserDriverServiceProvider jBrowserDriverServiceProvider=new JBrowserDriverServiceProvider();
    @Test
    public void getPageHtml() {
        String html = jBrowserDriverServiceProvider.getPageHtml("http://dev.r.xieqj.cn");
        System.out.println(html);
    }
    @Test
    public void getPageTree() {
        List<WebElement> html = jBrowserDriverServiceProvider.getPageTree("http://dev.r.xieqj.cn");
        System.out.println(html.get(0).getText());
    }
}
