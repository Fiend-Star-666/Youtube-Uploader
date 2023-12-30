package com.Fiend_Star;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class VideoInformation {
    private String filePath;
    private String title;
    private String description;
    private String category;
    private List<String> tags;
    private String privacyStatus;
}