package main.workflow;

import main.db_files.CreateTables;

public class MainFlow{
    public static void main(String[] args){
        CreateTables ct = new CreateTables();
        ct.createFacilityClassification();
    }
}