package Thi_Cuoi_Module.model;

import java.time.LocalDate;

public class AuthenticPhone extends Phone {
    private LocalDate period;
    private String scope;
    public AuthenticPhone(String id, String name, String price, String amount, String manufacturer, LocalDate period, String scope) {
        super(id, name, price, amount, manufacturer);
        this.period = period;
        this.scope = scope;
    }

    public LocalDate getPeriod() {
        return period;
    }

    public void setPeriod(LocalDate period) {
        this.period = period;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return super.toString() + " AuthenticPhone{" +
                "period=" + period +
                ", scope='" + scope + '\'' +
                '}';
    }
}
