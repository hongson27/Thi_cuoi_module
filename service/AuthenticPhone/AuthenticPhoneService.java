package Thi_Cuoi_Module.service.AuthenticPhone;

import Thi_Cuoi_Module.model.AuthenticPhone;
import Thi_Cuoi_Module.repository.AuthenticPhone.AuthenticPhoneRepository;
import Thi_Cuoi_Module.repository.AuthenticPhone.IAuthenticPhoneRepository;


import java.util.List;

public class AuthenticPhoneService implements IAuthenticPhoneService{
    IAuthenticPhoneRepository iAuthenticPhoneRepository = new AuthenticPhoneRepository();


    @Override
    public List<AuthenticPhone> findAll() {
        return iAuthenticPhoneRepository.findAll();
    }

    @Override
    public void addAuthenticPhone(AuthenticPhone authenticPhone) {
        iAuthenticPhoneRepository.addAuthenticPhone(authenticPhone);
    }

    @Override
    public void deleteAuthenticPhone(String id) {
        iAuthenticPhoneRepository.deleteAuthenticPhone(id);
    }

    @Override
    public void findAuthenticPhone(String id) {
        iAuthenticPhoneRepository.findAuthenticPhone(id);
    }

    @Override
    public int getOrdinalNumber() {
        return iAuthenticPhoneRepository.getOrdinalNumber();
    }
}
