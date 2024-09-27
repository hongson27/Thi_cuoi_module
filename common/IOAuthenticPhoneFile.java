package Thi_Cuoi_Module.common;

import Thi_Cuoi_Module.model.AuthenticPhone;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IOAuthenticPhoneFile {
    private static final String AUTHENTIC_PATH = "src/Thi_Cuoi_Module/data/AuthenticPhone.csv";

    public static void writeAuthenticPhoneFile(AuthenticPhone phone) {
        try {
            FileWriter writer = new FileWriter(AUTHENTIC_PATH, true);
            BufferedWriter buff = new BufferedWriter(writer);
            String data = phone.getId() + "," + phone.getName() + "," + phone.getPrice()
                    + "," + phone.getAmount() + "," + phone.getManufacturer() + "," + phone.getPeriod() + "," + phone.getScope();
            buff.write(data);
            buff.newLine();
            buff.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearFile() {
        try {
            FileWriter writer = new FileWriter(AUTHENTIC_PATH);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<AuthenticPhone> readFromAuthenticPhoneFile() {
        List<AuthenticPhone> list = new ArrayList<>();
        try {
            FileReader reader = new FileReader(AUTHENTIC_PATH);
            BufferedReader buff = new BufferedReader(reader);
            while (true) {
                String data = buff.readLine();
                if (data == null) {
                    break;
                }
                String[] arrayData = data.split(",");
                AuthenticPhone phone = new AuthenticPhone(arrayData[0], arrayData[1],arrayData[2],arrayData[3], arrayData[4], LocalDate.parse(arrayData[5]),
                        arrayData[6]);
                list.add(phone);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }
}
