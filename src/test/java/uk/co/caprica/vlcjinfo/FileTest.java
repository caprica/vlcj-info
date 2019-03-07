package uk.co.caprica.vlcjinfo;

public class FileTest {

    public static void main(String[] args) {
        MediaInfoFile file = new MediaInfoFile("/home/mark/1.mp4");

        if (file.open()) {
            System.out.println(file.info("Video;%Duration%"));
            System.out.println(file.info("Video;%Duration/String1%"));
            System.out.println(file.info("Video;%Duration/String2%"));
            System.out.println(file.info("Video;%Duration/String3%"));
            System.out.println(file.info("Video;%Duration/String4%"));
            System.out.println(file.info("Video;%Duration/String5%"));
            System.out.println(file.info("General;%Duration%"));
            file.close();
        }
    }

}
