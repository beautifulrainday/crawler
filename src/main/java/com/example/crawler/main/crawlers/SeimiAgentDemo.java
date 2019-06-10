package com.example.crawler.main.crawlers;

import cn.wanghaomiao.seimi.annotation.Crawler;
import cn.wanghaomiao.seimi.def.BaseSeimiCrawler;
import cn.wanghaomiao.seimi.struct.Request;
import cn.wanghaomiao.seimi.struct.Response;
import cn.wanghaomiao.xpath.model.JXDocument;
import org.apache.commons.lang3.StringUtils;

@Crawler(name = "seimiagent")
public class SeimiAgentDemo extends BaseSeimiCrawler {

    @Override
    public String[] startUrls() {
        return new String[]{"https://www.souyidai.com"};
    }

    @Override
    public String seimiAgentHost() {
        return "39.108.58.234";
    }

    @Override
    public int seimiAgentPort() {
        return 999;
    }

    @Override
    public void start(Response response) {
        Request seimiAgentReq = Request.build("https://krcom.cn/6212569431/episodes/2358773:4311384947948754", "getTotalTransactions")
                .useSeimiAgent()
                // 告诉SeimiAgent针对这个请求是否使用cookie，如果没有设置使用当前Crawler关于cookie使用条件作为默认值。
                //.setSeimiAgentUseCookie(true)
                // 设置全部load完成后给SeimiAgent多少时间用于执行js并渲染页面，单位为毫秒
                .setSeimiAgentRenderTime(2000);
        push(seimiAgentReq);
    }

    /**
     * 获取搜易贷首页总成交额
     *
     * @param response
     */
    public void getTotalTransactions(Response response) {
        JXDocument doc = response.document();
        try {
            String trans = StringUtils.join(doc.sel("//div[@class='homepage-amount']/div[@class='number font-arial']/div/span/text()"), "");
            logger.info("Final Res:{}", trans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}