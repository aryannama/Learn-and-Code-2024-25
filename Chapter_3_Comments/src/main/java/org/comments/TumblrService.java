package org.comments;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpResponse;
import java.util.*;

import org.comments.constants.Messages;
import org.comments.constants.Urls;

public class TumblrService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String getBlogData(String blogName, int start, int end) {
        String url = String.format(Urls.BASE_URL, blogName, end - start + 1, start);

        HttpResponse<String> response = APIClient.sendGetRequest(url);

        if (response.statusCode() != 200) {
            throw new RuntimeException(Messages.POSTS_NOT_FOUND);
        }

        /*
         * Tumblr API return the response with JavaScript variable assignment
         * (e.g., "var tumblr_api_read = {};").
         * We need to remove this part to get a clean JSON response.
         */
        return response.body().replace("var tumblr_api_read = ", "").replace(";$", "");
    }

    public Map<String, String> parseBlogInfo(String response) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(response);

        Map<String, String> blogInfo = new LinkedHashMap<>();
        blogInfo.put("title", jsonNode.path("tumblelog").path("title").asText());
        blogInfo.put("name", jsonNode.path("tumblelog").path("name").asText());
        blogInfo.put("description", jsonNode.path("tumblelog").path("description").asText());
        blogInfo.put("numberOfPosts", jsonNode.path("posts-total").asText());

        return blogInfo;
    }

    // parse highest quality images from post data
    public List<String> parseImageUrls(String response, int start) throws JsonProcessingException {
        List<String> imageUrls = new ArrayList<>();

        JsonNode jsonNode = objectMapper.readTree(response);
        JsonNode posts = jsonNode.get("posts");

        for (JsonNode post : posts) {
            if (post.has("photo-url-1280")) {
                imageUrls.add(post.path("photo-url-1280").asText());
            }
        }

        return imageUrls;
    }

}
