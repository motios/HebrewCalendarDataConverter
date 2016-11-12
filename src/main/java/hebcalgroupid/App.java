package hebcalgroupid;

import hebcalgroupid.controllers.DataController;
import hebcalgroupid.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        DataController dataController= new DataController();
        dataController.getDates(Utils.START_YEAR, Utils.END_YEAR);
    }
}
