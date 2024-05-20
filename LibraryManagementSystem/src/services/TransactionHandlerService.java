package services;

import entities.Book;
import entities.Member;

public interface TransactionHandlerService {

        Boolean issueBook(Book book, Member member);
        Boolean returnBook(Book book, Member member);


}
