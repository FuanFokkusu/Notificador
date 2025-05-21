package co.edu.uniquindio.poo.notificador.Model;

import java.util.ArrayList;
import java.util.List;

public class UserManager{
    private static UserManager instance;
    private static List<User> users;

    private UserManager() {
        users = new ArrayList<>();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public User findUser(String username) {
        for (User user : users) {
            if (user.getUserId().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void initialize() {

        users = UserManager.getInstance().getUsers();
        AdminUser adminUser = new AdminUser("admin", "Jose", "@yourMom69");
        ClientUser clientUser = new ClientUser("client", "JoseManuel", "@yourMom96");
        ClientUser clientUser2 = new ClientUser("client2", "Maria", "@yourMom96");
        Auditor auditor = new Auditor(new ArrayList<String>(), new ArrayList<User>());
        PushNotification pushNotification = new PushNotification();
        EmailNotification emailNotification = new EmailNotification();
        SMSNotification smsNotification = new SMSNotification();
        Notification notification = new Notification(clientUser, "Nuevo Evento disponible por tiempo limitado", "email");
        Notification notification2 = new Notification(clientUser2, "El descuento de la semana pasada acabó", "sms");
        Notification notification3 = new Notification(clientUser, "Nuevo Evento disponible por tiempo limitado", "push");
        NotificationInvoker notificationInvoker = new NotificationInvoker();

        addUser(adminUser);
        addUser(clientUser);
        addUser(clientUser2);

    }
}
