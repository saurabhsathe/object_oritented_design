package entitites;

public class Merchant {

    String name;
    String address;
    String bankAccNum;
    String merchantId;

    public Merchant(String name, String address, String bankAccNum, String merchantId) {
        this.name = name;
        this.address = address;
        this.bankAccNum = bankAccNum;
        this.merchantId = merchantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankAccNum() {
        return bankAccNum;
    }

    public void setBankAccNum(String bankAccNum) {
        this.bankAccNum = bankAccNum;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
}
