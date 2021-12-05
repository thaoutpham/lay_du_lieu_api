package com.example.synchronized_api.controller;



import com.example.synchronized_api.model.Data;
import com.example.synchronized_api.model.Datum;
import com.example.synchronized_api.service.DataService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class MyJob {
@Autowired
private DataService dataService;
    @GetMapping("/hello")
  //  @Scheduled(cron = "*/10 * * * * *")
    public void scheduleTaskUsingCronExpression() throws InterruptedException {
        Gson gson = new Gson();
        System.out.println("vao day:" + new Date());
        String maId = "ma_tinh_thanh";
        String id = "01";
        String capDonViHanhChinh = "Cấp tỉnh";
        String jsonData = optionsCall(maId, id, capDonViHanhChinh);

        JsonElement jsonElement = new JsonParser().parse(jsonData);

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String dataTmp = jsonObject.get("data").toString();

        String data = dataTmp.replace("dtm_covid_nguy_co.", "");

        Datum[] userArray = gson.fromJson(data, Datum[].class);


        String danhSachMaTinh[] = {
                "01", "02", "04", "06", "08", "10", "11", "12", "14", "15", "17", "19", "20", "22", "24", "25",
                "26", "27", "30", "31", "33", "34", "35", "36", "37", "38", "40", "42", "44", "45", "46", "48",
                "49", "51", "52", "54", "56", "58", "60", "62", "64", "66", "67", "68", "70", "72", "74", "75",
                "77", "79", "80", "82", "83", "84", "86", "87", "89", "91", "92", "93", "94", "95", "96"
        };
        System.out.println(danhSachMaTinh.length);
        Long dvhc_id = (long) 1000003;
        try {
            Optional<Data> data1 = dataService.findByMa_phuong_xa("ggg");
            System.out.println(data1.get().getCap());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Autowired
    RestTemplate restTemplate;

    private String optionsCall(String maId, String id, String capDonViHanhChinh) {
        final String url = "https://capdodichapi.yte.gov.vn/v1/load";
        final HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsIm5hbWUiOiJWUENQIn0.eyJpYXQiOjE3MjgzMDg0MjF9.bcXrKS6vhxW_zY1TH_12I_UCXQxTboLDTqkXXRHV3u0");
        requestHeaders.set("Content-Type", "application/json;charset=UTF-8");
        String json = "{\r\n" +
                "    \"query\": {\r\n" +
                "        \"filters\": [\r\n" +
                "            {\r\n" +
                "                \"and\": [\r\n" +
                "                    {\r\n" +
                "                        \"member\": \"dtm_covid_nguy_co." + maId + "\",\r\n" +
                "                        \"operator\": \"equals\",\r\n" +
                "                        \"values\": [\r\n" +
                "                            \"" + id + "\"\r\n" +
                "                        ]\r\n" +
                "                    },\r\n" +
                "                    {\r\n" +
                "                        \"member\": \"dtm_covid_nguy_co.cap\",\r\n" +
                "                        \"operator\": \"equals\",\r\n" +
                "                        \"values\": [\r\n" +
                "                            \"" + capDonViHanhChinh + "\"\r\n" +
                "                        ]\r\n" +
                "                    }\r\n" +
                "                ]\r\n" +
                "            }\r\n" +
                "        ],\r\n" +
                "        \"measures\": [\r\n" +
                "            \"dtm_covid_nguy_co.count_so_don_vi\",\r\n" +
                "            \"dtm_covid_nguy_co.max_ngay_cap_nhap\"\r\n" +
                "        ],\r\n" +
                "        \"dimensions\": [\r\n" +
                "            \"dtm_covid_nguy_co.nguy_co\",\r\n" +
                "            \"dtm_covid_nguy_co.cap\",\r\n" +
                "            \"dtm_covid_nguy_co.ngay_cap_nhap\",\r\n" +
                "            \"dtm_covid_nguy_co.ten_tinh_thanh\",\r\n" +
                "            \"dtm_covid_nguy_co.ten_quan_huyen\",\r\n" +
                "            \"dtm_covid_nguy_co.ten_phuong_xa\",\r\n" +
                "            \"dtm_covid_nguy_co.ma_tinh_thanh\",\r\n" +
                "            \"dtm_covid_nguy_co.ma_quan_huyen\",\r\n" +
                "            \"dtm_covid_nguy_co.ma_phuong_xa\"\r\n" +
                "        ]\r\n" +
                "    }\r\n" +
                "}";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<String>(json, requestHeaders);
        String answer = restTemplate.postForObject(url, entity, String.class);
        return answer;


    }

}