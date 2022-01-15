package day08;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileExistTest {
    @Test
    public void isExist(){
        String homePath=System.getProperty("user.home"); //root path until Desktop-downloads
        System.out.println("homePath= "+ homePath); // users/admin

        //I stored file on Desktop
        //  /Users/admin/Desktop/download.png
        String pathOfImage = homePath + "/Desktop/download.png";
        System.out.println("pathOfImage= "+pathOfImage);

        //Verify if the file exists or not with Java
        boolean isExist = Files.exists(Paths.get(pathOfImage));
        Assert.assertTrue(isExist);


    }
}
