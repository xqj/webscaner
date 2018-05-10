package hayaa.ai.browerprovider;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JBrowserDriverServiceProvider {
    public String getPageHtml(String url){
        String result=null;
        JBrowserDriver driver = new JBrowserDriver(Settings.builder().
                timezone(Timezone.ASIA_SHANGHAI).build());
        driver.get(url);
        result=driver.getPageSource();
        driver.quit();
        return  result;
    }
    public List<WebElement> getPageTree(String url){
        List<WebElement> result=null;
        JBrowserDriver driver = new JBrowserDriver(Settings.builder().
                timezone(Timezone.ASIA_SHANGHAI).build());
        driver.get(url);
        result=driver.findElementsByTagName("body");
        return  result;
    }
}
