package com.company.main;

import com.company.security.AccessModifierDemo;

public class PackageTestMain {
    public static void main(String[] args) {
        AccessModifierDemo demo = new AccessModifierDemo(10, "CrossPkg", 5.5, true);

        System.out.println(demo.publicField);
        demo.publicMethod();
    }
}
