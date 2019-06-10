package com.example.crawler.main;

import java.io.IOException;
import java.net.URLDecoder;

public class Test1 {

    public static void main(String[] args) throws IOException {
        String s = URLDecoder.decode("%2F%2Ffus.cdn.krcom.cn%2F004pisaelx07usPjgLLW01041202e7Qy0E010.mp4%3Flabel%3Dmp4_ld%26template%3D640x360.22.0%26Expires%3D1560168517%26ssig%3Dmzj0O7PMM%252F%26KID%3Dunistore%2Cvideo&480=%2F%2Ffus.cdn.krcom.cn%2F000c7ADslx07usPngbQI01041203yWgb0E020.mp4%3Flabel%3Dmp4_hd%26template%3D852x480.22.0%26Expires%3D1560168517%26ssig%3DSqemZ8nHLs%26KID%3Dunistore%2Cvideo&720=%2F%2Ffus.cdn.krcom.cn%2F004tUF9ylx07usPxcjy001041206XOyR0E030.mp4%3Flabel%3Dmp4_720p%26template%3D1280x720.22.0%26Expires%3D1560168517%26ssig%3D4Iw98ToQt0%26KID%3Dunistore%2Cvideo&1080=%2F%2Ffus.cdn.krcom.cn%2F002jbcqPlx07usPW8iGc0104120eSa2j0E060.mp4%3Flabel%3Dmp4_1080p%26template%3D1920x1080.22.0%26Expires%3D1560168517%26ssig%3DUYJRbPNzvh%26KID%3Dunistore%2Cvideo\\");
        System.out.println(s);
    }
}
