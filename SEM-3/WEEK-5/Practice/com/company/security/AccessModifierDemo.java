// File: AccessModifierDemo.java
package com.company.security;

public class AccessModifierDemo {
    private int privateField;
    String defaultField;
    protected double protectedField;
    public boolean publicField;

    public AccessModifierDemo(int privateField, String defaultField, double protectedField, boolean publicField) {
        this.privateField = privateField;
        this.defaultField = defaultField;
        this.protectedField = protectedField;
        this.publicField = publicField;
    }

    private void privateMethod() {
        System.out.println("Private method called");
    }

    void defaultMethod() {
        System.out.println("Default method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    public void testInternalAccess() {
        System.out.println("=== Inside AccessModifierDemo class ===");
        System.out.println("privateField: " + privateField);
        System.out.println("defaultField: " + defaultField);
        System.out.println("protectedField: " + protectedField);
        System.out.println("publicField: " + publicField);
        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo demo = new AccessModifierDemo(42, "Hello", 3.14, true);
        // System.out.println(demo.privateField);
        System.out.println(demo.defaultField);
        System.out.println(demo.protectedField);
        System.out.println(demo.publicField);
        // demo.privateMethod();
        demo.defaultMethod();
        demo.protectedMethod();
        demo.publicMethod();
        demo.testInternalAccess();
    }
}

class SamePackageTest {
    public static void testAccess() {
        AccessModifierDemo demo = new AccessModifierDemo(99, "World", 2.71, false);
        // System.out.println(demo.privateField);
        System.out.println(demo.defaultField);
        System.out.println(demo.protectedField);
        System.out.println(demo.publicField);
        // demo.privateMethod();
        demo.defaultMethod();
        demo.protectedMethod();
        demo.publicMethod();
    }
}
