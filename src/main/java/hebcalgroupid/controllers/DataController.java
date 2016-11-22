package hebcalgroupid.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import hebcalgroupid.connectors.RestConnector;
import hebcalgroupid.model.MonthModel;
import hebcalgroupid.model.YearModel;
import hebcalgroupid.model.YearsModel;
import hebcalgroupid.utils.Utils;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by We on 11.11.2016.
 */
public final class DataController {

    private  RestConnector restConnector;
    private YearsModel yearsModel;


    public DataController() {  init();  }

    private void init(){
        restConnector = new RestConnector();
        yearsModel =new YearsModel();
    }


    public  void getDates(int startYear, int endYear) {
        for(int year=startYear; year < endYear+1; year++){
            YearModel yearModel = new YearModel(year);
            for (int month = 1; month<Utils.MONTHNUMBER+1; month++ ){
                yearModel.addMonthModel(month,restConnector.connect(year, month));
            }
            yearsModel.addYear(year,yearModel);

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            System.out.println(dateFormat.format(cal.getTime())+" add year: "+year);
        }
        writeJson();
    }

    private void writeJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("GregorianHebrew.json"),yearsModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
