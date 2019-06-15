package com.example.crawler.main.crawlers;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

    public static void main(String[] args) {
        final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_60);//新建一个模拟谷歌Chrome浏览器的浏览器客户端对象

        webClient.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常, 这里选择不需要
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常, 这里选择不需要
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);//是否启用CSS, 因为不需要展现页面, 所以不需要启用
        webClient.getOptions().setJavaScriptEnabled(true); //很重要，启用JS
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX
        webClient.getOptions().setTimeout(30000);

        HtmlPage page = null;
        try {
            page = webClient.getPage("https://krcom.cn/1994516565/episodes/2358773:4380559388909077?sudaref=krcom.cn&display=0&retcode=6102");//尝试加载上面图片例子给出的网页
            //Thread.sleep(60000);
            webClient.waitForBackgroundJavaScript(6000);//异步JS执行需要耗时,所以这里线程要阻塞30秒,等待异步JS执行结束
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }

        String pageXml = page.asXml();//直接将加载完成的页面转换成xml格式的字符串

        //TODO 下面的代码就是对字符串的操作了,常规的爬虫操作,用到了比较好用的Jsoup库

        Pattern p = Pattern.compile("fluency=.*action");
        Matcher matcher = p.matcher(pageXml);
        String firstRegex = null;
        while (matcher.find()) {
            firstRegex = matcher.group();
        }

        Document document = Jsoup.parse(pageXml);//获取html文档
        String res = document.title().split(" ")[0];
        System.out.println("title:" + res);

        String afterEncode = URLDecoder.decode(firstRegex);
        Pattern pSecond = Pattern.compile("1080=//fus.cdn.krcom.cn/.*video");
        Matcher matcherSecond = pSecond.matcher(afterEncode);
        String r = null;
        while (matcherSecond.find()) {
            r = matcherSecond.group();
        }
        System.out.println(r.replace("1080=", ""));

    }
}
