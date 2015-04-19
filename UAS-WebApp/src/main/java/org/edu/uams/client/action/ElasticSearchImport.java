/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.uams.client.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.edu.uams.server.business.StudentDao;
import org.edu.uams.server.elasticsearch.EmbeddedElasticsearchServer;
import org.edu.uams.server.pojo.StudentEntity;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.suggest.SuggestRequestBuilder;
import org.elasticsearch.action.suggest.SuggestResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;

/**
 *
 * @author SARAT
 */
public class ElasticSearchImport extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ElasticSearchImport</title>");
            out.println("</head>");
            out.println("<body>");
//            out.println("<h1>Servlet ElasticSearchImport at  " + request.getContextPath() + "</h1>");
            out.println("Elastic Search index id");
            initElastic(out);
            out.println("</body>");
            out.println("</html>");
            String path = getServletContext().getRealPath("");
//            getEmbededServer();
            System.out.println("Path " + path);

        }
    }

    private void initElastic(PrintWriter out) throws IOException {

        Client client = getEmbededServer();
//        Client client = new TransportClient()
//                .addTransportAddress(new InetSocketTransportAddress("localhost", 9300));

//       Node node = nodeBuilder().clusterName("elasticsearch").node();
//Client client = node.client();
        // deleting index
     
     /*   final CreateIndexRequestBuilder createIndexRequestBuilder = client.admin().indices().prepareCreate("university");
        createIndexRequestBuilder.addMapping("student", getMaping());
        // MAPPING DONE
        createIndexRequestBuilder.execute().actionGet();*/

        StudentDao studentDao = new StudentDao();
        StudentEntity studentEntity = studentDao.findByPrimaryKey(Long.valueOf("1"));
        XContentBuilder builder = jsonBuilder().startObject()
                //                .field("_id", studentEntity.getId())
                .field("admnNum", studentEntity.getStudentEnrollment().getEnrollmentNumber())
                .field("rollNum", studentEntity.getRollNum())
                .field("firstName", studentEntity.getFirstName())
                .field("lastName", studentEntity.getLastName())
                .field("fatherName", studentEntity.getFatherName())
                .field("motherName", studentEntity.getMotherName())
                .field("dob", studentEntity.getDob())
                .field("genderType", studentEntity.getGenderType())
                .field("seatCategoryType", studentEntity.getSeatCategoryType().name())
                .field("email", studentEntity.getEmail())
                .field("nationality", studentEntity.getNationality())
                .field("fatherOccup", studentEntity.getFatherOccup())
                .field("motherOccup", studentEntity.getMotherOccup())
                .field("parentMob", studentEntity.getParentMob())
                .field("studentMob", studentEntity.getStudentMob())
                .field("nationality", studentEntity.getNationality())
                .endObject();
        IndexResponse response = client.prepareIndex("university", "student", String.valueOf(studentEntity.getId())).setSource(builder).execute().actionGet();
        long _version = response.getVersion();
        System.out.println("Version " + _version);
        getResponseFromElasticSearch(out, client);
//         return  response.getId();
    }

    private void getResponseFromElasticSearch(PrintWriter out, Client client) {
//        GetResponse response = client.prepareGet("university", "student", "1")
//        .execute()
//        .actionGet();
//             out.println(response.getSourceAsString());

        SearchResponse searchResponse = client.prepareSearch("university").setTypes("student")
                .setQuery(QueryBuilders.queryStringQuery("sarat")).execute().actionGet();
        Iterator<SearchHit> searchiIterable = searchResponse.getHits().iterator();
        while (searchiIterable.hasNext()) {
            SearchHit nextElement = searchiIterable.next();
            System.out.println(nextElement.getSourceAsString());
        }
        out.println("max score " + searchResponse.getHits().getMaxScore());
        out.println("Total return " + searchResponse.getHits().getTotalHits());
        out.println("Time taken to " + searchResponse.getTookInMillis());
        out.println(searchResponse.toString());
        client.close();
    }

    private Client getEmbededServer() {
        String path = getServletContext().getRealPath("");
        System.out.println("Path " + path);
        EmbeddedElasticsearchServer elasticsearchServer = new EmbeddedElasticsearchServer();
        Client client = elasticsearchServer.getClient();
        return client;
    }

    private XContentBuilder getMaping() throws IOException {
        XContentBuilder builder = jsonBuilder().startObject()
                .startObject("properties")
                .startObject("admnNum")
                .field("type", "long")
                .endObject()
                .startObject("rollNum")
                .field("type", "long")
                .endObject()
                .startObject("firstName")
                .field("type", "string")
                .endObject()
                .startObject("lastName")
                .field("type", "string")
                .endObject()
                .startObject("fatherName")
                .field("type", "string")
                .endObject()
                .startObject("motherName")
                .field("type", "string")
                .endObject()
                .startObject("dob")
                .field("type", "date")
                .field("format", "dateOptionalTime")
                .endObject()
                .startObject("genderType")
                .field("type", "string")
                .endObject()
                .startObject("seatCategoryType")
                .field("type", "string")
                .endObject()
                .startObject("email")
                .field("type", "string")
                .endObject()
                .startObject("nationality")
                .field("type", "string")
                .endObject()
                .startObject("fatherOccup")
                .field("type", "string")
                .endObject()
                .startObject("motherOccup")
                .field("type", "string")
                .endObject()
                .startObject("parentMob")
                .field("type", "long")
                .endObject()
                .startObject("studentMob")
                .field("type", "long")
                .endObject()
                .startObject("nationality")
                .field("type", "string")
                .endObject()
                .startObject("suggest")
                .field("type", "completion")
                .field("index_analyzer", "simple")
                .field("search_analyzer", "simple")
                .field("payloads", "false")
                .endObject();

        return builder;
    }

    public void findSuggestionsFor(String suggestRequest,Client client) {
        CompletionSuggestionBuilder suggestionsBuilder = new CompletionSuggestionBuilder("completeMe");
        suggestionsBuilder.text(suggestRequest);
        suggestionsBuilder.field("suggest");
        SuggestRequestBuilder suggestRequestBuilder
                = client.prepareSuggest("university").addSuggestion(suggestionsBuilder);

        SuggestResponse suggestResponse = suggestRequestBuilder.execute().actionGet();

        Iterator<? extends Suggest.Suggestion.Entry.Option> iterator
                = suggestResponse.getSuggest().getSuggestion("completeMe").iterator().next().getOptions().iterator();

        List<String> items = new ArrayList<>();
        while (iterator.hasNext()) {
            Suggest.Suggestion.Entry.Option next = iterator.next();
            items.add((next.getText().string()));
    }
}
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
