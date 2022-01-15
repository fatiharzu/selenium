package Seleniumturkce.day05;

import org.junit.Test;

public class C01_Notasyon {

    //Java daki gibi selenium da da belirli islemleri yapan methodlar olsuturabilirz
    //ancak bu methodlar cagirilmadikca calismazlar
    public void ilkTestMethodu(){
        System.out.println("Ilk test methodumuz");
    }
    //JUnit ile notasyon kullanarak siradan methodlari test method una donusturebilirz
    // Bir Test methodu bagimsiz olarak calisabilen test yapmamiza imkan verir
    //@Test notasyonu sayesinde main method mecburiyeti ortadan kalkar
    @Test
    public void notasyonluIlkTestMethodu(){
        System.out.println("Mutasyonlu ilk test methodumuz");
    }

}

