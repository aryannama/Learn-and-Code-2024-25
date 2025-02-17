package org.comments;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the blog name:");
        String blogName = scanner.nextLine();

        System.out.println("Enter the post range (start-end):");
        String range = scanner.nextLine();

        String[] postRange = range.split("-");
        if (postRange.length != 2) {
            System.out.println("Invalid range format! Use start-end (e.g., 1-5).");
            return;
        }

        int start, end;
        try {
            start = Integer.parseInt(postRange[0]);
            end = Integer.parseInt(postRange[1]);
            if (start < 1 || end < start) {
                System.out.println("Invalid range values! start should be >= 1 and end should be >= start.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in range!");
            return;
        }


        TumblrService tumblrService = new TumblrService();
        String blogResponse;
        try {
            blogResponse = tumblrService.getBlogData(blogName, start, end);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Map<String, String> blogInfo = tumblrService.parseBlogInfo(blogResponse);
        List<String> imageUrls = tumblrService.parseImageUrls(blogResponse, 1);

        // print blog info
        for (Map.Entry<String, String> info : blogInfo.entrySet()) {
            System.out.println(info.getKey() + ": " + info.getValue());
        }

        // print highest quality images url
        int postNumber = start;
        for (String url : imageUrls) {
            System.out.println(postNumber + ". " + url);
            postNumber++;
        }
    }
}
