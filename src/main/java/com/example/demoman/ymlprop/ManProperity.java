package com.example.demoman.ymlprop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "man")
public class ManProperity {

    private String prop1;
    private String prop2;
    private String prop3;
    private String prop4;
    private String prop5;

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public String getProp2() {
        return prop2;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }

    public String getProp3() {
        return prop3;
    }

    public void setProp3(String prop3) {
        this.prop3 = prop3;
    }

    public String getProp4() {
        return prop4;
    }

    public void setProp4(String prop4) {
        this.prop4 = prop4;
    }

    public String getProp5() {
        return prop5;
    }

    public void setProp5(String prop5) {
        this.prop5 = prop5;
    }

    @Override
    public String toString() {
        return "Man{" +
                "prop1='" + prop1 + '\'' +
                ", prop2='" + prop2 + '\'' +
                ", prop3='" + prop3 + '\'' +
                ", prop4='" + prop4 + '\'' +
                ", prop5='" + prop5 + '\'' +
                '}';
    }
}
