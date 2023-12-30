# Video-Uploader-CodeGenZing

This project is a video uploader for YouTube. It uses Google's OAuth 2.0 for authentication and the YouTube Data API v3 to upload videos.

## Prerequisites

Before you begin, ensure you have met the following requirements:

* You have installed Java 17.
* You have a Windows machine. This code may work on other platforms, but it was developed and tested on Windows.
* You have a Google account with access to YouTube.
* You have created a project in the Google Cloud Console, enabled the YouTube Data API v3, and obtained OAuth 2.0 credentials (a client ID and client secret).

## Using Video-Uploader-CodeGenZing

To use Video-Uploader-CodeGenZing, follow these steps:

1. Clone this repository to your local machine.
2. Place your OAuth 2.0 credentials in a file named `client_secret.json` and put it in the `src/main/resources` directory.
3. Update the `VideoUploader` and `MainApplication` classes with your specific video details and file paths.
4. Run the `MainApplication` class to start uploading videos.
