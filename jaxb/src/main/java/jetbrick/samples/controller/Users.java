package jetbrick.samples.controller;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="users")
public class Users {

    @XmlElement(name="user")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }
    
    public void setUsers(List<User> users) {
        this.users = users;
    }
}