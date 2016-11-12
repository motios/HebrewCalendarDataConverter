package hebcalgroupid.controllers;


import hebcalgroupid.connectors.RestConnector;
import hebcalgroupid.model.DayModel;
import hebcalgroupid.model.MonthModel;
import hebcalgroupid.model.YearModel;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import java.io.IOException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by We on 11.11.2016.
 */
public final class DataController {

    private  RestConnector restConnector;
    private List<YearModel> years;

    private static final int MAX_MONTH_NUM=12;
    private static final int FIRST_MONTH_NUM=1;
    public DataController() {  init();  }

    private void init(){
        restConnector = new RestConnector();
        years =new ArrayList<>();
    }


    public  void getDates(int startYear, int endYear) throws IOException {
        years.clear();
        List<DayModel> days = new ArrayList<>();
        for(int year=startYear; year < endYear; year++) {
            YearModel yearModel = new YearModel(year);
            for (int month=FIRST_MONTH_NUM; month<MAX_MONTH_NUM+1; month++) {
                MonthModel monthModel = new MonthModel();
                yearModel.addMonthModel(restConnector.connect(year, month));;
            }
            years.add(yearModel);
            yearModel.getMonths().forEach(month->{
                month.getDays().forEach(day->{
                    if(day.isYomtov()){
                        days.add(day);
                    }
                });
            });

            System.out.println(LocalDateTime.now()+ "  new year: "+yearModel.getYear());
        }
        String k ="";
    }
}
