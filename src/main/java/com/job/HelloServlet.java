package com.job;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloServlet extends HttpServlet {

    static class HelloResponseDTO {
        private String id;
        private List<String> people;

        public HelloResponseDTO() {
        }

        public HelloResponseDTO(String id, List<String> people) {
            this.id = id;
            this.people = people;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getPeople() {
            return people;
        }

        public void setPeople(List<String> people) {
            this.people = people;
        }
    }

    static int calledCount = 0;

    {
        calledCount++;
        System.out.println("called count " + calledCount);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String requestBody = readRequestBody(req);
        Gson gson = new Gson();
        doGet(req, resp);
    }

    String readRequestBody(HttpServletRequest request) throws IOException {

        BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);


        HelloResponseDTO responseDTO = new HelloResponseDTO();
        responseDTO.setId("123");

        List<String> list = new ArrayList<>();
        list.add("Jackie");
        list.add("Amanda");
        responseDTO.setPeople(list);
//        Gson gson = new Gson();

        System.out.println("xxxx");

//        response.getWriter().print(gson.toJson(responseDTO));
        response.getWriter().print(responseDTO);


//        response.getWriter().println("<h1>Hello Servlet</h1>");
//        response.getWriter().println("session=" + request.getSession(true).getId());
    }
}
