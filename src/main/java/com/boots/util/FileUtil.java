package com.boots.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

public class FileUtil {

    /**
     * Инструментальный класс FileUtil, реализующий метод uploadFile
     * @author lrd
     * @date 2018/10/23
     * @param  * @param null
     */
        /**
         * Сервисный метод загрузки файлов
         * @param  * @param file
         * @param filePath
         * @param fileName
         * @return
         */
        public static void uploadFile(byte[] file,String filePath,String fileName)throws Exception{
            File targetFile = new File(filePath);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            FileOutputStream out = new FileOutputStream(filePath+fileName);
            out.write(file);
            out.flush();
            out.close();

        }
        /**
         * Получить расширение файла
         * @param  * @param fileName
         * @return String
         */
        public static String getSuffix(String fileName){
            return fileName.substring(fileName.lastIndexOf("."));
        }
        /**
         * Создать новое имя файла
         * @param * @param fileOriginName имя исходного файла
         * @return
         */
        public static String getFileName(String fileOriginName){
            return getUUID() + getSuffix(fileOriginName);
        }
        /**
         * Создать имя файла
         * @param  * @param
         * @return
         */
        public static String getUUID(){
            return UUID.randomUUID().toString();//.replace("-","");
        }
    }

