package hayaa.ai.browerprovider;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.List;

public class TestJsoupServiceProvider {
    private JsoupServiceProvider jsoupServiceProvider = new JsoupServiceProvider();

    @Test
    public void getPageHtml() {
        String html = jsoupServiceProvider.getPageHtml("http://dev.r.xieqj.cn");
        System.out.println(html);
    }
    @Test
    public void getPageTree() {
        List<Node> html = jsoupServiceProvider.getPageTree("http://dev.r.xieqj.cn");
        System.out.println(html);
    }
    @Test
    public void getPageElement() {
        List<Element> html = jsoupServiceProvider.getPageElement("http://dev.r.xieqj.cn");
        System.out.println(html);
    }
}
