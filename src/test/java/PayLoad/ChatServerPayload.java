package PayLoad;

public class ChatServerPayload {

    public static String createChatUser()
    {
        return "{\n" +
            "  \"username\": \"vasu999\",\n" +
            "  \"password\": \"r1234\",\n" +
            "  \"email\": \"rahul@example.org\",\n" +
            "  \"name\": \"rahul\",\n" +
            "  \"surname\": \"P\",\n" +
            "  \"chat_nickname\": \"rahul123\",\n" +
            "  \"departments\": [\n" +
            "    1,\n" +
            "    2\n" +
            "  ],\n" +
            "  \"departments_read\": [\n" +
            "    2\n" +
            "  ],\n" +
            "  \"department_groups\": [\n" +
            "    1\n" +
            "  ],\n" +
            "  \"user_groups\": [\n" +
            "    1\n" +
            "  ]\n" +
            "}" ;
    }

    public static String createChatUser(String username,String password,String email,
                                        String name,String surname,String nickName)
    {
        return "{\n" +
                "  \"username\": \""+username+"\",\n" +
                "  \"password\": \""+password+"\",\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"surname\": \""+surname+"\",\n" +
                "  \"chat_nickname\": \""+nickName+"\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}" ;
    }


    public static String updateChatUser()
    {
        return "{\n" +
                "  \"username\": \"sushil\",\n" +
                "  \"password\": \"s1234\",\n" +
                "  \"email\": \"sushil@example.org\",\n" +
                "  \"name\": \"sushil\",\n" +
                "  \"surname\": \"X\",\n" +
                "  \"chat_nickname\": \"sushil12\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}" ;
    }


    public static String updateChatUser(String username,String password,String email,
                                        String name,String surname,String nickName)
    {
        return "{\n" +
                "  \"username\": \""+username+"\",\n" +
                "  \"password\": \""+password+"\",\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"surname\": \""+surname+"\",\n" +
                "  \"chat_nickname\": \""+nickName+"\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}" ;
    }
}
