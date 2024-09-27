package Thi_Cuoi_Module.model;

public class HandPhone extends Phone {
    private String national;
    private String status;
    public HandPhone(String id, String name, String price, String amount, String manufacturer, String national, String status) {
        super(id, name, price, amount, manufacturer);
        this.national = national;
        this.status = status;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + " HandPhone{" +
                "national='" + national + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
