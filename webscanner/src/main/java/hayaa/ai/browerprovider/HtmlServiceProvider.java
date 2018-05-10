package hayaa.ai.browerprovider;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlServiceProvider {
    JBrowserDriver driver = new JBrowserDriver(Settings.builder().
            timezone(Timezone.ASIA_SHANGHAI).build());
    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
    private static final String regEx_head = "<head[^>]*?>[\\s\\S]*?<\\/head>"; // 定义head的正则表达式
    private static final String regEx_iframe = "<iframe[^>]*?>[\\s\\S]*?<\\/iframe>"; // 定义iframe的正则表达式
    public List<Element> getPageAllElement(String url) {
        driver.get(url);
        String html = driver.getPageSource();
        driver.quit();
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(html);
        html = m_script.replaceAll(""); // 过滤script标签
        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(html);
        html = m_style.replaceAll(""); // 过滤style标签
//        Pattern p_head = Pattern.compile(regEx_head, Pattern.CASE_INSENSITIVE);
//        Matcher m_head = p_head.matcher(html);
//        html = m_head.replaceAll(""); // 过滤head标签
        Pattern p_iframe = Pattern.compile(regEx_iframe, Pattern.CASE_INSENSITIVE);
        Matcher m_iframe = p_iframe.matcher(html);
        html = m_iframe.replaceAll(""); // 过滤iframe标签
        Document doc = Jsoup.parse(html);
        List<Element> list = doc.getAllElements();
        return list;
    }

    public List<Element> getLeafElement(String url) {
        List<Element> list = getPageAllElement(url);
        List<Element> result = new ArrayList<Element>();
        for (Element e : list) {
            if ((e.childNodes() != null)&&(e.childNodeSize()==1)) {
                result.add(e);
            }
        }
        for(int i=0;i<result.size();i++){
            if(result.get(i).tag().getName().equals("#root")){
                result.remove(i);
                i--;
                continue;
            }
        }
        return result;
    }
}
