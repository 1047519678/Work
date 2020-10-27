package cn.mvc.tools;

import java.io.*;

public class FileReadOrWrite {
    public static BufferedWriter bw = null;

    public static String ReadFile(String filename){
        String str = "";
        try {
            FileReader fr=new FileReader(filename);
            BufferedReader br=new BufferedReader(fr);
            while((br.readLine())!=null) {//readLine()方法一次读取一行数据
                str += br.readLine() + "\r\n";
            }
            br.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void WriteFilePath(String filename){
        try {
            File file = new File(filename);
            if(!file.exists()){
                file.createNewFile();
            }
            String oldStr = ReadFile(filename);
            FileWriter fw=new FileWriter(filename);
            bw = new BufferedWriter(fw);
            if(oldStr != null){
                bw.write(oldStr);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteFile(String str){
        try {
            bw.write(str+"\r\n");
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteSave(){
        try {
            bw.flush();            //将缓存压入文本
            bw.close();            //关闭输出流
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
