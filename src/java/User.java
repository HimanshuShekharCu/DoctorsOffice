
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
    private InputStream inputStream;
    private String fname,lname,age, gender, contact, disease, location , email, password;  
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
    this.inputStream = inputStream;
}
public InputStream getImage(){
    return inputStream;
}

   

}


