package Note.threadstudy;

import java.io.*;

class MoveFile {

    public void copyFile(String strOldpath,String strNewPath)
    {
        System.out.println("kkk");
        try
        {

            File fOldFile = new File(strOldpath);
            if (fOldFile.exists())
            {
                int bytesum = 0;
                int byteread = 0;
                InputStream inputStream = new FileInputStream(fOldFile);
                FileOutputStream fileOutputStream = new FileOutputStream(strNewPath);
                byte[] buffer = new byte[1444];
                while ( (byteread = inputStream.read(buffer)) != -1)
                {
                    bytesum += byteread; //这一行是记录文件大小的，可以删去
                    fileOutputStream.write(buffer, 0, byteread);//三个参数，第一个参数是写的内容，
                    //第二个参数是从什么地方开始写，第三个参数是需要写的大小
                }
                inputStream.close();
                fileOutputStream.close();
            }
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("复制单个文件出错");
            e.printStackTrace();
        }
    }

    public void copyFolder(String strPatientImageOldPath,String strPatientImageNewPath)
    {
        File fOldFolder = new File(strPatientImageOldPath);//旧文件夹
        try
        {
            File fNewFolder = new File(strPatientImageNewPath);//新文件夹
            if (!fNewFolder.exists())
            {
                fNewFolder.mkdirs();//不存在就创建一个文件夹
            }
            File [] arrFiles = fOldFolder.listFiles();//获取旧文件夹里面所有的文件
            for (int i = 0; i < arrFiles.length; i++)
            {
                //从原来的路径拷贝到现在的路径，拷贝一个文件
                if (!arrFiles[i].isDirectory())
                {
                    copyFile(strPatientImageOldPath+"/"+arrFiles[i].getName(), strPatientImageNewPath+"/"+arrFiles[i].getName());
                }
            }
        }
        catch (Exception e)
        {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {

    }

}

class MoveFileThread extends MoveFile implements Runnable {
    // 文件移动线程的的状态，false要求线程阻塞
    private boolean flag = false;
    @Override
    public void run() {
        if(flag) {
//            super.copyFile();
        } else {

        }
    }
}

public class Test {
    public static void main(String[] args) {
        new MoveFile().copyFile("E:\\bing\\01.jpeg", "E:\\E:\\kall xuni");
    }
}
