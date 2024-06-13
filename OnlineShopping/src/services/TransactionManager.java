package services;

import entitites.Customer;
import entitites.ShopItem;

public interface TransactionManager {


    public boolean addItemToCart(Customer customer, ShopItem item);
    public boolean displayUserCart(Customer customer);
    public boolean checkout(Customer customer);
    public boolean emptyUserCart(Customer customer);

}
