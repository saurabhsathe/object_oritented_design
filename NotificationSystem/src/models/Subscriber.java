package models;

import enums.DeliveryType;

public class Subscriber {

        DeliveryType deliveryType;
        String name;
        String email="";
        String phoneNumber="";

    public Subscriber(DeliveryType deliveryType, String name, String email, String phoneNumber) {
        this.deliveryType = deliveryType;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
