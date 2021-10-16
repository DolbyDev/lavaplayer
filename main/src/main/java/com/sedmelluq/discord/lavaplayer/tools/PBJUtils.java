package com.sedmelluq.discord.lavaplayer.tools;

import java.util.ArrayList;
import java.util.List;

public class PBJUtils {

    public static String getYouTubeMusicThumbnail(JsonBrowser videoData, String videoId) {
        JsonBrowser thumbnails = videoData.get("thumbnail").get("thumbnails").index(0);
        if (!thumbnails.isNull()) return thumbnails.get("url").text().replaceFirst("=.*", "=w1000-h1000");
        return String.format("https://i.ytimg.com/vi_webp/%s/maxresdefault.webp", videoId);
    }

    public static String getYouTubeThumbnail(JsonBrowser videoData, String videoId) {
        List<JsonBrowser> thumbnails = videoData.get("thumbnail").get("thumbnails").values();
        if (!thumbnails.isEmpty()){
            String lastThumbnail = thumbnails.get(thumbnails.size() - 1).get("url").text();
            if(lastThumbnail.contains("maxresdefault"))return lastThumbnail;
            ArrayList<JsonBrowser> bestThumbnails = new ArrayList<>();
            for (JsonBrowser thumbnail : thumbnails) {
                if(thumbnail.get("url").text().contains("?sqp=")) bestThumbnails.add(thumbnail);
            }
            if(!bestThumbnails.isEmpty())return bestThumbnails.get(bestThumbnails.size() - 1).get("url").text();
            return lastThumbnail;
        }
        if(videoId.isEmpty())return "";
        return String.format("https://i.ytimg.com/vi_webp/%s/maxresdefault.webp", videoId);
    }

    public static String getSoundCloudThumbnail(JsonBrowser trackData) {
        JsonBrowser thumbnail = trackData.get("artwork_url");
        if (!thumbnail.isNull()) return soundCloudBestImage(thumbnail.text());
        JsonBrowser avatar = trackData.get("user").get("avatar_url");
        return soundCloudBestImage(avatar.text());
    }

    public static String soundCloudBestImage(String artworkUrl) {
        return artworkUrl.replace("large.jpg", "t500x500.jpg");
    }
}