package Collections.test;

import Collections.domain.Smartphone;

import java.util.*;

public class EqualsTest01 {
    public static void main(String[] args) {

        Smartphone phone1 = new Smartphone("1M354L", "iPhone");
        Smartphone phone2 = new Smartphone("1M354L", "iPhone");

        System.out.println(phone1.equals(phone2));

    }
}
