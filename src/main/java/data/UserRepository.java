package data;

/**
 * Created by Olya on 4/3/2017.
 */
public class UserRepository {

    public static User getIxlooUser(){
        return new User("Roberto", "Kitte", "223-450-7888", "robkit@gmail.com", "5656-58-8978", "Test 123", "Los Angeles", "USA", "111111");
    }

    public static User1 getIxlooUserWithComments(){
        return new User1("Olia", "User1", "555-666-7777", "olga.voloshyn@xloo.com", "555-777-666-999", "Street 123", "Los Angeles", "USA", "12356", "test comments text 123");
    }

    public static User2 getIxlooUserWithoutZip(){
        return new User2("Maria", "User2", "333-999-1111", "test_1@dxloo.com", "45212-365-458", "Street 456", "New York", "USA");
    }
}
