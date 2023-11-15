package ait.citizens.test;

import ait.citizens.dao.Citizens;
import ait.citizens.dao.CitizensImpl;
import ait.citizens.model.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizensTest {
    Citizens citizens;



    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        citizens = new CitizensImpl(List.of(
                new Person(111,"Ann","Smith",LocalDate.of(2000,01,01)),
                new Person(222,"Bill","Black",LocalDate.of(2001,01,01)),
                new Person(333,"Patric","White",LocalDate.of(2002,01,01)),
                new Person(444,"Jane","Red",LocalDate.of(2003,01,01))


        ));



    }

    @Test
    void testCitizensImpl(){
        Citizens citizens1=new CitizensImpl(List.of(
                new Person(111,"Ann","Smith",LocalDate.of(2000,01,01)),
                new Person(111,"Ann","Smith",LocalDate.of(2000,01,01))
        ));
        assertEquals(1,citizens1.size());

    }

    @org.junit.jupiter.api.Test
    void add() {
        assertFalse(citizens.add(null));
        assertFalse(citizens.add(new Person(111,"Ann","Smith",LocalDate.of(2000,01,01))));
        assertTrue(citizens.add(new Person(555,"Annet","Smithon",LocalDate.of(2004,01,01))));
        assertEquals(5,citizens.size());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        assertFalse(citizens.remove(555));
        assertTrue(citizens.remove(111));
        assertEquals(3,citizens.size());
    }

    @org.junit.jupiter.api.Test
    void find() {
        Person expexted= new Person(111,"Ann","Smith",LocalDate.of(2000,01,01)) ;
        Person actual =citizens.find(111);
        assertEquals(expexted,actual);
        assertNull(citizens.find(555));

    }

    @org.junit.jupiter.api.Test
    void testFindByAge() {
    }

    @org.junit.jupiter.api.Test
    void testFindByName() {
    }

    @org.junit.jupiter.api.Test
    void getAllPersonSortedById() {
    }

    @org.junit.jupiter.api.Test
    void getAllPersonSortedByAge() {
    }

    @org.junit.jupiter.api.Test
    void getAllPersonSortedByLastName() {
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(4, citizens.size());
    }
}