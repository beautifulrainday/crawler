package com.example.crawler.main.crawlers;

import cn.wanghaomiao.seimi.annotation.Crawler;
import cn.wanghaomiao.seimi.def.BaseSeimiCrawler;
import cn.wanghaomiao.seimi.struct.Request;
import cn.wanghaomiao.seimi.struct.Response;
import org.springframework.beans.factory.annotation.Value;

@Crawler(name = "seimiAgentTest")
public class SeimiAgentTest extends BaseSeimiCrawler {

    @Value("${seimiAgentHost}")
    private String seimiAgentHost;

    @Value("${seimiAgentPort}")
    private String seimiAgentPort;

    private final String url = "https://krcom.cn/6212569431/episodes/2358773:4311384947948754";

    @Override
    public String[] startUrls() {
        return new String[]{url};
    }

    @Override
    public void start(Response response) {
        Request seimiAgentReq = Request.build(url, "getHtml")
                .useSeimiAgent()
//                告诉SeimiAgent针对这个请求是否使用cookie，如果没有设置使用当前Crawler关于cookie使用条件作为默认值。
//                .setSeimiAgentUseCookie(true)
                //设置全部load完成后给SeimiAgent多少时间用于执行js并渲染页面，单位为毫秒
                .setSeimiAgentRenderTime(10000);
        push(seimiAgentReq);
    }

    @Override
    public int seimiAgentPort() {
        return Integer.parseInt(this.seimiAgentPort);
    }

    @Override
    public String seimiAgentHost() {
        return this.seimiAgentHost;
    }

    /**
     * 打印网页信息
     *
     * @param response
     */
    public void getHtml(Response response) {
        try {
            System.out.println(response.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
