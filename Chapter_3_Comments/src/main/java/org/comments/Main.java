package org.comments;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.comments.constants.Messages;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Messages.ENTER_BLOG_NAME);
        String blogName = scanner.nextLine();

        System.out.println(Messages.ENTER_POST_RANGE);
        String range = scanner.nextLine();

        String[] postRange = range.split("-");
        if (postRange.length != 2) {
            System.out.println(Messages.INVALID_RANGE_FORMAT);
            return;
        }

        int start, end;
        try {
            start = Integer.parseInt(postRange[0]);
            end = Integer.parseInt(postRange[1]);
            if (start < 1 || end < start) {
                System.out.println(Messages.INVALID_RANGE_VALUES);
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println(Messages.INVALID_NUMBER_FORMAT);
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
