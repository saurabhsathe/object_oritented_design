import models.Message;
import models.MessageStore;
import models.User;
import services.MessageService;
import services.SocialService;
import services.implementations.MessageServiceImpl;
import services.implementations.SocialServiceImpl;

public class SocialNetwork {

    public static void main(String[] args) {
        User user1 = new User("sss","sss@gmail.com","sss222");
        User user2 = new User("ggg","ggg@gmail.com","sss222");
        User user3 = new User("aaa","aaa@gmail.com","sss222");
        User user4 = new User("bbb","bbb@gmail.com","sss222");


        SocialService socialService = new SocialServiceImpl();
        MessageService msgService = new MessageServiceImpl(new MessageStore(),socialService);


        socialService.addFriend(user1,user2);
        socialService.addFriend(user1,user3);
        socialService.addFriend(user1,user4);
        socialService.addFriend(user2,user4);


        msgService.sendMessage(user1,user2,"Hello 1 to 2");
        msgService.sendMessage(user1,user3,"Hello 1 to 3");
        msgService.sendMessage(user1,user2,"Hello2 1 to 2");
        msgService.sendMessage(user1,user3,"Hello2 1 to 3");
        msgService.sendMessage(user1,user2,"Hello3 1 to 2");
        msgService.sendMessage(user1,user3,"Hello3 1 to 3");
        msgService.sendMessage(user4,user1,"Hello 4 to 1");
        msgService.sendMessage(user4,user1,"Hello2 4 to 1");

        for(Message msg:msgService.getMostRecentMessages(user1)){
            System.out.println(msg.toString());
        }
        socialService.removeFriend(user1,user2);

        System.out.println("-------------------");
        for(Message msg:msgService.getUserMessages(user1)){
            System.out.println(msg.toString());
        }



    }

}
