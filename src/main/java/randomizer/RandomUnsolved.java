package randomizer;

import java.net.http.*;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;
import org.json.*;

public class RandomUnsolved {
    static final String SESSION = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfYXV0aF91c2VyX2lkIjoiMTU2MzU0MyIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImFsbGF1dGguYWNjb3VudC5hdXRoX2JhY2tlbmRzLkF1dGhlbnRpY2F0aW9uQmFja2VuZCIsIl9hdXRoX3VzZXJfaGFzaCI6Ijg5OGExZGMzNWI3NmRkZWFlNDFjYTU0YmZlMjRjMjgyMTk1NDcyZTFjYjE4YTM3MzNjOTQzYzYxMDZkMjIyYzEiLCJzZXNzaW9uX3V1aWQiOiIwYzRhMDZjZCIsImlkIjoxNTYzNTQzLCJlbWFpbCI6InNlbmFicmFzb3VzYUBnbWFpbC5jb20iLCJ1c2VybmFtZSI6InNlbmFicmFzb3VzYSIsInVzZXJfc2x1ZyI6InNlbmFicmFzb3VzYSIsImF2YXRhciI6Imh0dHBzOi8vYXNzZXRzLmxlZXRjb2RlLmNvbS91c2Vycy9zZW5hYnJhc291c2EvYXZhdGFyXzE1NDI5OTIwNDUucG5nIiwicmVmcmVzaGVkX2F0IjoxNzUyOTM0MzkzLCJpcCI6IjIwMDE6OGEwOjcyNzg6MWUwMDo1ZjU4OjdkNmI6NDIzOjFkNyIsImlkZW50aXR5IjoiNmZmYTU3MGY1MjFlODdlNjVjNTI5ZTE1YTVhYWFjNjciLCJkZXZpY2Vfd2l0aF9pcCI6WyJjYjMxYmU1YzQwMmU0NzhhMjBjZjI5ZTJkOWU0MzZlMCIsIjIwMDE6OGEwOjcyNzg6MWUwMDo1ZjU4OjdkNmI6NDIzOjFkNyJdfQ.fSAK-QqEjcSSBJzFsDOqqG0M6MblF-Ve4HBtLGIV4gw"; // replace this

    public static void main(String[] args) throws Exception {
        String url = "https://leetcode.com/api/problems/all/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("cookie", "LEETCODE_SESSION=" + SESSION)
                .header("referer", "https://leetcode.com")
                .header("user-agent", "JavaHttpClient")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());
        JSONArray questions = json.getJSONArray("stat_status_pairs");

        List<JSONObject> unsolved = new ArrayList<>();

        for (int i = 0; i < questions.length(); i++) {
            JSONObject q = questions.getJSONObject(i);
            String status = q.optString("status", "null");
            int difficulty = q.getJSONObject("difficulty").getInt("level");
            if (status.equals("null") && difficulty == 1) {
                unsolved.add(q);
            }

        }

        if (unsolved.isEmpty()) {
            System.out.println("🎉 You’ve solved all problems!");
            return;
        }

        JSONObject randomQ = unsolved.get(new Random().nextInt(unsolved.size()));
        JSONObject stat = randomQ.getJSONObject("stat");
        String title = stat.getString("question__title");
        String slug = stat.getString("question__title_slug");
        int diff = randomQ.getJSONObject("difficulty").getInt("level");
        String difficulty = switch (diff) {
            case 1 -> "Easy";
            case 2 -> "Medium";
            case 3 -> "Hard";
            default -> "Unknown";
        };

        System.out.printf("🔀 %s [%s]\n➡️ https://leetcode.com/problems/%s/\n", title, difficulty, slug);
    }
}
