package services.implementations;

import entities.Book;
import entities.Member;
import services.TransactionHandlerService;



public class TransactionHandlerServiceImpl implements TransactionHandlerService {

    LibraryManagerServiceImpl libraryManagerService;

    public LibraryManagerServiceImpl getLibraryManagerService() {
        return libraryManagerService;
    }

    public void setLibraryManagerService(LibraryManagerServiceImpl libraryManagerService) {
        this.libraryManagerService = libraryManagerService;
    }

    @Override
    public Boolean issueBook(Book book, Member member) {
        if(libraryManagerService.isMember(member) && libraryManagerService.updateQuantity(book,-1) ){
            return Boolean.TRUE;
        }
        return  Boolean.FALSE;
    }

    @Override
    public Boolean returnBook(Book book, Member member) {
        if(libraryManagerService.isMember(member) && libraryManagerService.updateQuantity(book,+1) ){
            return Boolean.TRUE;
        }
        return  Boolean.FALSE;
    }
}
