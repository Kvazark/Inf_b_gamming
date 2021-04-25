package com.company;

import java.util.*;


public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите текст для зашифровки: ");
        String text = sc.nextLine();

        System.out.print("Введите гамму: ");
        String key=sc.nextLine();

        byte[] textBytes = text.getBytes();
        byte[] keyBytes = key.getBytes();
        byte[] serialBytes = encode(textBytes, keyBytes);

        String serialString = new String(serialBytes);
        System.out.print("Зашифрованное сообщение: ");
        System.out.println(serialString);

        byte[] deserialBytes = encode(serialBytes, keyBytes);
        String deserialString = new String(deserialBytes);
        System.out.print("Расшифрованное сообщение: ");
        System.out.println(deserialString);

        //System.out.println(getBits(text));

    }
    /*public static String getBits(String text){
        StringBuilder result = new StringBuilder();
        byte[] bytes = text.getBytes();
        for(int i=0; i < bytes.length; i++){
            for(int j=7; j >= 0; j--){
                result.append((bytes[i]>>j&0x1));
            }
            result.append("\n");
        }
        return result.toString();
    }*/
    public static byte XOR (byte b1, byte g){
        return(byte)(b1^g);
        }
    public static byte[] encode(byte[] text, byte[] key) {
        byte[] dst = new byte[text.length];
        for ( int i=0, k=0; i < text.length; i++, k= ++k == key.length ? 0 : k) {
            dst[i]= XOR(text[i],key[k]);
        }
        return dst;
    }
}









