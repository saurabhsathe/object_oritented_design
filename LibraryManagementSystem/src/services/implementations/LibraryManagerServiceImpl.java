package services.implementations;

import entities.Book;
import entities.Library;
import entities.Member;
import services.LibraryManager;

public class LibraryManagerServiceImpl implements LibraryManager {
    Library library;

    public LibraryManagerServiceImpl(Library library) {
        this.library = library;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public void addBook(Book book) {
        library.addBook(book);
    }

    @Override
    public Boolean removeBook(Book book) {
        return library.removeBook(book);
    }

    @Override
    public void addMember(Member member) {
        library.addMember(member);
        }

    @Override
    public Boolean removeMember(Member member) {
        return null;
    }

    @Override
    public Boolean isMember(Member member) {
        return library.isMember(member);
    }

    @Override
    public Boolean updateQuantity(Book book, int quantity) {
        return library.updateQuantity(book,quantity);
    }


}
