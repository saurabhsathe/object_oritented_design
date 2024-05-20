package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    HashMap<String,Integer> inventory;
    ArrayList<Member> members;


    public Library(HashMap<String, Integer> inventory, ArrayList<Member> members) {
        this.inventory = inventory;
        this.members = members;
    }

    public HashMap<String, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(HashMap<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void addBook(Book b1) {
        inventory.put(b1.getIsbn(), inventory.getOrDefault(b1.getIsbn(), 0) + 1);
    }
    public Boolean removeBook(Book b1) {
        if(inventory.containsKey(b1.getIsbn())){
            inventory.remove(b1.getIsbn());
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


    public Boolean addMember(Member member){
        if(members.contains(member)){
            return Boolean.FALSE;
        }
        members.add(member);
        return Boolean.TRUE;
    }
    public Boolean isMember(Member member){
        return members.contains(member);

    }

    public Boolean updateQuantity(Book book,int quantity){

        if( inventory.getOrDefault(book.getIsbn(),0)<0){
            return Boolean.FALSE;
        }

        inventory.put(book.getIsbn(),inventory.get(book.getIsbn())+quantity);
        return Boolean.TRUE;
    }


}
