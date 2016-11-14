package hebcalgroupid.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import hebcalgroupid.connectors.RestConnector;
import hebcalgroupid.model.MonthModel;
import hebcalgroupid.model.YearModel;
import hebcalgroupid.model.YearsModel;
import hebcalgroupid.utils.Utils;
import java.io.File;
import java.io.IOException;
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


    public  void getDates(int startYear, int endYear) throws IOException {
        for(int year=startYear; year < endYear+1; year++){
            YearModel yearModel = new YearModel(year);
            for (int month = 1; month<Utils.MONTHNUMBER+1; month++ ){
                yearModel.addMonthModel(month,restConnector.connect(year, month));
            }
            yearsModel.addYear(year,yearModel);
        }
        writeJson();
    }

    private void writeJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("GregorianHebrew.json"),yearsModel);
    }
}
