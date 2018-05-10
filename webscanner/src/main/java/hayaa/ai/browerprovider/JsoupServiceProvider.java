package hayaa.ai.browerprovider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class JsoupServiceProvider {
    public String getPageHtml(String url){
        String result=null;
        try {
            Document doc = Jsoup.connect(url).get();
            result=doc.html();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  result;
    }
    public List<Node> getPageTree(String url){
        List<Node> result=null;
        try {
            Document doc = Jsoup.connect(url).get();
            result=doc.childNodes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  result;
    }
    public List<Element> getPageElement(String url){
        List<Element> result=null;
        try {
            Document doc = Jsoup.connect(url).get();
            result=doc.getAllElements();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  result;
    }
}
