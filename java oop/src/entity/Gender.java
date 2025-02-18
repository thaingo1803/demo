/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author thinh
 */
public enum Gender {
    MALE, FEMALE;

    public int getGender() {
        switch (this) {
            case MALE:
                return 1;
            case FEMALE:
                return 2;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    public static Gender getGenderByInt(int type) {
        switch (type) {
            case 1:
                return MALE;
            case 2:
                return FEMALE;
            default:
                throw new AssertionError();
        }
    }
}
