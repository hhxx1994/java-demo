package spring.propertychangesupport;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author huanghaoxing
 */
public class Person {

    PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public  void addLister(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        propertyChangeSupport.firePropertyChange("age",this.age,age);
        this.age = age;
    }
}
