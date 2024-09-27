package Thi_Cuoi_Module.repository.AuthenticPhone;

import Thi_Cuoi_Module.common.IOAuthenticPhoneFile;
import Thi_Cuoi_Module.model.AuthenticPhone;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AuthenticPhoneRepository implements IAuthenticPhoneRepository {
    private final static List<AuthenticPhone> list;
    static {
        list = new ArrayList<>();
        AuthenticPhone authenticPhone1 = new AuthenticPhone("1", "iPhone 12", "10000000", "100", "Apple", LocalDate.parse("2025-12-12"), "International");
        AuthenticPhone authenticPhone2 = new AuthenticPhone("2", "iPhone 13", "20000000", "200", "Apple", LocalDate.parse("2025-12-12"), "International");
        list.add(authenticPhone1);
        list.add(authenticPhone2);
        for (AuthenticPhone authenticPhone : list) {
            IOAuthenticPhoneFile.writeAuthenticPhoneFile(authenticPhone);
        }
    }

    @Override
    public List<AuthenticPhone> findAll() {
        IOAuthenticPhoneFile.readFromAuthenticPhoneFile();
        return list;
    }

    @Override
    public void addAuthenticPhone(AuthenticPhone authenticPhone) {
        list.add(authenticPhone);
        IOAuthenticPhoneFile.writeAuthenticPhoneFile(authenticPhone);
    }

    @Override
    public void deleteAuthenticPhone(String id) {
        boolean found = true;
        for (AuthenticPhone phone : list) {
            if (phone.getId().equals(id)) {
                list.remove(phone);
                found = false;
                break;
            }
        }
        if (found) {
            System.out.println("Không tìm thấy điện thoại có mã " + id);
        }
        IOAuthenticPhoneFile.clearFile();
        for (AuthenticPhone phone : list) {
            IOAuthenticPhoneFile.writeAuthenticPhoneFile(phone);
        }
    }

    @Override
    public void findAuthenticPhone(String id) {
        boolean found = true;
        for (AuthenticPhone phone : list) {
            if (phone.getId().equals(id)) {
                System.out.println(phone);
                IOAuthenticPhoneFile.clearFile();
                IOAuthenticPhoneFile.writeAuthenticPhoneFile(phone);
                found = false;
                break;
            }
        }
        if (found) {
            System.out.println("Không tìm thấy điện thoại có mã " + id);
        }
    }

    @Override
    public int getOrdinalNumber() {
        return (list.size() + 1);
    }
}
