package Buttons;

import org.junit.Test;

import static org.junit.Assert.*;

public class UploadTest {

    @Test
    public void getHeader() {
            Upload upload = new Upload();
            String header = upload.getHeader();
            String dataToWrite = "";
            dataToWrite += "@relation animals" + '\n' + '\n';
            dataToWrite += "@attribute class {Mamifer, Insecta}" + '\n';
            dataToWrite += "@attribute classMatching {low, high}" + '\n';
            dataToWrite += "@attribute concept {Soarece, Albina, Caine, Motan, Urs, Maimuta}" + '\n';
            dataToWrite += "@attribute conceptMatching {low, high}" + '\n' + '\n';
            //
            dataToWrite += "@data" + '\n';
            assertEquals(header,dataToWrite);
    }


    @Test
    public void getJsonObjects(){
        
    }

}
