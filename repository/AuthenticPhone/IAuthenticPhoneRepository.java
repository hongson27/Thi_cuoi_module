package Thi_Cuoi_Module.repository.AuthenticPhone;

import Thi_Cuoi_Module.model.AuthenticPhone;

import java.util.List;

public interface IAuthenticPhoneRepository {
    List<AuthenticPhone> findAll();
    void addAuthenticPhone(AuthenticPhone authenticPhone);
    void deleteAuthenticPhone(String id);
    void findAuthenticPhone(String id);
    int getOrdinalNumber();

}
