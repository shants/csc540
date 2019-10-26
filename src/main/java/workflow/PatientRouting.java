package workflow;
//import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import Utils.CommandLineUtils;
import Utils.MessageUtils;
import Utils.IScreen;
import db_files.FacilityCRUD;
import entities.MedicalFacility;

import java.net.StandardSocketOptions;
import java.util.ArrayList;

public class PatientRouting implements IScreen {
    public void run() {
        display();
        String opt = CommandLineUtils.ReadOption();
        int option = 1;
        try {
            option = Integer.parseInt(opt);
            MessageUtils.PATIENT_ROUTING o = MessageUtils.PATIENT_ROUTING.values()[option];
            switch (o) {
                case PATIENT_ROUTING_CHECKIN:
                    System.out.println(MessageUtils.PATIENT_ROUTING_CHECK_IN);
                    ArrayList<MedicalFacility> facilityList = FacilityCRUD.read();
                    for (int i=0; i < facilityList.size(); i++){
                        System.out.println(facilityList.get(i).getName() + " "  +
                                facilityList.get(i).getId());
                    }
                    break;
                case PATIENT_ROUTING_CHECK_OUT:
                    System.out.println(MessageUtils.PATIENT_ROUTING_CHECK_OUT_ACK);
                    break;
                case PATIENT_ROUTING_GO_BACK:
                    System.out.println(MessageUtils.PATIENT_ROUTING_GO_BACK);
                    break;
                default:
                    System.out.println(MessageUtils.GLOBAL_UNABLE_TO_HANDLE);

            }

        } catch (NumberFormatException e) {

        }

        }
    public void display(){
        System.out.println(MessageUtils.PATIENT_ROUTING.PATIENT_ROUTING_CHECKIN.ordinal()
               + MessageUtils.GLOBAL_SPACE + MessageUtils.PATIENT_ROUTING_CHECK_IN);
        System.out.println(MessageUtils.PATIENT_ROUTING.PATIENT_ROUTING_CHECK_OUT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.PATIENT_ROUTING_CHECK_OUT_ACK);
        System.out.println(MessageUtils.PATIENT_ROUTING.PATIENT_ROUTING_GO_BACK.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.PATIENT_ROUTING_GO_BACK);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);

    }
}
