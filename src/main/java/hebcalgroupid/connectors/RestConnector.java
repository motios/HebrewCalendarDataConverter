package hebcalgroupid.connectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import hebcalgroupid.dto.MonthDto;
import hebcalgroupid.model.DayModel;
import hebcalgroupid.model.MonthModel;
import hebcalgroupid.utils.Utils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by We on 10.11.2016.
 */
public class RestConnector {


    private int dayCounter=1;

    public MonthModel connect(int year, int month) {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://www.hebcal.com/hebcal/?v=1&cfg=json&maj=on&year="+year+"&month="+month+"&d=on&D=on");
        //HttpGet request = new HttpGet("http://www.hebcal.com/hebcal/?v=1&cfg=json&maj=on&year=1975&month=4&d=on&D=on");
        try {
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                stringBuilder.append(line);
            }
            ObjectMapper objectMapper = new ObjectMapper();

            MonthDto monthDto = objectMapper.readValue(stringBuilder.toString(), MonthDto.class);
            return monthDtoToModel(monthDto);
        }catch (Exception e){
            System.out.println("connect year: "+year+", month: "+month+" error: "+ e.getMessage());
            return null;
        }

    }

    private MonthModel monthDtoToModel(MonthDto monthDto) {

        //TODO need think for getting Yomtov flag from other category
        MonthModel monthModel= new MonthModel();
        monthDto.getItems().forEach(dayDto->{

            DayModel dayModel = new DayModel();
            int day=0;
            int lastDay=0;
            boolean isYomTov=false;

            //check if nubmer of day is some number with dayCounter
            try {
                String val =dayDto.getDate();
                day = Integer.valueOf(val.substring(val.length() - 2));
                val=monthDto.getItems().get(monthDto.getItems().size()-1).getDate();
                lastDay = Integer.valueOf(val.substring(val.length() - 2));
            }catch (Exception e){
                System.out.println("monthDtoToModel. date: "+dayDto.getCategory()+", "+dayDto.getDate()+": error: "+e.getMessage());
            }
            //check if day is yomtov
            try {
                if (dayDto.getCategory().equalsIgnoreCase(Utils.CATEGORY_OF_HEBREW_VALUE_HOLIDAY)) {
                    if (dayDto.isYomtov()) {
                        monthModel.getDays().get(day).setYomtov(dayDto.isYomtov());
                    }

                }


            //get all data from hebdate category
            else if(dayDto.getCategory().equalsIgnoreCase(Utils.CATEGORY_OF_HEBREW_VALUE_HEBDATE)) {
                dayModel.setDayNumber(day);
                dayModel.setDateGregorian(dayDto.getDate());
                dayModel.setHebrewDate(formatDate(dayDto.getHebrew(),true));
                dayModel.setTitleEnglishDateHebrewCalendar(formatDate(dayDto.getTitle(),false));
                dayModel.setYomtov(dayDto.isYomtov());
                dayModel.setCategory(dayDto.getCategory());
                monthModel.addDayModel(day, dayModel);
            }
            }catch (Exception e){
                System.out.println(dayDto.getDate());
                System.out.println(e.getMessage());
            }
        });
        return monthModel;
    }

    //format date: dd/mm/yyyy. remove not needed symbols, return formated date
    private String formatDate(String date, boolean isHebrew){
        StringBuilder stringBuilder = new StringBuilder();

        if(isHebrew){
            stringBuilder.append(date.substring(0,date.indexOf(" ")));
            date=stringBuilder.append(date.substring(date.indexOf(" ")+2)).toString();
            date=date.replace('׳','/').replace(" ","/");
        }
        else {
            final String[] val = new String[1];
            final String tmpDate=date;
            List<String> values = new ArrayList<>(Arrays.asList(Utils.ENGLISH_VAL_ND, Utils.ENGLISH_VAL_RD, Utils.ENGLISH_VAL_ST, Utils.ENGLISH_VAL_TH));
            values.forEach(value->{
                if(tmpDate.contains(value)){
                    val[0]=value;
                    return;
                }
            });
            stringBuilder.append(date.substring(0,date.indexOf(val[0]))).append("/");
            stringBuilder.append(date.substring(date.indexOf("of")+3,date.indexOf(",")));
            String date2=stringBuilder.append("/").append(date.substring(date.indexOf(",")+2)).toString();
        }
        return date;
    }



}
