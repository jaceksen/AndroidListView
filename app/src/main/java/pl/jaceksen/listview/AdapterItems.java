package pl.jaceksen.listview;

/**
 * Created by jsen on 05.01.18.
 */

public class AdapterItems {
    public   int ID;
    public  String JobTitle;
    public  String Description;
    //for news details
    AdapterItems(int ID, String JobTitle,String Description)
    {
        this. ID=ID;
        this. JobTitle=JobTitle;
        this. Description=Description;
    }
}
