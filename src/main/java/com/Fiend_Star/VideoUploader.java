package com.Fiend_Star;

import com.google.api.client.http.InputStreamContent;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoSnippet;
import com.google.api.services.youtube.model.VideoStatus;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.GeneralSecurityException;

public class VideoUploader {
    public static void uploadVideo(VideoInformation videoInfo) {
        try {
            YouTube youtubeService = YouTubeServiceBuilder.buildYouTubeService();

            Video video = new Video();
            VideoSnippet snippet = new VideoSnippet();
            snippet.setCategoryId(videoInfo.getCategory());
            snippet.setDescription(videoInfo.getDescription());
            snippet.setTitle(videoInfo.getTitle());
            snippet.setTags(videoInfo.getTags());
            video.setSnippet(snippet);

            VideoStatus status = new VideoStatus();
            status.setPrivacyStatus(videoInfo.getPrivacyStatus());
            status.setMadeForKids(false);
            status.setSelfDeclaredMadeForKids(false);
            video.setStatus(status);

            File mediaFile = new File(videoInfo.getFilePath());
            InputStreamContent mediaContent = new InputStreamContent("application/octet-stream",
                    new BufferedInputStream(Files.newInputStream(mediaFile.toPath())));
            mediaContent.setLength(mediaFile.length());

            YouTube.Videos.Insert request = youtubeService.videos()
                    .insert("snippet,status", video, mediaContent);
            Video response = request.execute();
            System.out.println("Uploaded Video ID: " + response.getId());
        } catch (GeneralSecurityException e) {
            System.out.println("Security exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception: " + e.getMessage());
        }
    }

}
