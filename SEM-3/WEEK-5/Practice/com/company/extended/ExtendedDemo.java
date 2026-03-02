package com.company.extended;

import com.company.security.AccessModifierDemo;

public class ExtendedDemo extends AccessModifierDemo {
    public ExtendedDemo(int privateField, String defaultField, double protectedField, boolean publicField) {
        super(privateField, defaultField, protectedField, publicField);
    }

    public void testInheritedAccess() {
        System.out.println(protectedField);
        System.out.println(publicField);
        protectedMethod();
        publicMethod();
    }

    @Override
    protected void protectedMethod() {
        System.out.println("Overridden protected method in ExtendedDemo");
    }

    public static void main(String[] args) {
        ExtendedDemo child = new ExtendedDemo(1, "Test", 2.2, true);
        child.testInheritedAccess();

        AccessModifierDemo parent = new AccessModifierDemo(2, "Parent", 3.3, false);
        parent.publicMethod();
    }
}
