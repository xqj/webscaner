package hayaa.ai.jauntProvider;

import com.jaunt.Element;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;

import java.util.List;

public class JauntServiceProvider {
    public String getPageHtml(String url){
        String result=null;
        try{
            UserAgent userAgent = new UserAgent();
            userAgent.visit(url);
           result=userAgent.doc.innerHTML();
        }
        catch(JauntException e){
            System.err.println(e);
        }
        return  result;
    }
    public List<Element> getPageTree(String url){
        List<Element> result=null;
        try{
            UserAgent userAgent = new UserAgent();
            userAgent.visit(url);
            result=userAgent.doc.getChildElements();
        }
        catch(JauntException e){
            System.err.println(e);
        }
        return  result;
    }
}
