package hayaa.ai.browerprovider;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class HtmlServiceProvider {
    JBrowserDriver driver = new JBrowserDriver(Settings.builder().
            timezone(Timezone.ASIA_SHANGHAI).build());

    public List<Element> getPageAllElement(String url) {
        driver.get(url);
        String html = driver.getPageSource();
        driver.quit();
        Document doc = Jsoup.parse(html);
        List<Element> list = doc.getAllElements();
        return list;
    }

    public List<Element> getBodyElement(String url) {
        driver.get(url);
        String html = driver.getPageSource();
        driver.quit();
        Document doc = Jsoup.parse(html);
        List<Element> list = doc.getElementsByTag("body");
        return list;
    }
    public List<Element> getLeafElement(String url) {
        List<Element> list = getBodyElement(url);
        List<Element> result = new ArrayList<Element>();
        for (Element e : list) {
            if ((e.childNodes() != null)&&(e.childNodeSize()==1)) {
                result.add(e);
            }
        }
        return result;
    }
}
