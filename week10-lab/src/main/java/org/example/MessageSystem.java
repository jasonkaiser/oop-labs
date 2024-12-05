package org.example;

public class MessageSystem {


    @CanSendMessage
    @RequiresPermission(permission = "admin")
    public static void SendClientMessage(User user){

        Class<?> userClass = user.getClass();

        if(userClass.isAnnotationPresent(UserPermission.class)){
            UserPermission userPermission = userClass.getAnnotation(UserPermission.class);
            if("admin".equals(userPermission.permission())){
                System.out.println(user.getUsername() + " sent a message.");
            } else if("user".equals(userPermission.permission())){
                System.out.println("You don't have permissions to send a message!");
            }
        }
        else{
            System.out.println("User does not have any permissions defined!");
        }

    }

    public static void main(String[] args) {

        AdminUser jason = new AdminUser("Jason");
        RegularUser kris = new RegularUser("kris");

        SendClientMessage(jason);
        SendClientMessage(kris);

    }
}