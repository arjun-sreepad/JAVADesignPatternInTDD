package com.xebia.designpattern.creationalpattern.prototype;
/*Features 
Prototype pattern is used when the Object creation is a costly affair and requires a lot
of time and resources and you have a similar object already existing. 
So this pattern provides a mechanism to copy the original object to a new object and then 
modify it according to our needs. This pattern uses java cloning to copy the object.

Advantages
The main advantage of this pattern is to have minimal instance creation process which is 
much costly than cloning process.

*/

import java.util.List;

public class PrototypeExample {
 
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee emps = new Employee();
        emps.loadData();
         
        //Use the clone method to get the Employee object
        Employee empsNew = (Employee) emps.clone();
        Employee empsNew1 = (Employee) emps.clone();
        List<String> list = empsNew.getEmpList();
        list.add("John");
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("Pankaj");
         
        System.out.println("emps List: "+emps.getEmpList());
        System.out.println("empsNew List: "+list);
        System.out.println("empsNew1 List: "+list1);
    }
 
}
