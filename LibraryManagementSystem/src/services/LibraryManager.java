package services;

import entities.Book;
import entities.Member;

public interface LibraryManager {

    void addBook(Book book);
    Boolean removeBook(Book book);
    void addMember(Member member);
    Boolean removeMember(Member member);
    Boolean isMember(Member member);
    Boolean updateQuantity(Book book, int quantity);




}
