package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class Requests
{
    public static void sendImage(String host, int port, String fileLocation, String fileExtension) throws IOException
    {
        try (Socket socket = new Socket(host, port))
        {
            OutputStream outputStream = socket.getOutputStream();

            BufferedImage image = ImageIO.read(new File(fileLocation));

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, fileExtension, byteArrayOutputStream); //fileExtension -> jpg, png..etc

            byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
            outputStream.write(size);
            outputStream.write(byteArrayOutputStream.toByteArray());
            outputStream.flush();
            System.out.println("Flushed: " + System.currentTimeMillis());

            Thread.sleep(120000);
            System.out.println("Closing: " + System.currentTimeMillis());
    } catch (InterruptedException e)
        {
            System.err.println("Conexiune intrerupta!");
        } catch (UnknownHostException e)
        {
            System.err.println("Host necunoscut!");
        }
    }

    public static void sendText(String linkToTextServiceHost, String text)
    {
        try
        {
            String urlString = linkToTextServiceHost + "/sendText?text=" + text;
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            System.out.println(is);
        } catch (MalformedURLException e)
        {
            System.err.println("Link-ul este invalid!");
        } catch (IOException e)
        {
            System.err.println("Nu s-au putut lua datele!");
        }
    }
}
