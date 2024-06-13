package entitites;

public class Customer {

    String name;
    String email;
    String address;
    String password;
    Cart userCart;


    public Customer(String name, String email, String address, String password, Cart userCart) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.userCart = userCart;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addItem(ShopItem item){

    }


}
