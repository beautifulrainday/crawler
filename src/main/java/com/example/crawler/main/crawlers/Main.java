package com.example.crawler.main.crawlers;

import okhttp3.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        /*Seimi seimi = new Seimi();
        seimi.start("seimiAgentTest");*/
        //seimi.start("seimiagent");

        OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(50000, TimeUnit.MILLISECONDS)
                .readTimeout(50000, TimeUnit.MILLISECONDS)
                .build();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        //String url = "url=https%3A%2F%2Fpassport.jd.com%2Fuc%2Flogin&renderTime=6000&script=%24(%22%23loginname%22).val(%22seimimaster%22)%3B%24(%22%23nloginpwd%22).val(%22seimi%22)%3B%24(%22.login-btn%3Ea%22).click()%3B&contentType=img&useCookie=1";
        String url = "%2F%2Ffus.cdn.krcom.cn%2F002paBJJlx07pykti8Os0104020156Fi0E010.mp4%3Flabel%3Dmp4_ld%26template%3D640x360.20.0%26Expires%3D1560162199%26ssig%3D5yVtWx3NIc%26KID%3Dunistore%2Cvideo&amp;480=%2F%2Ffus.cdn.krcom.cn%2F000vH2brlx07pykuZCzm01040201KGpB0E010.mp4%3Flabel%3Dmp4_hd%26template%3D852x480.20.0%26Expires%3D1560162199%26ssig%3DqiOPkkgz8W%26KID%3Dunistore%2Cvideo&amp;720=%2F%2Ffus.cdn.krcom.cn%2F000KNPOElx07pykErtPq010402038o0p0E020.mp4%3Flabel%3Dmp4_720p%26template%3D1280x720.20.0%26Expires%3D1560162199%26ssig%3D7pm%252FtvGko%252F%26KID%3Dunistore%2Cvideo&amp;1080=%2F%2Ffus.cdn.krcom.cn%2F0039TqXMlx07tXbJJ2Ss01041206okjV0E030.mp4%3Flabel%3Dmp4_1080p%26template%3D1920x1080.20.0%26Expires%3D1560162199%26ssig%3DkAez5N0ZF%252B%26KID%3Dunistore%2Cvideo\" action-data=\"type=krcomvideo&amp;object_id=2358773:4311384947948754&amp;fnick=Aha视频&amp;uid=6212569431&amp;cover_img=https%3A%2F%2Fwx3.sinaimg.cn%2Fcrop.0.0.1920.1080%2F006Mrj6Lly1fxnwxnyonfj31hc0u0n4l.jpg&amp;short_url=http%3A%2F%2Ft.cn%2FELCjdwC&amp;encode_mode=&amp;protocol=general&amp;bitrate=656&amp;biz_id=231414&amp;duration=308.458&amp;play_count=719420&amp;card_width=3840&amp;card_height=2160&amp;keys=4311384954288867\" next-data=\"cardSrc=https%3A%2F%2Fwx1.sinaimg.cn%2Fcrop.0.0.1920.1080%2F006Mrj6Lly1ft77rtgzmbj31hc0u0wl5.jpg&amp;cardW=3840&amp;cardH=2160&amp;fnick=Aha%E8%A7%86%E9%A2%91&amp;nextInfo=Aha%E4%B8%80%E4%B8%8B%7C%E4%BC%AA%E7%90%83%E8%BF%B7%E6%98%AF%E4%B8%96%E7%95%8C%E6%9D%AF%E4%B8%8D%E5%8F%AF%E5%88%86%E5%89%B2%E7%9A%84%E4%B8%80%E9%83%A8%E5%88%86&amp;time=3:11&amp;jumpUrl=%2F6212569431%2Fepisodes%2F2358773%3A4261013940585646";
        String r = URLDecoder.decode(url);
        //String url = "url=" + URLEncoder.encode("https://krcom.cn/6212569431/episodes/2358773:4311384947948754" + "&renderTime=60000");
        RequestBody body = RequestBody.create(mediaType, url);
        Request request = new Request.Builder()
                .url("http://39.108.58.234:999/doload")
                .post(body)
                //.addHeader("accept-charset", "UTF-8")
                //.addHeader("cache-control", "no-cache")
                //.addHeader("postman-token", "96caaa7b-3978-9a94-cd15-af884aa19bb4")
                //.addHeader("content-type", "application/x-www-form-urlencoded")
                .build();

        Response response = client.newCall(request).execute();
        String retText = response.body().string();
        System.out.println(retText);
    }

}
