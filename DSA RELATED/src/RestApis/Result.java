package RestApis;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

class Result {
    /*
     * Complete the 'getAverageTemperatureForUser' function below.
     *
     * URL for cut and paste:
     * https://jsonmock.hackerrank.com/api/medical_records?userId=<userId>&page=<page>
     *
     * The function is expected to return a String value.
     * The function accepts a userId argument (Integer).
     *
     * In the case of an empty array result, return value '0'
     */
    
    public static String getAverageTemperatureForUser(int userId) {
        String baseUrl = "https://jsonmock.hackerrank.com/api/medical_records?userId=";
        int page = 1;
        double totalTemps = 0;
        int totalRecords = 0;

        try {
            while (true) {
                // Construct API URL for the current page
                String urlString = baseUrl + userId + "&page=" + page;
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");

                // Read response
                Scanner scanner = new Scanner(conn.getInputStream());
                StringBuilder jsonResponse = new StringBuilder();
                while (scanner.hasNext()) {
                    jsonResponse.append(scanner.nextLine());
                }
                scanner.close();
                conn.disconnect();

                // Parse JSON response
                JSONObject response = new JSONObject(jsonResponse.toString());
                JSONArray data = response.getJSONArray("data");

                // If no data is found, return "0"
                if (data.length() == 0) {
                    return "0";
                }

                // Process each record and extract body temperature
                for (int i = 0; i < data.length(); i++) {
                    JSONObject record = data.getJSONObject(i);
                    double bodyTemperature = record.getJSONObject("vitals").getDouble("bodyTemperature");
                    totalTemps += bodyTemperature;
                    totalRecords++;
                }

                // Stop if last page is reached
                int totalPages = response.getInt("total_pages");
                if (page >= totalPages) {
                    break;
                }
                page++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "0"; // Return 0 in case of an exception (e.g., API failure)
        }

        // Compute average and round to one decimal place
        double averageTemp = totalTemps / totalRecords;
        return String.format("%.1f", averageTemp);
    }
}

//public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int userId = Integer.parseInt(bufferedReader.readLine().trim());
        String result = Result.getAverageTemperatureForUser(userId);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
//}
