package POJO;

public class Msg {

    int id;
    String msg;
    String meta_msg;
    int time;
    int chat_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMeta_msg() {
        return meta_msg;
    }

    public void setMeta_msg(String meta_msg) {
        this.meta_msg = meta_msg;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName_support() {
        return name_support;
    }

    public void setName_support(String name_support) {
        this.name_support = name_support;
    }

    int user_id;
    String name_support;
}
