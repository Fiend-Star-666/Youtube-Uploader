package com.Fiend_Star;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        try {
            Reader in = new InputStreamReader(new FileInputStream("E:\\vinciProjects\\Done\\Code_2\\Code.csv"), StandardCharsets.UTF_8); // Replace with the path to the actual CSV file

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader("filePath", "title", "description", "category", "tags", "privacyStatus").parse(in);

            List<VideoInformation> videos = new ArrayList<>();
            for (CSVRecord record : records) {
                VideoInformation video = new VideoInformation();
                video.setFilePath(record.get("filePath"));
                video.setTitle(record.get("title"));
                video.setDescription(record.get("description"));
                video.setCategory(record.get("category"));
                video.setTags(List.of(record.get("tags").split(","))); // Assuming tags are comma-separated
                video.setPrivacyStatus(record.get("privacyStatus"));
                videos.add(video);
            }

            for (VideoInformation videoInfo : videos) {
                VideoUploader.uploadVideo(videoInfo);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }
}

