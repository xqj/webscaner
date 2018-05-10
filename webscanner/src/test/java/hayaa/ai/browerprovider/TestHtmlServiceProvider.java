package hayaa.ai.browerprovider;

import org.jsoup.nodes.Element;
import org.junit.Test;

import java.util.List;

public class TestHtmlServiceProvider {
    private HtmlServiceProvider provider=new HtmlServiceProvider();
    @Test
    public void getPageElement(){
        List<Element> list=provider.getPageAllElement("http://dev.r.xieqj.cn");
        System.out.println(list);
    }

    @Test
    public void getLeafElement(){
        List<Element> list=provider.getLeafElement("http://dev.r.xieqj.cn");
        System.out.println(list);
    }
}
