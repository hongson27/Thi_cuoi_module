package Thi_Cuoi_Module.controller;

import Thi_Cuoi_Module.model.AuthenticPhone;
import Thi_Cuoi_Module.service.AuthenticPhone.AuthenticPhoneService;
import Thi_Cuoi_Module.service.AuthenticPhone.IAuthenticPhoneService;

import java.util.List;

public class AuthenticPhoneController {
    IAuthenticPhoneService iAuthenticPhoneService = new AuthenticPhoneService();

    public void getAuthenticPhoneList() {
        List<AuthenticPhone> list = iAuthenticPhoneService.findAll();
        for (AuthenticPhone phone : list) {
            if (phone!= null) {
                System.out.println(phone);
            }
        }
    }

    public void addAuthenticPhone(AuthenticPhone phone) {
        iAuthenticPhoneService.addAuthenticPhone(phone);
    }

    public void deleteAuthenticPhoneById(String id) {
        iAuthenticPhoneService.deleteAuthenticPhone(id);
    }

    public void findAuthenticPhone(String id) {
        iAuthenticPhoneService.findAuthenticPhone(id);
    }

    public int getOrinalNumber() {
        return iAuthenticPhoneService.getOrdinalNumber();
    }
}
