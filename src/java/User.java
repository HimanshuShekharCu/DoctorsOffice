
import java.io.InputStream;
import javax.servlet.http.Part;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author himan
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author himan
 */
public class User{
    private InputStream photo;
    private String email1, email2, fname,lname,age, gender, contact, disease, location , email, password, message;  
public String getFName() {  
    return fname;  
}  
public void setFName(String fname) {  
      this.fname=fname;
}  
public String getLName() {  
    return lname;  
}
public void setLName(String lname) {  
      this.lname=lname;
}

public void setAge(String age) {  
      this.age=age;
}
public String getAge() {  
    return age;  
}  
public void setGender(String gender) {  
      this.gender=gender;
}
public String getGender() {  
    return gender;  
}  
public void setContact(String contact) {  
      this.contact=contact;
}public String getContact() {  
    return contact;  
}  
public void setDisease(String disease) {  
      this.disease=disease;
}public String getDisease() {  
    return disease;  
}  
public void setLocation(String location) {  
      this.location=location;
}public String getLocation() {  
    return location;  
}  
public void setEmail(String email) {  
      this.email=email;
}public String getEmail() {  
    return email;  
}  
public void setPassword(String password) {  
      this.password=password;
}public String getPassword() {  
    return password;  
}
public void setImage(InputStream photo){
    this.photo = photo;
}
public InputStream getImage(){
    return photo;
}
public void setMessage(String message){
    this.message= message;
}
public String getMessage(){
    return message;
}
public void setEmail1(String email1) {  
      this.email1=email1;
}public String getEmail1() {  
    return email1;  
}
 public void setEmail2(String email2) {  
      this.email2=email2;
}public String getEmail2() {  
    return email2;  
}  

}


