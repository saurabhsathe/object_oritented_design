package services.implementations;

import entitites.Customer;
import entitites.ShopItem;
import services.TransactionManager;

public class TransactionManagerImpl implements TransactionManager {


    @Override
    public boolean addItemToCart(Customer customer, ShopItem item) {
        return false;
    }

    @Override
    public boolean displayUserCart(Customer customer) {
        return false;
    }

    @Override
    public boolean checkout(Customer customer) {
        return false;
    }

    @Override
    public boolean emptyUserCart(Customer customer) {
        return false;
    }
}
