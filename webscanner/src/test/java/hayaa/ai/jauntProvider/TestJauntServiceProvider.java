package hayaa.ai.jauntProvider;

import com.jaunt.Element;
import org.junit.Test;

import java.util.List;

public class TestJauntServiceProvider {
    private JauntServiceProvider jauntServiceProvider = new JauntServiceProvider();

    @Test
    public void getPageHtml() {
        String html = jauntServiceProvider.getPageHtml("http://www.baidu.com");
        System.out.println(html);
    }
    @Test
    public void getPageTree() {
        List<Element> html = jauntServiceProvider.getPageTree("http://www.baidu.com");
        System.out.println(html);
    }
}
